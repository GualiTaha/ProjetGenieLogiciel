package com.ESNLEADER.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ESNLEADER.model.Collaborateurs;
import com.ESNLEADER.model.Projet;
import com.ESNLEADER.model.Technologies;
import com.ESNLEADER.service.ProjetService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/projet" ,produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjetController {

	@Autowired
	ProjetService service;
	
	@PostMapping("/ajouter")
	public ResponseEntity<Projet> add(@RequestBody Projet projet){
		Projet p = service.Ajouter(projet);
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	@PostMapping("/ajouterTechno/{ProjetId}")
	public ResponseEntity<Projet> AjouterTechnologie( @PathVariable(name="ProjetId") Long id ,@RequestBody Technologies tech){
		Projet p = service.AjouterTechnologies(id,tech);
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	@PostMapping("/ajouterCollab/{ProjetId}")
	public ResponseEntity<Projet> AjouterCollaborateur( @PathVariable(name="ProjetId") Long id ,@RequestBody Collaborateurs collab){
		Projet p  = service.AjouterCollaborateurs(id,collab);
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	@PostMapping("/modifier")
	public ResponseEntity<Projet> modfier(@RequestBody Projet projet){
		Projet p = service.Modifier(projet);
		return new ResponseEntity<>(p,HttpStatus.OK);
	}

	@PostMapping("/supprimer/{nom}")
	public ResponseEntity<Projet> Supprimer(@PathVariable(name="nom") @RequestBody String nom){
		service.Supprimer(nom);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping("/lister")
	public ResponseEntity<List<Projet>> ListProjet(){
		List<Projet> projets= new ArrayList<>();
		projets.addAll(service.listAll());
		return new ResponseEntity<>(projets,HttpStatus.OK);
	}
	
	@RequestMapping("/listerTech/{nom}")
	public ResponseEntity<List<Projet>> ListProjetTech(@PathVariable(name="nom") @RequestBody String nom){
		List<Projet> projets= new ArrayList<>();
		projets.addAll(service.listProjetTechno(nom));
		return new ResponseEntity<>(projets,HttpStatus.OK);
	}
	
	@RequestMapping("/listerCollab/{nom}")
	public ResponseEntity<List<Projet>> ListProjetCollab(@PathVariable(name="nom") @RequestBody String nom){
		List<Projet> projets= new ArrayList<>();
		projets.addAll(service.listProjetCollab(nom));
		return new ResponseEntity<>(projets,HttpStatus.OK);
	}
}
