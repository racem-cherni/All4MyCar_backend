package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.models.Client;
import tn.esprit.spring.models.Prestataire;
import tn.esprit.spring.models.Rdv_dispo;


@Repository
public interface PrestataireRepository extends JpaRepository<Prestataire, Long> {

	@Query("Select "
			+ "d from Rdv_dispo d where d.prestataire.id=:idp")
	public List<Rdv_dispo> findDispByPres(@Param("idp") Long id);

	@Query("Select "
			+ "d from Rdv_dispo d where d.id=:idp")
	public Rdv_dispo findDispById(@Param("idp") int id);
	
	 List<Prestataire> findAll() ;
		
	 @Query("SELECT c from Prestataire c where c.date_inscrip=:date")
	 List<Prestataire> findByDate_inscription(@Param("date") Date date_inscrip);
	 
	 @Query("SELECT p from Prestataire p where p.etat=0")
		List<Prestataire> findByEtat();
	 
	 @Query("SELECT p from Prestataire p where p.etat=0 and p.notif_etat=0")
		List<Prestataire> findByEtatnotification();
	 
	 

}
