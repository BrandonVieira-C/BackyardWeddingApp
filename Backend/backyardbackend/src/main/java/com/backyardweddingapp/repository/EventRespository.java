package com.backyardweddingapp.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.backyardweddingapp.entity.Event;
@Component
public interface EventRespository extends CrudRepository<Event, Integer>{
	
//	@Query("select *.e from Event e where e.eventId = :emailId and e.dateOfEvent = :dateOfEvent")
//	Event findEventByEventIdAndDateOfEvent (@Param("eventId") Integer eventId, @Param("dateOfEvent") LocalDate dateOfEvent);

}
