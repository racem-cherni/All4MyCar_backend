package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.models.Carburant_Carnet;
@Repository
public interface Carburant_CarnetRepository  extends JpaRepository<Carburant_Carnet, Long>{

}
