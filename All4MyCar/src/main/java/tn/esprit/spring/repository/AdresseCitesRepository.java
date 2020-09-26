package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.models.AdresseCites;
import tn.esprit.spring.models.AdresseVilles;
import java.util.List;

@Repository
public interface AdresseCitesRepository extends JpaRepository<AdresseCites, Long> {
	
	List<AdresseCites> findByAdressevillesId(@Param("id") Long id);

}
