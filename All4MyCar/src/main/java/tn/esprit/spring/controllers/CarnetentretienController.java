package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.models.Carburant_Carnet;
import tn.esprit.spring.models.Client;
import tn.esprit.spring.models.Depense_carnet;
import tn.esprit.spring.models.Entretien_Carnet;
import tn.esprit.spring.models.Odometer_carnet;
import tn.esprit.spring.models.Trajet_carnet;
import tn.esprit.spring.services.CarnetentretienService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/api")
public class CarnetentretienController {

	@Autowired
	CarnetentretienService carnetservice;
	
	@PostMapping("/ajouter_carburant")
	public String ajouter_carburant(@RequestBody Carburant_Carnet c) {
		
		return carnetservice.ajouter_carburant(c);
	}
	
	@PostMapping("/ajouter_depense")
	public String ajouter_depense(@RequestBody Depense_carnet d) {
		
		return carnetservice.ajouter_depense(d);
	}
	
	@PostMapping("/ajouter_entretien")
	public String ajouter_entretien(@RequestBody Entretien_Carnet e) {
		
		return carnetservice.ajouter_entretien(e);
	}
	

	
	
	@PostMapping("/ajouter_trajet")
	public String ajouter_trajet(@RequestBody Trajet_carnet t) {
		
		return carnetservice.ajouter_trajet(t);
	}
	
	
	@PostMapping("/ajouter_odometer")
	public String ajouter_odometer(@RequestBody Odometer_carnet o) {
		
		return carnetservice.ajouter_odometer(o);
	}
}