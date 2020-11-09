package tn.esprit.spring.services;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Collections;
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
	public float getDepense_carburantMois(long vehiculeId, String periode) {
		Date d = new Date();
		System.out.println("im hereperidoee "+periode);

		List<Float> tm = Collections.emptyList();float stm=0;

		if (periode.equals("THIS_MONTH")){
			tm =carburantrepository.getDepense_carburantMoisTM(vehiculeId,d);
			System.out.println("size "+tm.size());

			if( !tm.isEmpty()){
		for (int i=0;i<tm.size();i++){
			System.out.println("im hereTM "+tm.get(i));

			stm+=tm.get(i);
		}
		stm=stm/tm.size();
		System.out.println("im hereTM "+stm);

		}
		}

		else if (periode.equals("LAST_MONTH")){
			tm =carburantrepository.getDepense_carburantMoisLM(vehiculeId,d);
			System.out.println("size "+tm.size());

			if( !tm.isEmpty()){
				System.out.println("im hereLM "+tm.size());

				for (int i=0;i<tm.size();i++){
					stm+=tm.get(i);
				}
				stm=stm/tm.size();
				System.out.println("im hereLM "+stm);

				}
			}
		else if (periode.equals("THIS_YEAR")){
			tm =carburantrepository.getDepense_carburantMoisTY(vehiculeId,d);
			System.out.println("size "+tm.size());

			if( !tm.isEmpty()){
				for (int i=0;i<tm.size();i++){
					stm+=tm.get(i);
				}
				stm=stm/tm.size();
				System.out.println("im hereTY "+stm);

				}	
			}
		else {  
			tm =carburantrepository.getDepense_carburantMoisAT(vehiculeId);
			System.out.println("size "+tm.size());

			if( !tm.isEmpty()){
				for (int i=0;i<tm.size();i++){

					stm+=tm.get(i);
				}
				stm=stm/tm.size();

				}
		}
		System.out.println("im here "+stm);
		return stm;

		
	}
	
	@Override
	public float getRemplis_carburantMois(long vehiculeId, String periode) {
		Date d = new Date();
		System.out.println("im hereperidoee "+periode);

		List<Float> tm = Collections.emptyList();float stm=0;

		if (periode.equals("THIS_MONTH")){
			tm =carburantrepository.getRemplis_carburantMoisTM(vehiculeId);
			System.out.println("size TM"+tm.size());

			if( !tm.isEmpty()){
		for (int i=0;i<tm.size();i++){
			System.out.println("im hereTM "+tm.get(i));

			stm+=tm.get(i);
		}
		stm=stm/tm.size();
		System.out.println("im hereTM "+stm);

		}
		}

		else if (periode.equals("LAST_MONTH")){
			tm =carburantrepository.getRemplis_carburantMoisLM(vehiculeId,d);

			if( !tm.isEmpty()){
				System.out.println("im hereLM "+tm.size());

				for (int i=0;i<tm.size();i++){
					stm+=tm.get(i);
				}
				stm=stm/tm.size();
				System.out.println("im hereLM "+stm);

				}
			}
		else if (periode.equals("THIS_YEAR")){
			tm =carburantrepository.getRemplis_carburantMoisTY(vehiculeId,d);
			System.out.println("size TY"+tm.size());

			if( !tm.isEmpty()){
				System.out.println("size TY2"+tm.size());

				for (int i=0;i<tm.size();i++){
					System.out.println("get TY"+" "+i+""+tm.get(i));

					stm+=tm.get(i);
				}
				stm=stm/tm.size();
				System.out.println("im hereTY "+stm);

				}	
			}
		else if (periode.equals("ALLTIME")) {  
			tm =carburantrepository.getRemplis_carburantMoisAT(vehiculeId);
			System.out.println("size AT"+tm.size());

			if( !tm.isEmpty()){
				System.out.println("size AT2"+tm.size());

				for (int i=0;i<tm.size();i++){
					System.out.println("get AT"+" "+i+""+tm.get(i));

					stm+=tm.get(i);
				}
				stm=stm/tm.size();
				System.out.println("im here AT "+stm);

				}
		}
		System.out.println("im here "+stm);
		return stm;

		
	}
	
	
	

	@Override
	public float getNbr_entretienMois(long vehiculeId, String periode) {
		Date d = new Date();
		System.out.println("im hereperidoee "+periode);

		List<Float> tm = Collections.emptyList();float stm=0;

		if (periode.equals("THIS_MONTH")){
			tm =entretienrepository.getNbr_entretienMoisTM(vehiculeId);
			System.out.println("size TM"+tm.size());

			if( !tm.isEmpty()){
		for (int i=0;i<tm.size();i++){
			System.out.println("im hereTM "+tm.get(i));

			stm+=tm.get(i);
		}
		stm=stm/tm.size();
		System.out.println("im hereTM "+stm);

		}
		}

		else if (periode.equals("LAST_MONTH")){
			tm =entretienrepository.getNbr_entretienMoisLM(vehiculeId,d);

			if( !tm.isEmpty()){
				System.out.println("im hereLM "+tm.size());

				for (int i=0;i<tm.size();i++){
					stm+=tm.get(i);
				}
				stm=stm/tm.size();
				System.out.println("im hereLM "+stm);

				}
			}
		else if (periode.equals("THIS_YEAR")){
			tm =entretienrepository.getNbr_entretienMoisTY(vehiculeId,d);
			System.out.println("size TY"+tm.size());

			if( !tm.isEmpty()){
				System.out.println("size TY2"+tm.size());

				for (int i=0;i<tm.size();i++){
					System.out.println("get TY"+" "+i+""+tm.get(i));

					stm+=tm.get(i);
				}
				stm=stm/tm.size();
				System.out.println("im hereTY "+stm);

				}	
			}
		else if (periode.equals("ALLTIME")) {  
			tm =entretienrepository.getNbr_entretienMoisAT(vehiculeId);
			System.out.println("size AT"+tm.size());

			if( !tm.isEmpty()){
				System.out.println("size AT2"+tm.size());

				for (int i=0;i<tm.size();i++){
					System.out.println("get AT"+" "+i+""+tm.get(i));

					stm+=tm.get(i);
				}
				stm=stm/tm.size();
				System.out.println("im here AT "+stm);

				}
		}
		System.out.println("im here "+stm);
		return stm;
	}

	@Override
	public float getDepense_entretienMois(long vehiculeId, String periode) {
		Date d = new Date();
		System.out.println("im hereperidoee "+periode);

		List<Float> tm = Collections.emptyList();float stm=0;

		if (periode.equals("THIS_MONTH")){
			tm =entretienrepository.getDepense_entretienMoisTM(vehiculeId);
			System.out.println("size TM"+tm.size());

			if( !tm.isEmpty()){
		for (int i=0;i<tm.size();i++){
			System.out.println("im hereTM "+tm.get(i));

			stm+=tm.get(i);
		}
		stm=stm/tm.size();
		System.out.println("im hereTM "+stm);

		}
		}

		else if (periode.equals("LAST_MONTH")){
			tm =entretienrepository.getDepense_entretienMoisLM(vehiculeId,d);

			if( !tm.isEmpty()){
				System.out.println("im hereLM "+tm.size());

				for (int i=0;i<tm.size();i++){
					stm+=tm.get(i);
				}
				stm=stm/tm.size();
				System.out.println("im hereLM "+stm);

				}
			}
		else if (periode.equals("THIS_YEAR")){
			tm =entretienrepository.getDepense_entretienMoisTY(vehiculeId,d);
			System.out.println("size TY"+tm.size());

			if( !tm.isEmpty()){
				System.out.println("size TY2"+tm.size());

				for (int i=0;i<tm.size();i++){
					System.out.println("get TY"+" "+i+""+tm.get(i));

					stm+=tm.get(i);
				}
				stm=stm/tm.size();
				System.out.println("im hereTY "+stm);

				}	
			}
		else if (periode.equals("ALLTIME")) {  
			tm =entretienrepository.getDepense_entretienMoisAT(vehiculeId);
			System.out.println("size AT"+tm.size());

			if( !tm.isEmpty()){
				System.out.println("size AT2"+tm.size());

				for (int i=0;i<tm.size();i++){
					System.out.println("get AT"+" "+i+""+tm.get(i));

					stm+=tm.get(i);
				}
				stm=stm/tm.size();
				System.out.println("im here AT "+stm);

				}
		}
		System.out.println("im here "+stm);
		return stm;
	}

	
	//////////////////kilometrage 
	
	@Override
	public float getKilometrage_mois(long vehiculeId, String periode) {
		Date d = new Date();
		List<Date> ld = Collections.emptyList();int fail=0;int success=0;
		List<Float> lo = Collections.emptyList(); float stm=0;int nbr=0;int i=0;
		/////this_month
		if ( periode.equals("THIS_MONTH")){
		lo =odometerrepository.getKilometrageTMo(vehiculeId,d);
		if( !lo.isEmpty()){
			for (i=0;i<lo.size()-1;i++){
                   stm=stm+(lo.get(i+1)-lo.get(i));					
				}

			}
		}
		
	    /////last_month
		else if( periode.equals("LAST_MONTH")){
			lo =odometerrepository.getKilometrageLMo(vehiculeId,d);
			if( !lo.isEmpty()){
				for (i=0;i<lo.size()-1;i++){
	                   stm=stm+(lo.get(i+1)-lo.get(i));					
					}

				}
			}

	    /////last_year
		else if ( periode.equals("THIS_YEAR")){
			lo =odometerrepository.getKilometrageTYo(vehiculeId,d);
			ld = odometerrepository.getKilometrageTYd(vehiculeId,d);

			if( !lo.isEmpty()){
					while(i<lo.size()-1 ){
						if (ld.get(i).getMonth()==ld.get(i+1).getMonth()){
						stm=stm+ (lo.get(i+1)-lo.get(i));
						i++;
						fail=0;
						success=1;
						}
						else{
							success=0;
							if(fail==1) {i++;}
							else{
							fail++;
						    i++;
							nbr++;
							}
						}
					}
					if (success==1)  nbr++;
					if(nbr!=0) stm=stm/nbr;

			}
		}
		/////all_time
		else if ( periode.equals("ALLTIME")){
			lo =odometerrepository.getKilometrageATo(vehiculeId);
			ld = odometerrepository.getKilometrageATd(vehiculeId);

			if( !lo.isEmpty()){
					while(i<lo.size()-1 ){
						if (ld.get(i).getMonth()==ld.get(i+1).getMonth() && ld.get(i).getYear()==ld.get(i+1).getYear() ){
						stm=stm+ (lo.get(i+1)-lo.get(i));
						i++;
						fail=0;
						success=1;
						}
						else{
							success=0;
							if(fail==1) {i++;}
							else{
							fail++;
						    i++;
							nbr++;
							}
						}
					}
					if (success==1)  nbr++;
					if(nbr!=0) stm=stm/nbr;

			}
			}		
		return stm;
		}
/////////////////////////////////////////////////////////////////////kilometrage_semaine
	@Override
	public float getKilometrage_semaine(long vehiculeId, String periode) {
		Calendar calendar = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();

		Date d = new Date();
		List<Date> ld = Collections.emptyList();int fail=0;int success=0;
		List<Float> lo = Collections.emptyList(); float stm=0;int nbr=0;int i=0;
		/////this_month
		if ( periode.equals("THIS_MONTH")){
			lo =odometerrepository.getKilometrageTMo(vehiculeId,d);
			ld = odometerrepository.getKilometrageTMd(vehiculeId,d);

			if( !lo.isEmpty()){
					while(i<lo.size()-1 ){
						calendar.set(ld.get(i).getYear(),ld.get(i).getMonth(),ld.get(i).getDay());
						calendar2.set(ld.get(i+1).getYear(),ld.get(i+1).getMonth(),ld.get(i+1).getDay());
						
						if (calendar.WEEK_OF_YEAR == calendar2.WEEK_OF_YEAR  ){
						stm=stm+ (lo.get(i+1)-lo.get(i));
						i++;
						fail=0;
						success=1;
						}
						else{
							success=0;
							if(fail==1) {i++;}
							else{
							fail++;
						    i++;
							nbr++;
							}
						}
					}
					if (success==1)  nbr++;
					if(nbr!=0) stm=stm/nbr;

			}
		}
		
	    /////last_month
		else if( periode.equals("LAST_MONTH")){
			lo =odometerrepository.getKilometrageLMo(vehiculeId,d);
			ld = odometerrepository.getKilometrageLMd(vehiculeId,d);

			if( !lo.isEmpty()){
					while(i<lo.size()-1 ){
						calendar.set(ld.get(i).getYear(),ld.get(i).getMonth(),ld.get(i).getDay());
						calendar2.set(ld.get(i+1).getYear(),ld.get(i+1).getMonth(),ld.get(i+1).getDay());
						
						if (calendar.WEEK_OF_YEAR == calendar2.WEEK_OF_YEAR  ){
						stm=stm+ (lo.get(i+1)-lo.get(i));
						i++;
						fail=0;
						success=1;
						}
						else{
							success=0;
							if(fail==1) {i++;}
							else{
							fail++;
						    i++;
							nbr++;
							}
						}
					}
					if (success==1)  nbr++;
					if(nbr!=0) stm=stm/nbr;

			}
			}

	    /////last_year
		else if ( periode.equals("THIS_YEAR")){
			lo =odometerrepository.getKilometrageTYo(vehiculeId,d);
			ld = odometerrepository.getKilometrageTYd(vehiculeId,d);

			if( !lo.isEmpty()){
					while(i<lo.size()-1 ){
						calendar.set(ld.get(i).getYear(),ld.get(i).getMonth(),ld.get(i).getDay());
						calendar2.set(ld.get(i+1).getYear(),ld.get(i+1).getMonth(),ld.get(i+1).getDay());
						
						if (ld.get(i).getMonth()==ld.get(i+1).getMonth() && ld.get(i).getMonth()==ld.get(i+1).getMonth() 
						&& calendar.WEEK_OF_YEAR == calendar2.WEEK_OF_YEAR  ){
						stm=stm+ (lo.get(i+1)-lo.get(i));
						i++;
						fail=0;
						success=1;
						}
						else{
							success=0;
							if(fail==1) {i++;}
							else{
							fail++;
						    i++;
							nbr++;
							}
						}
					}
					if (success==1)  nbr++;
					if(nbr!=0) stm=stm/nbr;

			}
		}
		/////all_time
		else if ( periode.equals("ALLTIME")){
			lo =odometerrepository.getKilometrageATo(vehiculeId);
			ld = odometerrepository.getKilometrageATd(vehiculeId);

			if( !lo.isEmpty()){
					while(i<lo.size()-1 ){
						calendar.set(ld.get(i).getYear(),ld.get(i).getMonth(),ld.get(i).getDay());
						calendar2.set(ld.get(i+1).getYear(),ld.get(i+1).getMonth(),ld.get(i+1).getDay());
						
						if (ld.get(i).getMonth()==ld.get(i+1).getMonth() && ld.get(i).getMonth()==ld.get(i+1).getMonth() 
						&& ld.get(i).getYear()==ld.get(i+1).getYear() && calendar.WEEK_OF_YEAR == calendar2.WEEK_OF_YEAR  ){
						stm=stm+ (lo.get(i+1)-lo.get(i));
						i++;
						fail=0;
						success=1;
						}
						else{
							success=0;
							if(fail==1) {i++;}
							else{
							fail++;
						    i++;
							nbr++;
							}
						}
					}
					if (success==1)  nbr++;
					if(nbr!=0) stm=stm/nbr;

			}
			}		

		return stm;
	}

/////////////////////////////////////////////////////////////////////kilometrage_jour

	@Override
	public float getKilometrage_jour(long vehiculeId, String periode) {
		Date d = new Date();
		List<Date> ld = Collections.emptyList();int fail=0;int success=0;
		List<Float> lo = Collections.emptyList(); float stm=0;int nbr=0;int i=0;
		/////this_month
		if ( periode.equals("THIS_MONTH")){
			lo =odometerrepository.getKilometrageTMo(vehiculeId,d);
			ld = odometerrepository.getKilometrageTMd(vehiculeId,d);
			if( !lo.isEmpty()){
				while(i<lo.size()-1 ){
					if (ld.get(i).getDay()==ld.get(i+1).getDay()){
					stm=stm+ (lo.get(i+1)-lo.get(i));
					i++;
					fail=0;
					success=1;
					}
					else{
						success=0;
						if(fail==1) {i++;}
						else{
						fail++;
					    i++;
						nbr++;
						}
					}
				}
				if (success==1)  nbr++;
				if(nbr!=0) stm=stm/nbr;

		}
		}
		
	    /////last_month
		else if( periode.equals("LAST_MONTH")){
			lo =odometerrepository.getKilometrageLMo(vehiculeId,d);
			ld = odometerrepository.getKilometrageLMd(vehiculeId,d);
			if( !lo.isEmpty()){
				while(i<lo.size()-1 ){
					if (ld.get(i).getDay()==ld.get(i+1).getDay()){
					stm=stm+ (lo.get(i+1)-lo.get(i));
					i++;
					fail=0;
					success=1;
					}
					else{
						success=0;
						if(fail==1) {i++;}
						else{
						fail++;
					    i++;
						nbr++;
						}
					}
				}
				if (success==1)  nbr++;
				if(nbr!=0) stm=stm/nbr;

		}
			}

	    /////last_year
		else if ( periode.equals("THIS_YEAR")){
			lo =odometerrepository.getKilometrageTYo(vehiculeId,d);
			ld = odometerrepository.getKilometrageTYd(vehiculeId,d);

			if( !lo.isEmpty()){
					while(i<lo.size()-1 ){
						if (ld.get(i).getDay()==ld.get(i+1).getDay() && ld.get(i).getMonth()==ld.get(i+1).getMonth()){
						stm=stm+ (lo.get(i+1)-lo.get(i));
						i++;
						fail=0;
						success=1;
						}
						else{
							success=0;
							if(fail==1) {i++;}
							else{
							fail++;
						    i++;
							nbr++;
							}
						}
					}
					if (success==1)  nbr++;
					if(nbr!=0) stm=stm/nbr;

			}
		}
		/////all_time
		else if ( periode.equals("ALLTIME")){
			lo =odometerrepository.getKilometrageATo(vehiculeId);
			ld = odometerrepository.getKilometrageATd(vehiculeId);

			if( !lo.isEmpty()){
					while(i<lo.size()-1 ){
						if (ld.get(i).getDay()==ld.get(i+1).getDay() && ld.get(i).getMonth()==ld.get(i+1).getMonth() && ld.get(i).getYear()==ld.get(i+1).getYear() ){
						stm=stm+ (lo.get(i+1)-lo.get(i));
						i++;
						fail=0;
						success=1;
						}
						else{
							success=0;
							if(fail==1) {i++;}
							else{
							fail++;
						    i++;
							nbr++;
							}
						}
					}
					if (success==1)  nbr++;
					if(nbr!=0) stm=stm/nbr;

			}
			}		
		return stm;
	}

/////////////////////////////////////////////////////////////////////kilometrage_annee

	@Override
	public float getKilometrage_annee(long vehiculeId, String periode) {
		Date d = new Date();
		List<Date> ld = Collections.emptyList();int fail=0;int success=0;
		List<Float> lo = Collections.emptyList(); float stm=0;int nbr=0;int i=0;
		/////this_month
		if ( periode.equals("THIS_MONTH")){
	stm=0;
		}
		
	    /////last_month
		else if( periode.equals("LAST_MONTH")){
			stm=0;
			}

	    /////last_year
		else if ( periode.equals("THIS_YEAR")){
			lo =odometerrepository.getKilometrageTYo(vehiculeId,d);

			if( !lo.isEmpty()){
				for (i=0;i<lo.size()-1;i++){
	                   stm=stm+(lo.get(i+1)-lo.get(i));					
					}
			}
		}
		/////all_time
		else if ( periode.equals("ALLTIME")){
			lo =odometerrepository.getKilometrageATo(vehiculeId);
			ld =odometerrepository.getKilometrageATd(vehiculeId);

			if( !lo.isEmpty()){
					while(i<lo.size()-1 ){
						if (ld.get(i).getYear()==ld.get(i+1).getYear() ){
						stm=stm+ (lo.get(i+1)-lo.get(i));
						i++;
						fail=0;
						success=1;
						}
						else{
							success=0;
							if(fail==1) {i++;}
							else{
							fail++;
						    i++;
							nbr++;
							}
						}
					}
					if (success==1)  nbr++;
					if(nbr!=0) stm=stm/nbr;

			}
			}		
		return stm;
	}

	@Override
	public String delete_carburant(long idcarburant) {
		Carburant_Carnet c = carburantrepository.findById(idcarburant).get();
		carburantrepository.delete(c);
		return "carburant supprimée";
	}

	@Override
	public String delete_depense(long iddepense) {
		Depense_carnet d = depenserepository.findById(iddepense).get();
		depenserepository.delete(d);
		return "depense supprimé";
	}

	@Override
	public String delete_entretien(long identretien) {
		Entretien_Carnet e = entretienrepository.findById(identretien).get();
		entretienrepository.delete(e);
		return "entretien supprimé" ;
	}

	@Override
	public String delete_trajet(long idtrajet) {
		Trajet_carnet t = trajetrepository.findById(idtrajet).get();
		trajetrepository.delete(t);
		return "trajet supprimé";
	}

	@Override
	public String delete_odometer(long idodometer) {
		Odometer_carnet o = odometerrepository.findById(idodometer).get();
		odometerrepository.delete(o);
		return "odometer suppriméé";
	}

}
