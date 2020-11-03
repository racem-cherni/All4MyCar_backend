package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import tn.esprit.spring.models.Details_Specialisations;
import tn.esprit.spring.models.Specialisations;
import tn.esprit.spring.repository.Details_SpecialisationsRepository;
import tn.esprit.spring.repository.SpecialisationsRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
@CrossOrigin(origins = "http://localhost:4200")
public class SpecialisationServiceImpl implements SpecialisationService {
	
	@Autowired
	SpecialisationsRepository specialisationrepository ;
	
	@Autowired
	Details_SpecialisationsRepository detailspecialisationrepository ;

	@Override
	public List<Specialisations> findallspecialisations() {
		return specialisationrepository.findAll();
	}

	@Override
	public List<Details_Specialisations> finddetailsSpecialisationbyId(long idspecialisation) {
		
		return detailspecialisationrepository.findBySpecialisationId(idspecialisation);
	}

	@Override
	public List<Details_Specialisations> finddetailsSpecialisation() {
		return detailspecialisationrepository.findAll();
	}
	
	

}
