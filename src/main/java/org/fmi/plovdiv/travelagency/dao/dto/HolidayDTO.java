package org.fmi.plovdiv.travelagency.dao.dto;

import java.time.LocalDateTime;

public class HolidayDTO {

	private Long id;
	private DestinationDTO destination;
	private LocalDateTime startDate;
	private Integer duration;
	private Double price;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public DestinationDTO getDestination() {
		return destination;
	}
	public void setDestination(DestinationDTO destination) {
		this.destination = destination;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
