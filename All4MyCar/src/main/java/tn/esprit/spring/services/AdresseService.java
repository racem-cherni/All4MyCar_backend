package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.models.AdresseCites;
import tn.esprit.spring.models.AdressePays;
import tn.esprit.spring.models.AdresseVilles;

public interface AdresseService {
	
	List<AdressePays> findallpays();
	List<AdresseVilles> findallvillesofpays(Long id);
	
	List<AdresseCites> findallcitesofville(Long id);

}
