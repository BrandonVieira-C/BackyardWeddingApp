package com.backyardweddingapp.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Component;

import com.backyardweddingapp.entity.Partner;
@Component
public interface PartnerRepository extends CrudRepository<Partner, Integer> {

}
