package org.fmi.plovdiv.travelagency.api;

import java.util.List;

import org.fmi.plovdiv.travelagency.dao.dto.DestinationDTO;
import org.fmi.plovdiv.travelagency.exceptions.BadDestinationInformationException;
import org.fmi.plovdiv.travelagency.model.service.ContactService;
import org.fmi.plovdiv.travelagency.model.service.DestinationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping(produces = "application/json", consumes = "application/json", name = "destination-controller", value = "/destinations")
public class DestinationController {

	private final DestinationService destinationService;

	public DestinationController(DestinationService destinationService) {
		super();
		this.destinationService = destinationService;
	}
	
	@GetMapping("/{destinationId}")
	public ResponseEntity<DestinationDTO> getOne(@PathVariable Long destinationId) {
		return new ResponseEntity<DestinationDTO>(destinationService.getOne(destinationId), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<DestinationDTO>> getAll() {
		return new ResponseEntity<List<DestinationDTO>>(destinationService.getAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<DestinationDTO> create(@RequestBody DestinationDTO dto) throws BadDestinationInformationException {
		return new ResponseEntity<DestinationDTO>(destinationService.create(dto), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<DestinationDTO> update(@Valid @RequestBody DestinationDTO dto) throws BadDestinationInformationException {
		return new ResponseEntity<DestinationDTO>(destinationService.update(dto), HttpStatus.OK);
	}
	
	@DeleteMapping("/{destinationId}")
	public ResponseEntity<Boolean> delete(@PathVariable Long destinationId) {
		return new ResponseEntity<Boolean>(destinationService.delete(destinationId), HttpStatus.OK);
	}
}
