package org.fmi.plovdiv.travelagency.dao.dto;

import java.util.List;

public class ReservationDTO {

	private Long id;
	private HolidayDTO holiday;
	private List<ContactDTO> contacts;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public HolidayDTO getHoliday() {
		return holiday;
	}
	public void setHoliday(HolidayDTO holiday) {
		this.holiday = holiday;
	}
	public List<ContactDTO> getContacts() {
		return contacts;
	}
	public void setContacts(List<ContactDTO> contacts) {
		this.contacts = contacts;
	}
}
