package org.fmi.plovdiv.travelagency.model.service;

import java.util.ArrayList;
import java.util.List;

import org.fmi.plovdiv.travelagency.dao.LocationRepository;
import org.fmi.plovdiv.travelagency.dao.dto.location.CreateLocationDTO;
import org.fmi.plovdiv.travelagency.dao.dto.location.ResponseLocationDTO;
import org.fmi.plovdiv.travelagency.dao.dto.location.UpdateLocationDTO;
import org.fmi.plovdiv.travelagency.exceptions.BadLocationInformationException;
import org.fmi.plovdiv.travelagency.model.Location;
import org.fmi.plovdiv.travelagency.util.EntityToDtoMapper;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
	
	private final LocationRepository locationRepository;
	
	public LocationService(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}
	
	public ResponseLocationDTO getOne(Long locationId) {
		Location l = locationRepository.findById(locationId).get();
		return EntityToDtoMapper.toDto(l);
	}

	public List<ResponseLocationDTO> getAll() {
		List<Location> l = locationRepository.findAll();
		List<ResponseLocationDTO> output = new ArrayList<ResponseLocationDTO>();
		for (Location i : l) {
			output.add(EntityToDtoMapper.toDto(i));
		}
		return output;
	}
	
	public ResponseLocationDTO create(CreateLocationDTO input) throws BadLocationInformationException {
		Location l = new Location();
		if (locationRepository.existsLocationByStreetAndNumber(input.getStreet(), input.getNumber())) {
			throw new BadLocationInformationException();
		}
		l.setStreet(input.getStreet());
		l.setNumber(input.getNumber());
		l.setCity(input.getCity());
		l.setCountry(input.getCountry());
		
		l = locationRepository.save(l);
		return EntityToDtoMapper.toDto(l);
	}
	
	public ResponseLocationDTO update(UpdateLocationDTO input) {
		Location l = locationRepository.findById(input.getId()).get();
		if (!input.getStreet().isEmpty()) {
			l.setStreet(input.getStreet());
		} 
		if (!input.getNumber().isEmpty()) {
			l.setNumber(input.getNumber());
		} 
		if (!input.getCity().isEmpty()) {
			l.setCity(input.getCity());
		} 
		if (!input.getCountry().isEmpty()) {
			l.setCountry(input.getCountry());
		} 

		l = locationRepository.save(l);
		
		return EntityToDtoMapper.toDto(l);
	}
	
	public Boolean delete(Long locationId) {
		if (locationRepository.existsById(locationId)) {
			locationRepository.deleteById(locationId);
			return true;
		}
		return false;
	}
}
