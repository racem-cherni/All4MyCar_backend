package tn.esprit.spring.services;

import java.sql.Time;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import tn.esprit.spring.models.Prestataire;
import tn.esprit.spring.models.Rdv_dispo;
import tn.esprit.spring.repository.PrestataireRepository;
import tn.esprit.spring.repository.Rdv_dispoRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
@CrossOrigin(origins = "http://localhost:4200")
public class RdvServiceImpl implements RdvService{
	@Autowired
	PrestataireRepository prestatairerepository ;

	@Autowired
	UserRepository userrepository ;
	@Autowired
	Rdv_dispoRepository rdv_disporepository;
	
	
	
	@Override
	public List<Rdv_dispo> getdisponibility() {
		 Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				String userName = ((UserDetails) principal).getUsername();
				Prestataire clt  = userrepository.findByUsername(userName).get().getPrestataire();
				return prestatairerepository.findDispByPres(clt.getId());
	}		return null;
	}

	@Override
	public String modifier_dispojour(Rdv_dispo dispo, int id) throws ParseException {
		Rdv_dispo dp = prestatairerepository.findDispById(id);
        dp.setHeuredam(addoneHour(dispo.getHeuredam()));
       dp.setHeuredm(addoneHour(dispo.getHeuredm()));
        dp.setHeurefam(addoneHour(dispo.getHeurefam()));
        dp.setHeurefm(addoneHour(dispo.getHeurefm()));
dp.setJour_actif(dispo.isJour_actif());
dp.setPeriodedeux_actif(dispo.isPeriodedeux_actif());
	      System.out.println("heyservice"+dp.isJour_actif());

        rdv_disporepository.save(dp);
return "profil modifie";
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
