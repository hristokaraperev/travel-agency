package org.fmi.plovdiv.travelagency.dao;

import org.fmi.plovdiv.travelagency.model.Contact;

public interface ContactRepository extends BaseRepository<Contact, Long>{

	boolean existsContactByPhoneNumber(String phoneNumber);
}
