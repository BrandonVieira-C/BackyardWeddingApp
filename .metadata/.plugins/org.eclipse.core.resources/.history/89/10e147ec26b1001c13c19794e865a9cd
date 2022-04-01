package com.backyardweddingapp.service;

import com.backyardweddingapp.dto.CustomerDTO;
import com.backyardweddingapp.dto.EventDTO;
import com.backyardweddingapp.exception.BackyardWeddingException;

import org.springframework.stereotype.Component;

@Component
public interface CustomerService {

  Integer addCustomer(CustomerDTO customerDTO) throws BackyardWeddingException; //returns newly added customerId
  CustomerDTO getCustomer(Integer customerId) throws BackyardWeddingException;
  // Integer deleteCustomerWithId(Integer customerId) throws BackyardWeddingException; //returns deleted customerId

  Integer addEventForCustomer(Integer customerId, EventDTO eventDTO) throws BackyardWeddingException; //returns newly added eventId
  // CustomerDTO getEventsForCustomer(Integer customerId) throws BackyardWeddingException;
  String deleteEventForCustomer(Integer customerId, Integer eventId) throws BackyardWeddingException; //returns success message
  // EventDTO getEvent(Integer eventId) throws BackyardWeddingException; not needed(?) since getCustomer will also give events
  
}
