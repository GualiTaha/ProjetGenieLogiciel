package com.ESNLEADER.service;

import java.util.List;

import com.ESNLEADER.model.Technologies;

public interface TechnologiesService {

	Technologies Ajouter(Technologies technologies);
	Technologies Modifier(Technologies technologies);
	void Supprimer(String nom);
	List<Technologies> listAll();
}
