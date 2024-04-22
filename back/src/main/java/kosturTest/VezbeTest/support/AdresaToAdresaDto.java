package kosturTest.VezbeTest.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import kosturTest.VezbeTest.dto.AdresaDTO;
import kosturTest.VezbeTest.model.Adresa;

@Component
public class AdresaToAdresaDto implements Converter<Adresa, AdresaDTO> {

	@Override
	public AdresaDTO convert(Adresa adresa) {
		AdresaDTO dto = new AdresaDTO();
		dto.setId(adresa.getId());
		dto.setUlica(adresa.getUlica());
		dto.setBroj(adresa.getBroj());
		
		return dto;
	}

	public List<AdresaDTO> convert(List<Adresa> adrese) {
		List<AdresaDTO> adresaDTO = new ArrayList<>();

		for (Adresa adresa : adrese) {
			adresaDTO.add(convert(adresa));
		}

		return adresaDTO;
	}
}
