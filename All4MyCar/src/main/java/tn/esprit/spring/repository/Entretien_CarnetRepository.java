package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.models.Carburant_Carnet;
import tn.esprit.spring.models.Entretien_Carnet;
@Repository
public interface Entretien_CarnetRepository extends JpaRepository<Entretien_Carnet, Long> {

	
	@Query("Select "
			+ "d from Entretien_Carnet d where d.vehicule.id=:vi ORDER BY d.date_entretien asc ")
	List<Entretien_Carnet> getEntretienAll(@Param("vi") long vehiculeId);

	@Query("Select "
			+ "d from Entretien_Carnet d where d.vehicule.id=:vi and "
			+ "MONTH(d.date_entretien) = MONTH(:d) ORDER BY d.date_entretien asc ")
	List<Entretien_Carnet> getEntretienParMois(@Param("vi") long vehiculeId,@Param("d") Date d);

	@Query("Select "
			+ "d from Entretien_Carnet d where d.vehicule.id=:vi and "
			+ "MONTH(d.date_entretien) = MONTH(:d)-1 ORDER BY d.date_entretien asc ")
	List<Entretien_Carnet> getEntretienParDernierMois(@Param("vi") long vehiculeId,@Param("d") Date d);

	@Query("Select "
			+ "d from Entretien_Carnet d where d.vehicule.id=:vi and "
			+ "YEAR(d.date_entretien) = YEAR(:d) ORDER BY d.date_entretien asc ")
	List<Entretien_Carnet> getEntretienParAnnee(@Param("vi") long vehiculeId,@Param("d") Date d);
	
}
