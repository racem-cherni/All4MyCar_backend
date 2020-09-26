package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.models.Client;
import tn.esprit.spring.models.Vehicule;
import tn.esprit.spring.models.Vehicule_marque;
import tn.esprit.spring.models.Vehicule_model;

public interface VehiculeService {

	// List<Vehicule_marque> getVehiculeMarqueModel (); 
	String add_vehicule(Vehicule vs);

	List<Vehicule> getVehiculeOfClient();

	String removeVehicule(long id);
	Optional<Vehicule> getvehicule(long id);

	Vehicule_model getmodelbyid(long idmodel);

}
