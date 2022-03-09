package com.backyardweddingapp.dto;

import java.time.LocalDate;
import com.backyardweddingapp.entity.Customer;
import com.backyardweddingapp.entity.Partner;

public class EventDTO {
	
	private int eventId;
	private Customer customer;
	private int amountPaid;
	private LocalDate dateOfEvent;
	private Partner partner;
	
	public EventDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EventDTO(int eventId, Customer customer, int amountPaid, LocalDate dateOfEvent, Partner partner) {
		super();
		this.eventId = eventId;
		this.customer = customer;
		this.amountPaid = amountPaid;
		this.dateOfEvent = dateOfEvent;
		this.partner = partner;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}
	public LocalDate getDateOfEvent() {
		return dateOfEvent;
	}
	public void setDateOfEvent(LocalDate dateOfEvent) {
		this.dateOfEvent = dateOfEvent;
	}
	public Partner getPartner() {
		return partner;
	}
	public void setPartner(Partner partner) {
		this.partner = partner;
	}
	
	

}
