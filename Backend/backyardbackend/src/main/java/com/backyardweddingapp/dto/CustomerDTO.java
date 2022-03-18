package com.backyardweddingapp.dto;

import java.time.LocalDate;

public class CustomerDTO {
	
	
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String email;
	private String city;
	
	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerDTO(String firstName, String lastName, LocalDate dob, String email, String city) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.city = city;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	public void setDob(LocalDate string) {
		this.dob = string;
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
