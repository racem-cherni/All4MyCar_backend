package tn.esprit.spring.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
   
  /* @PutMapping("/edit_client")
	
	public String edit_client(@RequestBody Client clt) {
	   Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			String userName = ((UserDetails) principal).getUsername();
			//System.err.println(clientservice.Afficher_client_by_name(userName).getClient());
			return clientservice.edit_client(clientservice.Afficher_client_by_name(userName).getClient(),clt);
			
		}
		return null;
		
	}*/
   
   private static String UPLOADED_FOLDER = System.getProperty("user.dir")+"/src/main/upload";

   @PostMapping("/edit_client1/{firstname}/{lastname}/{email}/{adresse}/{telnum}/{cin}/{datepermis}")
	
	public String edit_clientttt(@PathVariable(value = "firstname") String firstname ,@PathVariable(value = "lastname") String lastname ,@PathVariable(value = "email") String email ,
			@PathVariable(value = "adresse") String adresse , @PathVariable(value = "telnum") int telnum , @PathVariable(value = "cin")  int cin ,
			@PathVariable(value = "datepermis") Date datepermis , @RequestParam("file") MultipartFile file
			 )
   {
	   Client clt = new Client();
	   
	      
	      File dir = new File(UPLOADED_FOLDER);
	      if (!dir.exists())
				dir.mkdirs();
	      System.out.println("c bnsssssssssssssssssssaaaaaas ");
	      File fileToImport = null;
	      if (dir.isDirectory()) {
	    	  System.out.println("c bnssssssssssssssssssssssssssssssssss ");
	    	  try {
		        	
		        	System.out.println("c bn ");
		        	
		            fileToImport = new File(dir + File.separator + file.getOriginalFilename());
		            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fileToImport));
		            stream.write(file.getBytes());
		            stream.close();
		        } catch (Exception e) {
		            System.out.println("nnnnnnnnn");
		        }
	      }
	   clt.setAdresseclt(adresse);clt.setEmailclt(email);
	   clt.setCIN(cin);clt.setTelclt(telnum);clt.setDate_permis(datepermis);clt.setFirstNameclt(firstname);clt.setLastNameclt(lastname);clt.setPhotoclt(file.getOriginalFilename());
	   
	   Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			String userName = ((UserDetails) principal).getUsername();
		//	System.err.println(clientservice.Afficher_client_by_name(userName).getClient());
			
			return clientservice.edit_client(clientservice.Afficher_client_by_name(userName).getClient(),clt);
			
		}
		return null;
		
	}
   
  

}
