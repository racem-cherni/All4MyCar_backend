package tn.esprit.spring.models;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Rdv_dispo implements Serializable{
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		@ManyToOne
		private Prestataire prestataire;	
	/*	@Enumerated (EnumType.STRING)
		Lesjours jour;*/
		private String jour;
		
		/*private Time heuredm;
		private Time heurefm;
		
		private Time heuredam;
		private Time heurefam;*/
		@DateTimeFormat(pattern = "HH:mm")
		private Date heuredm;
		@DateTimeFormat(pattern = "HH:mm")
		private Date heurefm;
		@DateTimeFormat(pattern = "HH:mm")
		private Date heuredam;
		@DateTimeFormat(pattern = "HH:mm")
		private Date heurefam;
		
		private boolean jour_actif;
		private boolean periodedeux_actif;

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		
		public String getJour() {
			return jour;
		}
		public void setJour(String jour) {
			this.jour = jour;
		}
		/*public Lesjours getJour() {
			return jour;
		}
		public void setJour(Lesjours jour) {
			this.jour = jour;
		}*/
		
		public Prestataire getPrestataire() {
			return prestataire;
		}
		public void setPrestataire(Prestataire prestataire) {
			this.prestataire = prestataire;
		}
		
		public boolean isJour_actif() {
			return jour_actif;
		}
		public void setJour_actif(boolean jour_actif) {
			this.jour_actif = jour_actif;
		}
		public Date getHeuredm() {
			return heuredm;
		}
		public void setHeuredm(Date heuredm) {
			this.heuredm = heuredm;
		}
		public Date getHeurefm() {
			return heurefm;
		}
		public void setHeurefm(Date heurefm) {
			this.heurefm = heurefm;
		}
		public Date getHeuredam() {
			return heuredam;
		}
		public void setHeuredam(Date heuredam) {
			this.heuredam = heuredam;
		}
		public Date getHeurefam() {
			return heurefam;
		}
		public void setHeurefam(Date heurefam) {
			this.heurefam = heurefam;
		}
		public boolean isPeriodedeux_actif() {
			return periodedeux_actif;
		}
		public void setPeriodedeux_actif(boolean periodedeux_actif) {
			this.periodedeux_actif = periodedeux_actif;
		}
	
		
		
		
		

}
