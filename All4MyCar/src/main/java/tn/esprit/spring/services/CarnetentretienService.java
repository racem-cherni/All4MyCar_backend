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
	
	String delete_carburant(long idcarburant);


	String ajouter_depense(Depense_carnet d);
	String delete_depense(long iddepense);


	String ajouter_entretien(Entretien_Carnet e);
	String delete_entretien(long identretien);


	String ajouter_trajet(Trajet_carnet t) throws ParseException;
	String delete_trajet(long idtrajet);

	public Date addoneHour (Date heure) throws ParseException;
	String ajouter_odometer(Odometer_carnet o);
	String delete_odometer(long idodometer);

	
List<Carburant_Carnet>  findCarburant(Vehicule vehicule);

List<Depense_carnet> findDepense(int idvehicule);

List<Entretien_Carnet> findEntretien(int idvehicule);

List<Odometer_carnet> findOdometer(int idvehicule);

List<Trajet_carnet> findTrajet(int idvehicule);

List<Carburant_Carnet> getCarburantParPeriode(long vehiculeId, String periode);


List<Entretien_Carnet> getEntretienParPeriode(long vehiculeId, String periode);

List<Odometer_carnet> getOdometerParPeriode(long vehiculeId, String periode);


List<Trajet_carnet> getTrajetParPeriode(long vehiculeId, String periode);


List<Depense_carnet> getDepenseParPeriode(long vehiculeId, String periode);

float getDepense_carburantMois(long vehiculeId, String periode);

float getRemplis_carburantMois(long vehiculeId, String periode);

float getNbr_entretienMois(long vehiculeId, String periode);

float getDepense_entretienMois(long vehiculeId, String periode);

float getKilometrage_mois(long vehiculeId, String periode);

float getKilometrage_semaine(long vehiculeId, String periode);

float getKilometrage_jour(long vehiculeId, String periode);

float getKilometrage_annee(long vehiculeId, String periode);

}
