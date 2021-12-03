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


import com.ESNLEADER.model.Technologies;
import com.ESNLEADER.service.TechnologiesService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/techs" ,produces = MediaType.APPLICATION_JSON_VALUE)
public class TechnologiesController {

	@Autowired
	TechnologiesService service;
	
	@PostMapping("/ajouter")
	public ResponseEntity<Technologies> add(@RequestBody Technologies tech){
		Technologies t = service.Ajouter(tech);
		return new ResponseEntity<>(t,HttpStatus.OK);
	}
	
	@PostMapping("/modifier")
	public ResponseEntity<Technologies> modfier(@RequestBody Technologies tech){
		Technologies t = service.Modifier(tech);
		return new ResponseEntity<>(t,HttpStatus.OK);
	}

	@PostMapping("/supprimer/{nom}")
	public ResponseEntity<Technologies> Supprimer(@PathVariable(name="nom") @RequestBody String nom){
		service.Supprimer(nom);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping("/lister")
	public ResponseEntity<List<Technologies>> ListTechs(){
		List<Technologies> techs= new ArrayList<>();
		techs.addAll(service.listAll());
		return new ResponseEntity<>(techs,HttpStatus.OK);
	}
	
}
