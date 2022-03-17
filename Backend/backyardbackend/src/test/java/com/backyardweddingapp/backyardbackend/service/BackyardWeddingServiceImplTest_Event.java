package com.backyardweddingapp.backyardbackend.service;

import com.backyardweddingapp.repository.EventRespository;
import com.backyardweddingapp.service.BackyardWeddingService;
import com.backyardweddingapp.service.BackyardWeddingServiceImpl;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BackyardWeddingServiceImplTest_Event {
  
  @Mock
  private EventRespository eventRepository;

  @InjectMocks
  private BackyardWeddingService eventService = new BackyardWeddingServiceImpl();

  

}
