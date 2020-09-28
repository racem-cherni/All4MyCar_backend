package tn.esprit.spring.services;

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
	public String modifier_dispojour(Rdv_dispo dispo, int id) {
		Rdv_dispo dp = prestatairerepository.findDispById(id);
        dp.setHeuredam(dispo.getHeuredam());
       dp.setHeuredm(dispo.getHeuredm());
        dp.setHeurefam(dispo.getHeurefam());
        dp.setHeurefm(dispo.getHeurefm());
dp.setJour_actif(dispo.isJour_actif());
dp.setPeriodedeux_actif(dispo.isPeriodedeux_actif());
	      System.out.println("heyservice"+dp.isJour_actif());

        rdv_disporepository.save(dp);
return "profil modifie";
	}


}
