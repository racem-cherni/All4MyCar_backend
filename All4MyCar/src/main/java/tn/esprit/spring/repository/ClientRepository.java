package tn.esprit.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import tn.esprit.spring.models.Client;
import tn.esprit.spring.models.User;
import java.util.Date;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
 List<Client> findAll() ;
 
 @Query("SELECT c from Client c where c.date_inscrip=:date")
 List<Client> findByDate_inscription(@Param("date") Date date_inscrip);
 
 @Query("SELECT c from Client c where c.etat=0")
	List<Client> findByEtat();
 
 @Query("SELECT c from Client c where c.etat=0 and c.notif_etat=0")
	List<Client> findByEtatnotification();
 
}
