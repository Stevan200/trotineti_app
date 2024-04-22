package kosturTest.VezbeTest.service;

import org.springframework.data.domain.Page;

import kosturTest.VezbeTest.model.Trotinet;


public interface TrotinetService {
	
	Trotinet findOne(Long id);

    Page<Trotinet> findAll(Integer pageNo);
    
    Trotinet save(Trotinet trotinet);

    Trotinet update(Trotinet trotinet);

    Trotinet delete(Long id);
    
    Page<Trotinet> pretraga(Long adresaId, Integer baterijaOd, Integer baterijaDo,  int pageNo);

}
