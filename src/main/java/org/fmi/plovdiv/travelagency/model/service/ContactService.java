package org.fmi.plovdiv.travelagency.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.fmi.plovdiv.travelagency.dao.ContactRepository;
import org.fmi.plovdiv.travelagency.dao.dto.ContactDTO;
import org.fmi.plovdiv.travelagency.exceptions.BadContactInformationException;
import org.fmi.plovdiv.travelagency.model.Contact;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
	
	private final ContactRepository contactRepository;
	
	public ContactService(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}
	
	public ContactDTO getOne(Long contactId) {
		// throws NoSuchElementException
		Contact c = contactRepository.findById(contactId).get();
		if (!c.getStatus()) {
			throw new NoSuchElementException();
		}
		return new ContactDTO(c.getId(), c.getContactName(), c.getPhoneNumber());
	}

	public List<ContactDTO> getAll() {
		List<Contact> c = contactRepository.findAll();
		List<ContactDTO> output = new ArrayList<ContactDTO>();
		for (Contact i : c) {
			if (i.getStatus()) {
				output.add(new ContactDTO(i.getId(), i.getContactName(), i.getPhoneNumber()));
			}
		}
		return output;
	}
	
	public ContactDTO create(ContactDTO input) throws BadContactInformationException {
		Contact c = new Contact();
		c.setStatus(true);
		c.setContactName(input.getContactName());
		// Phone number is supposed to be unique
		if (contactRepository.existsContactByPhoneNumber(input.getPhoneNumber())) {
			throw new BadContactInformationException();
		}
		c.setPhoneNumber(input.getPhoneNumber());
		c = contactRepository.save(c);
		return new ContactDTO(c.getId(), c.getContactName(), c.getPhoneNumber());
	}
	
	public ContactDTO update(ContactDTO input) throws BadContactInformationException {
		// throws NoSuchElementException
		Contact c = contactRepository.findById(input.getId()).get();
		if (c.getStatus()) {
			c.setContactName(input.getContactName());
			// Phone number is supposed to be unique
			if (contactRepository.existsContactByPhoneNumber(input.getPhoneNumber())) {
				throw new BadContactInformationException();
			}
			c.setPhoneNumber(input.getPhoneNumber());
			c = contactRepository.save(c);
		} else {
			throw new NoSuchElementException();
		}
		return new ContactDTO(c.getId(), c.getContactName(), c.getPhoneNumber());
	}
	
	public Boolean delete(Long contactId) {
		// throws NoSuchElementException
		Contact c = contactRepository.findById(contactId).get();
		c.setStatus(false);
		contactRepository.save(c);
		return true;
	}
}
