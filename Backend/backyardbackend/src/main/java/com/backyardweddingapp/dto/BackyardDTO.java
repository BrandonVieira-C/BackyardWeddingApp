package com.backyardweddingapp.dto;

import com.backyardweddingapp.entity.Partner;

public class BackyardDTO {
	
	private int backyardId;
	private String backyardName;
	private int squareFootage;
	private String city;
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

	public BackyardDTO() {
		super();
	}
	
	public BackyardDTO(int backyardId, String backyardName, int squareFootage, String city, Partner partner) {
		super();
		this.backyardId = backyardId;
		this.backyardName = backyardName;
		this.squareFootage = squareFootage;
		this.city = city;
		this.partner = partner;
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
