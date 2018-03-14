/**
 * 
 */
package org.lua.service.admin;

import org.lua.entity.Event;
import org.lua.entity.User;
import org.lua.repository.EventDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * @author onkyo
 * 
 */
@Component
@Transactional(readOnly = true)
public class EventService {
	
	@Autowired
    EventDao eventDao;
	
	@Transactional(readOnly = false)
	public void save(Event event) {
		this.eventDao.save(event);
	}
	
	public List<Event> findAll(Date start, Date end, User user) {
		return eventDao.findEvent(start, end, user.getId());
	}
	
	@Transactional
	public void delete(Long eventId){
		this.eventDao.delete(eventId);
	}
	
	public Event findOne(Long eventId){
		return eventDao.findOne(eventId);
	}

}
