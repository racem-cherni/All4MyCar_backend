package tn.esprit.spring.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(	name = "vehicule_marque")
public class Vehicule_marque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 
	private String name;
   
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="marque")
	private List<Vehicule_model> models;


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


	public List<Vehicule_model> getModels() {
		return models;
	}


	public void setModels(List<Vehicule_model> models) {
		this.models = models;
	}
	
	
}
