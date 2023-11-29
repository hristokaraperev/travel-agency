package org.fmi.plovdiv.travelagency.api;

import java.util.List;

import org.fmi.plovdiv.travelagency.dao.dto.contact.ResponseContactDTO;
import org.fmi.plovdiv.travelagency.exceptions.BadContactInformationException;
import org.fmi.plovdiv.travelagency.model.service.ContactService;
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
@RequestMapping("/contacts")
public class ContactController {
	
	private final ContactService contactService;

	public ContactController(ContactService contactService) {
		super();
		this.contactService = contactService;
	}

	@GetMapping("/{contactId}")
	public ResponseEntity<ResponseContactDTO> getOne(@PathVariable(name = "contactId") Long contactId) {
		return new ResponseEntity<ResponseContactDTO>(contactService.getOne(contactId), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<ResponseContactDTO>> getAll() {
		return new ResponseEntity<List<ResponseContactDTO>>(contactService.getAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ResponseContactDTO> create(@Valid @RequestBody ResponseContactDTO dto) throws BadContactInformationException {
		return new ResponseEntity<ResponseContactDTO>(contactService.create(dto), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<ResponseContactDTO> update(@Valid @RequestBody ResponseContactDTO dto) throws BadContactInformationException {
		return new ResponseEntity<ResponseContactDTO>(contactService.update(dto), HttpStatus.OK);
	}
	
	@DeleteMapping("/{contactId}")
	public ResponseEntity<Boolean> delete(@PathVariable(name = "contactId") Long contactId) {
		return new ResponseEntity<Boolean>(contactService.delete(contactId), HttpStatus.OK);
	}
}
