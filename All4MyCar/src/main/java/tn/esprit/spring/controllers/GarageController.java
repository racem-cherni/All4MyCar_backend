package tn.esprit.spring.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.models.AdresseCites;
import tn.esprit.spring.models.Garage;
import tn.esprit.spring.models.Prestataire;
import tn.esprit.spring.models.Vehicule;
import tn.esprit.spring.models.Vehicule_model;
import tn.esprit.spring.repository.GarageRepository;
import tn.esprit.spring.services.GarageService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/api")
public class GarageController {
	@Autowired
	GarageService garageservice;
	
	
	
	@Autowired
	GarageRepository garagerepository;
@PostMapping("/addgarage")
	
	public String add_garage(@RequestBody Garage garage) {
	 
	  
			return garageservice.add_Garage(garage);
			
		}
@GetMapping("/getgarage")
public Garage getGarage(){
	 return garageservice.findGarage();
}
private static String UPLOADED_FOLDER = System.getProperty("user.dir")+"/src/main/resources";	

@PostMapping("/addgaragee/{nbrMecaniciens}")
	
	public String add_garage(@PathVariable(value = "nbrMecaniciens") int nbrMecaniciens  )
{
	   Garage garage = new Garage();
	  
	//   AdresseCites ad = garageservice.getCitebyid(idadressecite);
	  
	     // garage.setAddresse(addresse);
	    //  garage.setAdressecite(ad);
	     //  garage.setAnnée_Experience(annéeExperience);
	      // garage.setDate_ouverture(dateouverture);

	       garage.setNbr_Mecaniciens(nbrMecaniciens);
	     
	       //garage.setPhoto_garage(file.getOriginalFilename());
	  
	   
	   return garageservice.add_Garage(garage);
		
	}
 

}
