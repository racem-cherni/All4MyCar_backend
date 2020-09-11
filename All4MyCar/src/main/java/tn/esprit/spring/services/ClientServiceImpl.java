package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import tn.esprit.spring.models.Client;
import tn.esprit.spring.models.User;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.UserRepository;



@Service
@CrossOrigin(origins = "http://localhost:4200")
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	ClientRepository clientrepository ;

	@Autowired
	UserRepository userrepository ;

	@Override
	public String add_client(Client clt) {
		
		clientrepository.save(clt);
		
		return "success";
	}

	@Override
	public String edit_client(Client cl1, Client clt) {
		//Client cl1 = clientrepository.findById(clt.getId()).get();
	
		cl1.setAdresseclt(clt.getAdresseclt());
		cl1.setCIN(clt.getCIN());
		cl1.setDate_permis(clt.getDate_permis());
		cl1.setEmailclt(clt.getEmailclt());
		cl1.setFirstNameclt(clt.getFirstNameclt());
		cl1.setLastNameclt(clt.getLastNameclt());
		cl1.setPhotoclt(clt.getPhotoclt());
		cl1.setTelclt(clt.getTelclt());
		
		
		clientrepository.save(cl1);
		return "profil modifie";
	}

	@Override
	public String RemoveClient(Long idclient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User Afficher_client_by_name(String username) {
		return userrepository.findByUsername(username).get();
	}
	
	

}
