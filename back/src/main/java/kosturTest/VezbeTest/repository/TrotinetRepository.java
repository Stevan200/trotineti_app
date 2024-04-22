package kosturTest.VezbeTest.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import kosturTest.VezbeTest.model.Trotinet;

@Repository
public interface TrotinetRepository extends JpaRepository<Trotinet, Long> {

    Trotinet findOneById(Long id);
    
	Page<Trotinet> findAll(Pageable pageable);

    
    @Query("SELECT p FROM Trotinet p WHERE "
			+ "(:adresaId IS NULL OR p.adresa.id = :adresaId) AND "
			+ "(:baterijaOd IS NULL OR p.nivoBaterije > :baterijaOd)AND"
			+ "(:baterijaDo IS NULL OR p.nivoBaterije < :baterijaDo)")
	Page<Trotinet> pretraga(
			@Param("adresaId") Long adresaId,
			@Param("baterijaOd") Integer baterijaOd,
			@Param("baterijaDo") Integer baterijaDo, Pageable pageable);
    
    List<Trotinet> findByIdIn(List<Long> ids);


}
