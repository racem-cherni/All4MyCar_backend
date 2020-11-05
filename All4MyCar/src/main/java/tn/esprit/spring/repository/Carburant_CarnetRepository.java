package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.models.Carburant_Carnet;
import tn.esprit.spring.models.Vehicule;

import java.util.Date;
import java.util.List;
@Repository
public interface Carburant_CarnetRepository  extends CrudRepository<Carburant_Carnet, Long>{
List<Carburant_Carnet> findByVehicule(Vehicule vehicule);

@Query("Select "
		+ "d from Carburant_Carnet d where d.vehicule.id=:vi ORDER BY d.date_carburant asc ")
List<Carburant_Carnet> getCarburantAll(@Param("vi") long vehiculeId);

@Query("Select "
		+ "d from Carburant_Carnet d where d.vehicule.id=:vi and "
		+ "MONTH(d.date_carburant) = MONTH(:d) ORDER BY d.date_carburant asc ")
List<Carburant_Carnet> getCarburantParMois(@Param("vi") long vehiculeId,@Param("d") Date d);

@Query("Select "
		+ "d from Carburant_Carnet d where d.vehicule.id=:vi and "
		+ "MONTH(d.date_carburant) = MONTH(:d)-1 ORDER BY d.date_carburant asc ")
List<Carburant_Carnet> getCarburantParDernierMois(@Param("vi") long vehiculeId,@Param("d") Date d);

@Query("Select "
		+ "d from Carburant_Carnet d where d.vehicule.id=:vi and "
		+ "YEAR(d.date_carburant) = YEAR(:d) ORDER BY d.date_carburant asc ")
List<Carburant_Carnet> getCarburantParAnnee(@Param("vi") long vehiculeId,@Param("d") Date d);





}

