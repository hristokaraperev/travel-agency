package org.fmi.plovdiv.travelagency.dao.dto;

public class ContactDTO {

	private Long id;
	private String contactName;
	private String phoneNumber;
	
	public ContactDTO() {
		super();
	}

	public ContactDTO(Long id, String contactName, String phoneNumber) {
		super();
		this.id = id;
		this.contactName = contactName;
		this.phoneNumber = phoneNumber;
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
	
}
