package tn.esprit.spring.repository;

import java.util.List
;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.web.bind.annotation.CrossOrigin;

import tn.esprit.spring.models.User;
import tn.esprit.spring.models.Vehicule_model;
import java.lang.Long;

@CrossOrigin("http://localhost:4200")

public interface Vehicule_modelRepository extends JpaRepository<Vehicule_model, Long> {
	
	List<Vehicule_model> findByMarqueName(@Param("name") String name);
	@Query("SELECT e from Vehicule_model e where e.id=:idmodel")
	Vehicule_model findByIdt(@Param("idmodel") long idmodel);

}
