package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.models.AdresseCites;
import tn.esprit.spring.models.Garage;
import tn.esprit.spring.models.Prestataire;
import tn.esprit.spring.models.Rdv_dispo;
import tn.esprit.spring.models.Vehicule_model;

public interface GarageService {
	String add_Garage(Garage garage);
	
	//try
	Garage findGarage();
	 AdresseCites getCitebyid(long idadressecite);
}
