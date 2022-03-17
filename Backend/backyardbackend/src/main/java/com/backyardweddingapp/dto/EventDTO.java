package com.backyardweddingapp.dto;

import java.time.LocalDate;

import com.backyardweddingapp.entity.Backyard;
import com.backyardweddingapp.entity.Customer;

public class EventDTO {
	
	private int eventId;
	private int amountPaid;
	private LocalDate dateOfEvent;
  
  private Customer customer;
  private Backyard backyard;
	
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
  public Backyard getBackyard() {
    return backyard;
  }
  public void setBackyard(Backyard backyard) {
    this.backyard = backyard;
  }
  @Override
  public String toString() {
    return "EventDTO [amountPaid=" + amountPaid + ", backyard=" + backyard + ", customer=" + customer + ", dateOfEvent="
        + dateOfEvent + ", eventId=" + eventId + "]";
  }

	
	

}
