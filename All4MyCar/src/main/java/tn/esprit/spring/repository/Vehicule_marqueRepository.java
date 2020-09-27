package tn.esprit.spring.repository;

import java.util.List; 


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import tn.esprit.spring.models.Client;
import tn.esprit.spring.models.Vehicule_marque;

@CrossOrigin("http://localhost:4200")
@Repository
public interface Vehicule_marqueRepository extends JpaRepository<Vehicule_marque, Long>{
	List<Vehicule_marque> findAll() ;
	 

	
	/*@Query("Select "
			+ "v from Vehicule_marque v")
	public List<Vehicule_marque> getVehiculeMarqueModel();*/  
	
  //
}
