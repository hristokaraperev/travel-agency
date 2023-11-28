package org.fmi.plovdiv.travelagency.api;

import java.util.List;

import org.fmi.plovdiv.travelagency.dao.dto.LocationDTO;
import org.fmi.plovdiv.travelagency.model.service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = "application/json", consumes = "application/json", name = "location-controller", value = "/locations")
public class LocationController {

	private final LocationService locationService;
	
	public LocationController(LocationService locationService) {
		super();
		this.locationService = locationService;
	}
	
	@GetMapping("/{locationId}")
	public ResponseEntity<LocationDTO> getOne(@PathVariable Long locationId) {
		return null;
	}
	
	@GetMapping
	public ResponseEntity<List<LocationDTO>> getAll() {
		return null;
	}
	
	@PostMapping
	public ResponseEntity<LocationDTO> create(@RequestBody LocationDTO dto) {
		return null;
	}
	
	@PutMapping
	public ResponseEntity<LocationDTO> update(@RequestBody LocationDTO dto) {
		return null;
	}
	
	@DeleteMapping("/{locationId}")
	public ResponseEntity<LocationDTO> delete(@PathVariable Long locationId) {
		return null;
	}
}
