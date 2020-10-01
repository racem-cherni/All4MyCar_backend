package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.models.User;

public interface AdminService {
	
List<User> findUser();
List<User> findClientUser();
List<User>  findPrestataireUser();
User Afficher_admin_by_name (String username);
String Accepter_Client(long idclient);
   String refuser_client(long idclient);
   
   String Accepter_Pres(long idpres);
   String refuser_pres(long idpres);

}
