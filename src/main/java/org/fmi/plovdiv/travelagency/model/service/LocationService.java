package org.fmi.plovdiv.travelagency.model.service;

import java.util.List;

import org.fmi.plovdiv.travelagency.dao.ContactRepository;
import org.fmi.plovdiv.travelagency.dao.DestinationRepository;
import org.fmi.plovdiv.travelagency.dao.HolidayRepository;
import org.fmi.plovdiv.travelagency.dao.LocationRepository;
import org.fmi.plovdiv.travelagency.dao.dto.ContactDTO;
import org.fmi.plovdiv.travelagency.dao.dto.DestinationDTO;
import org.fmi.plovdiv.travelagency.dao.dto.HolidayDTO;
import org.fmi.plovdiv.travelagency.dao.dto.LocationDTO;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
	
	private final LocationRepository locationRepository;
	
	public LocationService(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}
	
	public LocationDTO getOne(Long locationId) {
		return null;
	}

	public List<LocationDTO> getAll() {
		return null;
	}
	
	public LocationDTO create(LocationDTO input) {
		return null;
	}
	
	public LocationDTO update(LocationDTO input) {
		return null;
	}
	
	public Boolean delete(Long locationId) {
		return null;
	}
}
