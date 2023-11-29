package org.fmi.plovdiv.travelagency.util;

import org.fmi.plovdiv.travelagency.dao.dto.holiday.ResponseHolidayDTO;
import org.fmi.plovdiv.travelagency.dao.dto.location.ResponseLocationDTO;
import org.fmi.plovdiv.travelagency.dao.dto.reservation.ResponseReservationDTO;
import org.fmi.plovdiv.travelagency.model.Holiday;
import org.fmi.plovdiv.travelagency.model.Location;
import org.fmi.plovdiv.travelagency.model.Reservation;

public class EntityToDtoMapper {

	public static ResponseLocationDTO toDto(Location entity) {
		ResponseLocationDTO dto = new ResponseLocationDTO();
		dto.setId(entity.getId());
		dto.setStreet(entity.getStreet());
		dto.setNumber(entity.getNumber());
		dto.setCity(entity.getCity());
		dto.setCountry(entity.getCountry());
		return dto;
	}
	
	public static ResponseHolidayDTO toDto(Holiday entity) {
		ResponseHolidayDTO dto = new ResponseHolidayDTO();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setLocation(toDto(entity.getLocation()));
		dto.setStartDate(entity.getStartDate());
		dto.setDuration(entity.getDuration());
		dto.setPrice(entity.getPrice());
		dto.setFreeSlots(entity.getFreeSlots());
		return dto;
	}
	
	public static ResponseReservationDTO toDto(Reservation entity) {
		ResponseReservationDTO dto = new ResponseReservationDTO();
		dto.setId(entity.getId());
		dto.setContactName(entity.getContactName());
		dto.setPhoneNumber(entity.getPhoneNumber());
		dto.setHoliday(toDto(entity.getHoliday()));
		return dto;
	}
}
