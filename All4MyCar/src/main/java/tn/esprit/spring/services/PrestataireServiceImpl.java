package tn.esprit.spring.services;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import tn.esprit.spring.models.Prestataire;
import tn.esprit.spring.models.User;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.PrestataireRepository;
import tn.esprit.spring.repository.UserRepository;
@Service
@CrossOrigin(origins = "http://localhost:4200")
public class PrestataireServiceImpl implements PrestataireService {
	@Autowired
	PrestataireRepository prestatairerepository ;

	@Autowired
	UserRepository userrepository ;

	@Override
	public User Afficher_prestataire_by_name(String username) {
		return userrepository.findByUsername(username).get();
	}

	@Override
	public String add_prestataire(Prestataire pres) {
		prestatairerepository.save(pres);
		
		return "success";
	}

	@Override
	public String RemovePrestataire(Long idpres) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String edit_prestataire(Prestataire pres1, Prestataire pres) {
		pres1.setAdressepres(pres.getAdressepres());
		pres1.setFirstNamepres(pres.getFirstNamepres());
		pres1.setLastNamepres(pres.getLastNamepres());
		pres1.setAdresseprof(pres.getAdresseprof());
		pres1.setTelpres(pres.getTelpres());
		pres1.setEmailpres(pres.getEmailpres()); 
		pres1.setPhotopres(pres.getPhotopres());
		 

	
		prestatairerepository.save(pres1);
	return "profil modifie";
}

}
