package tn.esprit.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.models.User;
import tn.esprit.spring.models.Vehicule_model;
import java.util.Set;
import java.lang.Long;
import tn.esprit.spring.models.Client;
import tn.esprit.spring.models.Prestataire;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);
	
	@Query("SELECT u from User u where u.id=:iduser")
    User finduserbyid(@Param("iduser") Long id);
	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	
	@Query("SELECT u from User u where u.etat=0")
	List<User> findByEtat();
	
	User  findByClientId(@Param("idclient") Long id);
	
	User findByPrestataireId(@Param("idpres") Long id);
	
}
