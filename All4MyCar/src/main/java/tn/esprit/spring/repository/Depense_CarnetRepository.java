package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.models.Carburant_Carnet;
import tn.esprit.spring.models.Depense_carnet;

@Repository
public interface Depense_CarnetRepository extends JpaRepository<Depense_carnet, Long>{

	@Query("Select "
			+ "d from Depense_carnet d where d.vehicule.id=:vi ORDER BY d.date_depense asc ")
	List<Depense_carnet> getDepenseAll(@Param("vi") long vehiculeId);

	@Query("Select "
			+ "d from Depense_carnet d where d.vehicule.id=:vi and "
			+ "MONTH(d.date_depense) = MONTH(:d) and YEAR(d.date_depense) = YEAR(:d) ORDER BY d.date_depense asc ")
	List<Depense_carnet> getDepenseParMois(@Param("vi") long vehiculeId,@Param("d") Date d);

	@Query("Select "
			+ "d from Depense_carnet d where d.vehicule.id=:vi and "
			+ "MONTH(d.date_depense) = MONTH(:d)-1 and YEAR(d.date_depense) = YEAR(:d) ORDER BY d.date_depense asc ")
	List<Depense_carnet> getDepenseParDernierMois(@Param("vi") long vehiculeId,@Param("d") Date d);

	@Query("Select "
			+ "d from Depense_carnet d where d.vehicule.id=:vi and "
			+ "YEAR(d.date_depense) = YEAR(:d) ORDER BY d.date_depense asc ")
	List<Depense_carnet> getDepenseParAnnee(@Param("vi") long vehiculeId,@Param("d") Date d);


	

	
}
