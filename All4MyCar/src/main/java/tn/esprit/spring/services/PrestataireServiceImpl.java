package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import tn.esprit.spring.models.Client;
import tn.esprit.spring.models.Prestataire;
import tn.esprit.spring.models.Rdv_dispo;
import tn.esprit.spring.models.User;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.PrestataireRepository;
import tn.esprit.spring.repository.Rdv_dispoRepository;
import tn.esprit.spring.repository.UserRepository;
@Service
@CrossOrigin(origins = "http://localhost:4200")
public class PrestataireServiceImpl implements PrestataireService {
	@Autowired
	PrestataireRepository prestatairerepository ;

	@Autowired
	UserRepository userrepository ;
	@Autowired
	Rdv_dispoRepository rdv_disporepository;
	@Override
	public User Afficher_prestataire_by_name(String username) {
		return userrepository.findByUsername(username).get();
	}

	@Override
	public String add_prestataire(Prestataire pres) {
		prestatairerepository.save(pres);
		
		return "success";
	}

	@Override
	public String RemovePrestataire(Long idpres) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String edit_prestataire(Prestataire pres1, Prestataire pres) {
		pres1.setAdressepres(pres.getAdressepres());
		pres1.setFirstNamepres(pres.getFirstNamepres());
		pres1.setLastNamepres(pres.getLastNamepres());
		pres1.setTelpres(pres.getTelpres());
		pres1.setEmailpres(pres.getEmailpres()); 
		pres1.setPhotopres(pres.getPhotopres());
		pres1.setSpecialisations(pres.getSpecialisations()); 
		pres1.setCIN(pres.getCIN());
		 

	
		prestatairerepository.save(pres1);
	return "profil modifie";
}

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
	      System.out.println("heyservice"+dp.isJour_actif());

        rdv_disporepository.save(dp);
return "profil modifie";
	}



	@Override
	public String ajouterprofil_prestataire(long id, Prestataire press) {
		User user = userrepository.finduserbyid(id);
		Date d = new Date() ;
		press.setDate_inscrip(d);
		prestatairerepository.save(press);
		user.setPrestataire(press);
		userrepository.save(user);

		return "client ajouté";
	}

	
}
