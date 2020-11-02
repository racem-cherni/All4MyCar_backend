package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.models.Depense_carnet;
@Repository
public interface Depence_CarnetRepository extends JpaRepository<Depense_carnet, Long> {

}
