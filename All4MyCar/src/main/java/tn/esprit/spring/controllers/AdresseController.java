package tn.esprit.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.models.AdresseCites;
import tn.esprit.spring.models.AdressePays;
import tn.esprit.spring.models.AdresseVilles;
import tn.esprit.spring.models.Vehicule;
import tn.esprit.spring.services.AdresseService;
import tn.esprit.spring.services.ClientService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/api")
public class AdresseController {
	
	@Autowired
	AdresseService adresseservice ;
	
@GetMapping("/getallpaysadresse")
	
	public List<AdressePays> getallpaysadresse() {
	return adresseservice.findallpays();
	
		
	}

@GetMapping("/getVillesofpays/{id}")

public List<AdresseVilles> getvillesofpays(@PathVariable(value = "id") long id) {
return adresseservice.findallvillesofpays(id);

}

@GetMapping("/getcitesofville/{id}")

public List<AdresseCites> getcitessofvilles(@PathVariable(value = "id") long id) {
return adresseservice.findallcitesofville(id);

}



}
