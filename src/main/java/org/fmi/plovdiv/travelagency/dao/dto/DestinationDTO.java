package org.fmi.plovdiv.travelagency.dao.dto;

public class DestinationDTO {

	private Long id;
	private LocationDTO location;
	private String title;
	private String description;
	private Integer freeSlots;
	
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
