package com.ESNLEADER.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ESNLEADER.dto.EntrepriseDto;
import com.ESNLEADER.model.Entreprise;
import com.ESNLEADER.model.Filiale;
import com.ESNLEADER.service.EntrepriseService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/entreprise" ,produces = MediaType.APPLICATION_JSON_VALUE)
public class EntrerpiseController {
	@Autowired
	EntrepriseService service;
	
	
	@RequestMapping("/lister")
	public ResponseEntity<List<Entreprise>> listEntreprises(){
		List<Entreprise> entreprises= new ArrayList<>();
		entreprises.addAll(service.listAll());
		return new ResponseEntity<>(entreprises,HttpStatus.OK);
	}

	public ResponseEntity<Entreprise> add(@RequestBody Entreprise entreprise){
		Entreprise e = service.Ajouter(entreprise);
		return new ResponseEntity<>(e,HttpStatus.OK);
	}
	@PostMapping("/ajouterFiliale/{entrepriseId}")
	public ResponseEntity<Entreprise> AjouterFiliale( @PathVariable(name="entrepriseId") Long id ,@RequestBody Filiale f){
		Entreprise e = service.AjouterFiliale(id,f);
		return new ResponseEntity<>(e,HttpStatus.OK);
	}
	@PostMapping("/ajouter")
	public ResponseEntity<Entreprise> addDto(@RequestBody EntrepriseDto entrepriseDto){
		Entreprise e = service.saveOrUpdateProductForm(entrepriseDto);
		return new ResponseEntity<>(e,HttpStatus.OK);
	}
	
	@PostMapping("/modifier")
	public ResponseEntity<Entreprise> Modfier(@RequestBody Entreprise entreprise){
		Entreprise e = service.Modifier(entreprise);
		return new ResponseEntity<>(e,HttpStatus.OK);
	}
	
	@PostMapping("/supprimer/{nom}")
	public ResponseEntity<Entreprise> Supprimer(@PathVariable(name="nom") @RequestBody String nom){
		service.Supprimer(nom);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@RequestMapping("/list/{entrepriseId}")
	public ResponseEntity<Entreprise> entrepriseId(@PathVariable(name="entrepriseId") Long entrepriseId){
		Entreprise e = service.getById(entrepriseId);
		return new ResponseEntity<>(e,HttpStatus.OK);
	}
	
	
}
