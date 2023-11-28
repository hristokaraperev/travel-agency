package org.fmi.plovdiv.travelagency.model.service;

import java.util.List;

import org.fmi.plovdiv.travelagency.dao.ContactRepository;
import org.fmi.plovdiv.travelagency.dao.DestinationRepository;
import org.fmi.plovdiv.travelagency.dao.HolidayRepository;
import org.fmi.plovdiv.travelagency.dao.dto.ContactDTO;
import org.fmi.plovdiv.travelagency.dao.dto.DestinationDTO;
import org.fmi.plovdiv.travelagency.dao.dto.HolidayDTO;
import org.springframework.stereotype.Service;

@Service
public class HolidayService {
	
	private final HolidayRepository holidayRepository;
	
	public HolidayService(HolidayRepository holidayRepository) {
		this.holidayRepository = holidayRepository;
	}
	
	public HolidayDTO getOne(Long holidayId) {
		return null;
	}

	public List<HolidayDTO> getAll() {
		return null;
	}
	
	public HolidayDTO create(HolidayDTO input) {
		return null;
	}
	
	public HolidayDTO update(HolidayDTO input) {
		return null;
	}
	
	public Boolean delete(Long holidayId) {
		return null;
	}
}
