package com.backyardweddingapp.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.backyardweddingapp.dto.BackyardDTO;
import com.backyardweddingapp.dto.CustomerDTO;
import com.backyardweddingapp.dto.EventDTO;
import com.backyardweddingapp.dto.PartnerDTO;
import com.backyardweddingapp.exception.BackyardWeddingException;
@Component
public interface BackyardWeddingService {
	
	//customer CRUD methods
	
	public String addCustomer (CustomerDTO customerDTO) throws BackyardWeddingException;
	
	public CustomerDTO getCustomer(String email) throws BackyardWeddingException;
	
	public CustomerDTO updateCustomer(CustomerDTO customerDto) throws BackyardWeddingException;
	
	public String deleteCustomer(String email) throws BackyardWeddingException;
	
	//partner CRUD methods
	
	public Integer addPartner (PartnerDTO partnerDTO) throws BackyardWeddingException;
	
	public PartnerDTO getPartner(Integer partnerId) throws BackyardWeddingException;
	
	public PartnerDTO updatePartner(PartnerDTO partnerDto) throws BackyardWeddingException;
	
	public String deletePartner(Integer partnerId) throws BackyardWeddingException;
	
	//backyard CRUD methods
	
	public Integer addBackyard (BackyardDTO backyardDto) throws BackyardWeddingException;
	
	public BackyardDTO getBackyard(Integer backyardId) throws BackyardWeddingException;
	
	public List<BackyardDTO> getBackyardsByCity(String city) throws BackyardWeddingException;
	
	public BackyardDTO updateBackyard(BackyardDTO backyardDto) throws BackyardWeddingException;
	
	public String deleteBackyard(Integer backyardId) throws BackyardWeddingException;
	
	//event CRUD methods

	public Integer addEvent(String email, Integer partnerId, Integer backyardId, EventDTO eventDto) throws BackyardWeddingException;
	
	public EventDTO getEvent(Integer eventId) throws BackyardWeddingException;
	
	public EventDTO updateEvent(EventDTO eventDto) throws BackyardWeddingException;
	
	public String deleteEvent(Integer eventId) throws BackyardWeddingException;
	
}
