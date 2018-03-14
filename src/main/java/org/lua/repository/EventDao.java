package org.lua.repository;

import org.lua.entity.Event;
import org.lua.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;


public interface EventDao  extends BaseRepository<Event, Long>, JpaSpecificationExecutor<Event> {
	
	@Query("SELECT e FROM Event e WHERE e.owner.id=?3 AND ((e.endDate<=?1 AND e.endDate>=?2) OR (e.startDate>=?1 AND e.startDate<=?2))")
	public List<Event> findEvent(Date start, Date end, Long userId);

}
