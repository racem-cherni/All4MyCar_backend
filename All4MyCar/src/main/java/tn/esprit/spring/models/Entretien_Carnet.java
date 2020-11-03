package tn.esprit.spring.models;

import java.io.Serializable;
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
@Table(	name = "carnet_entretien")
public class Entretien_Carnet implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id  ;
	@Temporal(TemporalType.DATE)
      private Date date_entretien;
      private String centre_entretien;
      private float prix_entretien;
      private String note_entretien;
      private float odometer_entretien ;
      private String specialisations;   
    
      @OneToOne
      private Vehicule vehicule;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate_entretien() {
		return date_entretien;
	}
	public void setDate_entretien(Date date_entretien) {
		this.date_entretien = date_entretien;
	}
	public String getCentre_entretien() {
		return centre_entretien;
	}
	public void setCentre_entretien(String centre_entretien) {
		this.centre_entretien = centre_entretien;
	}
	
	public String getNote_entretien() {
		return note_entretien;
	}
	public void setNote_entretien(String note_entretien) {
		this.note_entretien = note_entretien;
	}
	
	
	public String getSpecialisations() {
		return specialisations;
	}
	public void setSpecialisations(String specialisations) {
		this.specialisations = specialisations;
	}
	public Vehicule getVehicule() {
		return vehicule;
	}
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	public float getPrix_entretien() {
		return prix_entretien;
	}
	public void setPrix_entretien(float prix_entretien) {
		this.prix_entretien = prix_entretien;
	}
	public float getOdometer_entretien() {
		return odometer_entretien;
	}
	public void setOdometer_entretien(float odometer_entretien) {
		this.odometer_entretien = odometer_entretien;
	}
	
	
}
