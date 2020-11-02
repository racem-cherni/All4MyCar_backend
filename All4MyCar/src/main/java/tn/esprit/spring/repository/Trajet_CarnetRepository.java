package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.models.Trajet_carnet;
@Repository
public interface Trajet_CarnetRepository  extends JpaRepository<Trajet_carnet, Long>{

}
