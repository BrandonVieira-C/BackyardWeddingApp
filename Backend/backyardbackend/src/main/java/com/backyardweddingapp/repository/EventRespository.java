package com.backyardweddingapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.backyardweddingapp.entity.Event;

@Component
public interface EventRespository extends CrudRepository<Event, Integer>{
	
}
