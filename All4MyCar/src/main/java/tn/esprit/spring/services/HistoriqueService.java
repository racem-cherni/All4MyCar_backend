package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.models.Historique_carnet;
import tn.esprit.spring.models.Vehicule;

public interface HistoriqueService {
	List<Historique_carnet> findAllHistorique();
	List <Historique_carnet> findPremiersHistoriques();
List<Historique_carnet> findHistoriqueByVehicule(long id);
String   deletehistorique (long idhistorique);
}
