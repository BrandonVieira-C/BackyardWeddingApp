package com.backyardweddingapp.backyardbackend.repository;

import java.time.LocalDate;
import java.util.Optional;

import com.backyardweddingapp.entity.Customer;
import com.backyardweddingapp.repository.CustomerRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CustomerRepositoryTest {

  @Autowired
  private CustomerRepository customerRepository;

  private Customer customer;

  @BeforeEach
  public void setUp() {
    customer = new Customer();
    customer.setFirstName("Kyla");
    customer.setLastName("Friso");
    customer.setDob(LocalDate.now());
    customer.setCustomerEmail("kylafriso@gmail.com");
    customer.setCity("Japan");
  }

  // save it and test if data saved is correct
  @Test
  void saveCustomerValidTest() {
    Customer customerFromDB = customerRepository.save(customer);
    Assertions.assertEquals("kylafriso@gmail.com", customerFromDB.getCustomerEmail());
  }

  // testing delete: this teset is very flimsy; AssertTrue if customer is successfully saved first, then delete?
  @Test
  void deleteCustomer() {
    customerRepository.save(customer);
    customerRepository.delete(customer);
    Optional<Customer> customers = customerRepository.findById("kylafriso@gmail.com");
    Assertions.assertTrue(customers.isEmpty());
  }


  
}
