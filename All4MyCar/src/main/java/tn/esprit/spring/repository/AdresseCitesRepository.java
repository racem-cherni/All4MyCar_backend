package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.models.AdresseCites;
import tn.esprit.spring.models.AdresseVilles;
import tn.esprit.spring.models.Vehicule_model;

import java.util.List;
import java.util.Optional;
import java.lang.Long;

@Repository
public interface AdresseCitesRepository extends JpaRepository<AdresseCites, Long> {
	
	List<AdresseCites> findByAdressevillesId(@Param("id") Long id);
	
	

	AdresseCites findById( @Param("idadressecite") long idadressecite);
}

