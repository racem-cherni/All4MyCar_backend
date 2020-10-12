package tn.esprit.spring.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@Entity
@Table(	name = "client")
@JsonIgnoreProperties({ "user" })

public class Client implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstNameclt;
	private String lastNameclt;
	private String emailclt;
	private String photoclt ;
	
	private int CIN ;
	private String cin_cartegrise_photo;
	
	@Temporal(TemporalType.DATE)
    private Date date_permis;
	
	@Temporal(TemporalType.DATE)
	private Date date_inscrip;
	
	private int etat;
	
	private boolean notif_etat ;
	
	private int telclt;
	private String adresseclt;
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private List<Vehicule> vehicules;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getCIN() {
		return CIN;
	}
	public void setCIN(int cIN) {
		CIN = cIN;
	}
	public Date getDate_permis() {
		return date_permis;
	}
	public void setDate_permis(Date date_permis) {
		this.date_permis = date_permis;
	}
	
	public String getFirstNameclt() {
		return firstNameclt;
	}
	public void setFirstNameclt(String firstNameclt) {
		this.firstNameclt = firstNameclt;
	}
	public String getLastNameclt() {
		return lastNameclt;
	}
	public void setLastNameclt(String lastNameclt) {
		this.lastNameclt = lastNameclt;
	}
	public String getEmailclt() {
		return emailclt;
	}
	public void setEmailclt(String emailclt) {
		this.emailclt = emailclt;
	}
	public String getPhotoclt() {
		return photoclt;
	}
	public void setPhotoclt(String photoclt) {
		this.photoclt = photoclt;
	}
	public int getTelclt() {
		return telclt;
	}
	public void setTelclt(int telclt) {
		this.telclt = telclt;
	}
	public String getAdresseclt() {
		return adresseclt;
	}
	public void setAdresseclt(String adresseclt) {
		this.adresseclt = adresseclt;
	}
	
	public List<Vehicule> getVehicules() {
		return vehicules;
	}
	public void setVehicules(List<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}
	public Date getDate_inscrip() {
		return date_inscrip;
	}
	public void setDate_inscrip(Date date_inscrip) {
		this.date_inscrip = date_inscrip;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	public String getCin_cartegrise_photo() {
		return cin_cartegrise_photo;
	}
	public void setCin_cartegrise_photo(String cin_cartegrise_photo) {
		this.cin_cartegrise_photo = cin_cartegrise_photo;
	}
	public boolean isNotif_etat() {
		return notif_etat;
	}
	
	public void setNotif_etat(boolean notif_etat) {
		this.notif_etat = notif_etat;
	}
	
	
	
	

     
}
