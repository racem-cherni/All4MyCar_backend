package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import tn.esprit.spring.models.User;
import tn.esprit.spring.models.Vehicule_model;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource()
public interface Vehicule_modelRepository extends JpaRepository<Vehicule_model, Long> {
 
	List<Vehicule_model> findByMarqueName(@Param("name") String name);
}
