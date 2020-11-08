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
			+ "MONTH(d.date_odometer) = MONTH(:d) and YEAR(d.date_odometer) = YEAR(:d) ORDER BY d.date_odometer asc ")
	List<Odometer_carnet> getOdometerParMois(@Param("vi") long vehiculeId,@Param("d") Date d);

	@Query("Select "
			+ "d from Odometer_carnet d where d.vehicule.id=:vi and "
			+ "MONTH(d.date_odometer) = MONTH(:d)-1 and YEAR(d.date_odometer) = YEAR(:d) ORDER BY d.date_odometer asc ")
	List<Odometer_carnet> getOdometerParDernierMois(@Param("vi") long vehiculeId,@Param("d") Date d);

	@Query("Select "
			+ "d from Odometer_carnet d where d.vehicule.id=:vi and "
			+ "YEAR(d.date_odometer) = YEAR(:d) ORDER BY d.date_odometer asc ")
	List<Odometer_carnet> getOdometerParAnnee(@Param("vi") long vehiculeId,@Param("d") Date d);
	
	
	@Query("Select "
			+ "d.odomoeter_cal from Odometer_carnet d where d.vehicule.id=:vi  "
			+ "ORDER BY d.date_odometer asc ")
	List<Float> getKilometrageATo(@Param("vi") long vehiculeId);
	@Query("Select "
			+ "d.date_odometer from Odometer_carnet d where d.vehicule.id=:vi  "
			+ "ORDER BY d.date_odometer asc ")
	List<Date> getKilometrageATd(@Param("vi") long vehiculeId);
	
	
	@Query("Select "
			+ "d.odomoeter_cal from Odometer_carnet d where d.vehicule.id=:vi and "
			+ "YEAR(d.date_odometer) = YEAR(:d) ORDER BY d.date_odometer asc ")
	List<Float> getKilometrageTYo(@Param("vi") long vehiculeId,@Param("d") Date d);
	@Query("Select "
			+ "d.date_odometer from Odometer_carnet d where d.vehicule.id=:vi and "
			+ "YEAR(d.date_odometer) = YEAR(:d) ORDER BY d.date_odometer asc ")
	List<Date> getKilometrageTYd(@Param("vi") long vehiculeId,@Param("d") Date d);
	
	
	@Query("Select "
			+ "d.odomoeter_cal from Odometer_carnet d where d.vehicule.id=:vi and "
			+ "YEAR(d.date_odometer) = YEAR(:d) and MONTH(d.date_odometer) = MONTH(:d)-1 ORDER BY d.date_odometer asc ")
	List<Float> getKilometrageLMo(@Param("vi") long vehiculeId,@Param("d") Date d);
	@Query("Select "
			+ "d.date_odometer from Odometer_carnet d where d.vehicule.id=:vi and "
			+ "YEAR(d.date_odometer) = YEAR(:d) and MONTH(d.date_odometer) = MONTH(:d)-1 ORDER BY d.date_odometer asc ")
	List<Date> getKilometrageLMd(@Param("vi") long vehiculeId,@Param("d") Date d);
	
	
	@Query("Select "
			+ "d.odomoeter_cal from Odometer_carnet d where d.vehicule.id=:vi and "
			+ "YEAR(d.date_odometer) = YEAR(:d) and MONTH(d.date_odometer) = MONTH(:d)  ORDER BY d.date_odometer asc ")
	List<Float> getKilometrageTMo(@Param("vi") long vehiculeId,@Param("d") Date d);
	@Query("Select "
			+ "d.date_odometer from Odometer_carnet d where d.vehicule.id=:vi and "
			+ "YEAR(d.date_odometer) = YEAR(:d) and MONTH(d.date_odometer) = MONTH(:d)  ORDER BY d.date_odometer asc ")
	List<Date> getKilometrageTMd(@Param("vi") long vehiculeId,@Param("d") Date d);
	
}
