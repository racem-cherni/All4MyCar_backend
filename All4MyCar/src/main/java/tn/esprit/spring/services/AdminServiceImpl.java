package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.models.Client;
import tn.esprit.spring.models.Prestataire;
import tn.esprit.spring.models.Role;
import tn.esprit.spring.models.User;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.PrestataireRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class AdminServiceImpl  implements AdminService{
@Autowired
UserRepository userrepository;

@Autowired
ClientRepository clientRepository;

@Autowired
PrestataireRepository prestataireRepository;

	@Override
	public List<User> findUser() {
		return  userrepository.findByEtat();
	}
	@Override
	public List<User> findClientUser() {
		List<User> users_clients =new ArrayList<>();  ;
		List<User> users = userrepository.findByEtat();
		for (int i=0;i<users.size();i++){
			Set<Role> roles = users.get(i).getRoles() ;
			List<Role> list = new ArrayList<>(); 
			   for (Role t : roles) 
			    list.add(t); 
				String l= list.get(0).getName().toString() ;
				//System.out.println(users.get(i));

				if (  l.equals("ROLE_USER")){
					System.err.println(users.get(i));

					users_clients.add(users.get(i));
					}
				
		}
		return users_clients ;
		
		
	}
	@Override
	public List<User> findPrestataireUser() {
		List<User> users_clients =new ArrayList<>();  ;
		List<User> users = userrepository.findByEtat();
		for (int i=0;i<users.size();i++){
			Set<Role> roles = users.get(i).getRoles() ;
			List<Role> list = new ArrayList<>(); 
			   for (Role t : roles) 
			    list.add(t); 
				String l= list.get(0).getName().toString() ;
				//System.out.println(users.get(i));

				if (  l.equals("ROLE_PRESTATAIRE")){
					System.err.println(users.get(i));

					users_clients.add(users.get(i));
					}
				
		}
		return users_clients ;
		
	}
	@Override
	public User Afficher_admin_by_name(String username) {
		return userrepository.findByUsername(username).get();

	}
	@Override
	public String Accepter_Client(long idclient) {
		User clt = userrepository.finduserbyid(idclient);
		
		Date d = new Date() ;
	   
			Client client = new Client();
			client.setFirstNameclt(clt.getUsername());
			client.setEmailclt(clt.getEmail());
			client.setDate_inscrip(d);
			clientRepository.save(client);
			clt.setEtat(true);
			clt.setClient(client);
			userrepository.save(clt);
			return "client ajouté";
		
		
	}
	@Override
	public String refuser_client(long idclient) {
		userrepository.deleteById(idclient);
		return "user supprime" ;
		
	}
	@Override
	public String Accepter_Pres(long idpres) {
		User clt = userrepository.finduserbyid(idpres);
		Date d = new Date() ;
	   
		Prestataire pres = new Prestataire();
		pres.setFirstNamepres(clt.getUsername());
		pres.setEmailpres(clt.getEmail());
		pres.setDate_inscrip(d);
		prestataireRepository.save(pres);
		clt.setEtat(true);
		clt.setPrestataire(pres);
		userrepository.save(clt);
		return "prestataire ajouté";

		
	}
	@Override
	public String refuser_pres(long idpres) {
		userrepository.deleteById(idpres);
		return "user supprime" ;
	}

}
