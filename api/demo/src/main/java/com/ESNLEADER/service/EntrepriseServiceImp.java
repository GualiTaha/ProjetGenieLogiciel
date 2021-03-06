package com.ESNLEADER.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ESNLEADER.converters.EntrepriseDtoToEntreprise;
import com.ESNLEADER.dto.EntrepriseDto;
import com.ESNLEADER.model.Entreprise;
import com.ESNLEADER.model.Filiale;
import com.ESNLEADER.repositories.EntrepriseRepository;

@Service
@Transactional
public class EntrepriseServiceImp implements EntrepriseService {
	@Autowired
	private EntrepriseRepository repo;
	
	@Transactional
	@Override
	public Entreprise Ajouter(Entreprise entreprise) {
		repo.save(entreprise);
		return entreprise;
	}
	public Entreprise AjouterFiliale(Long id,Filiale f) {
		Entreprise e =getById(id);
		List<Filiale>filiales= new ArrayList<>();
		for (Filiale f1 : e.getFiliales()) {
			filiales.add(f1);
		}
		filiales.add(f);
		e.setFiliales(filiales);
		repo.save(e);
		return e;
	}

	@Override
	public Entreprise Modifier(Entreprise entreprise) {
		repo.save(entreprise);
		return entreprise;
	}

	@Transactional
	@Override
	public List<Entreprise> listAll() {
		List<Entreprise> entreprises = new ArrayList<>();
		 repo.findAll().forEach(entreprises::add);
		 return entreprises;
	}

	
	@Override
	public void Supprimer(String nom) {
		List<Entreprise> entreprises = new ArrayList<>();
		repo.findAll().forEach(entreprises::add);
		for (Entreprise entreprise : entreprises) {
			if(entreprise.getNom().equals(nom)) {
				repo.delete(entreprise);
			}
		}	
	}

	@Override
	public Entreprise getById(Long id) {
		return repo.findById(id).orElse(null);
	}

	public Entreprise saveOrUpdateProductForm(EntrepriseDto entrepriseDto) {
		Entreprise savedentreprise = Ajouter(EntrepriseDtoToEntreprise.INSTANCE.apply(entrepriseDto));
        return savedentreprise;
    }
}
