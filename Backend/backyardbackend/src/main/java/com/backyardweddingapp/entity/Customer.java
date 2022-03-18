package com.backyardweddingapp.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	
	private Integer customerId;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	@Id
	@Column(name="customer_email")
	private String email;
	private String city;
	
	public Customer(Integer customerId, String firstName, String lastName, LocalDate dob, String email, String city) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.city = city;
	}
	public Customer() {
		super();
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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
	@Override
	public int hashCode() {
		return Objects.hash(customerId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return email == other.email;
	}
	@Override
	public String toString() {
		return "FirstName=" + firstName + ", lastName=" + lastName + ", dob="
				+ dob + ", email=" + email + ", city=" + city + "]";
	}
	
	
	
	

}
