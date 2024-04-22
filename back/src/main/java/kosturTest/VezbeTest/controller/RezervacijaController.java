package kosturTest.VezbeTest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosturTest.VezbeTest.dto.RezervacijaDTO;
import kosturTest.VezbeTest.model.Rezervacija;
import kosturTest.VezbeTest.service.RezervacijaService;
import kosturTest.VezbeTest.support.RezervacijaDtoToRezervacija;
import kosturTest.VezbeTest.support.RezervacijaToRezervacijaDto;


@RestController
@RequestMapping(value = "/api/rezervacije", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class RezervacijaController {
	
	@Autowired
	private RezervacijaDtoToRezervacija toRezervacija;
	
	@Autowired
	private RezervacijaToRezervacijaDto toRezervacijaDto;
	
	@Autowired
	private RezervacijaService rezervacijaService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RezervacijaDTO> create(@Valid @RequestBody RezervacijaDTO rezervacijaDTO){
		Rezervacija rezervacija = toRezervacija.convert(rezervacijaDTO);

		

		Rezervacija sacuvanTransfer= rezervacijaService.save(rezervacija);

		return new ResponseEntity<>(toRezervacijaDto.convert(sacuvanTransfer), HttpStatus.CREATED);
	}	

}
