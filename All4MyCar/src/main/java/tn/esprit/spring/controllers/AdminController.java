package tn.esprit.spring.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.models.Admin;
import tn.esprit.spring.models.AdressePays;
import tn.esprit.spring.models.Client;
import tn.esprit.spring.models.Prestataire;
import tn.esprit.spring.models.User;
import tn.esprit.spring.services.AdminService;
import tn.esprit.spring.services.AdresseService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/api")
public class AdminController {
	
	@Autowired
	AdminService adminservice ;
	
@GetMapping("/getusersinactifs")
	
	public List<User> getallusersinactives() {
	return adminservice.findUser();

}
@GetMapping("/getclientsinactifs")

public List<Client> getallclientsinactives() {
return adminservice.clientsinactifs();

}
@GetMapping("/getprestataireinactifs")

public List<Prestataire> getallprestatairesinactives() {
return adminservice.prestatairesinactifs();

}

@GetMapping("/getnbrdemandesinscriptionsnotifications")

public int getnbrdemandesinscriptionsnotifications() {
return adminservice.nbrdemandesinscriptionsnotif();

}

@GetMapping("/getclientsinactifsnotifications")

public List<Client> getallclientsinactivesnotifications() {
return adminservice.clientsinactifsnotifications();

}
@GetMapping("/getprestataireinactifsnotifications")

public List<Prestataire> getallprestatairesinactivesnotifications() {
return adminservice.prestatairesinactifsnotifications();

}

@PutMapping("/setdemandesnotifications")

public int setdemandesnotifications() {
return adminservice.Demandesnotificationsaffiches();

}
@GetMapping("/Findadmin")

	public Admin FindadminById() {
	   Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			String userName = ((UserDetails) principal).getUsername();
			//System.err.println(clientservice.Afficher_client_by_name(userName).getClient());
			return adminservice.Afficher_admin_by_name(userName).getAdmin();
			
		}
		return null;
		
	}

   @PostMapping("/adduserclient/{idclient}")
   public List<Client> adduserclient(@PathVariable(value = "idclient") long idclient)throws MessagingException, IOException {
	
	return adminservice.Accepter_Client(idclient) ; 
}
   
   @PostMapping("/adduserprestataire/{idpres}")
   public List<Prestataire> adduserprestataire(@PathVariable(value = "idpres") long idpres) {
	
	return adminservice.Accepter_Pres(idpres); 
}
   
   @DeleteMapping("/deleteuserclient/{idclient}")
	
	public String removeuserclient(@PathVariable(value = "idclient") long idclient) {
	 
	  
			return adminservice.refuser_client(idclient);
			
		}
   
   @DeleteMapping("/deleteuserprestataire/{idpres}")
	
	public String removeuserprestataire(@PathVariable(value = "idpres") long idpres) {
	 
	  
			return adminservice.refuser_pres(idpres);
			
		}
   @GetMapping("/getAllClient")

   public List<Client> getAllClients() {
   return adminservice.getAllClient();

   }
   @GetMapping("/getAllPrestataire")

   public List<Prestataire> getAllPrestataires() {
   return adminservice.getAllPrestataire();

   }
   @DeleteMapping("/deleteclient/{idclient}")
	
	public String deleteclient(@PathVariable(value = "idclient") long idclient) {
	 
	  
			return adminservice.deleteClient(idclient);
			
		}
   @DeleteMapping("/deleteprestataire/{idpres}")
	
	public String deletepres(@PathVariable(value = "idpres") long idpres) {
	 
	  
			return adminservice.deletPrestataire(idpres);
			
		}
   
   
   @GetMapping("/getClientbyid/{idclt}")

   public Client getClient(@PathVariable(value = "idclt") long idclt) {
   return adminservice.detailclient(idclt);

   }
   
   @GetMapping("/getPrestatairebyid/{idpres}")

   public Prestataire getPrestataire(@PathVariable(value = "idpres") long idpres) {
   return adminservice.detailprestataire(idpres);

   }
   
   @GetMapping("/getallClientbydateinscription/{date}")

   public List<Client> getallClientbydateinscription(@PathVariable(value = "date") Date date_inscription) {
   return adminservice.getAllClientbydateinscription(date_inscription);

   }
   
   @GetMapping("/getallprestatairesbydateinscription/{date}")

   public List<Prestataire> getallprestatairebydateinscription(@PathVariable(value = "date") Date date_inscription) {
   return adminservice.getAllPrestatairebydateinscription(date_inscription);

   }
   
   @GetMapping("/getallprestatairesbyspecialisations/{specialisation}")

   public List<Prestataire> getallprestatairebyspecialisations(@PathVariable(value = "specialisation") String specialisation) {
   return adminservice.getAllPrestatairebyspecialisations(specialisation);

   }
   
}
