package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import tn.esprit.spring.models.Client;
import tn.esprit.spring.models.Vehicule_marque;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "marque" , path="marque")
public interface Vehicule_marqueRepository extends JpaRepository<Vehicule_marque, Long>{

	/*@Query("Select "
			+ "v from Vehicule_marque v")
	public List<Vehicule_marque> getVehiculeMarqueModel();*/  
	

}
