package org.fmi.plovdiv.travelagency.api;

import java.util.List;

import org.fmi.plovdiv.travelagency.dao.dto.HolidayDTO;
import org.fmi.plovdiv.travelagency.model.service.HolidayService;
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
@RequestMapping(produces = "application/json", consumes = "application/json", name = "holiday-controller", value = "/holidays")
public class HolidayController {

	private final HolidayService holidayService;
	
	public HolidayController(HolidayService holidayService) {
		super();
		this.holidayService = holidayService;
	}
	
	@GetMapping("/{holidayId}")
	public ResponseEntity<HolidayDTO> getOne(@PathVariable Long holidayId) {
		return null;
	}
	
	@GetMapping
	public ResponseEntity<List<HolidayDTO>> getAll() {
		return null;
	}
	
	@PostMapping
	public ResponseEntity<HolidayDTO> create(@RequestBody HolidayDTO dto) {
		return null;
	}
	
	@PutMapping
	public ResponseEntity<HolidayDTO> update(@RequestBody HolidayDTO dto) {
		return null;
	}
	
	@DeleteMapping("/{holidayId}")
	public ResponseEntity<HolidayDTO> delete(@PathVariable Long holidayId) {
		return null;
	}
}
