package com.ESNLEADER.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ESNLEADER.model.Technologies;
import com.ESNLEADER.repositories.TechnologiesRepository;

@Service
@Transactional
public class TechnologiesServiceImp implements TechnologiesService{
	@Autowired
	private TechnologiesRepository repo;
	
	
	@Override
	public Technologies Ajouter(Technologies technologies) {
		repo.save(technologies);
		return technologies;
	}

	@Override
	public Technologies Modifier(Technologies technologies) {
		repo.save(technologies);
		return technologies;
	}

	
	@Override
	public void Supprimer(String nom) {
		List<Technologies> technologies = new ArrayList<>();
		technologies = listAll();
		for (Technologies technologie : technologies) {
			if(technologie.getNom().equals(nom)) {
				repo.delete(technologie);
			}
		}
		
	}

	@Override
	public List<Technologies> listAll() {
		List<Technologies> technologies = new ArrayList<>();
		 repo.findAll().forEach(technologies::add);
		 return technologies;
	}

}
