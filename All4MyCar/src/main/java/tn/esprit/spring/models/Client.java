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


@Entity
@Table(	name = "client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstNameclt;
	private String lastNameclt;
	private String emailclt;
	private String photoclt ;
	
	private int CIN ;
	
	@Temporal(TemporalType.DATE)
	private Date date_permis;
	
	@Temporal(TemporalType.DATE)
	private Date date_assurance;
	
	private int telclt;
	private String adresseclt;
	
	@OneToOne
	private User user;
	
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
	public Date getDate_assurance() {
		return date_assurance;
	}
	public void setDate_assurance(Date date_assurance) {
		this.date_assurance = date_assurance;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

     
}
