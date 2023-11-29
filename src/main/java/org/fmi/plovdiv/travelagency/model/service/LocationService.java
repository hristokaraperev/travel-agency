package org.fmi.plovdiv.travelagency.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.text.BadLocationException;

import org.fmi.plovdiv.travelagency.dao.LocationRepository;
import org.fmi.plovdiv.travelagency.dao.dto.LocationDTO;
import org.fmi.plovdiv.travelagency.exceptions.BadContactInformationException;
import org.fmi.plovdiv.travelagency.exceptions.BadLocationInformationException;
import org.fmi.plovdiv.travelagency.model.Location;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
	
	private final LocationRepository locationRepository;
	
	public LocationService(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}
	
	public LocationDTO getOne(Long locationId) {
		Location l = locationRepository.findById(locationId).get();
		if (!l.getStatus()) {
			throw new NoSuchElementException();
		}
		return new LocationDTO(
				l.getId(), 
				l.getStreet(), 
				l.getNumber(), 
				l.getCity(), 
				l.getCountry());
	}

	public List<LocationDTO> getAll() {
		List<Location> l = locationRepository.findAll();
		List<LocationDTO> output = new ArrayList<LocationDTO>();
		for (Location i : l) {
			if (i.getStatus()) {
				output.add(new LocationDTO(
						i.getId(), 
						i.getStreet(), 
						i.getNumber(), 
						i.getCity(), 
						i.getCountry()));
			}
		}
		return output;
	}
	
	public LocationDTO create(LocationDTO input) throws BadLocationInformationException {
		Location l = new Location();
		l.setStatus(true);
		if (!input.getStreet().isEmpty()) {
			l.setStreet(input.getStreet());
		} else {
			throw new BadLocationInformationException();
		}
		if (!input.getNumber().isEmpty()) {
			l.setNumber(input.getNumber());
		} else {
			throw new BadLocationInformationException();
		}
		if (!input.getCity().isEmpty()) {
			l.setCity(input.getCity());
		} else {
			throw new BadLocationInformationException();
		}
		if (!input.getCountry().isEmpty()) {
			l.setCountry(input.getCountry());
		} else {
			throw new BadLocationInformationException();
		}
		l = locationRepository.save(l);
		return new LocationDTO(
				l.getId(), 
				l.getStreet(), 
				l.getNumber(), 
				l.getCity(), 
				l.getCountry());
	}
	
	public LocationDTO update(LocationDTO input) {
		Location l = locationRepository.findById(input.getId()).get();
		if (l.getStatus()) {
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
		} else {
			throw new NoSuchElementException();
		}
		return new LocationDTO(
				l.getId(), 
				l.getStreet(), 
				l.getNumber(), 
				l.getCity(), 
				l.getCountry());
	}
	
	public Boolean delete(Long locationId) {
		Location l = locationRepository.findById(locationId).get();
		l.setStatus(false);
		locationRepository.save(l);
		return true;
	}
}
