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


import com.ESNLEADER.model.Filiale;
import com.ESNLEADER.model.Projet;
import com.ESNLEADER.service.FilialeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/filiale" ,produces = MediaType.APPLICATION_JSON_VALUE)
public class FilialeController {

	@Autowired
	FilialeService service;
	
	
	@RequestMapping("/lister")
	public ResponseEntity<List<Filiale>> listFiliales(){
		List<Filiale> filiales= new ArrayList<>();
		filiales.addAll(service.listAll());
		return new ResponseEntity<>(filiales,HttpStatus.OK);
	}
	
	@PostMapping("/ajouter")
	public ResponseEntity<Filiale> add(@RequestBody Filiale filiale){
		Filiale f = service.Ajouter(filiale);
		return new ResponseEntity<>(f,HttpStatus.OK);
	}
	
	@PostMapping("/modifier")
	public ResponseEntity<Filiale> Modfier(@RequestBody Filiale filiale){
		Filiale f = service.Modifier(filiale);
		return new ResponseEntity<>(f,HttpStatus.OK);
	}
	
	@PostMapping("/supprimer/{nom}")
	public ResponseEntity<Filiale> Supprimer(@PathVariable(name="nom") @RequestBody String nom){
		service.Supprimer(nom);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/ajouterProjet/{FilialeId}")
	public ResponseEntity<Filiale> AjouterProjet( @PathVariable(name="FilialeId") Long id ,@RequestBody Projet p){
		Filiale f = service.AjouterProjet(id,p);
		return new ResponseEntity<>(f,HttpStatus.OK);
	}
}
