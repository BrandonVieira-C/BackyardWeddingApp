package com.backyardweddingapp.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="event")
public class Event {

	@Id
  @Column(name="event_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY) //this allows information transmittion from db to entity.
	private int eventId;

  @Column(name="amount_paid")
	private int amountPaid;

  @Column(name="date_of_event")
	private LocalDate dateOfEvent;

  @OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="customer_email")
	private Customer customer;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="backyard_id")
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
    return "Event [amountPaid=" + amountPaid + ", backyard=" + backyard + ", customer=" + customer + ", dateOfEvent="
        + dateOfEvent + ", eventId=" + eventId + "]";
  }


}
