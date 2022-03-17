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

    customerRepository.save(customer);
    return customerDTO.getCustomerEmail();
  }

  @Override
  public CustomerDTO getCustomer(String customerEmail) throws BackyardWeddingException {
    Customer customer = customerRepository.findById(customerEmail)
        .orElseThrow(() -> new BackyardWeddingException("Could not find customer with that ID"));

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
    Customer customer = customerRepository.findById(customerDto.getCustomerEmail())
        .orElseThrow(() -> new BackyardWeddingException("Could not find customer with that ID"));

    customer.setCity(customerDto.getCity());
    customer.setCustomerEmail(customerDto.getCustomerEmail());
    customer.setDob(customerDto.getDob());
    customer.setFirstName(customerDto.getFirstName());
    customer.setLastName(customerDto.getLastName());

    return;
  }

  @Override
  public void deleteCustomer(String customerEmail) throws BackyardWeddingException {
    Customer customer = customerRepository.findById(customerEmail)
        .orElseThrow(() -> new BackyardWeddingException("Could not find customer with that ID"));

    customerRepository.delete(customer);
    return;
  }

  // event CRUD methods
  @Override
  public EventDTO addEvent(String customerEmail, Integer backyardId, EventDTO eventDto) throws BackyardWeddingException {

    Customer customerContainer = customerRepository.findById(customerEmail).orElseThrow(
      () -> new BackyardWeddingException("SERVICE ERROR: There is no customer by this customer email.")
    );
    
    Backyard backyardContainer = backyardRepository.findById(backyardId).orElseThrow(
      () -> new BackyardWeddingException("SERVICE ERROR: There is no backyard by this backyard id.")
    );


    Event event = new Event();
    event.setAmountPaid(eventDto.getAmountPaid());
    event.setDateOfEvent(eventDto.getDateOfEvent());
    event.setCustomer(customerContainer);
    event.setBackyard(backyardContainer);

    eventRepository.save(event);

    EventDTO dto = new EventDTO();
    dto.setEventId(event.getEventId());
    dto.setAmountPaid(event.getAmountPaid());
    dto.setDateOfEvent(event.getDateOfEvent());
    dto.setCustomer(event.getCustomer());
    dto.setBackyard(event.getBackyard());
    
    return dto;

  }

  public EventDTO getEvent(Integer eventId) throws BackyardWeddingException {
    Event event = eventRepository.findById(eventId)
        .orElseThrow(() -> new BackyardWeddingException("Event not found."));

    EventDTO dto = new EventDTO();
    dto.setAmountPaid(event.getAmountPaid());
    dto.setCustomer(event.getCustomer());
    dto.setDateOfEvent(event.getDateOfEvent());
    dto.setEventId(event.getEventId());
    // dto.setPartner(event.getPartner());
    return dto;

  }

  public EventDTO updateEvent(EventDTO eventDto) throws BackyardWeddingException {
    Event event = eventRepository.findById(eventDto.getEventId())
        .orElseThrow(() -> new BackyardWeddingException("Event not found."));

    event.setAmountPaid(eventDto.getAmountPaid());
    event.setCustomer(eventDto.getCustomer());
    event.setDateOfEvent(eventDto.getDateOfEvent());
    event.setEventId(eventDto.getEventId());
    // event.setPartner(eventDto.getPartner());
    return eventDto;

  }

  public String deleteEvent(Integer eventId) throws BackyardWeddingException {
    Event event = eventRepository.findById(eventId)
        .orElseThrow(() -> new BackyardWeddingException("Event not found."));

    eventRepository.delete(event);
    return "Event has been deleted.";

  }

  // partner CRUD methods

  @Override
  public Integer addPartner(PartnerDTO partnerDTO) throws BackyardWeddingException {
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
    Partner partner = partnerRepository.findById(partnerId)
        .orElseThrow(() -> new BackyardWeddingException("Partner not found."));

    PartnerDTO dto = new PartnerDTO();
    dto.setCity(partner.getCity());
    dto.setDob(partner.getDob());
    dto.setEmail(partner.getEmail());
    dto.setFirstName(partner.getFirstName());
    dto.setLastName(partner.getLastName());
    return dto;

  }

  public PartnerDTO updatePartner(PartnerDTO partnerDto) throws BackyardWeddingException {
    Partner partner = partnerRepository.findById(partnerDto.getPartnerId())
        .orElseThrow(() -> new BackyardWeddingException("Partner not found."));

    partner.setCity(partnerDto.getCity());
    partner.setDob(partnerDto.getDob());
    partner.setEmail(partnerDto.getEmail());
    partner.setFirstName(partnerDto.getFirstName());
    partner.setLastName(partnerDto.getLastName());
    return partnerDto;

  }

  public String deletePartner(Integer partnerId) throws BackyardWeddingException {
    Partner partner = partnerRepository.findById(partnerId)
        .orElseThrow(() -> new BackyardWeddingException("Partner not found."));

    partnerRepository.delete(partner);
    return "Account deleted.";

  }

  // backyard CRUD methods

  @Override
  public Integer addBackyard(BackyardDTO backyardDto) throws BackyardWeddingException {
    Backyard backyard = new Backyard();
    backyard.setBackyardName(backyardDto.getBackyardName());
    backyard.setCity(backyardDto.getCity());
    backyard.setSquareFootage(backyardDto.getSquareFootage());
    backyard.setPartner(backyardDto.getPartner());
    backyard.setDescription(backyardDto.getDescription());
    backyard.setBackyardImage(backyardDto.getBackyardImage());
    Backyard backyard2 = backyardRepository.save(backyard);
    return backyard2.getBackyardId();

  }

  public BackyardDTO getBackyard(Integer backyardId) throws BackyardWeddingException {
    Backyard backyard = backyardRepository.findById(backyardId)
        .orElseThrow(() -> new BackyardWeddingException("Cannot find that backyard ID."));

    BackyardDTO dto = new BackyardDTO();
    dto.setBackyardName(backyard.getBackyardName());
    dto.setCity(backyard.getCity());
    dto.setSquareFootage(backyard.getSquareFootage());
    dto.setPartner(backyard.getPartner());
    return dto;
  }

  public List<BackyardDTO> getBackyardsByCity(String city) throws BackyardWeddingException {
    List<Backyard> backyardsArray = backyardRepository.findByCity(city);
    if (backyardsArray.isEmpty()) {
      throw new BackyardWeddingException("There are no search results.");
    }
    List<BackyardDTO> dtoArray = backyardsArray.stream()
        .map(entity -> {
          BackyardDTO dto = new BackyardDTO();
          dto.setBackyardId(entity.getBackyardId());
          dto.setBackyardName(entity.getBackyardName());
          dto.setCity(entity.getCity());
          dto.setPartner(entity.getPartner());
          dto.setSquareFootage(entity.getSquareFootage());
          return dto;
        })
        .collect(Collectors.toList());

    return dtoArray;

  }

  public BackyardDTO updateBackyard(BackyardDTO backyardDto) throws BackyardWeddingException {
    Backyard backyard = backyardRepository.findById(backyardDto.getBackyardId())
        .orElseThrow(() -> new BackyardWeddingException("Cannot find that backyard ID."));

    backyard.setBackyardName(backyardDto.getBackyardName());
    backyard.setCity(backyardDto.getCity());
    backyard.setSquareFootage(backyardDto.getSquareFootage());
    backyard.setPartner(backyardDto.getPartner());
    return backyardDto;

  }

  public String deleteBackyard(Integer backyardId) throws BackyardWeddingException {
    Backyard backyard = backyardRepository.findById(backyardId)
        .orElseThrow(() -> new BackyardWeddingException("Cannot find that backyard ID."));

    backyardRepository.delete(backyard);
    return "Backyard deleted.";

  }

}
