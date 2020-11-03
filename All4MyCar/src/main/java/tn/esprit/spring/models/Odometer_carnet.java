
package tn.esprit.spring.models;

import java.io.Serializable;
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
@Table(	name = "carnet_Odometer")
public class Odometer_carnet implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id ;
	@Temporal(TemporalType.DATE)
    private Date   date_odometer;
   private float  odomoeter_cal;
   private String  note_odometer ;
   @OneToOne
    private Vehicule vehicule;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Date getDate_odometer() {
	return date_odometer;
}
public void setDate_odometer(Date date_odometer) {
	this.date_odometer = date_odometer;
}

public String getNote_odometer() {
	return note_odometer;
}
public void setNote_odometer(String note_odometer) {
	this.note_odometer = note_odometer;
}
public Vehicule getVehicule() {
	return vehicule;
}
public void setVehicule(Vehicule vehicule) {
	this.vehicule = vehicule;
}
public float getOdomoeter_cal() {
	return odomoeter_cal;
}
public void setOdomoeter_cal(float odomoeter_cal) {
	this.odomoeter_cal = odomoeter_cal;
}


   
}
