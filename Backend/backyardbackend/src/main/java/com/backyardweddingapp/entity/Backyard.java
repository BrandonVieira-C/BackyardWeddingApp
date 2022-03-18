package com.backyardweddingapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Backyard {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int backyardId;
  
	private String backyardName;
	private int squareFootage;
	private String city;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="partner_id")
	private Partner partner;

	private String description;
	private String backyardImage;
		
	public String getBackyardImage() {
		return backyardImage;
	}
	public void setBackyardImage(String backyardImage) {
		this.backyardImage = backyardImage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getBackyardId() {
		return backyardId;
	}
	public void setBackyardId(int backyardId) {
		this.backyardId = backyardId;
	}
	public String getBackyardName() {
		return backyardName;
	}
	public void setBackyardName(String backyardName) {
		this.backyardName = backyardName;
	}
	public int getSquareFootage() {
		return squareFootage;
	}
	public void setSquareFootage(int squareFootage) {
		this.squareFootage = squareFootage;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Partner getPartner() {
		return partner;
	}
	public void setPartner(Partner partner) {
		this.partner = partner;
	}
	
	

}
