package tn.esprit.spring.services;

import tn.esprit.spring.models.Carburant_Carnet;
import tn.esprit.spring.models.Depense_carnet;
import tn.esprit.spring.models.Entretien_Carnet;
import tn.esprit.spring.models.Odometer_carnet;
import tn.esprit.spring.models.Trajet_carnet;

public interface CarnetentretienService {

	String ajouter_carburant(Carburant_Carnet c);

	String ajouter_depense(Depense_carnet d);

	String ajouter_entretien(Entretien_Carnet e);

	String ajouter_trajet(Trajet_carnet t);

	String ajouter_odometer(Odometer_carnet o);

}
