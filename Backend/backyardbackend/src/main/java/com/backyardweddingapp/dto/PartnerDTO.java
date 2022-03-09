package com.backyardweddingapp.dto;

import java.time.LocalDate;

public class PartnerDTO {
	
	private int partnerId;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String email;
	private String city;
	
	public PartnerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PartnerDTO(int partnerId, String firstName, String lastName, LocalDate dob, String email, String city) {
		super();
		this.partnerId = partnerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.city = city;
	}
	public int getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(int partnerId) {
		this.partnerId = partnerId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	

}
