package org.fmi.plovdiv.travelagency.api;

import java.time.LocalDate;
import java.util.List;

import org.fmi.plovdiv.travelagency.dao.dto.reservation.CreateReservationDTO;
import org.fmi.plovdiv.travelagency.dao.dto.reservation.ResponseReservationDTO;
import org.fmi.plovdiv.travelagency.dao.dto.reservation.UpdateReservationDTO;
import org.fmi.plovdiv.travelagency.exceptions.BadReservationInformationException;
import org.fmi.plovdiv.travelagency.model.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

	private final ReservationService reservationService;
	
	public ReservationController(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}
	
	@GetMapping("/{reservationId}")
	public ResponseEntity<ResponseReservationDTO> getOne(@PathVariable Long reservationId) {
		return new ResponseEntity<ResponseReservationDTO>(reservationService.getOne(reservationId), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<ResponseReservationDTO>> getAll() {
		return new ResponseEntity<List<ResponseReservationDTO>>(reservationService.getAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ResponseReservationDTO> create(@Valid @RequestBody CreateReservationDTO dto) throws BadReservationInformationException {
		return new ResponseEntity<ResponseReservationDTO>(reservationService.create(dto), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<ResponseReservationDTO> update(@Valid @RequestBody UpdateReservationDTO dto) throws BadReservationInformationException {
		return new ResponseEntity<ResponseReservationDTO>(reservationService.update(dto), HttpStatus.OK);
	}
	
	@DeleteMapping("/{reservationId}")
	public ResponseEntity<Boolean> delete(@PathVariable Long reservationId) {
		return new ResponseEntity<Boolean>(reservationService.delete(reservationId), HttpStatus.OK);
	}
}
