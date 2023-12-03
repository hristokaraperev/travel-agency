package org.fmi.plovdiv.travelagency.dao.dto.holiday;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class UpdateHolidayDTO {

	@Positive
	private Long id;
	@PositiveOrZero
	private Long location;
	@Size(min = 0, max = 100)
	private String title;
	
	private LocalDate startDate;
	@PositiveOrZero
	private Integer duration;
	@PositiveOrZero
	private Double price;
	@PositiveOrZero
	private Integer freeSlots;
	
	public UpdateHolidayDTO() {
		super();
	}

	public UpdateHolidayDTO(@PositiveOrZero Long id, @PositiveOrZero Long location,
			@Size(min = 1, max = 100) String title, @FutureOrPresent LocalDate startDate,
			@PositiveOrZero Integer duration, @PositiveOrZero Double price, @PositiveOrZero Integer freeSlots) {
		super();
		this.id = id;
		this.location = location;
		this.title = title;
		this.startDate = startDate;
		this.duration = duration;
		this.price = price;
		this.freeSlots = freeSlots;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLocation() {
		return location;
	}

	public void setLocation(Long location) {
		this.location = location;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
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

	public Integer getFreeSlots() {
		return freeSlots;
	}

	public void setFreeSlots(Integer freeSlots) {
		this.freeSlots = freeSlots;
	}
}
