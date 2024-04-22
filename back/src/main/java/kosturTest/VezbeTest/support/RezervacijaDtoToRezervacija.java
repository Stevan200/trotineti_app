package kosturTest.VezbeTest.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import kosturTest.VezbeTest.dto.RezervacijaDTO;
import kosturTest.VezbeTest.model.Rezervacija;
import kosturTest.VezbeTest.service.RezervacijaService;
import kosturTest.VezbeTest.service.TrotinetService;

@Component
public class RezervacijaDtoToRezervacija implements Converter<RezervacijaDTO, Rezervacija> {
	
	@Autowired
	private RezervacijaService rezervacijaService;
	
	@Autowired
	private TrotinetService trotinetService;
	


	@Override
	public Rezervacija convert(RezervacijaDTO dto) {
		
		Rezervacija rezervacija;
		
		if(dto.getId() == null){
            rezervacija = new Rezervacija();
        }else{
            rezervacija = rezervacijaService.findOneById(dto.getId());
        }
		if (rezervacija != null) {
			rezervacija.setId(dto.getId());
			rezervacija.setEmail(dto.getEmail());
			rezervacija.setVremeIznajmljivanja(dto.getVremeIznajmljivanja());
			rezervacija.setVremeVracanja(dto.getVremeVracanja());
			
			rezervacija.setTrotinet(trotinetService.findOne(dto.getTrotinetId()));
		
		
		}
		
		return rezervacija;
	}

}
