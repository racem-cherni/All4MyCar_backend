package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.models.Carburant_Carnet;
import tn.esprit.spring.models.Vehicule;
import java.util.List;
@Repository
public interface Carburant_CarnetRepository  extends JpaRepository<Carburant_Carnet, Long>{
List<Carburant_Carnet> findByVehicule(Vehicule vehicule);
}
