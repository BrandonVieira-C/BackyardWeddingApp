package com.backyardweddingapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.backyardweddingapp.entity.Backyard;

public interface BackyardRepository extends CrudRepository<Backyard, Integer>{
	
	public Optional<List<Backyard>> findByCity(String city);
	public Optional<List<Backyard>> findByPartner(Integer partnerId);

}
