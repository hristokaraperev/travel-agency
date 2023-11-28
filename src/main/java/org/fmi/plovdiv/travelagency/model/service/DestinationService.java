package org.fmi.plovdiv.travelagency.model.service;

import java.util.List;

import org.fmi.plovdiv.travelagency.dao.ContactRepository;
import org.fmi.plovdiv.travelagency.dao.DestinationRepository;
import org.fmi.plovdiv.travelagency.dao.dto.ContactDTO;
import org.fmi.plovdiv.travelagency.dao.dto.DestinationDTO;
import org.springframework.stereotype.Service;

@Service
public class DestinationService {
	
	private final DestinationRepository destinationRepository;
	
	public DestinationService(DestinationRepository destinationRepository) {
		this.destinationRepository = destinationRepository;
	}
	
	public DestinationDTO getOne(Long destinationId) {
		return null;
	}

	public List<DestinationDTO> getAll() {
		return null;
	}
	
	public DestinationDTO create(DestinationDTO input) {
		return null;
	}
	
	public DestinationDTO update(DestinationDTO input) {
		return null;
	}
	
	public Boolean delete(Long destinationId) {
		return null;
	}
}
