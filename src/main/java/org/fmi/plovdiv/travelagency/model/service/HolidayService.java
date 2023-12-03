package org.fmi.plovdiv.travelagency.model.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.fmi.plovdiv.travelagency.dao.HolidayRepository;
import org.fmi.plovdiv.travelagency.dao.LocationRepository;
import org.fmi.plovdiv.travelagency.dao.ReservationRepository;
import org.fmi.plovdiv.travelagency.dao.dto.holiday.CreateHolidayDTO;
import org.fmi.plovdiv.travelagency.dao.dto.holiday.ResponseHolidayDTO;
import org.fmi.plovdiv.travelagency.dao.dto.holiday.UpdateHolidayDTO;
import org.fmi.plovdiv.travelagency.exceptions.BadHolidayInformationException;
import org.fmi.plovdiv.travelagency.model.Holiday;
import org.fmi.plovdiv.travelagency.model.Location;
import org.fmi.plovdiv.travelagency.util.EntityToDtoMapper;
import org.springframework.stereotype.Service;

@Service
public class HolidayService {
	
	private final HolidayRepository holidayRepository;
	private final LocationRepository locationRepository;
	private final ReservationRepository reservationRepository;
	
	public HolidayService(HolidayRepository holidayRepository, LocationRepository locationRepository, ReservationRepository reservationRepository) {
		super();
		this.holidayRepository = holidayRepository;
		this.locationRepository = locationRepository;
		this.reservationRepository = reservationRepository;
	}

	public ResponseHolidayDTO getOne(Long holidayId) {
		Holiday h = holidayRepository.findById(holidayId).get();
		return EntityToDtoMapper.toDto(h);
	}
	
	public List<ResponseHolidayDTO> getAll(Long locationId, LocalDate startDate, Integer duration) {
		if (locationId == null && startDate == null && duration == null) {
			return getAll();
		} else {
			List<ResponseHolidayDTO> output = new ArrayList<ResponseHolidayDTO>();
			Stream<Holiday> h = holidayRepository.findAll().stream();
			
			h = h.filter(holiday -> holiday.getFreeSlots() > reservationRepository.countByHoliday(holiday));
			
			if (locationId != null) {
				h = h.filter(holiday -> holiday.getLocation().getId() == locationId);
			}
			if (startDate != null) {
				h = h.filter(holiday -> holiday.getStartDate().isEqual(startDate));
			}
			if (duration != null) {
				h = h.filter(holiday -> holiday.getDuration() == duration);
			}
			
			h.forEach(holiday -> output.add(EntityToDtoMapper.toDto(holiday)));
			
			return output;
		}
	}

	private List<ResponseHolidayDTO> getAll() {
		List<Holiday> h = holidayRepository.findAll();
		List<ResponseHolidayDTO> output = new ArrayList<ResponseHolidayDTO>();
		for (Holiday i : h) {
			if (i.getFreeSlots() > reservationRepository.countByHoliday(i)) {
				output.add(EntityToDtoMapper.toDto(i));
			}
		}
		return output;
	}
	
	public ResponseHolidayDTO create(CreateHolidayDTO input) throws BadHolidayInformationException {
		Holiday h = new Holiday();
		Location l;
		try {
			l = locationRepository.findById(input.getLocation()).get();
		} catch (Exception e) {
			throw new BadHolidayInformationException();
		}
		if (input.getStartDate().isAfter(LocalDate.now())) {
			h.setStartDate(input.getStartDate());
		} else {
			throw new BadHolidayInformationException();
		}
		
		h.setLocation(l);
		h.setTitle(input.getTitle());
		h.setDuration(input.getDuration());
		h.setPrice(input.getPrice());
		h.setFreeSlots(input.getFreeSlots());
		h = holidayRepository.save(h);
		
		return EntityToDtoMapper.toDto(h);
	}
	
	public ResponseHolidayDTO update(UpdateHolidayDTO input) throws BadHolidayInformationException {
		Location l;
		Holiday h;
		try {
			h = holidayRepository.findById(input.getId()).get();
		} catch (Exception e) {
			throw new BadHolidayInformationException();
		}
		if (input.getLocation() > 0) {
			if (input.getLocation() != h.getLocation().getId()) {
				try {
					l = locationRepository.findById(input.getLocation()).get();
				} catch (Exception e) {
					throw new BadHolidayInformationException();
				}
				h.setLocation(l);
			}
		}
		if (input.getStartDate().isAfter(LocalDate.now())) {
			h.setStartDate(input.getStartDate());
		} else {
			throw new BadHolidayInformationException();
		}
		if (!input.getTitle().isEmpty()) {
			h.setTitle(input.getTitle());
		}
		if (input.getDuration() > 0) {
			h.setDuration(input.getDuration());
		}
		if (input.getPrice() > 0) {
			h.setPrice(input.getPrice());
		}
		if (input.getFreeSlots() > 0) {
			h.setFreeSlots(input.getFreeSlots());
		}
		
		h = holidayRepository.save(h);
		return EntityToDtoMapper.toDto(h);
	}
	
	public Boolean delete(Long holidayId) {
		if (holidayRepository.existsById(holidayId)) {
			holidayRepository.deleteById(holidayId);
			return true;
		}
		return false;
	}
}
