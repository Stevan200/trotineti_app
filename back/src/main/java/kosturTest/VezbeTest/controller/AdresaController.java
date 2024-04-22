package kosturTest.VezbeTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosturTest.VezbeTest.dto.AdresaDTO;
import kosturTest.VezbeTest.model.Adresa;
import kosturTest.VezbeTest.service.AdresaService;
import kosturTest.VezbeTest.support.AdresaToAdresaDto;

@RestController
@RequestMapping(value = "/api/adrese", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class AdresaController {
	
	@Autowired
	private AdresaService adresaService;
	
	@Autowired
	private AdresaToAdresaDto tAdresaDto;
	
	@GetMapping
    public ResponseEntity<List<AdresaDTO >> getAll(){

        List<Adresa> klubovi = adresaService.findAll();

        return new ResponseEntity<>(tAdresaDto.convert(klubovi), HttpStatus.OK);
    }

}
