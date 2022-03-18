package com.backyardweddingapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.backyardweddingapp.entity.Customer;

@Component
public interface CustomerRepository extends CrudRepository<Customer, String>
{

	
}
