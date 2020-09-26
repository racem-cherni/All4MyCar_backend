package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.models.AdresseCites;
import tn.esprit.spring.models.AdressePays;
import tn.esprit.spring.models.AdresseVilles;
import tn.esprit.spring.repository.AdresseCitesRepository;
import tn.esprit.spring.repository.AdressePaysRepository;
import tn.esprit.spring.repository.AdresseVillesRepository;
import tn.esprit.spring.repository.PrestataireRepository;


@Service
public class AdresseServiceImpl implements AdresseService {
	
	@Autowired
	AdressePaysRepository adressepaysrepository ;

	@Autowired
	AdresseVillesRepository adressevillesrepository ;
	
	@Autowired
	AdresseCitesRepository adressecitesrepository ;
	
	@Override
	public List<AdressePays> findallpays() {
		// TODO Auto-generated method stub
		return adressepaysrepository.findAll();
	}

	@Override
	public List<AdresseVilles> findallvillesofpays(Long id) {
		
		return adressevillesrepository.findByAdressepaysId(id);
	}

	@Override
	public List<AdresseCites> findallcitesofville(Long id) {
		// TODO Auto-generated method stub
		return adressecitesrepository.findByAdressevillesId(id);
	}

}
