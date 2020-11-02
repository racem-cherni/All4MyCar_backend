package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.models.Odometer_carnet;
@Repository
public interface Odometer_carnetRepository extends JpaRepository<Odometer_carnet, Long> {

}
