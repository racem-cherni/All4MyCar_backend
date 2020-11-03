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

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(	name = "carnet_trajet")
public class Trajet_carnet implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  id;
	
	@DateTimeFormat(pattern = "HH:mm")
    private Date heure_depart;
	
    @Temporal(TemporalType.DATE)
    private Date date_depart ;
   
    private String lieux_depart ;
     
    @DateTimeFormat(pattern = "HH:mm")
    private Date heure_arrive;

    @Temporal(TemporalType.DATE)
    private Date date_arrive ;
    
    private String lieux_arrive;

     private float taxe_trajet;
     private String note_trajet;
     private float distance_trajet;
     private int duree_trajet;
     private int vitesse_trajet;

@OneToOne
private Vehicule vehicule;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}





public Date getHeure_depart() {
	return heure_depart;
}

public void setHeure_depart(Date heure_depart) {
	this.heure_depart = heure_depart;
}

public Date getHeure_arrive() {
	return heure_arrive;
}

public void setHeure_arrive(Date heure_arrive) {
	this.heure_arrive = heure_arrive;
}

public Date getDate_depart() {
	return date_depart;
}

public void setDate_depart(Date date_depart) {
	this.date_depart = date_depart;
}

public String getLieux_depart() {
	return lieux_depart;
}

public void setLieux_depart(String lieux_depart) {
	this.lieux_depart = lieux_depart;
}





public Date getDate_arrive() {
	return date_arrive;
}

public void setDate_arrive(Date date_arrive) {
	this.date_arrive = date_arrive;
}

public String getLieux_arrive() {
	return lieux_arrive;
}

public void setLieux_arrive(String lieux_arrive) {
	this.lieux_arrive = lieux_arrive;
}

public float getTaxe_trajet() {
	return taxe_trajet;
}

public void setTaxe_trajet(float taxe_trajet) {
	this.taxe_trajet = taxe_trajet;
}

public String getNote_trajet() {
	return note_trajet;
}

public void setNote_trajet(String note_trajet) {
	this.note_trajet = note_trajet;
}

public float getDistance_trajet() {
	return distance_trajet;
}

public void setDistance_trajet(float distance_trajet) {
	this.distance_trajet = distance_trajet;
}

public int getDuree_trajet() {
	return duree_trajet;
}

public void setDuree_trajet(int duree_trajet) {
	this.duree_trajet = duree_trajet;
}

public int getVitesse_trajet() {
	return vitesse_trajet;
}

public void setVitesse_trajet(int vitesse_trajet) {
	this.vitesse_trajet = vitesse_trajet;
}

public Vehicule getVehicule() {
	return vehicule;
}

public void setVehicule(Vehicule vehicule) {
	this.vehicule = vehicule;
}



}
