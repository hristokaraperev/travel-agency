package org.fmi.plovdiv.travelagency.dao.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class HolidayDTO {

	private Long id;
	private DestinationDTO destination;
	@FutureOrPresent
	private LocalDateTime startDate;
	@PositiveOrZero
	private Integer duration;
	@PositiveOrZero
	private Double price;
	
	public HolidayDTO(Long id, DestinationDTO destination, LocalDateTime startDate, Integer duration, Double price) {
		super();
		this.id = id;
		this.destination = destination;
		this.startDate = startDate;
		this.duration = duration;
		this.price = price;
	}
	
	public HolidayDTO() {
		super();
	}

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
