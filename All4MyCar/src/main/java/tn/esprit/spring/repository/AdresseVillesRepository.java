package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.models.AdresseVilles;
import tn.esprit.spring.models.AdressePays;
import java.util.List;

@Repository
public interface AdresseVillesRepository extends JpaRepository <AdresseVilles, Long> {
	
	List<AdresseVilles> findByAdressepaysId(@Param("id") Long id);

}
