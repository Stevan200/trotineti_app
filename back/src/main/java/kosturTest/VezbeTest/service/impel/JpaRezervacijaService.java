package kosturTest.VezbeTest.service.impel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosturTest.VezbeTest.model.Rezervacija;
import kosturTest.VezbeTest.repository.RezervacijaRepository;
import kosturTest.VezbeTest.service.RezervacijaService;

@Service
public class JpaRezervacijaService implements RezervacijaService {
	
	@Autowired
	private RezervacijaRepository rezervacijaRepository;

	@Override
	public Rezervacija findOneById(Long id) {
		// TODO Auto-generated method stub
		return rezervacijaRepository.findOneById(id);
	}

	@Override
	public List<Rezervacija> findAll() {
		// TODO Auto-generated method stub
		return rezervacijaRepository.findAll();
	}

	@Override
	public Rezervacija save(Rezervacija rezervacija) {
		// TODO Auto-generated method stub
		return rezervacijaRepository.save(rezervacija);
	}

}
