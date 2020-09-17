package tn.esprit.spring.services;

import tn.esprit.spring.models.Prestataire;
import tn.esprit.spring.models.User;

public interface PrestataireService {

	User Afficher_prestataire_by_name (String username);
	String add_prestataire(Prestataire pres);
	//String edit_client(Client clt);
	String RemovePrestataire( Long idpres);
	String edit_prestataire(Prestataire pres1, Prestataire pres);
	
}
