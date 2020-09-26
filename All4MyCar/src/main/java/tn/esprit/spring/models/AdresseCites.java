package tn.esprit.spring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(	name = "adressecites")
public class AdresseCites {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String name;
	
	private int code;
	
	@ManyToOne
	AdresseVilles adressevilles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public AdresseVilles getAdressevilles() {
		return adressevilles;
	}

	public void setAdressevilles(AdresseVilles adressevilles) {
		this.adressevilles = adressevilles;
	}
	
	
	
	

}
