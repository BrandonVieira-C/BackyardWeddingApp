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
	String addCustomer (CustomerDTO customerDTO) throws BackyardWeddingException;
	CustomerDTO getCustomer(String customerEmail) throws BackyardWeddingException;
	void updateCustomer(CustomerDTO customerDTO) throws BackyardWeddingException;
	void deleteCustomer(String customerEmail) throws BackyardWeddingException;

  //event CRUD methods
	Integer addEvent(EventDTO eventDTO) throws BackyardWeddingException;
	EventDTO getEvent(Integer eventId) throws BackyardWeddingException;
	void updateEvent(EventDTO eventDTO) throws BackyardWeddingException;
	void deleteEvent(Integer eventId) throws BackyardWeddingException;

	
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

	
}
