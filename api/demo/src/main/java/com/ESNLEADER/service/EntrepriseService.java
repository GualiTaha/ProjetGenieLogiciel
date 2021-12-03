package com.ESNLEADER.service;

import java.util.List;

import com.ESNLEADER.dto.EntrepriseDto;
import com.ESNLEADER.model.Entreprise;
import com.ESNLEADER.model.Filiale;

public interface EntrepriseService {
	
	Entreprise Ajouter(Entreprise entreprise);
	Entreprise Modifier(Entreprise entreprise);
	void Supprimer(String nom);
	List<Entreprise> listAll();
	Entreprise getById(Long id);
	Entreprise saveOrUpdateProductForm(EntrepriseDto entrepriseDto);
	Entreprise AjouterFiliale(Long id,Filiale f);
	
	
}
