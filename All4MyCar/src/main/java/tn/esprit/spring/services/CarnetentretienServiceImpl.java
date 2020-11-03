package tn.esprit.spring.services;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import tn.esprit.spring.models.Carburant_Carnet;
import tn.esprit.spring.models.Depense_carnet;
import tn.esprit.spring.models.Entretien_Carnet;
import tn.esprit.spring.models.Historique_carnet;
import tn.esprit.spring.models.Odometer_carnet;
import tn.esprit.spring.models.Trajet_carnet;
import tn.esprit.spring.repository.Carburant_CarnetRepository;
import tn.esprit.spring.repository.Depense_CarnetRepository;
import tn.esprit.spring.repository.Entretien_CarnetRepository;
import tn.esprit.spring.repository.Historique_carnetRepository;
import tn.esprit.spring.repository.Odometer_carnetRepository;
import tn.esprit.spring.repository.Trajet_CarnetRepository;
import tn.esprit.spring.repository.VehiculeRepository;


@Service
public class CarnetentretienServiceImpl implements CarnetentretienService {
	@Autowired 
	Carburant_CarnetRepository carburantrepository ;

	@Autowired 
	Odometer_carnetRepository odometerrepository ;

	@Autowired 
	Depense_CarnetRepository depenserepository ;

	@Autowired 
	Entretien_CarnetRepository entretienrepository ;

	@Autowired 
	Trajet_CarnetRepository trajetrepository ;
	
	@Autowired 
	Historique_carnetRepository historiquerepository ;
	
	@Autowired 
	VehiculeRepository vehiculerepository ;
	@Override
	public String ajouter_carburant(Carburant_Carnet c) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			carburantrepository.save(c);
            Historique_carnet hc = new Historique_carnet();
            hc.setDate_ajout(c.getDate_carburant());
            hc.setCarburant(c);
            historiquerepository.save(hc);
		}
		return null;

	}

	@Override
	public String ajouter_depense(Depense_carnet d) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			depenserepository.save(d);
			Historique_carnet hc = new Historique_carnet();
            hc.setDate_ajout(d.getDate_depense());
            hc.setDepense(d);
            historiquerepository.save(hc);

		}
		return null;

	}

	@Override
	public String ajouter_entretien(Entretien_Carnet e) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			entretienrepository.save(e);
			Historique_carnet hc = new Historique_carnet();
            hc.setDate_ajout(e.getDate_entretien());
            hc.setEntretien(e);
            historiquerepository.save(hc);

		}
		return null;

	}

	@Override
	public String ajouter_trajet(Trajet_carnet t) throws ParseException {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			t.setHeure_depart(addoneHour(t.getHeure_depart()));
			t.setHeure_arrive(addoneHour(t.getHeure_arrive()));

			trajetrepository.save(t);
			Historique_carnet hc = new Historique_carnet();
            hc.setDate_ajout(t.getDate_depart());
            hc.setTrajet(t);
            historiquerepository.save(hc);

		}
		return null;

	}

	@Override
	public String ajouter_odometer(Odometer_carnet o) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			odometerrepository.save(o);
			Historique_carnet hc = new Historique_carnet();
            hc.setDate_ajout(o.getDate_odometer());
            hc.setOdometer(o);
            historiquerepository.save(hc);

		}
		return null;

	}
	
	
	public Date addoneHour (Date heure) throws ParseException{
		if (heure!=null){
		Calendar c = Calendar.getInstance(); 
		c.setTime(heure); 
		c.add(Calendar.HOUR_OF_DAY, 1);
		Date d = c.getTime();
		System.out.println("tryaddone"+""+c.getTime());
		System.out.println(d);
		
		//Time timeValue = new Time(d.getTime());

		return d;
		}else return null;
	}

}
