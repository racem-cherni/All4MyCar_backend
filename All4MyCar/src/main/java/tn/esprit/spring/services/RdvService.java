package tn.esprit.spring.services;

import java.text.ParseException;
import java.util.List;

import tn.esprit.spring.models.Rdv_dispo;

public interface RdvService {

	List<Rdv_dispo> getdisponibility();
	String modifier_dispojour(Rdv_dispo dispo, int id) throws ParseException;
}
