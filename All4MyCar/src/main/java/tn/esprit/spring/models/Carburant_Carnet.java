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
@Table(	name = "carnet_carburant")
public class Carburant_Carnet implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date date_carburant;
	private String station_carburant;
	private float quantite_carburant;
	private float depense_carburant;
	private float odometer_carburant;
	private String note_carburant;
	@OneToOne
	private Vehicule vehicule ;
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate_carburant() {
		return date_carburant;
	}
	public void setDate_carburant(Date date_carburant) {
		this.date_carburant = date_carburant;
	}
	public String getStation_carburant() {
		return station_carburant;
	}
	public void setStation_carburant(String station_carburant) {
		this.station_carburant = station_carburant;
	}


	public float getQuantite_carburant() {
		return quantite_carburant;
	}

	public void setQuantite_carburant(float quantite_carburant) {
		this.quantite_carburant = quantite_carburant;
	}

	public float getDepense_carburant() {
		return depense_carburant;
	}

	public void setDepense_carburant(float depense_carburant) {
		this.depense_carburant = depense_carburant;
	}

	public float getOdometer_carburant() {
		return odometer_carburant;
	}

	public void setOdometer_carburant(float odometer_carburant) {
		this.odometer_carburant = odometer_carburant;
	}

	public String getNote_carburant() {
		return note_carburant;
	}

	public void setNote_carburant(String note_carburant) {
		this.note_carburant = note_carburant;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	
	
	
	

}
