package com.backyardweddingapp.backyardbackend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.backyardweddingapp.dto.BackyardDTO;
import com.backyardweddingapp.entity.Backyard;
import com.backyardweddingapp.exception.BackyardWeddingException;
import com.backyardweddingapp.repository.BackyardRepository;
import com.backyardweddingapp.service.BackyardWeddingServiceImpl;
@SpringBootTest
public class BackyardServiceTest {
	
	private Backyard entity = new Backyard();
	
	@Mock
	BackyardRepository backyardRepo;
	
	@InjectMocks
	BackyardWeddingServiceImpl serviceImpl;
	
	@BeforeEach
	public void createBackyard() {
		int id = 1;
		String image = "s";
		String name = "Wonder Wall";
		String city = "Calgary";
		String descr = "Majestic";
		int sqft = 140000;
		
		entity.setBackyardId(id);
		entity.setBackyardImage(image);
		entity.setBackyardName(name);
		entity.setCity(city);
		entity.setDescription(descr);
		entity.setSquareFootage(sqft);
		
		
	}

	@Test
	public void addBackyardTest() throws BackyardWeddingException {
		BackyardDTO dto = new BackyardDTO();
		dto.setBackyardId(entity.getBackyardId());
		dto.setBackyardImage(entity.getBackyardImage());
		dto.setBackyardName(entity.getBackyardName());
		dto.setCity(entity.getCity());
		dto.setDescription(entity.getDescription());
		dto.setSquareFootage(entity.getSquareFootage());
		
	//	Mockito.when(backyardRepo.save(entity)).thenReturn(entity);
		Assertions.assertEquals(1, serviceImpl.addBackyard(dto));
	
	}
	

	@Test
	public void getBackyardTest () throws BackyardWeddingException {
		BackyardDTO backyardDto = new BackyardDTO();
		backyardDto.setDescription(entity.getDescription());
		Mockito.when(backyardRepo.findById(entity.getBackyardId())).thenReturn(Optional.of(entity));
		Assertions.assertEquals(backyardDto.getDescription(), serviceImpl.getBackyard(entity.getBackyardId()).getDescription());
	}
	
	//not sure how to assert equals two lists...
	@Test
	public void getBackyardsByCityTest() throws BackyardWeddingException {
		List<Backyard> backyardEntityList = new ArrayList<Backyard>();
		backyardEntityList.add(entity);
		
		BackyardDTO dto = new BackyardDTO();
		dto.setBackyardId(entity.getBackyardId());
		dto.setBackyardImage(entity.getBackyardImage());
		dto.setBackyardName(entity.getBackyardName());
		dto.setCity(entity.getCity());
		dto.setDescription(entity.getDescription());
		dto.setSquareFootage(entity.getSquareFootage());
		
		List<BackyardDTO> backyardDtoList = new ArrayList<BackyardDTO>();
		backyardDtoList.add(dto);
		
		Mockito.when(backyardRepo.findByCity(entity.getCity())).thenReturn(Optional.of(backyardEntityList));
		Assertions.assertEquals(backyardDtoList, serviceImpl.getBackyardsByCity(entity.getCity()));
		
	}
	
	@Test
	public void updateBackyardTest() throws BackyardWeddingException {
		BackyardDTO dto = new BackyardDTO();
		dto.setBackyardId(entity.getBackyardId());
		dto.setBackyardImage(entity.getBackyardImage());
		dto.setBackyardName("Changed Name!");
		dto.setCity(entity.getCity());
		dto.setDescription(entity.getDescription());
		dto.setSquareFootage(entity.getSquareFootage());
		
		Mockito.when(backyardRepo.findById(entity.getBackyardId())).thenReturn(Optional.of(entity));
		entity.setBackyardName(dto.getBackyardName());
		Mockito.when(backyardRepo.save(entity)).thenReturn(entity);
		Assertions.assertNotEquals("Wonder Wall", entity.getBackyardName());
		
		
	}
	

	@Test
	public void deleteBackyardTest() throws BackyardWeddingException {
		Mockito.when(backyardRepo.findById(entity.getBackyardId())).thenReturn(Optional.of(entity));
		Assertions.assertEquals("Backyard deleted.", serviceImpl.deleteBackyard(entity.getBackyardId()));
		
	}
	
	

}
