package tn.esprit.spring.models;

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
@Table(	name = "carnet_historique")
public class Historique_carnet {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Carburant_Carnet carburant;

	@OneToOne
	private Depense_carnet depense;
	
	@OneToOne
	private Entretien_Carnet entretien;
	
	@OneToOne
	private Trajet_carnet trajet;
	
	@OneToOne
	private Odometer_carnet odometer;
	@OneToOne
	private Vehicule vehicule;
	
	@DateTimeFormat
	private Date date_ajout;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Carburant_Carnet getCarburant() {
		return carburant;
	}

	public void setCarburant(Carburant_Carnet carburant) {
		this.carburant = carburant;
	}

	public Depense_carnet getDepense() {
		return depense;
	}

	public void setDepense(Depense_carnet depense) {
		this.depense = depense;
	}

	public Entretien_Carnet getEntretien() {
		return entretien;
	}

	public void setEntretien(Entretien_Carnet entretien) {
		this.entretien = entretien;
	}

	public Trajet_carnet getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajet_carnet trajet) {
		this.trajet = trajet;
	}

	public Odometer_carnet getOdometer() {
		return odometer;
	}

	public void setOdometer(Odometer_carnet odometer) {
		this.odometer = odometer;
	}

	public Date getDate_ajout() {
		return date_ajout;
	}

	public void setDate_ajout(Date date_ajout) {
		this.date_ajout = date_ajout;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	
	
}
	
