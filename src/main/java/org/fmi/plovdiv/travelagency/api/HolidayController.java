package org.fmi.plovdiv.travelagency.api;

import java.time.LocalDate;
import java.util.List;

import org.fmi.plovdiv.travelagency.dao.dto.holiday.CreateHolidayDTO;
import org.fmi.plovdiv.travelagency.dao.dto.holiday.ResponseHolidayDTO;
import org.fmi.plovdiv.travelagency.dao.dto.holiday.UpdateHolidayDTO;
import org.fmi.plovdiv.travelagency.exceptions.BadHolidayInformationException;
import org.fmi.plovdiv.travelagency.model.service.HolidayService;
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
@RequestMapping("/holidays")
public class HolidayController {

	private final HolidayService holidayService;
	
	public HolidayController(HolidayService holidayService) {
		super();
		this.holidayService = holidayService;
	}
	
	@GetMapping("/{holidayId}")
	public ResponseEntity<ResponseHolidayDTO> getOne(@PathVariable Long holidayId) {
		return new ResponseEntity<ResponseHolidayDTO>(holidayService.getOne(holidayId), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<ResponseHolidayDTO>> getAll(
			@RequestParam(name = "location", required = false) String location,
			@RequestParam(name = "startDate", required = false) LocalDate startDate,
			@RequestParam(name = "duration", required = false) Integer duration
			) {
		return new ResponseEntity<List<ResponseHolidayDTO>>(holidayService.getAll(location, startDate, duration), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ResponseHolidayDTO> create(@Valid @RequestBody CreateHolidayDTO dto) throws BadHolidayInformationException {
		return new ResponseEntity<ResponseHolidayDTO>(holidayService.create(dto), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<ResponseHolidayDTO> update(@Valid @RequestBody UpdateHolidayDTO dto) throws BadHolidayInformationException {
		return new ResponseEntity<ResponseHolidayDTO>(holidayService.update(dto), HttpStatus.OK);
	}
	
	@DeleteMapping("/{holidayId}")
	public ResponseEntity<Boolean> delete(@PathVariable Long holidayId) {
		return new ResponseEntity<Boolean>(holidayService.delete(holidayId), HttpStatus.OK);
	}
}
