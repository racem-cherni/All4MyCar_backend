package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.models.Client;
import tn.esprit.spring.models.User;
import tn.esprit.spring.services.ClientService;
import tn.esprit.spring.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/api")
public class UserController {

	@Autowired
	UserService userservice ;
	
    @GetMapping("/Finduserr/{id}")
	public User FinduserById(@PathVariable(value = "id") long id) {
	
			return userservice.Afficher_user_by_name(id);
			
		
		
}
}
