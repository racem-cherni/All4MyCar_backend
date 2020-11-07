package tn.esprit.spring.services;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import tn.esprit.spring.models.Carburant_Carnet;
import tn.esprit.spring.models.Depense_carnet;
import tn.esprit.spring.models.Entretien_Carnet;
import tn.esprit.spring.models.Odometer_carnet;
import tn.esprit.spring.models.Trajet_carnet;
import tn.esprit.spring.models.Vehicule;

public interface CarnetentretienService {

	String ajouter_carburant(Carburant_Carnet c);

	String ajouter_depense(Depense_carnet d);

	String ajouter_entretien(Entretien_Carnet e);

	String ajouter_trajet(Trajet_carnet t) throws ParseException;
	public Date addoneHour (Date heure) throws ParseException;
	String ajouter_odometer(Odometer_carnet o);
	
List<Carburant_Carnet>  findCarburant(Vehicule vehicule);

List<Depense_carnet> findDepense(int idvehicule);

List<Entretien_Carnet> findEntretien(int idvehicule);

List<Odometer_carnet> findOdometer(int idvehicule);

List<Trajet_carnet> findTrajet(int idvehicule);

List<Carburant_Carnet> getCarburantParPeriode(long vehiculeId, String periode);

int getDepense_carburantMois(Carburant_Carnet[] carburantlist);

List<Entretien_Carnet> getEntretienParPeriode(long vehiculeId, String periode);

List<Odometer_carnet> getOdometerParPeriode(long vehiculeId, String periode);


List<Trajet_carnet> getTrajetParPeriode(long vehiculeId, String periode);


List<Depense_carnet> getDepenseParPeriode(long vehiculeId, String periode);


}
