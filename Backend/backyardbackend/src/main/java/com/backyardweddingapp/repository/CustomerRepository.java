package com.backyardweddingapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.backyardweddingapp.entity.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Integer>
{

	
}
