package kosturTest.VezbeTest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kosturTest.VezbeTest.dto.TrotinetDTO;
import kosturTest.VezbeTest.model.Trotinet;
import kosturTest.VezbeTest.service.TrotinetService;
import kosturTest.VezbeTest.support.TrotinetDtoToTrotinet;
import kosturTest.VezbeTest.support.TrotinetToTrotinetDto;


@RestController
@RequestMapping(value = "/api/trotineti", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class TrotinetController {
	
	@Autowired
	private TrotinetService trotinetService;
	
	@Autowired
	private TrotinetDtoToTrotinet toTrotinet;
	
	@Autowired
	private TrotinetToTrotinetDto toTrotinetDto;
	
	@GetMapping
    public ResponseEntity<List<TrotinetDTO>> getAll(
    		@RequestParam(required=false) Long adresaId,
			@RequestParam(required=false) Integer baterijaOd,
			@RequestParam(required=false) Integer baterijaDo,
            @RequestParam(value = "pageNo", defaultValue = "0") int pageNo){
		Page<Trotinet> page;
		try {
	        page= trotinetService.pretraga(adresaId, baterijaOd, baterijaDo, pageNo);
		} catch (Exception e) {
	        page = trotinetService.findAll(pageNo);
		}
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Pages", Integer.toString(page.getTotalPages()));

        return new ResponseEntity<>(toTrotinetDto.convert(page.getContent()),headers, HttpStatus.OK);
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<TrotinetDTO> getOne(@PathVariable Long id) {
		Trotinet trotinet = trotinetService.findOne(id);

		if(trotinet != null) {
			return new ResponseEntity<>(toTrotinetDto.convert(trotinet), HttpStatus.OK);
		} else {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
		}
	}
	
	@PreAuthorize("hasRole('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrotinetDTO> create(@Valid @RequestBody TrotinetDTO trotinetDTO){
        Trotinet igrac = toTrotinet.convert(trotinetDTO);
        Trotinet sacuvanaIgrac = trotinetService.save(igrac);

        return new ResponseEntity<>(toTrotinetDto.convert(sacuvanaIgrac), HttpStatus.CREATED);
    }
    
  @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrotinetDTO> update(@PathVariable Long id, @Valid @RequestBody TrotinetDTO trotinetDTO){

        if(!id.equals(trotinetDTO.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Trotinet igrac = toTrotinet.convert(trotinetDTO);
        Trotinet sacuvanaIgrac = trotinetService.update(igrac);

        return new ResponseEntity<>(toTrotinetDto.convert(sacuvanaIgrac),HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Trotinet obrisanaIgrac = trotinetService.delete(id);

        if(obrisanaIgrac != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
