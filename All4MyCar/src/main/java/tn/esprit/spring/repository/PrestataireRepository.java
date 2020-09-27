package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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

}
