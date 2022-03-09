package com.backyardweddingapp.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Events")
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int eventId;
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer customer;
	private int amountPaid;
	private LocalDate dateOfEvent;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="partner_id")
	private Partner partner;
	
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
	@Override
	public int hashCode() {
		return Objects.hash(eventId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		return eventId == other.eventId;
	}
	
	
	
	
	
	

}
