package org.fmi.plovdiv.travelagency.model.service;

import java.util.List;

import org.fmi.plovdiv.travelagency.dao.ContactRepository;
import org.fmi.plovdiv.travelagency.dao.DestinationRepository;
import org.fmi.plovdiv.travelagency.dao.HolidayRepository;
import org.fmi.plovdiv.travelagency.dao.LocationRepository;
import org.fmi.plovdiv.travelagency.dao.ReservationRepository;
import org.fmi.plovdiv.travelagency.dao.dto.DestinationDTO;
import org.fmi.plovdiv.travelagency.dao.dto.HolidayDTO;
import org.fmi.plovdiv.travelagency.dao.dto.LocationDTO;
import org.fmi.plovdiv.travelagency.dao.dto.ReservationDTO;
import org.fmi.plovdiv.travelagency.dao.dto.contact.ResponseContactDTO;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
	
	private final ReservationRepository reservationRepository;
	
	public ReservationService(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}
	
	public ReservationDTO getOne(Long reservationId) {
		return null;
	}

	public List<ReservationDTO> getAll() {
		return null;
	}
	
	public ReservationDTO create(ReservationDTO input) {
		return null;
	}
	
	public ReservationDTO update(ReservationDTO input) {
		return null;
	}
	
	public Boolean delete(Long reservationId) {
		return null;
	}
}
