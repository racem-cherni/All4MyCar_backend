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
@Table(	name = "carnet_depense")
public class Depense_carnet implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date date_depense;
	private float prix_depense ;
	private String note_depense;
	private float odometer_depense;
	private String depense ;
	@OneToOne
	private Vehicule vehicule ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDate_depense() {
		return date_depense;
	}
	public void setDate_depense(Date date_depense) {
		this.date_depense = date_depense;
	}
	
	public String getNote_depense() {
		return note_depense;
	}
	public void setNote_depense(String note_depense) {
		this.note_depense = note_depense;
	}
	
	public float getPrix_depense() {
		return prix_depense;
	}
	public void setPrix_depense(float prix_depense) {
		this.prix_depense = prix_depense;
	}
	public float getOdometer_depense() {
		return odometer_depense;
	}
	public void setOdometer_depense(float odometer_depense) {
		this.odometer_depense = odometer_depense;
	}
	public Vehicule getVehicule() {
		return vehicule;
	}
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	public String getDepense() {
		return depense;
	}
	public void setDepense(String depense) {
		this.depense = depense;
	}
	
	
}
