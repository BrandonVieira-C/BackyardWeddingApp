package com.backyardweddingapp.service;

import java.util.List;
import java.util.stream.Collectors;

import com.backyardweddingapp.dto.CustomerDTO;
import com.backyardweddingapp.dto.EventDTO;
import com.backyardweddingapp.entity.Customer;
import com.backyardweddingapp.entity.Event;
import com.backyardweddingapp.exception.BackyardWeddingException;
import com.backyardweddingapp.repository.CustomerRepository;
import com.backyardweddingapp.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private EventRepository eventRepository;

  @Override
  public Integer addCustomer(CustomerDTO customerDTO) throws BackyardWeddingException {
    Customer customer = new Customer();
    customer.setFirstName(customerDTO.getFirstName());
    customer.setLastName(customerDTO.getLastName());
    // not setting customer event here...
    Customer saved = customerRepository.save(customer);
    return saved.getCustomerId();
  }

  @Override
  public CustomerDTO getCustomer(Integer customerId) throws BackyardWeddingException {
    Customer customer = customerRepository.findById(customerId).orElseThrow(
        () -> new BackyardWeddingException("SERVICE ERROR: Could not find customer with that customerId."));

    CustomerDTO customerDTO = new CustomerDTO();
    customerDTO.setCustomerId(customer.getCustomerId());
    customerDTO.setFirstName(customer.getFirstName());
    customerDTO.setLastName(customer.getLastName());

    List<Event> customerEvents = customer.getEvents();
    // copy list entity to list dto
    List<EventDTO> customerEventsDTO = customerEvents.stream().map(entity -> {
      EventDTO dto = new EventDTO();
      dto.setEventId(entity.getEventId());
      dto.setEventName(entity.getEventName());
      dto.setEventDate(entity.getEventDate());
      dto.setBackyardId(entity.getBackyardId());
      return dto;
    }).collect(Collectors.toList());

    customerDTO.setCustomerEvents(customerEventsDTO);

    return customerDTO;
  }

  @Override
  public Integer addEventForCustomer(Integer customerId, EventDTO eventDTO) throws BackyardWeddingException {
    Customer customer = customerRepository.findById(customerId).orElseThrow(
        () -> new BackyardWeddingException("SERVICE ERROR: Could not find customer with that customerId."));

    List<Event> listOfCustomerEvents = customer.getEvents();
    Event newEvent = new Event();
    newEvent.setEventName(eventDTO.getEventName()); 
    newEvent.setEventDate(eventDTO.getEventDate());

    newEvent.setBackyardId(eventDTO.getBackyardId());

    listOfCustomerEvents.add(newEvent);
    customer.setEvents(listOfCustomerEvents);

    Customer customerAfterSave = customerRepository.save(customer);
    List<Event> customerEventEntityAfterAddition = customerAfterSave.getEvents();
    Event newEventWithId = customerEventEntityAfterAddition.get(customerEventEntityAfterAddition.size() - 1); //gets the last event

    return newEventWithId.getEventId();
  }

  @Override
  public String deleteEventForCustomer(Integer customerId, Integer eventId) throws BackyardWeddingException {
    Customer customer = customerRepository.findById(customerId).orElseThrow(
        () -> new BackyardWeddingException("SERVICE ERROR: Could not find customer with that customerId."));

    // nulls customerId in event table
    // List<Event> listOfCustomerEvents = customer.getEvents();
    // listOfCustomerEvents.removeIf(event -> event.getEventId().equals(eventId));
    // customer.setEvents(listOfCustomerEvents);
    // customerRepository.save(customer);

    Event eventToRemove = eventRepository.findById(eventId).orElseThrow(
        () -> new BackyardWeddingException("SERVICE ERROR: Could not find event with that eventId"));
    eventRepository.delete(eventToRemove);

    return "SERVICE: event removed successfully.";
  }
}
