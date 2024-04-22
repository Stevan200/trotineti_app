package kosturTest.VezbeTest.service.impel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosturTest.VezbeTest.model.Adresa;
import kosturTest.VezbeTest.repository.AdresaRepository;
import kosturTest.VezbeTest.service.AdresaService;

@Service
public class JpaAdresaService implements AdresaService {
	
	@Autowired
	private AdresaRepository adresaRepository;

	@Override
	public Adresa findOneById(Long id) {
		// TODO Auto-generated method stub
		return adresaRepository.findOneById(id);
	}

	@Override
	public List<Adresa> findAll() {
		// TODO Auto-generated method stub
		return adresaRepository.findAll();
	}

	@Override
	public Adresa save(Adresa adresa) {
		// TODO Auto-generated method stub
		return adresaRepository.save(adresa);
	}

}
