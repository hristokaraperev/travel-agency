package org.fmi.plovdiv.travelagency.dao.dto;

import jakarta.validation.constraints.Size;

public class DestinationDTO {

	private Long id;
	private LocationDTO location;
	@Size(min = 0, max = 100, message = "Title name should not be over 100 characters")
	private String title;
	@Size(min = 0, max = 500, message = "Description name should not be over 500 characters")
	private String description;
	@Size(min = 0, message = "Destination cannot have negative free slots")
	private Integer freeSlots;
	
	public DestinationDTO() {
		super();
	}

	public DestinationDTO(Long id, LocationDTO location, String title, String description, Integer freeSlots) {
		super();
		this.id = id;
		this.location = location;
		this.title = title;
		this.description = description;
		this.freeSlots = freeSlots;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocationDTO getLocation() {
		return location;
	}
	public void setLocation(LocationDTO location) {
		this.location = location;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getFreeSlots() {
		return freeSlots;
	}
	public void setFreeSlots(Integer freeSlots) {
		this.freeSlots = freeSlots;
	}
		
	
}
