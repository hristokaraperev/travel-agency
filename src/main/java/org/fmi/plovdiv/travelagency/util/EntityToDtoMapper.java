package org.fmi.plovdiv.travelagency.util;

import org.fmi.plovdiv.travelagency.dao.dto.DestinationDTO;
import org.fmi.plovdiv.travelagency.dao.dto.HolidayDTO;
import org.fmi.plovdiv.travelagency.dao.dto.LocationDTO;
import org.fmi.plovdiv.travelagency.model.Destination;
import org.fmi.plovdiv.travelagency.model.Holiday;
import org.fmi.plovdiv.travelagency.model.Location;

public class EntityToDtoMapper {

	public static LocationDTO toDto(Location entity) {
		return new LocationDTO(entity.getId(), entity.getStreet(), entity.getNumber(), entity.getCity(), entity.getCountry());
	}
	
	public static DestinationDTO toDto(Destination entity) {
		return new DestinationDTO(entity.getId(), toDto(entity.getLocation()), entity.getTitle(), entity.getDescription(), entity.getFreeSlots());
	}
	
	public static HolidayDTO toDto(Holiday entity) {
		return new HolidayDTO(entity.getId(), toDto(entity.getDestination()), entity.getStartDate(), entity.getDuration(), entity.getPrice());
	}
}
