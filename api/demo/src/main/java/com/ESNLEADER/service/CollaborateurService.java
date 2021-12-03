package com.ESNLEADER.service;

import java.util.List;

import com.ESNLEADER.model.Collaborateurs;


public interface CollaborateurService {

	Collaborateurs Ajouter(Collaborateurs collaborateurs);
	Collaborateurs Modifier(Collaborateurs collaborateurs);
	void Supprimer(String nom);
	List<Collaborateurs> listAll();
	
}
