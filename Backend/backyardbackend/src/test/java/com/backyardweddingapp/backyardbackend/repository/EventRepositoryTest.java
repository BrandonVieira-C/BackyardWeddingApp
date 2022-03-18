package com.backyardweddingapp.backyardbackend.repository;

import java.time.LocalDate;
import java.util.Optional;

import com.backyardweddingapp.entity.Backyard;
import com.backyardweddingapp.entity.Customer;
import com.backyardweddingapp.entity.Event;
import com.backyardweddingapp.repository.EventRespository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class EventRepositoryTest {
  
  @Autowired
  private EventRespository eventRepository;

  private Event event;

  @BeforeEach
  void setUp() {
    event = new Event();
    event.setAmountPaid(999);
    event.setDateOfEvent(LocalDate.now());

    Customer customer = new Customer();
    customer.setCustomerEmail("nicoleMiche@gmail.com");
    customer.setFirstName("Nicole");
    event.setCustomer(customer);

    Backyard backyard = new Backyard();
    backyard.setBackyardName("popeyes");
    event.setBackyard(backyard);
  }

  @Test
  void saveFindByIdValidTest() {
    Event eventAfterSave = eventRepository.save(event);
    Optional<Event> eventContainer = eventRepository.findById(eventAfterSave.getEventId());
    Assertions.assertTrue(eventContainer.isPresent());
  }

  @Test
  void findByIdInvalidTest() {
    Optional<Event> eventContainer = eventRepository.findById(2);
    Assertions.assertTrue(eventContainer.isEmpty());
  }

}
