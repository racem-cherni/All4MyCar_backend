package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.models.Details_Specialisations;
import tn.esprit.spring.models.Prestataire;

@Repository
public interface Details_SpecialisationsRepository extends JpaRepository<Details_Specialisations, Long> {
	
	List<Details_Specialisations> findBySpecialisationId(@Param("id") long idspecialisation);

}
