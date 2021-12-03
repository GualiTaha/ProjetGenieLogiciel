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
import com.ESNLEADER.service.CollaborateurService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/collabs" ,produces = MediaType.APPLICATION_JSON_VALUE)
public class CollaborateursController {

	@Autowired
	CollaborateurService service;
	
	@PostMapping("/ajouter")
	public ResponseEntity<Collaborateurs> add(@RequestBody Collaborateurs collab){
		Collaborateurs c = service.Ajouter(collab);
		return new ResponseEntity<>(c,HttpStatus.OK);
	}
	
	@PostMapping("/modifier")
	public ResponseEntity<Collaborateurs> modfier(@RequestBody Collaborateurs collab){
		Collaborateurs c = service.Modifier(collab);
		return new ResponseEntity<>(c,HttpStatus.OK);
	}

	@PostMapping("/supprimer/{nom}")
	public ResponseEntity<Collaborateurs> Supprimer(@PathVariable(name="nom") @RequestBody String nom){
		service.Supprimer(nom);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping("/lister")
	public ResponseEntity<List<Collaborateurs>> ListCollab(){
		List<Collaborateurs> Collab= new ArrayList<>();
		Collab.addAll(service.listAll());
		return new ResponseEntity<>(Collab,HttpStatus.OK);
	}
}
