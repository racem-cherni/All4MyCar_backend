package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import tn.esprit.spring.models.Client;
import tn.esprit.spring.models.Historique_carnet;
import tn.esprit.spring.models.Vehicule;
import tn.esprit.spring.repository.Historique_carnetRepository;
@Service
public class HistoriqueServiceImpl  implements HistoriqueService{
@Autowired
Historique_carnetRepository historiquerepository;
@Autowired
ClientService clientservice;
	@Override
	public List<Historique_carnet> findAllHistorique() {
		
		return  historiquerepository.findAll();
	}
	@Override
	public List<Historique_carnet> findPremiersHistoriques() {
		
		return historiquerepository.findPremiersHistorique();
	}
	@Override
	public List<Historique_carnet> findHistoriqueByVehicule(long id) {
		
	return historiquerepository.findByVehiculeId(id);
	}
	@Override
	public String deletehistorique(long idhistorique) {
		Historique_carnet his = historiquerepository.findById(idhistorique).get() ;
		historiquerepository.delete(his);
		return "historique supprimé";

	}

}
