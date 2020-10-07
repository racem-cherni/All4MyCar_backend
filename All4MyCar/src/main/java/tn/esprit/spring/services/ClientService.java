package tn.esprit.spring.services;

import tn.esprit.spring.models.Client;
import tn.esprit.spring.models.User;

public interface ClientService {
	
    User Afficher_client_by_name (String username);
	String add_client(Client clt);
	//String edit_client(Client clt);
	String RemoveClient ( Long idclient);
	String edit_client(Client Cach, Client clt);
	String ajouterclient_sansverif(Long id, Client clt);
	
	
	
	

}
