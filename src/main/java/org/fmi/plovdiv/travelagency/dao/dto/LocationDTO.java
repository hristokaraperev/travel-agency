package org.fmi.plovdiv.travelagency.dao.dto;

import jakarta.validation.constraints.Size;

public class LocationDTO {

	private Long id;
	@Size(min = 0, max = 100, message = "Street name should not be over 100 characters")
	private String street;
	@Size(min = 0, max = 5, message = "Street number should not be over 5 characters")
	private String number;
	@Size(min = 0, max = 50, message = "City should not be over 50 characters")
	private String city;
	@Size(min = 0, max = 50, message = "Country should not be over 50 characters")
	private String country;

	public LocationDTO() {
		super();
	}

	public LocationDTO(Long id, String street, String number, String city, String country) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
		this.city = city;
		this.country = country;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
