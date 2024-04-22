package kosturTest.VezbeTest.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import kosturTest.VezbeTest.dto.TrotinetDTO;
import kosturTest.VezbeTest.model.Trotinet;

@Component
public class TrotinetToTrotinetDto implements Converter<Trotinet, TrotinetDTO> {

	@Override
	public TrotinetDTO convert(Trotinet trotinet) {
		TrotinetDTO dto = new TrotinetDTO();
		dto.setId(trotinet.getId());
		dto.setIznajmljen(trotinet.isIznajmljen());
		dto.setMaksimalnaBrzina(trotinet.getMaksimalnaBrzina());
		dto.setNivoBaterije(trotinet.getNivoBaterije());
		dto.setSifra(trotinet.getSifra());
		
		dto.setAdresaId(trotinet.getAdresa().getId());
		dto.setAdresaUlica(trotinet.getAdresa().getUlica());
		
		
		return dto;
	}
	
	public List<TrotinetDTO> convert(List<Trotinet> trotineti) {
		List<TrotinetDTO> trotiDTO = new ArrayList<>();

		for (Trotinet trotinet : trotineti) {
			trotiDTO.add(convert(trotinet));
		}

		return trotiDTO;
	}

}
