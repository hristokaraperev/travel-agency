package org.fmi.plovdiv.travelagency.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.fmi.plovdiv.travelagency.dao.ContactRepository;
import org.fmi.plovdiv.travelagency.dao.dto.contact.ResponseContactDTO;
import org.fmi.plovdiv.travelagency.exceptions.BadContactInformationException;
import org.fmi.plovdiv.travelagency.model.Contact;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
	
	private final ContactRepository contactRepository;
	
	public ContactService(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}
	
	public ResponseContactDTO getOne(Long contactId) {
		Contact c = contactRepository.findById(contactId).get();
		if (!c.getStatus()) {
			throw new NoSuchElementException();
		}
		return new ResponseContactDTO(c.getId(), c.getContactName(), c.getPhoneNumber());
	}

	public List<ResponseContactDTO> getAll() {
		List<Contact> c = contactRepository.findAll();
		List<ResponseContactDTO> output = new ArrayList<ResponseContactDTO>();
		for (Contact i : c) {
			if (i.getStatus()) {
				output.add(new ResponseContactDTO(i.getId(), i.getContactName(), i.getPhoneNumber()));
			}
		}
		return output;
	}
	
	public ResponseContactDTO create(ResponseContactDTO input) throws BadContactInformationException {
		if (contactRepository.existsContactByPhoneNumber(input.getPhoneNumber())) {
			throw new BadContactInformationException();
		}
		Contact c = new Contact();
		c.setStatus(true);
		if (!input.getContactName().isEmpty()) {
			c.setContactName(input.getContactName());
		} else {
			throw new BadContactInformationException();
		}
		if (!input.getPhoneNumber().isEmpty()) {
			c.setPhoneNumber(input.getPhoneNumber());
		} else {
			throw new BadContactInformationException();
		}
		c = contactRepository.save(c);
		return new ResponseContactDTO(c.getId(), c.getContactName(), c.getPhoneNumber());
	}
	
	public ResponseContactDTO update(ResponseContactDTO input) throws BadContactInformationException {
		if (contactRepository.existsContactByPhoneNumber(input.getPhoneNumber())) {
			throw new BadContactInformationException();
		}
		Contact c = contactRepository.findById(input.getId()).get();
		if (c.getStatus()) {
			if (!c.getContactName().isEmpty()) {
				c.setContactName(input.getContactName());
			}
			if (!c.getPhoneNumber().isEmpty()) {
				c.setPhoneNumber(input.getPhoneNumber());
			}
			c = contactRepository.save(c);
		} else {
			throw new NoSuchElementException();
		}
		return new ResponseContactDTO(c.getId(), c.getContactName(), c.getPhoneNumber());
	}
	
	public Boolean delete(Long contactId) {
		Contact c = contactRepository.findById(contactId).get();
		c.setStatus(false);
		contactRepository.save(c);
		return true;
	}
}
