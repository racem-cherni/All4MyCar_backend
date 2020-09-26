package tn.esprit.spring.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(	name = "vehicule")
public class Vehicule implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/*private String marque;
	private String modele;*/
	
	
	/*@OneToOne
	private Vehicule_marque marque;*/
	
	
	@OneToOne
	private Vehicule_model model;
	@Temporal(TemporalType.DATE)
	private Date  date_immatriculation;
	@Temporal(TemporalType.DATE)
	private Date date_assurance;
	private String immatriculation;
	private String galerie_photo;
	private String assureur;
	private String num_contrat_assurance;
	
	
	private String type_vehicule ;
	
	private String carburant ;

	@ManyToOne
	Client client;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	
	public Date getDate_immatriculation() {
		return date_immatriculation;
	}

	public void setDate_immatriculation(Date date_immatriculation) {
		this.date_immatriculation = date_immatriculation;
	}

	public Date getDate_assurance() {
		return date_assurance;
	}

	public void setDate_assurance(Date date_assurance) {
		this.date_assurance = date_assurance;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getGalerie_photo() {
		return galerie_photo;
	}

	public void setGalerie_photo(String galerie_photo) {
		this.galerie_photo = galerie_photo;
	}

	public String getAssureur() {
		return assureur;
	}

	public void setAssureur(String assureur) {
		this.assureur = assureur;
	}

	public String getNum_contrat_assurance() {
		return num_contrat_assurance;
	}

	public void setNum_contrat_assurance(String num_contrat_assurance) {
		this.num_contrat_assurance = num_contrat_assurance;
	}

	

	public String getType_vehicule() {
		return type_vehicule;
	}

	public void setType_vehicule(String type_vehicule) {
		this.type_vehicule = type_vehicule;
	}

	

	public String getCarburant() {
		return carburant;
	}

	public void setCarburant(String carburant) {
		this.carburant = carburant;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Vehicule_model getModel() {
		return model;
	}

	public void setModel(Vehicule_model model) {
		this.model = model; 
	}

	
	
	
	
	
	
	
	
	
	
	




	
	
	
	
	
	

}
