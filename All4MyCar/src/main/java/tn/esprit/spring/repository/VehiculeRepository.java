package tn.esprit.spring.repository;

import java.util.List; 

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import tn.esprit.spring.models.Client;
import tn.esprit.spring.models.Vehicule;
import tn.esprit.spring.models.Vehicule_model;

@CrossOrigin("http://localhost:4200")
@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long>  {
	
	List<Vehicule> findByClientId(@Param("id") long id);

	void deleteById(@Param("id") long id);
	
	
	 Optional<Vehicule>  findById(Long arg0) ;


	
	//List<Vehicule> findByClientId(Long id);

	//List<Vehicule> findByClientId(Client clt);


}
