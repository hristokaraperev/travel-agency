package org.fmi.plovdiv.travelagency.dao.dto.reservation;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class UpdateReservationDTO {

	@Positive
	private Long id;
	@Size(min = 0, max = 100)
	private String contactName;
	@Size(min = 0, max = 10)
	private String phoneNumber;
	@PositiveOrZero
	private Long holiday;
	
	public UpdateReservationDTO(
			Long id,
			String contactName,
			String phoneNumber, 
			Long holiday) {
		super();
		this.id = id;
		this.contactName = contactName;
		this.phoneNumber = phoneNumber;
		this.holiday = holiday;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getHoliday() {
		return holiday;
	}

	public void setHoliday(Long holiday) {
		this.holiday = holiday;
	}

	public UpdateReservationDTO() {
		super();
	}
	
	
}
