package com.ESNLEADER.service;

import java.util.List;


import com.ESNLEADER.model.Filiale;
import com.ESNLEADER.model.Projet;

public interface FilialeService {
	Filiale Ajouter(Filiale filiale);
	Filiale Modifier(Filiale filiale);
	void Supprimer(String nom);
	List<Filiale> listAll();
	Filiale AjouterProjet(Long id,Projet p);
	Filiale getById(Long id);
}
