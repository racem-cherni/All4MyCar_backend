package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.models.AdressePays;
import tn.esprit.spring.models.Details_Specialisations;

@Repository
public interface AdressePaysRepository extends JpaRepository <AdressePays, Long> {
	
	
	 List<AdressePays> findAll();

}
