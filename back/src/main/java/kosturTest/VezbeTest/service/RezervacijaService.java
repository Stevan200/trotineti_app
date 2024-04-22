package kosturTest.VezbeTest.service;

import java.util.List;

import kosturTest.VezbeTest.model.Rezervacija;

public interface RezervacijaService {

	Rezervacija findOneById(Long id);
	List<Rezervacija> findAll();
	Rezervacija save(Rezervacija rezervacija);
}
