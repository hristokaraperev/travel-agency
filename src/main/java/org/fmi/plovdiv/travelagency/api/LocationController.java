package org.fmi.plovdiv.travelagency.api;

import java.util.List;

import org.fmi.plovdiv.travelagency.dao.dto.LocationDTO;
import org.fmi.plovdiv.travelagency.exceptions.BadLocationInformationException;
import org.fmi.plovdiv.travelagency.model.service.LocationService;
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
@RequestMapping("/locations")
public class LocationController {

	private final LocationService locationService;
	
	public LocationController(LocationService locationService) {
		super();
		this.locationService = locationService;
	}
	
	@GetMapping("/{locationId}")
	public ResponseEntity<LocationDTO> getOne(@PathVariable(name = "locationId") Long locationId) {
		return new ResponseEntity<LocationDTO>(locationService.getOne(locationId), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<LocationDTO>> getAll() {
		return new ResponseEntity<List<LocationDTO>>(locationService.getAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<LocationDTO> create(@Valid @RequestBody LocationDTO dto) throws BadLocationInformationException {
		return new ResponseEntity<LocationDTO>(locationService.create(dto), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<LocationDTO> update(@RequestBody LocationDTO dto) {
		return new ResponseEntity<LocationDTO>(locationService.update(dto), HttpStatus.OK);
	}
	
	@DeleteMapping("/{locationId}")
	public ResponseEntity<Boolean> delete(@PathVariable(name = "locationId") Long locationId) {
		return new ResponseEntity<Boolean>(locationService.delete(locationId), HttpStatus.OK);
	}
}
