package tn.esprit.spring.models;

import java.util.Date;
import java.util.List;

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




@Entity
@Table(	name = "prestataire")
public class Prestataire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstNamepres;
	private String lastNamepres;
	private String adressepres;
	private String emailpres;
	private int telpres;
	private String photopres ;
	private String specialisations ;
	private int CIN ;
	private int etat;
    private String photoCin ;
	private boolean notif_etat ;

    
	public int getEtat() {
		return etat;
	}




	public void setEtat(int etat) {
		this.etat = etat;
	}




	@Temporal(TemporalType.DATE)
	private Date date_inscrip;

	@JsonIgnore
	@OneToMany(mappedBy="prestataire")
	private List<Rdv_dispo> rdvdispo;
	
	@JsonIgnore
	@OneToMany(mappedBy="prestataire")
	private List<Rdv> rdvp;
	
	@OneToOne
	private User user;




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getFirstNamepres() {
		return firstNamepres;
	}




	public void setFirstNamepres(String firstNamepres) {
		this.firstNamepres = firstNamepres;
	}




	public String getLastNamepres() {
		return lastNamepres;
	}




	public void setLastNamepres(String lastNamepres) {
		this.lastNamepres = lastNamepres;
	}




	public String getAdressepres() {
		return adressepres;
	}




	public void setAdressepres(String adressepres) {
		this.adressepres = adressepres;
	}




	




	public String getEmailpres() {
		return emailpres;
	}




	public void setEmailpres(String emailpres) {
		this.emailpres = emailpres;
	}




	public int getTelpres() {
		return telpres;
	}




	public void setTelpres(int telpres) {
		this.telpres = telpres;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public Date getDate_inscrip() {
		return date_inscrip;
	}




	public void setDate_inscrip(Date date_inscrip) {
		this.date_inscrip = date_inscrip;
	}




	public String getPhotopres() {
		return photopres;
	}




	public void setPhotopres(String photopres) {
		this.photopres = photopres;
	}




	public int getCIN() {
		return CIN;
	}




	public void setCIN(int cIN) {
		CIN = cIN;
	}




	public List<Rdv> getRdvp() {
		return rdvp;
	}




	public void setRdvp(List<Rdv> rdvp) {
		this.rdvp = rdvp;
	}




	public String getSpecialisations() {
		return specialisations;
	}




	public void setSpecialisations(String specialisations) {
		this.specialisations = specialisations;
	}




	public List<Rdv_dispo> getRdvdispo() {
		return rdvdispo;
	}




	public void setRdvdispo(List<Rdv_dispo> rdvdispo) {
		this.rdvdispo = rdvdispo;
	}




	public String getPhotoCin() {
		return photoCin;
	}




	public void setPhotoCin(String photoCin) {
		this.photoCin = photoCin;
	}




	public boolean isNotif_etat() {
		return notif_etat;
	}




	public void setNotif_etat(boolean notif_etat) {
		this.notif_etat = notif_etat;
	}




	
	
	

}
