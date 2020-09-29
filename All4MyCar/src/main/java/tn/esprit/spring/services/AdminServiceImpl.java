package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.models.Role;
import tn.esprit.spring.models.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class AdminServiceImpl  implements AdminService{
@Autowired
UserRepository userrepository;
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

}
