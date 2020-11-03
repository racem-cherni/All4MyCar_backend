package tn.esprit.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.models.Details_Specialisations;
import tn.esprit.spring.models.Specialisations;
import tn.esprit.spring.models.Vehicule;
import tn.esprit.spring.services.SpecialisationService;
import tn.esprit.spring.services.VehiculeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/api")
public class SpecialisationController {
	
	@Autowired
	SpecialisationService specialisationservice ;
	
@GetMapping("/getSpecialisations")
	
	public List<Specialisations> getSpecialisations() {
	return specialisationservice.findallspecialisations();
	
		
	}

@GetMapping("/getdetailspecialisation/{idspecialisation}")

public List<Details_Specialisations> getdetailspecialisations(@PathVariable(value = "idspecialisation") long id) {
return specialisationservice.finddetailsSpecialisationbyId(id);

}

@GetMapping("/getdetailspecialisationn")

public List<Details_Specialisations> getdetailspecialisations() {
return specialisationservice.finddetailsSpecialisation();

}
}
