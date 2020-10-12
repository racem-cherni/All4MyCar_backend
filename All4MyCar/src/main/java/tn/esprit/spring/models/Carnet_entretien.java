package tn.esprit.spring.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(	name = "carnet_entretien")
public class Carnet_entretien implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Vehicule vehicule ;
	
	@OneToOne
	private Details_Specialisations detail_specialisation ;
	
	 private String autre_depense ;
	
	private String details;
	
	private long prix ;
	
	private long kilometrage ;
	
	private Date date_entretien ;
	
	private Date rappel ;
	
	
	
	
	
	
}
