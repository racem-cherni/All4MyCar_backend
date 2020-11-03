package tn.esprit.spring.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import tn.esprit.spring.models.Details_Specialisations;
import tn.esprit.spring.models.Specialisations;

public interface SpecialisationService {
	
	List<Specialisations> findallspecialisations();
	List<Details_Specialisations> finddetailsSpecialisationbyId(long idspecialisation);
	List<Details_Specialisations> finddetailsSpecialisation();


}
