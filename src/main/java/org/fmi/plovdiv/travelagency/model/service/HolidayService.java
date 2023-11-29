package org.fmi.plovdiv.travelagency.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.fmi.plovdiv.travelagency.dao.ContactRepository;
import org.fmi.plovdiv.travelagency.dao.DestinationRepository;
import org.fmi.plovdiv.travelagency.dao.HolidayRepository;
import org.fmi.plovdiv.travelagency.dao.dto.DestinationDTO;
import org.fmi.plovdiv.travelagency.dao.dto.HolidayDTO;
import org.fmi.plovdiv.travelagency.dao.dto.contact.ResponseContactDTO;
import org.fmi.plovdiv.travelagency.exceptions.BadHolidayInformationException;
import org.fmi.plovdiv.travelagency.model.Destination;
import org.fmi.plovdiv.travelagency.model.Holiday;
import org.fmi.plovdiv.travelagency.util.EntityToDtoMapper;
import org.springframework.stereotype.Service;

@Service
public class HolidayService {
	
	private final HolidayRepository holidayRepository;
	private final DestinationRepository destinationRepository;
	
	public HolidayService(HolidayRepository holidayRepository, DestinationRepository destinationRepository) {
		this.holidayRepository = holidayRepository;
		this.destinationRepository = destinationRepository;
	}
	
	public HolidayDTO getOne(Long holidayId) {
		Holiday h = holidayRepository.findById(holidayId).get();
		if (!h.getStatus()) {
			throw new NoSuchElementException();
		}
		return EntityToDtoMapper.toDto(h);
	}

	public List<HolidayDTO> getAll() {
		List<Holiday> h = holidayRepository.findAll();
		List<HolidayDTO> output = new ArrayList<HolidayDTO>();
		for (Holiday i : h) {
			if (i.getStatus()) {
				output.add(EntityToDtoMapper.toDto(i));
			}
		}
		return output;
	}
	
	public HolidayDTO create(HolidayDTO input) throws BadHolidayInformationException {
		Destination d;
		try {
			d = destinationRepository.findById(input.getDestination().getId()).get();
		} catch (Exception e) {
			throw new BadHolidayInformationException();
		}
		Holiday h = new Holiday();
		
		h.setStatus(true);
		h.setStartDate(input.getStartDate());
		if (input.getDuration() != 0) {
			h.setDuration(input.getDuration());
		} else {
			throw new BadHolidayInformationException();
		}
		if (input.getPrice() != 0) {
			h.setPrice(input.getPrice());
		} else {
			throw new BadHolidayInformationException();
		}
		
		h.setDestination(d);
		h = holidayRepository.save(h);
		
		return EntityToDtoMapper.toDto(h);
	}
	
	public HolidayDTO update(HolidayDTO input) {
		return null;
	}
	
	public Boolean delete(Long holidayId) {
		return null;
	}
}
