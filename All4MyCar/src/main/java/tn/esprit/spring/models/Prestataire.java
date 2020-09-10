package tn.esprit.spring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(	name = "prestataire")
public class Prestataire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstNamepres;
	private String lastNamepres;
	private String adressepres;
	private String adresseprof;
	private String emailpres;
	private int telpres;

	
	
	
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




	public String getAdresseprof() {
		return adresseprof;
	}




	public void setAdresseprof(String adresseprof) {
		this.adresseprof = adresseprof;
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




	
	
	

}
