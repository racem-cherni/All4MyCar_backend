package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.models.Carburant_Carnet;
import tn.esprit.spring.models.Trajet_carnet;
@Repository
public interface Trajet_CarnetRepository  extends JpaRepository<Trajet_carnet, Long>{

	@Query("Select "
			+ "d from Trajet_carnet d where d.vehicule.id=:vi ORDER BY d.date_depart asc ")
	List<Trajet_carnet> getTrajetAll(@Param("vi") long vehiculeId);

	@Query("Select "
			+ "d from Trajet_carnet d where d.vehicule.id=:vi and "
			+ "MONTH(d.date_depart) = MONTH(:d) and YEAR(d.date_depart) = YEAR(:d) ORDER BY d.date_depart asc ")
	List<Trajet_carnet> getTrajetParMois(@Param("vi") long vehiculeId,@Param("d") Date d);

	@Query("Select "
			+ "d from Trajet_carnet d where d.vehicule.id=:vi and "
			+ "MONTH(d.date_depart) = MONTH(:d)-1 and YEAR(d.date_depart) = YEAR(:d) ORDER BY d.date_depart asc ")
	List<Trajet_carnet> getTrajetParDernierMois(@Param("vi") long vehiculeId,@Param("d") Date d);

	@Query("Select "
			+ "d from Trajet_carnet d where d.vehicule.id=:vi and "
			+ "YEAR(d.date_depart) = YEAR(:d) ORDER BY d.date_depart asc ")
	List<Trajet_carnet> getTrajetParAnnee(@Param("vi") long vehiculeId,@Param("d") Date d);
	
}
