package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.models.Entretien_Carnet;
@Repository
public interface Entretien_CarnetRepository extends JpaRepository<Entretien_Carnet, Long> {

}
