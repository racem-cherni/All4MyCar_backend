package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.models.Historique_carnet;
import tn.esprit.spring.models.Vehicule;

@Repository
public interface Historique_carnetRepository extends JpaRepository<Historique_carnet,Long>{
	@Query(value="Select  *  from carnet_historique c "
			+ "ORDER BY c.date_ajout desc limit 3" ,nativeQuery=true)
	
	public  List<Historique_carnet> findPremiersHistorique();
	List<Historique_carnet> findByVehicule(Vehicule vehicule);
}
