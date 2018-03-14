package org.lua.service.admin;

import com.schickit.utils.DateUtils;
import com.schickit.utils.FileUtils;
import org.lua.entity.*;
import org.lua.repository.*;
import org.lua.util.FileUploadUtil;
import org.lua.util.ResourceUtils;
import org.lua.util.UserUtils;
import org.lua.web.index.formbean.MessageFB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Component
@Transactional(readOnly = true)
public class MessageService {
    
    final Logger logger = LoggerFactory.getLogger(MessageService.class);
	
	@Autowired
	private MessageDao messageDao;
	
	@Autowired
	private MessageSenderDao messageSenderDao;
	
	@Autowired
	private MessageRepientDao messageRepientDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private MessageAttachmentDao messageAttachmentDao;
	
	
	public Page<Message> findAll(Specification<Message> specification, Pageable pageable) {
		return this.messageDao.findAll(specification, pageable);
	}
	
	public Message findOne(Long messageId) {
		return this.messageDao.findOne(messageId);
	}
	
//	/**
//	 * 当前用户未读消息总数
//	 * @return
//	 */
//	public Long findUnreadCount() {
//		return this.messageDao.findUnreadCount(UserUtils.getCurrentUser().getId());
//	}
	
	/**
	 * 一次发送消息给多个人
	 * @param messageFB
	 * @param request
	 */
	@Transactional
	public String sendMessage(MessageFB messageFB, MultipartHttpServletRequest request) {
	    User user;
	    Message message;
	    List<MessageAttachment> messageAttachmentList = new LinkedList<MessageAttachment>();
	    MessageAttachment messageAttachment;
	    
	    // 解析发送人
	    Long recipientId = messageFB.getRecipientId();
	    
	    user = userDao.findByPersonId(recipientId);
	    
	    if (user == null) {
	    	return "没有匹配的接受人！";
	    }
	    
	    
	    // 保存消息内容
	    message = new Message();
	    message.setSender(UserUtils.getCurrentUser());
	    message.setDatetime(DateUtils.getCurrentDateTime());
	    message.setTitle(messageFB.getTitle());
	    message.setContent(messageFB.getMessageContent());
	    messageDao.save(message);
	    
	    // 保存附件
	    logger.info("保存消息附件开始...");
        Iterator<String> itr = request.getFileNames();
        MultipartFile mpf;
        String messageAttachmentUploadPath = FileUploadUtil.getCurrentPath(request)
                + ResourceUtils.getProperty(ResourceUtils.FILEUPLOAD_MESSAGE_ATTACHMENT);
        while (itr.hasNext()) {
            mpf = request.getFile(itr.next());
            if(!"".equals(mpf.getOriginalFilename())){
                messageAttachment = new MessageAttachment();
                messageAttachment.setFileName(mpf.getOriginalFilename());
                messageAttachment.setFileLength(mpf.getSize());
                messageAttachment.setExtName(FileUtils.getFileExtension(mpf.getOriginalFilename()));
                messageAttachment.setMessage(message);
                messageAttachmentDao.save(messageAttachment);

                String path =  messageAttachmentUploadPath + messageAttachment.getId() + "." + messageAttachment.getExtName();
                messageAttachment.setFileNewId(messageAttachment.getId());
                messageAttachmentDao.save(messageAttachment);
                logger.info("保存文件路径 " + path);
                File newFile = new File(path);

                if (!newFile.exists()) {
                    newFile.mkdirs();
                }
                try {
                    mpf.transferTo(newFile);
                } catch (IOException e) {
                    logger.error("上传文件出错！", e);
                }
                messageAttachmentList.add(messageAttachment);
            }
        }
        
        //TODO: 多接受人
        // 保存发送人与消息关联
        MessageSender messageSender = new MessageSender();
        messageSender.setSender(UserUtils.getCurrentUser());
        messageSender.setMessage(message);
        messageSenderDao.save(messageSender);
        
        // 保存接受人与消息关联
        MessageRepient messageRepient;
	    messageRepient = new MessageRepient();
	    messageRepient.setMessage(message);
	    messageRepient.setRepientUser(user);
	    messageRepient.setRead(false);
	    if (user.getPerson() != null) {
	        message.setRecipientStr(user.getPerson().getName());
	    }
	    messageRepientDao.save(messageRepient);
        
        // 保存消息接受人到消息中
        messageDao.save(message);
	    
	    return null;
	}
	
	@Transactional(readOnly = false)
	public void saveMessage(Message message) {
		this.messageDao.save(message);
	}
	
	/**
	 * 用账户ID查找人员信息 
	 */
	public Person findPersonByUserId(Long userId) {
		List<Person> personList = this.personDao.findByUserId(userId);
		if (personList != null && personList.size()>0) {
			return personList.get(0);
		}
		return null;
	}
	
//	@Transactional(readOnly = false)
//	public void read(Integer messageId) {
//		this.messageDao.read(messageId);
//	}
//	
//	@Transactional(readOnly = false)
//	public void unread(Integer messageId) {
//		this.messageDao.unread(messageId);
//	}
//	
//	public void remove(Integer messageId) {
//		this.messageDao.remove(messageId);
//	}
}
