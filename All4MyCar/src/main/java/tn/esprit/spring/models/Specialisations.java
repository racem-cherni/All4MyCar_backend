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
@Table(	name = "specialisations")
public class Specialisations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	//@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="specialisation")
	private List<Details_Specialisations > detailspecialisations;
	
	
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
	public List<Details_Specialisations> getDetailspecialisations() {
		return detailspecialisations;
	}
	public void setDetailspecialisations(List<Details_Specialisations> detailspecialisations) {
		this.detailspecialisations = detailspecialisations;
	}

     
}
