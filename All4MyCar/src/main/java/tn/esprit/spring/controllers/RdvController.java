package tn.esprit.spring.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.models.Prestataire;
import tn.esprit.spring.models.Rdv_dispo;
import tn.esprit.spring.repository.Rdv_dispoRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.services.PrestataireService;
import tn.esprit.spring.services.RdvService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/api")
public class RdvController {
	
	@Autowired
	PrestataireService prestataireservice ;
	
	@Autowired
	UserRepository userrepository ;
	
	@Autowired
	Rdv_dispoRepository rdv_disporepository;
	
	@Autowired
	RdvService rdvservice ;
	
	
	   @PostMapping("/modifier_dispojour")
		
		public String modifier_dispojour(@RequestBody Rdv_dispo dispos) throws ParseException {
		  Rdv_dispo dispo = new Rdv_dispo();
				
		  dispo.setHeuredam(dispos.getHeuredam());
		  dispo.setHeuredm(dispos.getHeuredm());
		  dispo.setHeurefam(dispos.getHeurefam());
		  dispo.setHeurefm(dispos.getHeurefm());
		  
		  String jour = dispos.getJour();
	      System.out.println("hey"+jour);
		  dispo.setJour(dispos.getJour());
	      System.out.println("heyheuredam"+dispo.getHeuredam());

		  
			  dispo.setJour_actif(dispos.isJour_actif());
		      System.out.println("hey"+dispo.isJour_actif());
dispo.setPeriodedeux_actif(dispos.isPeriodedeux_actif());
		   Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				String userName = ((UserDetails) principal).getUsername();
				Prestataire clt  = userrepository.findByUsername(userName).get().getPrestataire();		
				int idd = rdv_disporepository.getdispoByDayAndpres(dispo.getJour(),clt.getId());
			      System.out.println("hey"+idd);

				return rdvservice.modifier_dispojour(dispo,idd);

		}
			return null;

	}
	   
	   @GetMapping("/FinddispoByPres")
		
		public List<Rdv_dispo> getdisponibility() {
		 
				return rdvservice.getdisponibility();
			
		}

}
