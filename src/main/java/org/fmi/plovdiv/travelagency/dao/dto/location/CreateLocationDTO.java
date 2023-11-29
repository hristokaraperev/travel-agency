package org.fmi.plovdiv.travelagency.dao.dto.location;

import jakarta.validation.constraints.Size;

public class CreateLocationDTO {

	@Size(min = 1, max = 100)
	private String street;
	@Size(min = 1, max = 5)
	private String number;
	@Size(min = 1, max = 50)
	private String city;
	@Size(min = 1, max = 50)
	private String country;
	
	public CreateLocationDTO(
			String street,
			String number, 
			String city,
			String country) {
		super();
		this.street = street;
		this.number = number;
		this.city = city;
		this.country = country;
	}

	public CreateLocationDTO() {
		super();
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
