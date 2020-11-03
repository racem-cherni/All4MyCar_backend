package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.models.Historique_carnet;

@Repository
public interface Historique_carnetRepository extends JpaRepository<Historique_carnet,Long>{

}
