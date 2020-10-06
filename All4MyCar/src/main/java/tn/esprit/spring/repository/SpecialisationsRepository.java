package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.models.Specialisations;

@Repository
public interface SpecialisationsRepository extends JpaRepository<Specialisations, Long> {
	
	@Override
	List<Specialisations> findAll();
	
	
	
	
    
	
	
	

}
