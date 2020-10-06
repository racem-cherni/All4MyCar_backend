package tn.esprit.spring.services;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import tn.esprit.spring.models.Client;
import tn.esprit.spring.models.Prestataire;
import tn.esprit.spring.models.User;

public interface AdminService {
	
List<User> findUser();
List<User> findClientUser();
List<User>  findPrestataireUser();
User Afficher_admin_by_name (String username);
String Accepter_Client(long idclient)throws MessagingException, IOException;
   String refuser_client(long idclient);
   
   String Accepter_Pres(long idpres);
   String refuser_pres(long idpres);
   List<Client> getAllClient();
   List<Client> getAllClientbydateinscription(Date date);

   List<Prestataire> getAllPrestataire();
   List<Prestataire> getAllPrestatairebydateinscription(Date date);
   
   List<Prestataire> getAllPrestatairebyspecialisations(String specialisations);


   String deleteClient(long idclient);
   String deletPrestataire(long idpres);
   Client detailclient(long idclt);
   Prestataire detailprestataire(long idpres);
   

}
