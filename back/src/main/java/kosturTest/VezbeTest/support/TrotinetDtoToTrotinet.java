package kosturTest.VezbeTest.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import kosturTest.VezbeTest.dto.TrotinetDTO;
import kosturTest.VezbeTest.model.Trotinet;
import kosturTest.VezbeTest.service.AdresaService;
import kosturTest.VezbeTest.service.TrotinetService;

@Component
public class TrotinetDtoToTrotinet implements Converter<TrotinetDTO, Trotinet> {
	
	@Autowired
	private TrotinetService trotinetService;
	
	@Autowired
	private AdresaService adresaService;

	@Override
	public Trotinet convert(TrotinetDTO dto) {
		Trotinet trotinet;
		
		if(dto.getId() == null){
            trotinet = new Trotinet();
        }else{
            trotinet = trotinetService.findOne(dto.getId());
        }
		if (trotinet != null) {
			trotinet.setId(dto.getId());
			trotinet.setIznajmljen(dto.isIznajmljen());
			trotinet.setMaksimalnaBrzina(dto.getMaksimalnaBrzina());
			trotinet.setNivoBaterije(dto.getNivoBaterije());
			trotinet.setSifra(dto.getSifra());
			trotinet.setAdresa(adresaService.findOneById(dto.getAdresaId()));
				
		}
		
		return trotinet;
	}

}
