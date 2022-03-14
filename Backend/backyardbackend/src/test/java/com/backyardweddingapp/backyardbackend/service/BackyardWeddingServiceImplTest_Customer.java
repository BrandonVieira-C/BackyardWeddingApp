package com.backyardweddingapp.backyardbackend.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.backyardweddingapp.dto.CustomerDTO;
import com.backyardweddingapp.exception.BackyardWeddingException;
import com.backyardweddingapp.repository.CustomerRepository;
import com.backyardweddingapp.service.BackyardWeddingService;
import com.backyardweddingapp.service.BackyardWeddingServiceImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest //TODO: change this to be more specific: WebMVC?
public class BackyardWeddingServiceImplTest_Customer {
  
  @Autowired
  private BackyardWeddingService customerService = new BackyardWeddingServiceImpl();

  @Test
  void createValidCustomer() {

    CustomerDTO customerDTO = new CustomerDTO();
    customerDTO.setCustomerEmail("annTseng@gmail.com");
    customerDTO.setFirstName("Ann");
    customerDTO.setLastName("Tseng");
    customerDTO.setCity("Taiwan");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    String date = "16/09/1999";
    LocalDate dob = LocalDate.parse(date, formatter);
    customerDTO.setDob(dob);
    
    try {
      customerService.addCustomer(customerDTO);
    } catch (BackyardWeddingException e) {
      Logger.getLogger(BackyardWeddingServiceImplTest_Customer.class.getName()).log(Level.SEVERE, null, e);
      Assertions.fail("customer was valid. no exception should have been thrown.");
    }
  }


}
