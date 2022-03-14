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

  // saving it and see if the container object exist.
  // this is not really needed since we have the saveCustomerValidTest below. We need to change primary key to string...
  @BeforeEach
  public void setUp() {
    customer = new Customer();
    // customer.setCustomerId(1);
    customer.setFirstName("Kyla");
    customer.setLastName("Friso");
    customer.setDob(LocalDate.now());
    customer.setEmail("kylafriso@gmail.com");
    customer.setCity("Japan");
  }

  // save it and test if data saved is correct
  @Test
  void saveCustomerValidTest() {
    Customer customerFromDB = customerRepository.save(customer);
    Assertions.assertEquals("kylafriso@gmail.com", customerFromDB.getEmail());
  }

  // testing delete
  @Test
  void deleteCustomer() {
    customerRepository.save(customer);
    customerRepository.delete(customer);
    Optional<Customer> customers = customerRepository.findById(1);
    Assertions.assertTrue(customers.isEmpty());
  }


  
}
