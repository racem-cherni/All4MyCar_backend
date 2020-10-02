package tn.esprit.spring.controllers;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.models.Admin;
import tn.esprit.spring.models.AdressePays;
import tn.esprit.spring.models.Client;
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

public List<User> getallclientsinactives() {
return adminservice.findClientUser();

}
@GetMapping("/getprestataireinactifs")

public List<User> getallprestatairesinactives() {
return adminservice.findPrestataireUser();

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
   public String adduserclient(@PathVariable(value = "idclient") long idclient)throws MessagingException, IOException {
	
	return adminservice.Accepter_Client(idclient) ; 
}
   
   @PostMapping("/adduserprestataire/{idpres}")
   public String adduserprestataire(@PathVariable(value = "idpres") long idpres) {
	
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
}
