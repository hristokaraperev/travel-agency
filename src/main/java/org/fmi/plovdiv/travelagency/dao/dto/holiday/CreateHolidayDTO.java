package org.fmi.plovdiv.travelagency.dao.dto.holiday;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CreateHolidayDTO {

	@Positive
	private Long location;
	@Size(min = 1, max = 100)
	private String title;
	
	private LocalDate startDate;
	@Positive
	private Integer duration;
	@Size(min = 1, max = 8)
	private String price;
	@Positive
	private Integer freeSlots;
	
	public CreateHolidayDTO() {
		super();
	}

	public CreateHolidayDTO(@Positive Long location, @Size(min = 1, max = 100) String title,
			@FutureOrPresent LocalDate startDate, @Positive Integer duration, String price,
			@Positive Integer freeSlots) {
		super();
		this.location = location;
		this.title = title;
		this.startDate = startDate;
		this.duration = duration;
		this.price = price;
		this.freeSlots = freeSlots;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Integer getFreeSlots() {
		return freeSlots;
	}

	public void setFreeSlots(Integer freeSlots) {
		this.freeSlots = freeSlots;
	}
	
	
}
