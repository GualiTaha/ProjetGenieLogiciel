package com.ESNLEADER.service;

import java.util.List;

import com.ESNLEADER.model.Collaborateurs;
import com.ESNLEADER.model.Projet;
import com.ESNLEADER.model.Technologies;


public interface ProjetService {

	
	Projet Ajouter(Projet projet);
	Projet Modifier(Projet projet);
	void Supprimer(String nom);
	List<Projet> listAll();
	List<Projet> listProjetCollab(String nom);
	List<Projet> listProjetTechno(String nom);
	Projet AjouterTechnologies(Long id,Technologies t);
	 Projet AjouterCollaborateurs(Long id,Collaborateurs c);
	 Projet getById(Long id);
}
