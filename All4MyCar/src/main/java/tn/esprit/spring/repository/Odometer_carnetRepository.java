package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.models.Carburant_Carnet;
import tn.esprit.spring.models.Odometer_carnet;
@Repository
public interface Odometer_carnetRepository extends JpaRepository<Odometer_carnet, Long> {

	@Query("Select "
			+ "d from Odometer_carnet d where d.vehicule.id=:vi ORDER BY d.date_odometer asc ")
	List<Odometer_carnet> getOdometerAll(@Param("vi") long vehiculeId);

	@Query("Select "
			+ "d from Odometer_carnet d where d.vehicule.id=:vi and "
			+ "MONTH(d.date_odometer) = MONTH(:d) ORDER BY d.date_odometer asc ")
	List<Odometer_carnet> getOdometerParMois(@Param("vi") long vehiculeId,@Param("d") Date d);

	@Query("Select "
			+ "d from Odometer_carnet d where d.vehicule.id=:vi and "
			+ "MONTH(d.date_odometer) = MONTH(:d)-1 ORDER BY d.date_odometer asc ")
	List<Odometer_carnet> getOdometerParDernierMois(@Param("vi") long vehiculeId,@Param("d") Date d);

	@Query("Select "
			+ "d from Odometer_carnet d where d.vehicule.id=:vi and "
			+ "YEAR(d.date_odometer) = YEAR(:d) ORDER BY d.date_odometer asc ")
	List<Odometer_carnet> getOdometerParAnnee(@Param("vi") long vehiculeId,@Param("d") Date d);
}
