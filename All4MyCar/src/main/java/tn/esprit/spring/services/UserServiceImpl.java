package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.models.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userrepository ;
	
	@Override
	public User Afficher_user_by_name(long id) {
		return userrepository.findById(id).get();
	}
}
