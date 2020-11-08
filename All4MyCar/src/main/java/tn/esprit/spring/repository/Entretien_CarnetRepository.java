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
			+ "MONTH(d.date_entretien) = MONTH(:d) and YEAR(d.date_entretien) = YEAR(:d) ORDER BY d.date_entretien asc ")
	List<Entretien_Carnet> getEntretienParMois(@Param("vi") long vehiculeId,@Param("d") Date d);

	@Query("Select "
			+ "d from Entretien_Carnet d where d.vehicule.id=:vi and "
			+ "MONTH(d.date_entretien) = MONTH(:d)-1 and YEAR(d.date_entretien) = YEAR(:d) ORDER BY d.date_entretien asc ")
	List<Entretien_Carnet> getEntretienParDernierMois(@Param("vi") long vehiculeId,@Param("d") Date d);

	@Query("Select "
			+ "d from Entretien_Carnet d where d.vehicule.id=:vi and "
			+ "YEAR(d.date_entretien) = YEAR(:d) ORDER BY d.date_entretien asc ")
	List<Entretien_Carnet> getEntretienParAnnee(@Param("vi") long vehiculeId,@Param("d") Date d);
	
	
//////////////////depenseMois
@Query("Select "
+ "sum(d.prix_entretien) from Entretien_Carnet d where d.vehicule.id=:vi and "
+ "YEAR(d.date_entretien) = YEAR(:d) GROUP BY MONTH(d.date_entretien)  ")
List<Float> getDepense_entretienMoisTY(@Param("vi") long vehiculeId, @Param("d") Date d);

@Query("Select "
+ "sum(d.prix_entretien) from Entretien_Carnet d where d.vehicule.id=:vi and "
+ "MONTH(d.date_entretien) = MONTH(CURDATE()) and YEAR(d.date_entretien) = YEAR(CURDATE()) GROUP BY Month(d.date_entretien)  ")
List<Float> getDepense_entretienMoisTM(@Param("vi") long vehiculeId);

@Query("Select "
+ "sum(d.prix_entretien) from Entretien_Carnet d where d.vehicule.id=:vi and "
+ "MONTH(d.date_entretien) = MONTH(:d)-1 and YEAR(d.date_entretien) = YEAR(:d) GROUP BY Month(d.date_entretien)-1  ")
List<Float> getDepense_entretienMoisLM(@Param("vi") long vehiculeId, @Param("d") Date d);

@Query("Select "
+ "sum(d.prix_entretien) from Entretien_Carnet d where d.vehicule.id=:vi GROUP BY Month(d.date_entretien),YEAR(d.date_entretien)  ")
List<Float> getDepense_entretienMoisAT(@Param("vi") long vehiculeId);
////////////////////

//////////////////nbrMois
@Query("Select "
+ "COUNT(d) from Entretien_Carnet d where d.vehicule.id=:vi and "
+ "YEAR(d.date_entretien) = YEAR(:d) GROUP BY MONTH(d.date_entretien)  ")
List<Float> getNbr_entretienMoisTY(@Param("vi") long vehiculeId, @Param("d") Date d);

@Query("Select "
+ "COUNT(d) from Entretien_Carnet d where d.vehicule.id=:vi and "
+ "MONTH(d.date_entretien) = MONTH(CURDATE()) and YEAR(d.date_entretien) = YEAR(CURDATE()) GROUP BY MONTH(d.date_entretien) ")
List<Float> getNbr_entretienMoisTM(@Param("vi") long vehiculeId);

@Query("Select "
+ "COUNT(d) from Entretien_Carnet d where d.vehicule.id=:vi and "
+ "MONTH(d.date_entretien) = MONTH(:d)-1 and YEAR(d.date_entretien) = YEAR(:d) GROUP BY MONTH(d.date_entretien) ") 
List<Float> getNbr_entretienMoisLM(@Param("vi") long vehiculeId, @Param("d") Date d);

@Query("Select "
+ "COUNT(d) from Entretien_Carnet d where d.vehicule.id=:vi GROUP BY MONTH(d.date_entretien),YEAR(d.date_entretien) ")
List<Float> getNbr_entretienMoisAT(@Param("vi") long vehiculeId);
////////////////////
	
}
