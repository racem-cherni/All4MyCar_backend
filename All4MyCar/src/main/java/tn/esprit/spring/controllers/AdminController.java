package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.models.AdressePays;
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
}
