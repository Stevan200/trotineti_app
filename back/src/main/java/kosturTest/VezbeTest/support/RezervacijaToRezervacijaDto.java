package kosturTest.VezbeTest.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import kosturTest.VezbeTest.dto.RezervacijaDTO;
import kosturTest.VezbeTest.model.Rezervacija;

@Component
public class RezervacijaToRezervacijaDto implements Converter<Rezervacija, RezervacijaDTO> {

	@Override
	public RezervacijaDTO convert(Rezervacija rezervacija) {
		
		RezervacijaDTO dto = new RezervacijaDTO();
		dto.setId(rezervacija.getId());
		dto.setEmail(rezervacija.getEmail());
		dto.setVremeIznajmljivanja(rezervacija.getVremeIznajmljivanja());
		dto.setVremeVracanja(rezervacija.getVremeVracanja());
		
		dto.setTrotinetId(rezervacija.getTrotinet().getId());
		dto.setTrotinetSifra(rezervacija.getTrotinet().getSifra());
		
	
		return dto;
	}
	
	public List<RezervacijaDTO> convert(List<Rezervacija> rezervacije) {
		List<RezervacijaDTO> rezDTO = new ArrayList<>();

		for (Rezervacija rezervacija : rezervacije) {
			rezDTO.add(convert(rezervacija));
		}

		return rezDTO;
	}

}
