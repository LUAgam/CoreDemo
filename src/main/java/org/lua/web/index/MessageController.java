/**
 * 
 */
package org.lua.web.index;

import org.lua.constant.Constant;
import org.lua.datatables.JSONParam;
import org.lua.datatables.JSONResponse;
import org.lua.entity.*;
import org.lua.service.admin.MessageAttachmentService;
import org.lua.service.admin.MessageRepientService;
import org.lua.service.admin.MessageSenderService;
import org.lua.service.admin.MessageService;
import org.lua.util.*;
import org.lua.web.index.formbean.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.persistence.criteria.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


/**
 * @author onkyo
 * 
 */
@Controller
@SessionAttributes(value={"unReadCount", "messageLists"})
@RequestMapping(value = "/admin/profile/message")
public class MessageController {
	final Logger logger = LoggerFactory.getLogger(MessageController.class);

	@Autowired
	private MessageService messageService;

	@Autowired
	private MessageAttachmentService messageAttachmentService;

    @Autowired
    private MessageSenderService messageSenderService;
    
    @Autowired
    private MessageRepientService messageRepientService;
    
    @RequestMapping(value = "/{boxtype}", method = RequestMethod.POST)
	public @ResponseBody
    JSONResponse readmessagelist(@PathVariable("boxtype") String boxtype, @RequestBody JSONParam[] params, ModelMap map) {
    	HashMap<String, String> paramMap = JSONParamUtils.convertToMap(params);
		int size = Integer.parseInt(paramMap.get("iDisplayLength"));
		int page = Integer.parseInt(paramMap.get("iDisplayPage"));
		
    	
	    Pageable pr = new PageRequest(page, size, new Sort(new Order(Direction.DESC, "message.datetime")));
	    final String type = boxtype;
	    final Long userid = UserUtils.getCurrentUser().getId();

		map.addAttribute("boxtype", boxtype);
		map.addAttribute("unreadcount", messageRepientService.findUnreadCount(userid));
		
		if ("inbox".equals(type)) {// 收件箱
            Page<MessageRepient> messageRepientList = messageRepientService.findAll(new Specification<MessageRepient>() {
                @Override
                public Predicate toPredicate(Root<MessageRepient> root, CriteriaQuery<?> criteriaquery, CriteriaBuilder criteriabuilder) {
                    Path<User> recipientPath = root.get("repientUser");
                    Path<Integer> recipientidPath = recipientPath.get(Constant.DEFAULT_SORT_KEY);

                    criteriaquery.where(criteriabuilder.equal(recipientidPath, userid));
                    return null;
                }

            }, pr);
		    
            List<MessageRepientFB> messageRepientFBList = new LinkedList<MessageRepientFB>();
            MessageRepientFB messageRepientFB;
            for (MessageRepient messageRepient : messageRepientList) {
                messageRepientFB = MessageRepientFB.toFB(messageRepient);
                messageRepientFBList.add(messageRepientFB);
            }
            return JSONResponseUtils.convert(messageRepientList, paramMap,messageRepientFBList);
            
		} 
		
		// 发件箱
	    Page<MessageSender> messageSenderList = messageSenderService.findAll(new Specification<MessageSender>() {
            @Override
            public Predicate toPredicate(Root<MessageSender> root, CriteriaQuery<?> criteriaquery, CriteriaBuilder criteriabuilder) {
                Path<User> recipientPath = root.get("sender");
                Path<Integer> recipientidPath = recipientPath.get(Constant.DEFAULT_SORT_KEY);

                criteriaquery.where(criteriabuilder.equal(recipientidPath, userid));
                return null;
            }
        }, pr);
	    
	    List<MessageSenderFB> messageSenderFBList = new LinkedList<MessageSenderFB>();
	    MessageSenderFB messageSenderFB;
	    for (MessageSender messageSender : messageSenderList) {
	        messageSenderFB = MessageSenderFB.toFB(messageSender);
	        messageSenderFBList.add(messageSenderFB);
	    }
	    return JSONResponseUtils.convert(messageSenderList, paramMap,messageSenderFBList);
	}
   
    
	@RequestMapping(value = "/{boxtype}", method = RequestMethod.GET)
	public String message(@PathVariable("boxtype") String boxtype,	ModelMap map) {
	    final Long userid = UserUtils.getCurrentUser().getId();

		map.addAttribute("boxtype", boxtype);
		map.addAttribute("unreadcount", messageRepientService.findUnreadCount(userid));		
		
		// 更新commonNav上的信息
		Pageable msgPageRequest = new PageRequest(0, 3, new Sort(new Order(Direction.ASC, "message.datetime")));
        Page<MessageRepient> messageRepientList = messageRepientService.findAll(new Specification<MessageRepient>() {
            @Override
            public Predicate toPredicate(Root<MessageRepient> root, CriteriaQuery<?> criteriaquery, CriteriaBuilder criteriabuilder) {
                Path<User> recipientPath = root.get("repientUser");
                Path<Integer> recipientidPath = recipientPath.get(Constant.DEFAULT_SORT_KEY);
                
                Path<Boolean> readPath = root.get("read");

                criteriaquery.where(criteriabuilder.equal(recipientidPath, userid),criteriabuilder.equal(readPath, false));
                return null;
            }

        }, msgPageRequest);
        List<MessageRepientFB> messageRepientFBList = new LinkedList<MessageRepientFB>();
        MessageRepientFB messageRepientFB;
        for (MessageRepient messageRepient : messageRepientList) {
            messageRepientFB = MessageRepientFB.toFB(messageRepient);
            messageRepientFBList.add(messageRepientFB);
        }
		map.addAttribute("messageLists", messageRepientFBList);
		map.addAttribute("unReadCount", messageRepientService.findUnreadCount(userid));

		return "admin/message";
	}
	
	/**
	 * 发送消息
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String do_sent(ModelMap map) {
		return "admin/sendmessage";
	}

	@RequestMapping(value = "/read/{boxtype}/{messageid}", method = RequestMethod.GET)
	public String do_readmessage(@PathVariable("boxtype") String boxtype,
			@PathVariable("messageid") Long messageid, ModelMap map) {
	    
	    final Long userid = UserUtils.getCurrentUser().getId();
	    
		map.addAttribute("boxtype", boxtype);
		map.addAttribute("unreadcount", messageRepientService.findUnreadCount(userid));
		
		if ("inbox".equals(boxtype)) {// 收件箱
		    // 读消息(设置已读)
		    messageRepientService.read(messageid);
		    
		    // 查询消息
		    MessageRepient messageRepient = messageRepientService.findOne(messageid);
		    MessageRepientFB messageRepientFB = MessageRepientFB.toFB(messageRepient);
		    map.addAttribute("message",messageRepientFB);
		    if (messageRepient.getMessage() != null 
		            && messageRepient.getMessage().getSender() != null) {
		        map.addAttribute("sender", messageRepient.getMessage().getSender().getPerson());
		    }
		    
		    // 附件
		    if (messageRepient.getMessage() != null) {
    		    MessageAttachmentFB maFB = new MessageAttachmentFB();
    	        List<MessageAttachment> attachmentList = messageAttachmentService.findByMessageId(messageRepient.getMessage().getId());
    	        maFB.setFilecount(attachmentList.size());
    	        long totalLength = 0l;
    	        List<AttachmentFB> attachmentFBList = new LinkedList<AttachmentFB>();
    	        for (MessageAttachment ma : attachmentList) {
    	            totalLength += ma.getFileLength();
    	            AttachmentFB aFB = new AttachmentFB();
    	            aFB.setFileName(ma.getFileName());
    	            aFB.setMessageAttachmentId(ma.getId());
    	            totalLength += ma.getFileLength();
    	            attachmentFBList.add(aFB);
    	        }
    	        maFB.setFilelength(totalLength);
    	        maFB.setAttachmentList(attachmentFBList);
    	        map.addAttribute("attachment", maFB);
		    }
		} else {// 发件箱
		    // 查询消息
		    MessageSender messageSender = messageSenderService.findOne(messageid);
		    MessageSenderFB messageSenderFB = MessageSenderFB.toFB(messageSender);
            map.addAttribute("message", messageSenderFB);
            if (messageSender.getMessage() != null && messageSender.getMessage().getSender() != null) {
                map.addAttribute("sender", messageSender.getMessage().getSender().getPerson());
            }
		    
            // 附件
            if (messageSender.getMessage() != null) {
                MessageAttachmentFB maFB = new MessageAttachmentFB();
                List<MessageAttachment> attachmentList = messageAttachmentService.findByMessageId(messageSender.getMessage().getId());
                maFB.setFilecount(attachmentList.size());
                long totalLength = 0l;
                List<AttachmentFB> attachmentFBList = new LinkedList<AttachmentFB>();
                for (MessageAttachment ma : attachmentList) {
                    totalLength += ma.getFileLength();
                    AttachmentFB aFB = new AttachmentFB();
                    aFB.setFileName(ma.getFileName());
                    aFB.setMessageAttachmentId(ma.getId());
                    totalLength += ma.getFileLength();
                    attachmentFBList.add(aFB);
                }
                maFB.setFilelength(totalLength);
                maFB.setAttachmentList(attachmentFBList);
                map.addAttribute("attachment", maFB);
            }
		}
		
        // 更新commonNav上的信息
        Pageable msgPageRequest = new PageRequest(0, 3, new Sort(new Order(Direction.ASC, "message.datetime")));
        Page<MessageRepient> messageRepientList = messageRepientService.findAll(new Specification<MessageRepient>() {
            @Override
            public Predicate toPredicate(Root<MessageRepient> root, CriteriaQuery<?> criteriaquery, CriteriaBuilder criteriabuilder) {
                Path<User> recipientPath = root.get("repientUser");
                Path<Integer> recipientidPath = recipientPath.get(Constant.DEFAULT_SORT_KEY);
                
                Path<Boolean> readPath = root.get("read");

                criteriaquery.where(criteriabuilder.equal(recipientidPath, userid),criteriabuilder.equal(readPath, false));
                return null;
            }

        }, msgPageRequest);
        List<MessageRepientFB> messageRepientFBList = new LinkedList<MessageRepientFB>();
        MessageRepientFB messageRepientFB;
        for (MessageRepient messageRepient : messageRepientList) {
            messageRepientFB = MessageRepientFB.toFB(messageRepient);
            messageRepientFBList.add(messageRepientFB);
        }
        map.addAttribute("messageLists", messageRepientFBList);
        map.addAttribute("unReadCount", messageRepientService.findUnreadCount(userid));
		
		return "admin/messagedetail";
	}

	/**
	 * 保存、发送消息
	 * @param message
	 * @param result
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String do_write(@ModelAttribute @Valid MessageFB message,
			BindingResult result, ModelMap map, MultipartHttpServletRequest request ) {

		if (result.hasErrors()) {
			map.addAttribute("message",
					ErrorUtils.fetchAllErrorMessages(result));
			map.addAttribute("message", message);
			return "admin/sendmessage";
		}
		
		messageService.sendMessage(message, request);

		return "redirect:/admin/profile/message/outbox";
	}
	
	@RequestMapping(value = "/download/{attachmentId}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> do_download(@PathVariable("attachmentId") Long attachmentId, HttpServletRequest request) {
		
		//attachmentId
		MessageAttachment ma = messageAttachmentService.findByOne(attachmentId);
		
		
		//FIXME: messageattachment Permission
		
		HttpHeaders headers = new HttpHeaders();
	    String messageAttachmentUploadPath = FileUploadUtil.getCurrentPath(request)	+ ResourceUtils.getProperty(ResourceUtils.FILEUPLOAD_MESSAGE_ATTACHMENT);
		String path =  messageAttachmentUploadPath + ma.getFileNewId() + "." + ma.getExtName();
	    try {
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);  
	        headers.setContentDispositionFormData("attachment", ma.getFileName());
	        headers.setContentDispositionFormData("attachment", new String(ma.getFileName().getBytes("utf-8"), "ISO8859-1"));
	        
	        
	    
			return new ResponseEntity<byte[]>(org.apache.commons.io.FileUtils.readFileToByteArray(new File(path)), headers, HttpStatus.CREATED);
		} catch (IOException e) {
			logger.error("Error while download file " + path, e);
		}
		
		return null;
		
	}
	
	//删除消息
	@RequestMapping(value = "/remove/{boxtype}/{messageId}", method = RequestMethod.GET)
	public String do_delete(@PathVariable("boxtype") String boxtype, @PathVariable("messageId") Long messageId, ModelMap map){
	    if ("inbox".equals(boxtype)) {
	        messageRepientService.delete(messageId);
	    } else {
	        messageSenderService.delete(messageId);
	    }
		return "redirect:/admin/profile/message/"+boxtype;
	}
	
	//operatype 1表示回复    2 表示转发
	@RequestMapping(value = "/transpond/{operatype}/{messageId}", method = RequestMethod.GET)
	public String do_transpond(@PathVariable("operatype") Long operatype,@PathVariable("messageId") Long messageId, ModelMap map) {

		Message message = messageService.findOne(messageId);
		MessageFB messageFB = new MessageFB();
		if(operatype == 1){
			Person person = messageService.findPersonByUserId(message.getSender().getId());
			if (person != null) {
				messageFB.setRecipientId(person.getId());
				messageFB.setRecipientStr(person.getName());
			}
			
			messageFB.setTitle(Constant.MESSAGECONTROLLER_REPLY+message.getTitle());
			messageFB.setMessageContent(Constant.MESSAGECONTROLLER_REPLY+message.getContent());
		}
		if(operatype == 2){
			messageFB.setTitle(message.getTitle());
			messageFB.setMessageContent(message.getContent());
		}
		map.addAttribute("message", messageFB);
		return "admin/sendmessage";
	}
	
	//标记为已读 或 未读
	@RequestMapping(value = "/sign/{status}/{boxtype}/{messageId}", method = RequestMethod.GET)
	public String do_sign(@PathVariable("status") String status, @PathVariable("boxtype") String boxtype, @PathVariable("messageId") Long messageId, ModelMap map){
        if (Constant.READ.equals(status)) {
            messageRepientService.read(messageId);
        } else if (Constant.UNREAD.equals(status)) {
            messageRepientService.unRead(messageId);
        }
	    
		return "redirect:/admin/profile/message/"+boxtype;
	}
	
}
