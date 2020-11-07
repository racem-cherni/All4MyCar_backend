package tn.esprit.spring.services;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import tn.esprit.spring.models.Carburant_Carnet;
import tn.esprit.spring.models.Client;
import tn.esprit.spring.models.Depense_carnet;
import tn.esprit.spring.models.Entretien_Carnet;
import tn.esprit.spring.models.Historique_carnet;
import tn.esprit.spring.models.Odometer_carnet;
import tn.esprit.spring.models.Trajet_carnet;
import tn.esprit.spring.models.Vehicule;
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
	Historique_carnetRepository historiquecarnetrepository;
	@Autowired 
	Historique_carnetRepository historiquerepository ;
	@Autowired
	ClientService clientservice ;
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
            hc.setVehicule(c.getVehicule());
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
            hc.setVehicule(d.getVehicule());
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
            hc.setVehicule(e.getVehicule());
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
            hc.setVehicule(t.getVehicule());
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
            hc.setVehicule(o.getVehicule());
            historiquerepository.save(hc);

		}
		return null;

	}
	
	@Override
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

	@Override
	public List<Carburant_Carnet> findCarburant(Vehicule vehicule) {
		 Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				String userName = ((UserDetails) principal).getUsername();
				Client clt  = clientservice.Afficher_client_by_name(userName).getClient();
				return carburantrepository.findByVehicule(vehicule);
	}
	return null;
	}

	@Override
	public List<Depense_carnet> findDepense(int idvehicule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entretien_Carnet> findEntretien(int idvehicule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Odometer_carnet> findOdometer(int idvehicule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trajet_carnet> findTrajet(int idvehicule) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	//////////////////////////////////////

	@Override
	public List<Carburant_Carnet> getCarburantParPeriode(long vehiculeId, String periode) {
		Date d = new Date();
		if (periode.equals("THIS_MONTH"))
			return carburantrepository.getCarburantParMois(vehiculeId,d);

		else if (periode.equals("LAST_MONTH"))
			return carburantrepository.getCarburantParDernierMois(vehiculeId,d);

		else if (periode.equals("THIS_YEAR"))
			return carburantrepository.getCarburantParAnnee(vehiculeId,d);
	
		else return carburantrepository.getCarburantAll(vehiculeId);

	}
	
	public List<Entretien_Carnet> getEntretienParPeriode(long vehiculeId, String periode) {
		Date d = new Date();
		if (periode.equals("THIS_MONTH"))
			return entretienrepository.getEntretienParMois(vehiculeId,d);

		else if (periode.equals("LAST_MONTH"))
			return entretienrepository.getEntretienParDernierMois(vehiculeId,d);

		else if (periode.equals("THIS_YEAR"))
			return entretienrepository.getEntretienParAnnee(vehiculeId,d);
	
		else return entretienrepository.getEntretienAll(vehiculeId);

	}
	
	public List<Odometer_carnet> getOdometerParPeriode(long vehiculeId, String periode) {
		Date d = new Date();
		if (periode.equals("THIS_MONTH"))
			return odometerrepository.getOdometerParMois(vehiculeId,d);

		else if (periode.equals("LAST_MONTH"))
			return odometerrepository.getOdometerParDernierMois(vehiculeId,d);

		else if (periode.equals("THIS_YEAR"))
			return odometerrepository.getOdometerParAnnee(vehiculeId,d);
	
		else return odometerrepository.getOdometerAll(vehiculeId);

	}
	public List<Trajet_carnet> getTrajetParPeriode(long vehiculeId, String periode) {
		Date d = new Date();
		if (periode.equals("THIS_MONTH"))
			return trajetrepository.getTrajetParMois(vehiculeId,d);

		else if (periode.equals("LAST_MONTH"))
			return trajetrepository.getTrajetParDernierMois(vehiculeId,d);

		else if (periode.equals("THIS_YEAR"))
			return trajetrepository.getTrajetParAnnee(vehiculeId,d);
	
		else return trajetrepository.getTrajetAll(vehiculeId);

	}

	public List<Depense_carnet> getDepenseParPeriode(long vehiculeId, String periode) {
		Date d = new Date();
		if (periode.equals("THIS_MONTH"))
			return depenserepository.getDepenseParMois(vehiculeId,d);

		else if (periode.equals("LAST_MONTH"))
			return depenserepository.getDepenseParDernierMois(vehiculeId,d);

		else if (periode.equals("THIS_YEAR"))
			return depenserepository.getDepenseParAnnee(vehiculeId,d);
	
		else return depenserepository.getDepenseAll(vehiculeId);

	}
	@Override
	public int getDepense_carburantMois(Carburant_Carnet[] carburantlist) {
		System.out.println("im here");
		return 2;
	}

}
