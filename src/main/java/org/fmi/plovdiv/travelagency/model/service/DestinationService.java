package org.fmi.plovdiv.travelagency.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.fmi.plovdiv.travelagency.dao.ContactRepository;
import org.fmi.plovdiv.travelagency.dao.DestinationRepository;
import org.fmi.plovdiv.travelagency.dao.LocationRepository;
import org.fmi.plovdiv.travelagency.dao.dto.DestinationDTO;
import org.fmi.plovdiv.travelagency.dao.dto.LocationDTO;
import org.fmi.plovdiv.travelagency.dao.dto.contact.ResponseContactDTO;
import org.fmi.plovdiv.travelagency.exceptions.BadContactInformationException;
import org.fmi.plovdiv.travelagency.exceptions.BadDestinationInformationException;
import org.fmi.plovdiv.travelagency.model.Destination;
import org.fmi.plovdiv.travelagency.model.Location;
import org.springframework.stereotype.Service;

@Service
public class DestinationService {
	
	private final DestinationRepository destinationRepository;
	private final LocationRepository locationRepository;
	
	public DestinationService(DestinationRepository destinationRepository,
			LocationRepository locationRepository) {
		this.destinationRepository = destinationRepository;
		this.locationRepository = locationRepository;
	}
	
	public DestinationDTO getOne(Long destinationId) {
		Destination d = destinationRepository.findById(destinationId).get();
		if (!d.getStatus()) {
			throw new NoSuchElementException();
		}
		return new DestinationDTO(
				d.getId(), 
				new LocationDTO(
						d.getLocation().getId(), 
						d.getLocation().getStreet(), 
						d.getLocation().getNumber(),
						d.getLocation().getCity(), 
						d.getLocation().getCountry()),
				d.getTitle(),
				d.getDescription(),
				d.getFreeSlots());
	}

	public List<DestinationDTO> getAll() {
		List<Destination> d = destinationRepository.findAll();
		List<DestinationDTO> output = new ArrayList<DestinationDTO>();
		for (Destination i : d) {
			if (i.getStatus()) {
				output.add(new DestinationDTO(
							i.getId(), 
							new LocationDTO(
									i.getLocation().getId(), 
									i.getLocation().getStreet(), 
									i.getLocation().getNumber(),
									i.getLocation().getCity(), 
									i.getLocation().getCountry()),
							i.getTitle(),
							i.getDescription(),
							i.getFreeSlots()));
			}
		}
		return output;
	}
	
	public DestinationDTO create(DestinationDTO input) throws BadDestinationInformationException {
		Location l;
		try {
			l = locationRepository.findById(input.getLocation().getId()).get();
		} catch (Exception e) {
			throw new BadDestinationInformationException();
		}
		Destination d = new Destination();
		
		d.setStatus(true);
		
		if (!input.getTitle().isEmpty()) {
			d.setTitle(input.getTitle());
		} else {
			throw new BadDestinationInformationException();
		}
		if (!input.getDescription().isEmpty()) {
			d.setDescription(input.getDescription());
		} else {
			throw new BadDestinationInformationException();
		} 
		if (input.getFreeSlots() != 0) {
			d.setFreeSlots(input.getFreeSlots());
		} else {
			throw new BadDestinationInformationException();
		}
		
		d.setLocation(l);
		
		d = destinationRepository.save(d);
		return new DestinationDTO(
				d.getId(), 
				new LocationDTO(
						d.getLocation().getId(), 
						d.getLocation().getStreet(), 
						d.getLocation().getNumber(),
						d.getLocation().getCity(), 
						d.getLocation().getCountry()),
				d.getTitle(),
				d.getDescription(),
				d.getFreeSlots());
	}
	
	public DestinationDTO update(DestinationDTO input) throws BadDestinationInformationException {
		Location l;
		Destination d;
		try {
			l = locationRepository.findById(input.getLocation().getId()).get();
			d = destinationRepository.findById(input.getId()).get();
		} catch (Exception e) {
			throw new BadDestinationInformationException();
		}
		if (d.getStatus()) {
			if (!input.getTitle().isEmpty()) {
				d.setTitle(input.getTitle());
			} 
			if (!input.getDescription().isEmpty()) {
				d.setDescription(input.getDescription());
			} 
			if (input.getFreeSlots() != 0) {
				d.setFreeSlots(input.getFreeSlots());
			} else {
				d.setFreeSlots(input.getFreeSlots());
				d.setStatus(false);
			}
			d = destinationRepository.save(d);
		} else {
			throw new NoSuchElementException();
		}
		return new DestinationDTO(
				d.getId(), 
				new LocationDTO(
						d.getLocation().getId(), 
						d.getLocation().getStreet(), 
						d.getLocation().getNumber(),
						d.getLocation().getCity(), 
						d.getLocation().getCountry()),
				d.getTitle(),
				d.getDescription(),
				d.getFreeSlots());
	}
	
	public Boolean delete(Long destinationId) {
		Destination d = destinationRepository.findById(destinationId).get();
		d.setStatus(false);
		destinationRepository.save(d);
		return true;
	}
}
