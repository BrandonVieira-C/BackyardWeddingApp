package com.backyardweddingapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.backyardweddingapp.entity.Backyard;

@Component
public interface BackyardRepository extends CrudRepository<Backyard, Integer>{
	
	public List<Backyard> findByCity(String city);

}
