/**
 *        (c) 2006 JOVEN
 *
 *        http://www.joven.com.cn
 */

package org.lua.web.index;

import com.schickit.utils.DateUtils;
import org.lua.constant.Constant;
import org.lua.datatables.JSONParam;
import org.lua.entity.Event;
import org.lua.service.admin.EventService;
import org.lua.util.JSONParamUtils;
import org.lua.util.UserUtils;
import org.lua.web.BaseController;
import org.lua.web.index.formbean.EventFB;
import org.lua.web.index.formbean.EventJSON;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 *
 * @author       $Author: JHuang $
 * @version      $Revision: 4306 $ $Date: 2014-05-08 18:22:19 +0800 (星期四, 08 五月 2014) $
 */
@Controller
@RequestMapping(value = "/admin/profile/calendar")
public class CalendarController extends BaseController {
	
	@Autowired
    EventService eventService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String canendar() {
		return "admin/calendar";
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public @ResponseBody  List<EventJSON> list(@RequestBody JSONParam[] params) {
		HashMap<String, String> paramMap = JSONParamUtils.convertToMap(params);

	    Date start;
	    Date end;
	    
	    List<EventJSON> ret = new LinkedList<EventJSON>();
		try {
			start = DateUtils.parseAnyString(paramMap.get("start"));
			end = DateUtils.parseAnyString(paramMap.get("end"));

			List<Event> eventList = eventService.findAll(start, end, UserUtils.getCurrentUser());
			for (Event event : eventList) {
				EventJSON eJSON = new EventJSON();
				eJSON.id =  event.getId();
				eJSON.title = event.getTitle();
				eJSON.start = event.getStartDate();
				eJSON.end = event.getEndDate();
				eJSON.allDay = event.isAllDay();
				eJSON.color = event.getColor();
				eJSON.content = event.getContent();
				eJSON.startStr = DateUtils.formatDate(event.getStartDate(), "yyyy-MM-dd HH:mm");
				eJSON.endStr = DateUtils.formatDate(event.getEndDate(), "yyyy-MM-dd HH:mm");
				ret.add(eJSON);
				
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	    
	    
		
		return ret;
    }
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String do_sent(ModelMap map) {
		return "admin/writeevent";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String do_write(@ModelAttribute @Valid EventFB event, BindingResult result, Model model, MultipartHttpServletRequest request) {
		
		
		if (result.hasErrors()) {
				model.addAttribute("event", event);
				addMessage(model, result);
			return "admin/writeevent";
		}
		
		if (event.getStartDate() == null) {
			model.addAttribute("event", event);
			addMessage(model, Constant.MESSAGE_CALENARCONTROLLER_TIME_NOTEMPTY);
			return "admin/writeevent";
		}
		
		if (!event.isAllDay()) {
			if (event.getEndDate() == null) {
				model.addAttribute("event", event);
				addMessage(model, Constant.MESSAGE_CALENARCONTROLLER_ENDTIME_NOTEMPTY);
				return "admin/writeevent";
			}
			
			if (!event.getEndDate().after(event.getStartDate())) {
				model.addAttribute("event", event);
				addMessage(model, Constant.MESSAGE_CALENARCONTROLLER_BEGINTIME_ENDTIME);
				return "admin/writeevent";
			}
			
			
		}
		
		Event eventEntity;
		if(event.getId() != null){
			eventEntity = eventService.findOne(event.getId());
		}else{
			eventEntity = new Event();
			eventEntity.setOwner(UserUtils.getCurrentUser());
		}
		BeanUtils.copyProperties(event,eventEntity);
		eventService.save(eventEntity);

		return "redirect:/admin/profile/calendar";
	}
	
	@RequestMapping(value = "/delete/{eventId}", method = RequestMethod.POST)
	public @ResponseBody String delete(@PathVariable("eventId") Long eventId, Model model){
		Event event = eventService.findOne(eventId);
		if(!UserUtils.getCurrentUser().getId().equals(event.getOwner().getId())){
			addMessage(model, Constant.MESSAGE_CALENARCONTROLLER_NOPERMISSIONS_OPERATE);
			return "false";
		}
		eventService.delete(eventId);
		return "success";
	}
	
	@RequestMapping(value = "/edit/{eventId}", method = RequestMethod.GET)
	public String do_edit(@PathVariable("eventId") Long eventId, Model model){
		Event event = eventService.findOne(eventId);
		if(!UserUtils.getCurrentUser().getId().equals(event.getOwner().getId())){
			addMessage(model, Constant.MESSAGE_CALENARCONTROLLER_NOPERMISSIONS_OPERATE);
			return "redirect:/admin/profile/calendar";
		}
		
		EventFB fb = new EventFB();
		BeanUtils.copyProperties(event,fb);
		model.addAttribute("event", fb);
		return "admin/editevent";
	}

}
