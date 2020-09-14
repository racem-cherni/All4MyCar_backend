package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import tn.esprit.spring.models.User;
import tn.esprit.spring.models.Vehicule_marque;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.repository.Vehicule_marqueRepository;

@Service
@CrossOrigin(origins = "http://localhost:4200")
public class VehiculeServiceImpl implements VehiculeService{
    
	@Autowired
	Vehicule_marqueRepository vehicule_marqueRepository ;
	
	/*public List<Vehicule_marque> getVehiculeMarqueModel (){
		return vehicule_marqueRepository.getVehiculeMarqueModel();

	};*/

}
