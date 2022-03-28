package com.backyardweddingapp.api;

import com.backyardweddingapp.dto.CustomerDTO;
import com.backyardweddingapp.dto.EventDTO;
import com.backyardweddingapp.exception.BackyardWeddingException;
import com.backyardweddingapp.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/wedding")
public class CustomerAPI {

  @Autowired
  CustomerService customerService;

  @PostMapping(value = "/addcustomer")
  public ResponseEntity<String> addCustomer(@RequestBody CustomerDTO customerDTO) throws BackyardWeddingException {
    Integer newCustomerId = customerService.addCustomer(customerDTO);
    String successMsg = "New customer added with new customerId: " + newCustomerId;
    return new ResponseEntity<>(successMsg, HttpStatus.CREATED);
  }

  @GetMapping(value = "/getcustomer")
  public ResponseEntity<CustomerDTO> getCustomerWithId(@RequestBody CustomerDTO customerDTO)
      throws BackyardWeddingException {
    CustomerDTO returned = customerService.getCustomer(customerDTO.getCustomerId());
    return new ResponseEntity<CustomerDTO>(returned, HttpStatus.OK);
  }

  @PostMapping(value = "/addevent/{customerId}")
  public ResponseEntity<String> addEventForCustomer(
      @RequestBody EventDTO eventDTO,
      @PathVariable("customerId") Integer customerId) throws BackyardWeddingException {
    Integer newEventId = customerService.addEventForCustomer(customerId, eventDTO);
    String successMsg = "New event added with new eventId: " + newEventId;
    return new ResponseEntity<>(successMsg, HttpStatus.CREATED);
  }

  @DeleteMapping(value = "/deleteevent/{customerId}")
  public ResponseEntity<String> deleteEventForCustomer(
      @RequestBody EventDTO eventDTO,
      @PathVariable("customerId") Integer customerId) throws BackyardWeddingException {
    String successMsg = customerService.deleteEventForCustomer(customerId, eventDTO.getEventId());
    return new ResponseEntity<>(successMsg, HttpStatus.OK);
  }

}
