package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import tn.esprit.spring.models.AdresseCites;
import tn.esprit.spring.models.Client;
import tn.esprit.spring.models.Garage;
import tn.esprit.spring.models.Prestataire;
import tn.esprit.spring.repository.AdresseCitesRepository;
import tn.esprit.spring.repository.GarageRepository;
@Service
public class GarageServiceImpl implements GarageService{

	@Autowired
	GarageRepository garagerepository;
	@Autowired
	ClientService clientservice;
	@Autowired
	AdresseCitesRepository adressrecitesrepository;
	@Autowired
	PrestataireService prestataireservice;
	@Override
	public String add_Garage(Garage garage) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				String userName = ((UserDetails) principal).getUsername();
				Prestataire pres  = prestataireservice.Afficher_prestataire_by_name(userName).getPrestataire();
				garage.setPrestataire(pres);
				garagerepository.save(garage);
				return "garage ajouté";


				
			}
			
			
			return null ;
	}
	
	@Override
	public Garage findGarage() {
		 Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				String userName = ((UserDetails) principal).getUsername();
				Prestataire pres  = prestataireservice.Afficher_prestataire_by_name(userName).getPrestataire();
				
				return garagerepository.findByPrestataireId(pres.getId());
			    


			}
			return null ;
	}
	@Override
	public AdresseCites getCitebyid(long idadressecite) {
		
		return adressrecitesrepository.findById(idadressecite);
	}

	
//try
}
