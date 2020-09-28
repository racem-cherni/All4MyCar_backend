package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.models.Garage;
import tn.esprit.spring.models.Prestataire;
import java.util.List;
@Repository
public interface GarageRepository  extends JpaRepository<Garage,Long>{

	
	
	Garage findByPrestataireId(@Param("idpres") long idpres);

}

