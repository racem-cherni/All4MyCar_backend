package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.models.Lesjours;
import tn.esprit.spring.models.Prestataire;
import tn.esprit.spring.models.Rdv_dispo;

@Repository
public interface Rdv_dispoRepository extends CrudRepository<Rdv_dispo, Long> {

	@Query("Select "
			+ "d.id from Rdv_dispo d where d.jour=:jour and d.prestataire.id=:idp")
	int getdispoByDayAndpres(@Param("jour") String jour, @Param("idp") Long id);

}
