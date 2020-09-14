package tn.esprit.spring.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Table(	name = "vehicule")
public class Vehicule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/*private String marque;
	private String modele;*/
	@OneToOne
	private Vehicule_marque marque;
	@OneToOne
	private Vehicule_model model;
	private int  annee_de_sortie ;
	@Temporal(TemporalType.DATE)
	private Date date_assurance;
	private String immatriculation;
	private String galerie_photo;
	private String assureur;
	private String num_contrat_assurance;
	
	@Enumerated(EnumType.STRING)
	private Type_vehicule type_vehicule ;
	
	@Enumerated(EnumType.STRING)
	private Carburant carburant ;

	@ManyToOne
	Client client;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public int getAnnee_de_sortie() {
		return annee_de_sortie;
	}

	public void setAnnee_de_sortie(int annee_de_sortie) {
		this.annee_de_sortie = annee_de_sortie;
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

	public Type_vehicule getType_vehicule() {
		return type_vehicule;
	}

	public void setType_vehicule(Type_vehicule type_vehicule) {
		this.type_vehicule = type_vehicule;
	}

	public Carburant getCarburant() {
		return carburant;
	}

	public void setCarburant(Carburant carburant) {
		this.carburant = carburant;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Vehicule_marque getMarque() {
		return marque;
	}

	public void setMarque(Vehicule_marque marque) {
		this.marque = marque;
	}

	public Vehicule_model getModel() {
		return model;
	}

	public void setModel(Vehicule_model model) {
		this.model = model;
	}
	
	
	
	
	
	
	
	
	
	




	
	
	
	
	
	

}
