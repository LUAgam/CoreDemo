/**
 * 
 */
package org.lua.web.index;

import com.schickit.utils.DateUtils;
import org.lua.constant.Constant;
import org.lua.datatables.JSONParam;
import org.lua.entity.Department;
import org.lua.entity.Event;
import org.lua.entity.Person;
import org.lua.entity.User;
import org.lua.service.admin.EventService;
import org.lua.service.configuration.DepartmentService;
import org.lua.service.configuration.PersonService;
import org.lua.service.configuration.UserService;
import org.lua.util.JSONParamUtils;
import org.lua.util.UserUtils;
import org.lua.web.BaseController;
import org.lua.web.index.formbean.AllEventFB;
import org.lua.web.index.formbean.DepartmentFB;
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
import java.util.*;

/**
 * @author onkyo
 *
 */
@Controller
@RequestMapping(value = "/admin/profile/allcalendar")
public class AllCalendarController extends BaseController {
	
	@Autowired
    EventService eventService;
	
	@Autowired
    DepartmentService departmentService;
	
	@Autowired
    PersonService personService;
	
	@Autowired
    UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String canendar(Model model) {
		
		List<Department> departmentList = departmentService.findAll();
		
		List<DepartmentFB> departmentFBList = new ArrayList<DepartmentFB>(departmentList.size());
		for(Department department : departmentList) {
			List<Person> personList = personService.findAllByDepartment(department.getId());
			DepartmentFB dFB = new DepartmentFB();
			BeanUtils.copyProperties(department,dFB);
			dFB.setPersonList(personList);
			departmentFBList.add(dFB);
		}
		
		model.addAttribute("departmentList", departmentFBList);
		
		
		
		return "admin/allcalendar";
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public @ResponseBody  List<EventJSON> list(@RequestBody JSONParam[] params) {
		HashMap<String, String> paramMap = JSONParamUtils.convertToMap(params);

	    Date start;
	    Date end;
	    Long personId;
	    
	    List<EventJSON> ret = new LinkedList<EventJSON>();
		try {
			start = DateUtils.parseAnyString(paramMap.get("start"));
			end = DateUtils.parseAnyString(paramMap.get("end"));
			personId = 0l;
			try {
				personId = Long.valueOf(paramMap.get("person"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			
	
			
			if (personId>0) {
				
				User user = userService.findByPersonId(personId);

				if (user != null) {
					List<Event> eventList = eventService.findAll(start, end, user);
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
				}
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	    
	    
		
		return ret;
    }
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String do_sent(ModelMap map) {
		return "admin/allwriteevent";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String do_write(@ModelAttribute @Valid AllEventFB event, BindingResult result, Model model, MultipartHttpServletRequest request) {
		
		
		if (result.hasErrors()) {
				model.addAttribute("event", event);
				addMessage(model, result);
			return "admin/allwriteevent";
		}
		
		if (event.getRecipientId() <= 0) {
			model.addAttribute("event", event);
			addMessage(model, "人员不能为空");
			return "admin/allwriteevent";
		}
		
		if (event.getStartDate() == null) {
			model.addAttribute("event", event);
			addMessage(model, Constant.MESSAGE_CALENARCONTROLLER_TIME_NOTEMPTY);
			return "admin/allwriteevent";
		}
		
		if (!event.isAllDay()) {
			if (event.getEndDate() == null) {
				model.addAttribute("event", event);
				addMessage(model, Constant.MESSAGE_CALENARCONTROLLER_ENDTIME_NOTEMPTY);
				return "admin/allwriteevent";
			}
			
			if (!event.getEndDate().after(event.getStartDate())) {
				model.addAttribute("event", event);
				addMessage(model, Constant.MESSAGE_CALENARCONTROLLER_BEGINTIME_ENDTIME);
				return "admin/allwriteevent";
			}
			
			
		}
		
		Event eventEntity;
		if(event.getId() != null){
			eventEntity = eventService.findOne(event.getId());
		}else{
			eventEntity = new Event();
			User user = userService.findByPersonId(event.getRecipientId());
			eventEntity.setOwner(user);
		}
		BeanUtils.copyProperties(event,eventEntity);
		eventService.save(eventEntity);

		return "redirect:/admin/profile/allcalendar";
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

		
		AllEventFB fb = new AllEventFB();
		BeanUtils.copyProperties(event,fb);
		fb.setRecipientId(event.getOwner().getPerson().getId());
		fb.setRecipientStr(event.getOwner().getPerson().getName());
		model.addAttribute("event", fb);
		return "admin/alleditevent";
	}

}
