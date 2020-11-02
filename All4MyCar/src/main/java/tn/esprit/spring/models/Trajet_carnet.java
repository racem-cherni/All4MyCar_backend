package tn.esprit.spring.models;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(	name = "carnet_trajet")
public class Trajet_carnet implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  id;
    private Time heure_depart;
   @Temporal(TemporalType.DATE)
     private Date date_depart ;
     private String lieux_depart ;

     private Time heure_arrive;
     @Temporal(TemporalType.DATE)
     private Date date_arrive ;
     private String lieux_arrive;

     private int taxe_trajet;
     private String note_trajet;
     private int distance_trajet;
     private int duree_trajet;
     private int vitesse_trajet;

@OneToOne
private Vehicule vehicule;


}
