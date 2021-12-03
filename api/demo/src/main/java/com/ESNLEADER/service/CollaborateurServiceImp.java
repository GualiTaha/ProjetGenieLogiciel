package com.ESNLEADER.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ESNLEADER.model.Collaborateurs;
import com.ESNLEADER.repositories.CollaborateursRepository;


@Service
@Transactional
public class CollaborateurServiceImp implements CollaborateurService{
	@Autowired
	private CollaborateursRepository repo;
	
	
	@Override
	public Collaborateurs Ajouter(Collaborateurs collaborateurs) {
		repo.save(collaborateurs);
		return collaborateurs;
	}

	@Override
	public Collaborateurs Modifier(Collaborateurs collaborateurs) {
		repo.save(collaborateurs);
		return collaborateurs;
	}

	
	@Override
	public void Supprimer(String nom) {
		List<Collaborateurs> collaborateurs = new ArrayList<>();
		collaborateurs = (List<Collaborateurs>) repo.findAll();
		for (Collaborateurs collaborateur : collaborateurs) {
			if(collaborateur.getName().equals(nom)) {
				repo.delete(collaborateur);
			}
		}	
		
	}
	@Override
	public List<Collaborateurs> listAll() {
		List<Collaborateurs> collaborateurs = new ArrayList<>();
		 repo.findAll().forEach(collaborateurs::add);
		 return collaborateurs;
	}

}
