package com.ESNLEADER.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ESNLEADER.model.Filiale;
import com.ESNLEADER.model.Projet;
import com.ESNLEADER.repositories.FilialeRepository;


@Service
@Transactional
public class FilialeServiceImp implements FilialeService{
	@Autowired
	private FilialeRepository repo;
	
	
	@Override
	public Filiale Ajouter(Filiale filiale) {
		repo.save(filiale);
		return filiale;
	}

	@Override
	public Filiale Modifier(Filiale filiale) {
		repo.save(filiale);
		return filiale;
	}

	@Override
	public void Supprimer(String nom) {
		List<Filiale> filiales = new ArrayList<>();
		 repo.findAll().forEach(filiales::add);
		for (Filiale filiale : filiales) {
			if(filiale.getNomFiliale().equals(nom)) {
				repo.delete(filiale);
		}
		}	
	}

	@Override
	public List<Filiale> listAll() {
		List<Filiale> filiales = new ArrayList<>();
		 repo.findAll().forEach(filiales::add);
		 return filiales;
	}
	@Override
	public Filiale getById(Long id) {
		return repo.findById(id).orElse(null);
	}
	@Override
	public Filiale AjouterProjet(Long id,Projet p) {
		Filiale f =getById(id);
		List<Projet>projets= new ArrayList<>();
			for (Projet projet : f.getProjets()) {
				projets.add(projet);
			}
		projets.add(p);
		f.setProjets(projets);
		repo.save(f);
		return f;
	}

}
