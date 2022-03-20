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

@Service(value = "backyardService")
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

  // customer CRUD methods
  @Override
  public String addCustomer(CustomerDTO customerDTO) throws BackyardWeddingException {
    Customer customer = new Customer(); // add validation: see if customer already exist
    customer.setCity(customerDTO.getCity());
    customer.setDob(customerDTO.getDob());
    customer.setCustomerEmail(customerDTO.getCustomerEmail());
    customer.setFirstName(customerDTO.getFirstName());
    customer.setLastName(customerDTO.getLastName());

    Customer savedCustomer = customerRepository.save(customer);
    return savedCustomer.getCustomerEmail();
  }

  @Override
  public CustomerDTO getCustomer(String customerEmail) throws BackyardWeddingException {
    Customer customer = customerRepository.findById(customerEmail).orElseThrow(
      () -> new BackyardWeddingException("SERVICE ERROR: Could not find customer with that customerEmail."));

    CustomerDTO dto = new CustomerDTO();
    dto.setCity(customer.getCity());
    dto.setCustomerEmail(customer.getCustomerEmail());
    dto.setDob(customer.getDob());
    dto.setFirstName(customer.getFirstName());
    dto.setLastName(customer.getLastName());
    return dto;
  }

  @Override
  public void updateCustomer(CustomerDTO customerDto) throws BackyardWeddingException {
    Customer customer = customerRepository.findById(customerDto.getCustomerEmail()).orElseThrow(
      () -> new BackyardWeddingException("SERVICE ERROR: Could not find customer with that customerEmail."));

    customer.setCity(customerDto.getCity());
    customer.setCustomerEmail(customerDto.getCustomerEmail());
    customer.setDob(customerDto.getDob());
    customer.setFirstName(customerDto.getFirstName());
    customer.setLastName(customerDto.getLastName());
    return;
  }

  @Override
  public void deleteCustomer(String customerEmail) throws BackyardWeddingException {
    Customer customer = customerRepository.findById(customerEmail).orElseThrow(
      () -> new BackyardWeddingException("SERVICE ERROR: Could not find customer with that customerEmail."));
    customerRepository.delete(customer);
    return;
  }

  // event CRUD methods
  @Override
  public Integer addEvent(EventDTO eventDTO) throws BackyardWeddingException {

    Customer customerContainer = customerRepository.findById(eventDTO.getCustomer().getCustomerEmail()).orElseThrow(
      () -> new BackyardWeddingException("SERVICE ERROR: Could not find customer with that customerEmail."));
    
    Backyard backyardContainer = backyardRepository.findById(eventDTO.getBackyard().getBackyardId()).orElseThrow(
      () -> new BackyardWeddingException("SERVICE ERROR: Could not find backyard with that backyardId."));

    Event event = new Event();
    event.setAmountPaid(eventDTO.getAmountPaid());
    event.setDateOfEvent(eventDTO.getDateOfEvent());
    event.setCustomer(customerContainer);
    event.setBackyard(backyardContainer);

    Event savedEvent = eventRepository.save(event);
    return savedEvent.getEventId();
  }

  public EventDTO getEvent(Integer eventId) throws BackyardWeddingException {
    Event event = eventRepository.findById(eventId).orElseThrow(
      () -> new BackyardWeddingException("SERVICE ERROR: Could not find event with that eventId."));

    EventDTO dto = new EventDTO();
    dto.setEventId(event.getEventId());
    dto.setAmountPaid(event.getAmountPaid());
    dto.setDateOfEvent(event.getDateOfEvent());
    dto.setCustomer(event.getCustomer());
    dto.setBackyard(event.getBackyard());
    return dto;

  }

  public void updateEvent(EventDTO eventDTO) throws BackyardWeddingException {
    Event event = eventRepository.findById(eventDTO.getEventId()).orElseThrow(
      () -> new BackyardWeddingException("SERVICE ERROR: Could not find event with that eventId."));

    event.setAmountPaid(eventDTO.getAmountPaid());
    event.setDateOfEvent(eventDTO.getDateOfEvent());
    return;
  }

  public void deleteEvent(Integer eventId) throws BackyardWeddingException {
    //TODO: bug here. we need to first delete customer and backyard, and then we are allowed to delete event.

    Event event = eventRepository.findById(eventId).orElseThrow(
      () -> new BackyardWeddingException("SERVICE ERROR: Could not find event with that eventId."));

    // List<Event> listOfEvents = event.get // need to add a list in entity?
    
    customerRepository.delete(event.getCustomer());
    backyardRepository.delete(event.getBackyard());
    // deleteCustomer(event.getCustomer().getCustomerEmail());
    // deleteBackyard(event.getBackyard().getBackyardId());

    eventRepository.delete(event);
    return;
  }
	
	//partner CRUD methods
	@Override
	public Integer addPartner (PartnerDTO partnerDTO) throws BackyardWeddingException {	
		Partner partner = new Partner();
    partner.setFirstName(partnerDTO.getFirstName());
    partner.setLastName(partnerDTO.getLastName());
		partner.setCity(partnerDTO.getCity());
		partner.setDob(partnerDTO.getDob());
		partner.setEmail(partnerDTO.getEmail());
		
		Partner partnerNewId = partnerRepository.save(partner);	
		return partnerNewId.getPartnerId();	
	}
	
	public PartnerDTO getPartner(Integer partnerId) throws BackyardWeddingException {
		Partner partner = partnerRepository.findById(partnerId).orElseThrow(
      () -> new BackyardWeddingException("SERVICE ERROR: Could not find partner with that partnerId."));
		
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
		Partner partnerContainer = partnerRepository.findById(partnerDto.getPartnerId()).orElseThrow(
      () -> new BackyardWeddingException("SERVICE ERROR: Could not find partner with that partnerId."));

		partnerContainer.setCity(partnerDto.getCity());
		partnerContainer.setDob(partnerDto.getDob());
		partnerContainer.setEmail(partnerDto.getEmail());
		partnerContainer.setFirstName(partnerDto.getFirstName());
		partnerContainer.setLastName(partnerDto.getLastName());
		return partnerDto;	//TODO: bug here. why return partnerDto...
	}

	// TODO: Bug. unable to delete partner. what should error message be for list-backyard?
	public String deletePartner(Integer partnerId) throws BackyardWeddingException {
		Partner partner = partnerRepository.findById(partnerId).orElseThrow(
      () -> new BackyardWeddingException("SERVICE ERROR: Could not find partner with that partnerId."));
		List<Backyard> backyards = backyardRepository.findByPartner(partnerId).orElseThrow(
      () -> new BackyardWeddingException("SERVICE ERROR: Could not find backyardBackyard not found."));

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

    Partner partnerContainer = partnerRepository.findById(backyardDto.getPartner().getPartnerId()).orElseThrow(
      () -> new BackyardWeddingException("SERVICE ERROR: Could not find partner with that partnerId."));

    backyard.setPartner(partnerContainer);		
		Backyard backyard2 = backyardRepository.save(backyard);	
		return backyard2.getBackyardId();
	}

	@Override
	public BackyardDTO getBackyard(Integer backyardId) throws BackyardWeddingException {
		Backyard backyard = backyardRepository.findById(backyardId).orElseThrow(
      () -> new BackyardWeddingException("SERVICE ERROR: Could not find backyard with that backyardId."));
		
		BackyardDTO dto = new BackyardDTO();
    dto.setBackyardId(backyard.getBackyardId());
		dto.setBackyardName(backyard.getBackyardName());
		dto.setCity(backyard.getCity());
		dto.setSquareFootage(backyard.getSquareFootage());
		dto.setDescription(backyard.getDescription());

    dto.setPartner(backyard.getPartner());
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
			// dto.setPartner(entity.getPartner());
			dto.setCity(entity.getCity());
			dto.setSquareFootage(entity.getSquareFootage());
			return dto;
		})
			   .collect(Collectors.toList());
		return dtoArray;
	}

  // NOTE: will not be able to update partner here. 
	public void updateBackyard(BackyardDTO backyardDto) throws BackyardWeddingException {
		Backyard backyardContainer = backyardRepository.findById(backyardDto.getBackyardId()).orElseThrow(
      () -> new BackyardWeddingException("SERVICE ERROR: Could not find backyard with that backyardId."));
		
    backyardContainer.setBackyardId(backyardDto.getBackyardId());
		backyardContainer.setBackyardImage(backyardDto.getBackyardImage());
		backyardContainer.setBackyardName(backyardDto.getBackyardName());
		backyardContainer.setCity(backyardDto.getCity());
		backyardContainer.setDescription(backyardDto.getDescription());
		backyardContainer.setSquareFootage(backyardDto.getSquareFootage());

		backyardRepository.save(backyardContainer);
		return;
	}
	
	public String deleteBackyard(Integer backyardId) throws BackyardWeddingException {
		Backyard backyard = backyardRepository.findById(backyardId).orElseThrow(
      () -> new BackyardWeddingException("SERVICE ERROR: Could not find backyard with that backyardId."));
		
		backyardRepository.delete(backyard);	
		return "Backyard deleted.";
	}	
}
