package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import tn.esprit.spring.models.Carburant_Carnet;
import tn.esprit.spring.models.Depense_carnet;
import tn.esprit.spring.models.Entretien_Carnet;
import tn.esprit.spring.models.Odometer_carnet;
import tn.esprit.spring.models.Trajet_carnet;
import tn.esprit.spring.repository.Carburant_CarnetRepository;
import tn.esprit.spring.repository.Depense_CarnetRepository;
import tn.esprit.spring.repository.Entretien_CarnetRepository;
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
	VehiculeRepository vehiculerepository ;
	@Override
	public String ajouter_carburant(Carburant_Carnet c) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			carburantrepository.save(c);

		}
		return null;

	}

	@Override
	public String ajouter_depense(Depense_carnet d) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			depenserepository.save(d);

		}
		return null;

	}

	@Override
	public String ajouter_entretien(Entretien_Carnet e) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			entretienrepository.save(e);

		}
		return null;

	}

	@Override
	public String ajouter_trajet(Trajet_carnet t) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			trajetrepository.save(t);

		}
		return null;

	}

	@Override
	public String ajouter_odometer(Odometer_carnet o) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			odometerrepository.save(o);

		}
		return null;

	}

}
