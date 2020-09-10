package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.models.Prestataire;

@Repository
public interface PrestataireRepository extends JpaRepository<Prestataire, Long> {

}
