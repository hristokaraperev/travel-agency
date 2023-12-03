package org.fmi.plovdiv.travelagency.model.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.fmi.plovdiv.travelagency.dao.HolidayRepository;
import org.fmi.plovdiv.travelagency.dao.ReservationRepository;
import org.fmi.plovdiv.travelagency.dao.dto.reservation.CreateReservationDTO;
import org.fmi.plovdiv.travelagency.dao.dto.reservation.ResponseReservationDTO;
import org.fmi.plovdiv.travelagency.dao.dto.reservation.UpdateReservationDTO;
import org.fmi.plovdiv.travelagency.exceptions.BadReservationInformationException;
import org.fmi.plovdiv.travelagency.model.Holiday;
import org.fmi.plovdiv.travelagency.model.Reservation;
import org.fmi.plovdiv.travelagency.util.EntityToDtoMapper;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
	
	private final ReservationRepository reservationRepository;
	private final HolidayRepository holidayRepository;
	
	public ReservationService(ReservationRepository reservationRepository, HolidayRepository holidayRepository) {
		super();
		this.reservationRepository = reservationRepository;
		this.holidayRepository = holidayRepository;
	}

	public ResponseReservationDTO getOne(Long reservationId) {
		Reservation r = reservationRepository.findById(reservationId).get();
		return EntityToDtoMapper.toDto(r);
	}

	public List<ResponseReservationDTO> getAll() {
		List<Reservation> r = reservationRepository.findAll();
		List<ResponseReservationDTO> output = new ArrayList<ResponseReservationDTO>();
		for (Reservation i : r) {
			output.add(EntityToDtoMapper.toDto(i));
		}
		return output;
	}
	
	public ResponseReservationDTO create(CreateReservationDTO input) throws BadReservationInformationException {
		Reservation r = new Reservation();
		Holiday h;
		try {
			h = holidayRepository.findById(input.getHoliday()).get();
		} catch (Exception e) {
			throw new BadReservationInformationException();
		}
		r.setHoliday(h);
		r.setContactName(input.getContactName());
		try {
			Integer.parseInt(input.getPhoneNumber());
		} catch (NumberFormatException e) {
			throw new BadReservationInformationException();
		}
		r.setPhoneNumber(input.getPhoneNumber());
		r = reservationRepository.save(r);
		return EntityToDtoMapper.toDto(r);
	}
	
	public ResponseReservationDTO update(UpdateReservationDTO input) throws BadReservationInformationException {
		Reservation r;
		Holiday h;
		try {
			r = reservationRepository.findById(input.getId()).get();
		} catch (Exception e) {
			throw new BadReservationInformationException();
		}
		if (input.getHoliday() > 0) {
			if (input.getHoliday() != r.getHoliday().getId()) {
				try {
					h = holidayRepository.findById(input.getHoliday()).get();
				} catch (Exception e) {
					throw new BadReservationInformationException();
				}
				r.setHoliday(h);
			}
		}
		if (!input.getContactName().isEmpty()) {
			r.setContactName(input.getContactName());
		}
		if (!input.getPhoneNumber().isEmpty()) {
			try {
				Integer.parseInt(input.getPhoneNumber());
			} catch (NumberFormatException e) {
				throw new BadReservationInformationException();
			}
			r.setPhoneNumber(input.getPhoneNumber());
		}
		r = reservationRepository.save(r);
		return EntityToDtoMapper.toDto(r);
	}
	
	public Boolean delete(Long reservationId) {
		if (reservationRepository.existsById(reservationId)) {
			reservationRepository.deleteById(reservationId);
			return true;
		}
		return false;
	}
}
