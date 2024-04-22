package kosturTest.VezbeTest.service;

import java.util.List;

import kosturTest.VezbeTest.model.Adresa;


public interface AdresaService {

	Adresa findOneById(Long id);
	List<Adresa> findAll();
	Adresa save(Adresa adresa);
}
