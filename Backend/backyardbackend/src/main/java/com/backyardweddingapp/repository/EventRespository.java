package com.backyardweddingapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.backyardweddingapp.entity.Event;

@Component
public interface EventRespository extends CrudRepository<Event, Integer>{
	
//	@Query("select *.e from Event e where e.eventId = :emailId and e.dateOfEvent = :dateOfEvent")
//	Event findEventByEventIdAndDateOfEvent (@Param("eventId") Integer eventId, @Param("dateOfEvent") LocalDate dateOfEvent);

}
