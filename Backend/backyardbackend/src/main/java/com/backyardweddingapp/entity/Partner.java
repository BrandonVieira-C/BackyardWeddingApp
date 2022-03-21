package com.backyardweddingapp.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="partner")
public class Partner {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="partner_id")
	private int partnerId;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="dob")
	private LocalDate dob;

	@Column(name="email")
	private String email;

	@Column(name="city")
	private String city;

  // one partner has many events
  @OneToMany(cascade=CascadeType.ALL)
  @JoinColumn(name="partner_id")
  private List<Backyard> listOfBackyards;
	
	public List<Backyard> getListOfBackyards() {
    return listOfBackyards;
  }
  public void setListOfBackyards(List<Backyard> listOfBackyards) {
    this.listOfBackyards = listOfBackyards;
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
