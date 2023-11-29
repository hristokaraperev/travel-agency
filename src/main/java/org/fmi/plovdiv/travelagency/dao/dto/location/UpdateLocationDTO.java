package org.fmi.plovdiv.travelagency.dao.dto.location;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class UpdateLocationDTO {

	@Positive
	private Long id;
	@Size(min = 0, max = 100)
	private String street;
	@Size(min = 0, max = 5)
	private String number;
	@Size(min = 0, max = 50)
	private String city;
	@Size(min = 0, max = 50)
	private String country;
	
	public UpdateLocationDTO(
			Long id, 
			String street,
			String number,
			String city,
			String country) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
		this.city = city;
		this.country = country;
	}

	public UpdateLocationDTO() {
		super();
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
