package kosturTest.VezbeTest.service.impel;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import kosturTest.VezbeTest.model.Trotinet;
import kosturTest.VezbeTest.repository.TrotinetRepository;
import kosturTest.VezbeTest.service.TrotinetService;

@Service
public class JpaTrotinetService implements TrotinetService {
	
	@Autowired
	private TrotinetRepository trotinetRepository;

	@Override
	public Trotinet findOne(Long id) {
		// TODO Auto-generated method stub
		return trotinetRepository.findOneById(id);
	}

	@Override
	public Page<Trotinet> findAll(Integer pageNo) {
		// TODO Auto-generated method stub
		return trotinetRepository.findAll(PageRequest.of(pageNo, 10));
	}

	@Override
	public Trotinet save(Trotinet trotinet) {
		// TODO Auto-generated method stub
		return trotinetRepository.save(trotinet);
	}

	@Override
	public Trotinet update(Trotinet trotinet) {
		// TODO Auto-generated method stub
		return trotinetRepository.save(trotinet);
	}

	@Override
	public Trotinet delete(Long id) {
		Optional<Trotinet> igrac = trotinetRepository.findById(id);
        if(igrac.isPresent()){
            trotinetRepository.deleteById(id);
            return igrac.get();
        }
        return null;
	}

	@Override
	public Page<Trotinet> pretraga(Long adresaId, Integer baterijaOd, Integer baterijaDo, int pageNo) {
		// TODO Auto-generated method stub
		return trotinetRepository.pretraga(adresaId, baterijaOd, baterijaDo, PageRequest.of(pageNo, 3));
	}

}
