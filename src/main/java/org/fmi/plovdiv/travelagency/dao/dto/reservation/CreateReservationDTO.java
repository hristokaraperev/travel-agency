package org.fmi.plovdiv.travelagency.dao.dto.reservation;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CreateReservationDTO {

	@Size(min = 1, max = 100)
	private String contactName;
	@Size(min = 1, max = 10)
	private String phoneNumber;
	@Positive
	private Long holiday;
	
	public CreateReservationDTO() {
		super();
	}

	public CreateReservationDTO(
			String contactName,
			String phoneNumber, 
			Long holiday) {
		super();
		this.contactName = contactName;
		this.phoneNumber = phoneNumber;
		this.holiday = holiday;
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
}
