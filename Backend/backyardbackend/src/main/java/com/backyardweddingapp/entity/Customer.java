package com.backyardweddingapp.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
  
	@Id
  @Column(name="customer_email")
	private String customerEmail;

  @Column(name="first_name")
	private String firstName;

  @Column(name="last_name")
	private String lastName;

  @Column(name="dob")
	private LocalDate dob;

  @Column(name="city")
	private String city;

  // @OneToMany(cascade=CascadeType.ALL)
  // @JoinColumn(name="customer_email")
  // private List<Event> events;
		
	// public List<Event> getEvents() {
  //   return events;
  // }
  // public void setEvents(List<Event> events) {
  //   this.events = events;
  // }
  public String getCustomerEmail() {
    return customerEmail;
  }
  public void setCustomerEmail(String customerEmail) {
    this.customerEmail = customerEmail;
  }
  public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

}
