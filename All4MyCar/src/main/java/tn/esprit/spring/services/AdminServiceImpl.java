package tn.esprit.spring.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
ClientService clientservice ;

@Autowired
PrestataireService prestataireservice ;

@Autowired
private JavaMailSender javaMailSender;

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
	public List<Client> Accepter_Client(long idclient) throws MessagingException, IOException {
		//User clt = userrepository.finduserbyid(idclient);
		  Client cl = clientRepository.findById(idclient).get();
		  User user = userrepository.findByClientId(idclient);
		Date d = new Date() ;
	   
			//Client client =  clientservice.Afficher_client_by_name(clt.getUsername()).getClient();
			cl.setDate_inscrip(d);
			cl.setEtat(1);
			clientRepository.save(cl);
			user.setEtat(true);//////////////////
			userrepository.save(user);
			
			// SimpleMailMessage msg = new SimpleMailMessage();
			// MimeMessage msg = javaMailSender.createMimeMessage();
		//	 MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		//	 helper.setTo(clt.getEmail());
		  //      helper.setSubject("Merci pour votre inscription ! Bienvenue sur All4MyCar ▶");
			// true = text/html
		  /*      helper.setText("<html><body> <h1 style='font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif '>ALL <span"
		      +  " style='color:red;'> 4 </span> MYCAR</h1>\n"+
		        		 "<h3> Bonjour Mr(s) "+clt.getUsername()+",</h3>\n" + 
		         "Bienvenue ! Vous êtes inscrit sur All4MyCar,\n"+
		        " Connectez-vous sur notre site et faites vous plaisir en  les meilleures services \n"
		        + " ! Notre site s'est associé à nombreuses garages  \n pour vous garantir le meilleur choix et prix.\n"
		        + " N'hésitez pas à nous contacter pour toute question ou suggestion!\n"
		        +"Par email: <a href='all4mycar.info@gmail.com'>all4mycar.info@gmail.com</a> ou par téléphone en composant le +216 31320900 , du lundi au vendredi de 8h30 à 20h .\n"
		        +"<br>"
		        +"<p>Cordialement,</p>\n"+
		        "L'Equipe de ALL4MyCar\n"
		        + "</body></html>", true);*/
		        //helper.addAttachment("Capture d’écran 2020-10-02 104720.png", new ClassPathResource("/src/main/resources/Capture d’écran 2020-10-02 104720.png"));
		      //  javaMailSender.send(msg);
			return clientRepository.findByEtat();
			
		
		
	}
	@Override
	public String refuser_client(long idclient) {
		userrepository.deleteById(idclient);
		return "user supprime" ;
		
	}
	@Override
	public List<Prestataire> Accepter_Pres(long idpres) {
		//User clt = userrepository.finduserbyid(idpres);
		Prestataire pres = prestataireRepository.findById(idpres).get();
		Date d = new Date() ;
	    User user = userrepository.findByPrestataireId(idpres);
	//	Prestataire pres = prestataireservice.Afficher_prestataire_by_name(clt.getUsername()).getPrestataire();
		pres.setDate_inscrip(d);
		pres.setEtat(1);
		prestataireRepository.save(pres);
		user.setEtat(true);
		userrepository.save(user);
		return prestataireRepository.findByEtat();

		
	}
	@Override
	public String refuser_pres(long idpres) {
		userrepository.deleteById(idpres);
		return "user supprime" ;
	}
	@Override
	public List<Client> getAllClient() {
		return   clientRepository.findAll();
	}
	@Override
	public List<Prestataire> getAllPrestataire() {
		return prestataireRepository.findAll();
	}
	@Override
	public String deleteClient(long idclient) {
		User user=userrepository.findByClientId(idclient);
		userrepository.delete(user);
		clientRepository.deleteById(idclient);
		return "client supprimé";
	}
	@Override
	public String deletPrestataire(long idpres) {
		User user=userrepository.findByPrestataireId(idpres);
		
		userrepository.delete(user);
	prestataireRepository.deleteById(idpres);
	return "prestataire supprimé";
	}
	@Override
	public Client detailclient(long idclt) {
		
		return clientRepository.findById(idclt).get();
	}
	@Override
	public Prestataire detailprestataire(long idpres) {
		return prestataireRepository.findById(idpres).get();
	}
	@Override
	public List<Client> getAllClientbydateinscription(Date date) {
		return clientRepository.findByDate_inscription(date);
	}
	@Override
	public List<Prestataire> getAllPrestatairebydateinscription(Date date) {
		return prestataireRepository.findByDate_inscription(date);
	}
	
	@Override
	public List<Prestataire> getAllPrestatairebyspecialisations(String specialisations) {
		
		List<Prestataire> pres = prestataireRepository.findAll();
		//System.err.println(pres);
		List<Prestataire> recherchepres = new  ArrayList<>();
		for(int i=0;i<pres.size();i++){
			System.err.println(pres.get(i).getSpecialisations());
			if (pres.get(i).getSpecialisations().contains(specialisations)){
				recherchepres.add(pres.get(i));
				
			}
		}
		//System.err.println(recherchepres);
		return recherchepres ;
	}
	@Override
	public List<Client> clientsinactifs() {
		return clientRepository.findByEtat();
	}
	@Override
	public List<Prestataire> prestatairesinactifs() {
		return prestataireRepository.findByEtat();
	}
	
	@Override
	public List<Client> clientsinactifsnotifications() {
		return clientRepository.findByEtatnotification();
	}
	@Override
	public List<Prestataire> prestatairesinactifsnotifications() {
		return prestataireRepository.findByEtatnotification();
	}
	@Override
	public int nbrdemandesinscriptionsnotif() {
		return clientRepository.findByEtatnotification().size() + prestataireRepository.findByEtatnotification().size() ; 
	}
	@Override
	public int Demandesnotificationsaffiches() {
		List<Client> cltnotis = clientRepository.findByEtatnotification();
		List<Prestataire> presnotifs = prestataireRepository.findByEtatnotification();
		for (int i=0;i<cltnotis.size();i++){
			  cltnotis.get(i).setNotif_etat(true);
			  clientRepository.save(cltnotis.get(i));
			  
		}
		for (int i=0;i<presnotifs.size();i++){
			presnotifs.get(i).setNotif_etat(true);
			prestataireRepository.save(presnotifs.get(i));
			
		}
		
		return clientRepository.findByEtatnotification().size() + prestataireRepository.findByEtatnotification().size() ;
	}

}
