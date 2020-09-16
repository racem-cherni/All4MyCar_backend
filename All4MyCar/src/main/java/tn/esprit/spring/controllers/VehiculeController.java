package tn.esprit.spring.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.models.User;
import tn.esprit.spring.models.Vehicule;
import tn.esprit.spring.models.Vehicule_marque;
import tn.esprit.spring.services.ClientService;
import tn.esprit.spring.services.VehiculeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/api")
public class VehiculeController {

	@Autowired
	VehiculeService vehiculeservice ;

	
	
	 /*@GetMapping("/getVehiculeMarqueModel")
		
		public List<Vehicule_marque> getVehiculeMarqueModel() {
		return vehiculeservice.getVehiculeMarqueModel();
		
			
		}*/
 @PostMapping("/addvehicule")
	
	public String add_vehicule(@RequestBody Vehicule vl) {
	 
	  
			return vehiculeservice.add_vehicule(vl);
			
		}
 
 @DeleteMapping("/deleteById/{idVehicule}")
	
	public String removeVehicule(@PathVariable(value = "idVehicule") long id) {
	 
	  
			return vehiculeservice.removeVehicule(id);
			
		}
 
 @GetMapping("/getVehiculeOfClient")
	
	public List<Vehicule> getVehiculeOfClient() {
	return vehiculeservice.getVehiculeOfClient();
	
		
	}
 
 

		
	}
		
		


