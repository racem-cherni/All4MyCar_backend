package tn.esprit.spring.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import java.io.BufferedOutputStream; 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.models.Prestataire;
import tn.esprit.spring.models.User;
import tn.esprit.spring.models.Vehicule;
import tn.esprit.spring.models.Vehicule_marque;
import tn.esprit.spring.models.Vehicule_model;
import tn.esprit.spring.repository.Vehicule_marqueRepository;
import tn.esprit.spring.repository.Vehicule_modelRepository;
import tn.esprit.spring.services.ClientService;
import tn.esprit.spring.services.VehiculeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/api")
public class VehiculeController {

	@Autowired
	VehiculeService vehiculeservice ;
@Autowired
   Vehicule_marqueRepository vehiculemarquerepository;
@Autowired
Vehicule_modelRepository vehiculemodelrepository;
	
	
	 /*@GetMapping("/getVehiculeMarqueModel")
		
		public List<Vehicule_marque> getVehiculeMarqueModel() {
		return vehiculeservice.getVehiculeMarqueModel();
		
			
		}*/
 @PostMapping("/addvehicule")
	
	public String add_vehicule(@RequestBody Vehicule vl) {
	 
	  
			return vehiculeservice.add_vehicule(vl);
			
		}
 
 @DeleteMapping("/deleteById/{idVehicule}")
	
	public String removeVehicule(@PathVariable(value = "idVehicule") long id) {
	 
	  
			return vehiculeservice.removeVehicule(id);
			
		}
 
 @GetMapping("/getVehiculeOfClient")
	
	public List<Vehicule> getVehiculeOfClient() {
	return vehiculeservice.getVehiculeOfClient();
	
		
	}
 
 @GetMapping("/getVehicule/{id}")
	
	public Optional<Vehicule> getVehicule(@PathVariable(value = "id") long id) {
	return vehiculeservice.getvehicule(id);
	
}
 
 private static String UPLOADED_FOLDER = System.getProperty("user.dir")+"/src/main/resources";	

 @PostMapping("/addvehiculewithphoto/{model}/{date_immatriculation}/{date_assurance}/{immatriculation}/{assureur}/{num_contrat_assurance}/{type_vehicule}/{carburant}")
	
	public String add_vehiculewithphoto(@PathVariable(value = "model") long idmodel, @PathVariable(value = "date_immatriculation") Date dateimm ,@PathVariable(value = "date_assurance") Date dateass ,
			@PathVariable(value = "immatriculation") String immatriculation , @PathVariable(value = "assureur") String assureur , @PathVariable(value = "num_contrat_assurance")  String numcontrat , @PathVariable(value = "type_vehicule")  String type_vehicule,
			@PathVariable(value = "carburant") String carburant,@RequestParam("file") MultipartFile file)
			 
{
      Vehicule vec = new Vehicule();
	 
     File dir = new File(UPLOADED_FOLDER);
      if (!dir.exists())
			dir.mkdirs();
      System.out.println("c bnsssssssssssssssssssaaaaaas ");
      File fileToImport = null;
      if (dir.isDirectory()) {
    	  System.out.println("c bnssssssssssssssssssssssssssssssssss ");
    	  try {
	        	
	        	System.out.println("c bn ");
	        	
	            fileToImport = new File(dir + File.separator + file.getOriginalFilename());
	            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fileToImport));
	            stream.write(file.getBytes());
	            stream.close();
	        } catch (Exception e) {
	            System.out.println("nnnnnnnnn");
	        }
      }
      System.out.println(idmodel);

Vehicule_model vm = vehiculeservice.getmodelbyid(idmodel);
System.out.println(vm);

vec.setModel(vm);
vec.setDate_immatriculation(dateimm);
vec.setDate_assurance(dateass);
vec.setImmatriculation(immatriculation);
vec.setAssureur(assureur);
vec.setNum_contrat_assurance(numcontrat);
vec.setType_vehicule(type_vehicule);
vec.setCarburant(carburant);

vec.setGalerie_photo(file.getOriginalFilename());
return vehiculeservice.add_vehicule(vec);
			
		}
 
 @GetMapping(value = "/afficheimagevehicule/image/logo/{image}")
 public ResponseEntity<InputStreamResource> getImage(@PathVariable(value = "image") String image ) throws IOException {

     ClassPathResource imgFile = new ClassPathResource(image);

     return ResponseEntity
             .ok()
             .contentType(MediaType.IMAGE_JPEG)
             .body(new InputStreamResource(imgFile.getInputStream()));
 }
 @GetMapping("/getlistVehicule")
 public List<Vehicule_marque> getVehiculeMarque(){
	 return vehiculemarquerepository.findAll();
 }
 @GetMapping("/getlistVehiculeMarque/{name}")
 public List<Vehicule_model> getVehiculeMarquee(@PathVariable(value = "name") String name){
	 return vehiculemodelrepository.findByMarqueName(name);
 }


	

 

 

 
 
 

		
	}
		
		



		
		


