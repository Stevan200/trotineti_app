package kosturTest.VezbeTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kosturTest.VezbeTest.model.Adresa;

@Repository
public interface AdresaRepository extends JpaRepository<Adresa, Long> {

	Adresa findOneById(Long id);

}
