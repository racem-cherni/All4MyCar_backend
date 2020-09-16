package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.models.Client;
import tn.esprit.spring.models.Vehicule;
import tn.esprit.spring.models.Vehicule_marque;

public interface VehiculeService {

	// List<Vehicule_marque> getVehiculeMarqueModel (); 
	String add_vehicule(Vehicule vs);

	List<Vehicule> getVehiculeOfClient();

	String removeVehicule(long id);

}
