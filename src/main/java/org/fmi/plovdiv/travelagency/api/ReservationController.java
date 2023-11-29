package org.fmi.plovdiv.travelagency.api;

import java.util.List;

import org.fmi.plovdiv.travelagency.dao.dto.ReservationDTO;
import org.fmi.plovdiv.travelagency.dao.dto.contact.ResponseContactDTO;
import org.fmi.plovdiv.travelagency.model.service.ReservationService;
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
@RequestMapping(produces = "application/json", consumes = "application/json", name = "reservation-controller", value = "/reservations")
public class ReservationController {

	private final ReservationService reservationService;
	
	public ReservationController(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}
	
	@GetMapping("/{reservationId}")
	public ResponseEntity<ReservationDTO> getOne(@PathVariable Long reservationId) {
		return null;
	}
	
	@GetMapping
	public ResponseEntity<List<ReservationDTO>> getAll() {
		return null;
	}
	
	@PostMapping
	public ResponseEntity<ReservationDTO> create(@RequestBody ReservationDTO dto) {
		return null;
	}
	
	@PutMapping
	public ResponseEntity<ReservationDTO> update(@RequestBody ReservationDTO dto) {
		return null;
	}
	
	@DeleteMapping("/{reservationId}")
	public ResponseEntity<ReservationDTO> delete(@PathVariable Long reservationId) {
		return null;
	}
}
