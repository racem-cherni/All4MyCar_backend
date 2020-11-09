package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.models.Garage;
import tn.esprit.spring.models.Historique_carnet;
import tn.esprit.spring.models.Vehicule;
import tn.esprit.spring.services.HistoriqueService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/api")
public class Historique_carnetController {
	@Autowired
	HistoriqueService historiqueservice;
	@GetMapping("/gethistorique")
	public List <Historique_carnet> getAllHistorique(){
		 return historiqueservice.findAllHistorique();
	}
	@GetMapping("/getpremiershistorique")
	public List <Historique_carnet> getPremiersHistorique(){
		 return historiqueservice.findPremiersHistoriques();
	}
	@GetMapping("/gethistoriquebyVehicule/{id}")
	public List <Historique_carnet> getHistoriqueByVehicule(@PathVariable long id){
		 return historiqueservice.findHistoriqueByVehicule(id);
	}
@DeleteMapping("/deletehistorique/{idhistorique}")
	
	public String removehistorique(@PathVariable(value = "idhistorique") long idhistorique) {
	 
	  
			return historiqueservice.deletehistorique(idhistorique);
			
		}
}
