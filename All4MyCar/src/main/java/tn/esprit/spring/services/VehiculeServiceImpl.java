package tn.esprit.spring.services;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import tn.esprit.spring.models.Client;
import tn.esprit.spring.models.User;
import tn.esprit.spring.models.Vehicule;
import tn.esprit.spring.models.Vehicule_marque;
import tn.esprit.spring.models.Vehicule_model;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.repository.VehiculeRepository;
import tn.esprit.spring.repository.Vehicule_marqueRepository;
import tn.esprit.spring.repository.Vehicule_modelRepository;

@Service
@CrossOrigin(origins = "http://localhost:4200")
public class VehiculeServiceImpl implements VehiculeService{
    
	@Autowired
	Vehicule_marqueRepository vehicule_marqueRepository ;
	@Autowired
	Vehicule_modelRepository  vehicule_modelRepository ;
	@Autowired
	ClientService clientservice ;
	
	@Autowired 
	VehiculeRepository vehiculerepository ;

	@Override
	public String add_vehicule(Vehicule vs) {
		 Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				String userName = ((UserDetails) principal).getUsername();
				Client clt  = clientservice.Afficher_client_by_name(userName).getClient();
				vs.setClient(clt);
				vehiculerepository.save(vs);
				return "vehicule ajouté";


			}
			return null ;
			
	}

	@Override
	public List<Vehicule> getVehiculeOfClient() {
		 Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
				String userName = ((UserDetails) principal).getUsername();
				Client clt  = clientservice.Afficher_client_by_name(userName).getClient();
				return vehiculerepository.findByClientId(clt.getId());
	}
	return null;
	}
	/*public List<Vehicule_marque> getVehiculeMarqueModel (){
		return vehicule_marqueRepository.getVehiculeMarqueModel();

	};*/

	@Override
	public String removeVehicule(long id) {
		vehiculerepository.deleteById(id);
		return "vehicule supprimé";
	}

	@Override
	public Optional<Vehicule> getvehicule(long id) {
				return vehiculerepository.findById(id);
	}

	@Override
	public Vehicule_model getmodelbyid(long idmodel) {
		return vehicule_modelRepository.findByIdt(idmodel);
	}
 
}
