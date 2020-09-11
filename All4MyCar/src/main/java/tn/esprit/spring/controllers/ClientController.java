package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.models.Client;
import tn.esprit.spring.models.User;
import tn.esprit.spring.payload.request.SignupRequest;
import tn.esprit.spring.services.ClientService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/api")
public class ClientController {
	@Autowired
	ClientService clientservice ;
	
	
	
	           
	@PostMapping("/addclient")
	public String addclient(@RequestBody Client clt) {
		
		return clientservice.add_client(clt);
	}
	
	/*@PutMapping("/Updateclient")
	public String UpdateClient(@RequestBody Client client) {

		return clientservice.edit_client(client);
	}*/
	
	
   @GetMapping("/FinduserById")
	
	public User FindclientById() {
	   Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			String userName = ((UserDetails) principal).getUsername();
			System.err.println(clientservice.Afficher_client_by_name(userName).getClient());
			return clientservice.Afficher_client_by_name(userName);
			
		}
		return null;
		
	}
   @GetMapping("/FindclientById")
	
	public Client FinduserById() {
	   Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			String userName = ((UserDetails) principal).getUsername();
			System.err.println(clientservice.Afficher_client_by_name(userName).getClient());
			return clientservice.Afficher_client_by_name(userName).getClient();
			
		}
		return null;
		
	}
   
   @PutMapping("/edit_client")
	
	public String edit_client(@RequestBody Client clt) {
	   Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			String userName = ((UserDetails) principal).getUsername();
			System.err.println(clientservice.Afficher_client_by_name(userName).getClient());
			return clientservice.edit_client(clientservice.Afficher_client_by_name(userName).getClient(),clt);
			
		}
		return null;
		
	}

}
