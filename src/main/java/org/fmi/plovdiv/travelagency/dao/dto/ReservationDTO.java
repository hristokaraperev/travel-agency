package org.fmi.plovdiv.travelagency.dao.dto;

import java.util.List;

import org.fmi.plovdiv.travelagency.dao.dto.contact.ResponseContactDTO;

public class ReservationDTO {

	private Long id;
	private HolidayDTO holiday;
	private List<ResponseContactDTO> contacts;
	
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
	public List<ResponseContactDTO> getContacts() {
		return contacts;
	}
	public void setContacts(List<ResponseContactDTO> contacts) {
		this.contacts = contacts;
	}
}
