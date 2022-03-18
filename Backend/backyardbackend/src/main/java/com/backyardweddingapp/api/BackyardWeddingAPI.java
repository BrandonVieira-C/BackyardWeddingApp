package com.backyardweddingapp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backyardweddingapp.dto.BackyardDTO;
import com.backyardweddingapp.dto.CustomerDTO;
import com.backyardweddingapp.dto.EventDTO;
import com.backyardweddingapp.dto.PartnerDTO;
import com.backyardweddingapp.entity.Customer;
import com.backyardweddingapp.exception.BackyardWeddingException;
import com.backyardweddingapp.service.BackyardWeddingService;

@RestController
@RequestMapping(value="/wedding")
public class BackyardWeddingAPI {
	
	@Autowired
	BackyardWeddingService backyardWeddingService;
	
	//customer CRUD methods
	
	@PostMapping(value="/addcustomer")
	public ResponseEntity<String> addCustomer (@RequestBody CustomerDTO customerDTO) throws BackyardWeddingException {		
		String customerCreated = backyardWeddingService.addCustomer(customerDTO);	
		return new ResponseEntity<>(customerCreated, HttpStatus.CREATED);
		
	}	
	
	@GetMapping(value="/getcustomer/{customerId}")
	public ResponseEntity<CustomerDTO> getCustomer (@PathVariable("customerId") String email) throws BackyardWeddingException {
		CustomerDTO dto = backyardWeddingService.getCustomer(email);	
		return new ResponseEntity<CustomerDTO>(dto, HttpStatus.OK);
		
	}
	
	@PutMapping(value="/updatecustomer")
	public ResponseEntity<CustomerDTO> updateCustomer (@RequestBody CustomerDTO customerDto) throws BackyardWeddingException {
		CustomerDTO dto = backyardWeddingService.updateCustomer(customerDto);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deletecustomer/{customerId}")
	public ResponseEntity<String> deleteCustomer (@PathVariable("customerId") String email) throws BackyardWeddingException {
		String d = backyardWeddingService.deleteCustomer(email);
		return new ResponseEntity<>(d, HttpStatus.OK);
	}
	
	//partner CRUD methods
	
	@PostMapping(value="/addpartner")
	public ResponseEntity<String> addPartner (@RequestBody PartnerDTO partnerDTO) throws BackyardWeddingException {
		Integer num = backyardWeddingService.addPartner(partnerDTO);
		String successMessage = "Partner ID created: " + num;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
		
	}
	
	@GetMapping(value="/getpartner/{partnerId}")
	public ResponseEntity<PartnerDTO> getPartner (@PathVariable("partnerId") Integer partnerId) throws BackyardWeddingException {
		PartnerDTO dto = backyardWeddingService.getPartner(partnerId);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PutMapping(value="/updatepartner")
	public ResponseEntity<PartnerDTO> updateParter (@RequestBody PartnerDTO partnerDto) throws BackyardWeddingException {
		PartnerDTO dto = backyardWeddingService.updatePartner(partnerDto);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deletepartner/{partnerId}")
	public ResponseEntity<String> deletePartner (@PathVariable("partnerId") Integer partnerId) throws BackyardWeddingException {
		String thing = backyardWeddingService.deletePartner(partnerId);
		return new ResponseEntity<>(thing, HttpStatus.OK);
	}
	
	//backyard CRUD methods
	
	@PostMapping(value="/addbackyard")
	public ResponseEntity<String> addBackyard (@RequestBody BackyardDTO backyardDTO) throws BackyardWeddingException {	
		Integer num = backyardWeddingService.addBackyard(backyardDTO);
		String successMessage = "You have created backyard: "+ backyardDTO.getBackyardName()+" ("+num+").";		
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
		
	}
	
	@GetMapping(value="/getbackyard/{backyardId}")
	public ResponseEntity<BackyardDTO> getBackyard (@PathVariable("backyardId") Integer backyardId) throws BackyardWeddingException {
		BackyardDTO dto = backyardWeddingService.getBackyard(backyardId);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@GetMapping(value="/getbackyards/{city}")
	public ResponseEntity<List<BackyardDTO>> getBackyardsByCity (@PathVariable("city") String city) throws BackyardWeddingException {
		List<BackyardDTO> dto = backyardWeddingService.getBackyardsByCity(city);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PutMapping(value="/updatebackyard")
	public ResponseEntity<BackyardDTO> updateBackyard (@RequestBody BackyardDTO backyardDto) throws BackyardWeddingException {
		BackyardDTO dto = backyardWeddingService.updateBackyard(backyardDto);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deletebackyard/{backyardId}")
	public ResponseEntity<String> deleteBackyard (@PathVariable("backyardId") Integer backyardId) throws BackyardWeddingException {
		String thing = backyardWeddingService.deleteBackyard(backyardId);
		return new ResponseEntity<>(thing, HttpStatus.OK);
	}
	
	//event CRUD methods
	
	@PostMapping(value="/addevent")
	public ResponseEntity<String> addEvent (@RequestParam String email, @RequestParam Integer partnerId, @RequestParam Integer backyardId, @RequestBody EventDTO eventDTO) throws BackyardWeddingException {	
		Integer num = backyardWeddingService.addEvent(email, partnerId, backyardId, eventDTO);
		String successMessage = "Your event has been created. Event ID: "+ num;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
		
	}
	
	@GetMapping(value="/getevent/{eventId}")
	public ResponseEntity<EventDTO> getEvent (@PathVariable("eventid") Integer eventId) throws BackyardWeddingException {
		EventDTO dto = backyardWeddingService.getEvent(eventId);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PutMapping(value="/updateevent")
	public ResponseEntity<EventDTO> updateEvent (@RequestBody EventDTO eventDto) throws BackyardWeddingException {
		EventDTO dto = backyardWeddingService.updateEvent(eventDto);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteevent/{eventId}")
	public ResponseEntity<String> deleteEvent (@PathVariable("eventId") Integer eventId) throws BackyardWeddingException {
		String thing = backyardWeddingService.deleteEvent(eventId);
		return new ResponseEntity<>(thing, HttpStatus.OK);
	}
	


		
				
}
