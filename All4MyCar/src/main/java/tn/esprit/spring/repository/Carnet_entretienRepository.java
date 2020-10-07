package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.models.Carnet_entretien;
import tn.esprit.spring.models.Client;

@Repository
public interface Carnet_entretienRepository extends CrudRepository<Carnet_entretien, Long> {

}
