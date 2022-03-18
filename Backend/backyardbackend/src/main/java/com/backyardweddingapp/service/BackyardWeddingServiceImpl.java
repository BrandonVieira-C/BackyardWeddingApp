package com.backyardweddingapp.service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backyardweddingapp.dto.BackyardDTO;
import com.backyardweddingapp.dto.CustomerDTO;
import com.backyardweddingapp.dto.EventDTO;
import com.backyardweddingapp.dto.PartnerDTO;
import com.backyardweddingapp.entity.Backyard;
import com.backyardweddingapp.entity.Customer;
import com.backyardweddingapp.entity.Event;
import com.backyardweddingapp.entity.Partner;
import com.backyardweddingapp.exception.BackyardWeddingException;
import com.backyardweddingapp.repository.BackyardRepository;
import com.backyardweddingapp.repository.CustomerRepository;
import com.backyardweddingapp.repository.EventRespository;
import com.backyardweddingapp.repository.PartnerRepository;


@Service(value="backyardService")
@Transactional
public class BackyardWeddingServiceImpl implements BackyardWeddingService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	PartnerRepository partnerRepository;
	
	@Autowired 
	EventRespository eventRepository;
	
	@Autowired
	BackyardRepository backyardRepository;
	
	
	//customer CRUD methods
	
	@Override
	public String addCustomer (CustomerDTO customerDTO) throws BackyardWeddingException {		
		Customer customer = new Customer();
		customer.setCity(customerDTO.getCity());
		customer.setDob(customerDTO.getDob());
		customer.setEmail(customerDTO.getEmail());
		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		
		return customer.getEmail();
		
	}
	
	@Override
	public CustomerDTO getCustomer(String email) throws BackyardWeddingException {
		Customer customer = customerRepository.findById(email).orElseThrow(() -> new BackyardWeddingException("Could not find customer with that ID"));
		
		CustomerDTO dto = new CustomerDTO();
		dto.setCity(customer.getCity());
		dto.setDob(customer.getDob());
		dto.setEmail(customer.getEmail());
		dto.setFirstName(customer.getFirstName());
		dto.setLastName(customer.getLastName());	
		return dto;
		
	}
	
	public CustomerDTO updateCustomer(CustomerDTO customerDto) throws BackyardWeddingException {	
		Customer customer = customerRepository.findById(customerDto.getEmail()).orElseThrow(() -> new BackyardWeddingException("Could not find customer with that ID"));
		
		CustomerDTO dto = new CustomerDTO();
		customer.setCity(customerDto.getCity());
		customer.setDob(customerDto.getDob());
		customer.setEmail(customerDto.getEmail());
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());	
		return dto;	
		
	}
	
	public String deleteCustomer(String email) throws BackyardWeddingException {
		Customer customer = customerRepository.findById(email).orElseThrow(() -> new BackyardWeddingException("Could not find customer with that ID"));

		customerRepository.delete(customer);	
		return "Account deleted.";	
		
	}
	
	//partner CRUD methods
	
	@Override
	public Integer addPartner (PartnerDTO partnerDTO) throws BackyardWeddingException {	
		Partner partner = new Partner();
		partner.setCity(partnerDTO.getCity());
		partner.setDob(partnerDTO.getDob());
		partner.setEmail(partnerDTO.getEmail());
		partner.setFirstName(partnerDTO.getFirstName());
		partner.setLastName(partnerDTO.getLastName());
		
		Partner partnerNewId = partnerRepository.save(partner);	
		return partnerNewId.getPartnerId();	
		
	}
	
	public PartnerDTO getPartner(Integer partnerId) throws BackyardWeddingException {
		Partner partner = partnerRepository.findById(partnerId).orElseThrow(() -> new BackyardWeddingException("Partner not found."));
		
		PartnerDTO dto = new PartnerDTO();
		dto.setCity(partner.getCity());
		dto.setDob(partner.getDob());
		dto.setEmail(partner.getEmail());
		dto.setFirstName(partner.getFirstName());
		dto.setLastName(partner.getLastName());	
		dto.setPartnerId(partner.getPartnerId());
		return dto;
		
	}
	
	public PartnerDTO updatePartner(PartnerDTO partnerDto) throws BackyardWeddingException {
		Partner partner = partnerRepository.findById(partnerDto.getPartnerId()).orElseThrow(() -> new BackyardWeddingException("Partner not found."));

		partner.setCity(partnerDto.getCity());
		partner.setDob(partnerDto.getDob());
		partner.setEmail(partnerDto.getEmail());
		partner.setFirstName(partnerDto.getFirstName());
		partner.setLastName(partnerDto.getLastName());	
		return partnerDto;	
		
	}
	
	public String deletePartner(Integer partnerId) throws BackyardWeddingException {
		Partner partner = partnerRepository.findById(partnerId).orElseThrow(() -> new BackyardWeddingException("Partner not found."));

		List<Backyard> backyards = backyardRepository.findByPartner(partnerId).orElseThrow(() -> new BackyardWeddingException("Backyard not found."));

		for (Backyard b : backyards) {
			backyardRepository.delete(b);
		}
		
		partnerRepository.delete(partner);
		return "Partner account deleted.";	
		
	}
	
	//backyard CRUD methods
	
	@Override
	public Integer addBackyard (BackyardDTO backyardDto) throws BackyardWeddingException {
		Backyard backyard = new Backyard();
		backyard.setBackyardName(backyardDto.getBackyardName());
		backyard.setCity(backyardDto.getCity());
		backyard.setSquareFootage(backyardDto.getSquareFootage());
		backyard.setDescription(backyardDto.getDescription());	
		backyard.setBackyardImage(backyardDto.getBackyardImage());
		
		Partner partner = new Partner();
		partner.setCity(backyardDto.getPartner().getCity());
		partner.setDob(backyardDto.getPartner().getDob());
		partner.setEmail(backyardDto.getPartner().getEmail());
		partner.setFirstName(backyardDto.getPartner().getFirstName());
		partner.setLastName(backyardDto.getPartner().getLastName());
		partner.setPartnerId(backyardDto.getPartner().getPartnerId());
		backyard.setPartner(partner);
		
		Backyard backyard2 = backyardRepository.save(backyard);	
		
		return backyard2.getBackyardId();
		
	}
	
	public BackyardDTO getBackyard(Integer backyardId) throws BackyardWeddingException {
		Backyard backyard = backyardRepository.findById(backyardId)
				.orElseThrow(() -> new BackyardWeddingException("Cannot find that backyard ID."));
		
		BackyardDTO dto = new BackyardDTO();
		dto.setBackyardName(backyard.getBackyardName());
		dto.setCity(backyard.getCity());
		dto.setPartner(backyard.getPartner());
		dto.setSquareFootage(backyard.getSquareFootage());
		dto.setDescription(backyard.getDescription());
		return dto;
	}
	
	public List<BackyardDTO> getBackyardsByCity(String city) throws BackyardWeddingException {
		List<Backyard> backyardsArray = backyardRepository.findByCity(city).orElseThrow(() -> new BackyardWeddingException("Backyard not found."));;
		if (backyardsArray.isEmpty()) {
			throw new BackyardWeddingException("There are no search results.");
		}
		List<BackyardDTO> dtoArray = backyardsArray.stream()
				.map(entity -> {
			BackyardDTO dto = new BackyardDTO();
			dto.setBackyardId(entity.getBackyardId());
			dto.setBackyardName(entity.getBackyardName());
			dto.setPartner(entity.getPartner());
			dto.setCity(entity.getCity());
			dto.setSquareFootage(entity.getSquareFootage());
			return dto;
		})
			   .collect(Collectors.toList());
		
		
		return dtoArray;
		
	}

	
	public BackyardDTO updateBackyard(BackyardDTO backyardDto) throws BackyardWeddingException {
		Backyard entity = backyardRepository.findById(backyardDto.getBackyardId())
				.orElseThrow(() -> new BackyardWeddingException("Cannot find that backyard ID."));
		
		entity.setBackyardId(backyardDto.getBackyardId());
		entity.setBackyardImage(backyardDto.getBackyardImage());
		entity.setBackyardName(backyardDto.getBackyardName());
		entity.setCity(backyardDto.getCity());
		entity.setPartner(backyardDto.getPartner());
		entity.setDescription(backyardDto.getDescription());
		entity.setSquareFootage(backyardDto.getSquareFootage());
		backyardRepository.save(entity);
		return backyardDto;
		
	}
	
	public String deleteBackyard(Integer backyardId) throws BackyardWeddingException {
		Backyard backyard = backyardRepository.findById(backyardId)
				.orElseThrow(() -> new BackyardWeddingException("Cannot find that backyard ID."));
		
		backyardRepository.delete(backyard);	
		
		return "Backyard deleted.";
		
	}
	
	//event CRUD methods
	
	@Override
	public Integer addEvent(String email, Integer partnerId, Integer backyardId, EventDTO eventDto) throws BackyardWeddingException {
		Event event = new Event();
		event.setAmountPaid(eventDto.getAmountPaid());
		Customer customer = customerRepository.findById(email).orElseThrow(() -> new BackyardWeddingException("There is no customer by this ID."));
		event.setCustomer(customer);
		event.setDateOfEvent(eventDto.getDateOfEvent());
		Backyard backyard = backyardRepository.findById(backyardId).orElseThrow(() -> new BackyardWeddingException("There is no backyard by this ID."));
		event.setBackyard(backyard);
		
		Event event2 = eventRepository.save(event);
		return event2.getEventId();
		
	}
	
	public EventDTO getEvent(Integer eventId) throws BackyardWeddingException {
		Event event = eventRepository.findById(eventId)
				.orElseThrow(() -> new BackyardWeddingException("Event not found."));
		
		EventDTO dto = new EventDTO();
		dto.setAmountPaid(event.getAmountPaid());
		dto.setCustomer(event.getCustomer());
		dto.setDateOfEvent(event.getDateOfEvent());
		dto.setEventId(event.getEventId());
		dto.setBackyard(event.getBackyard());	
		return dto;
		
	}
	
	public EventDTO updateEvent(EventDTO eventDto) throws BackyardWeddingException {
		Event event = eventRepository.findById(eventDto.getEventId())
				.orElseThrow(() -> new BackyardWeddingException("Event not found."));
		
		event.setAmountPaid(eventDto.getAmountPaid());
		event.setCustomer(eventDto.getCustomer());
		event.setDateOfEvent(eventDto.getDateOfEvent());
		event.setEventId(eventDto.getEventId());
		event.setBackyard(eventDto.getBackyard());		
		return eventDto;
		
	}
	
	public String deleteEvent(Integer eventId) throws BackyardWeddingException {
		Event event = eventRepository.findById(eventId)
				.orElseThrow(() -> new BackyardWeddingException("Event not found."));
		
		eventRepository.delete(event);		
	    return "Event has been deleted.";
		
	}


	
	
	

}
