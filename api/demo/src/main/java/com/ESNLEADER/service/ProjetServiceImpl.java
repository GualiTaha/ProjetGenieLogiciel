package com.ESNLEADER.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ESNLEADER.model.Collaborateurs;
import com.ESNLEADER.model.Projet;
import com.ESNLEADER.model.Technologies;
import com.ESNLEADER.repositories.ProjetRepository;


@Service
@Transactional
public class ProjetServiceImpl implements ProjetService{

	@Autowired
	ProjetRepository repo;
	@Override
	public Projet Ajouter(Projet projet) {
		repo.save(projet);
		return projet;
	}

	@Override
	public Projet Modifier(Projet projet) {
		 Projet existing = getById(projet.getIdProjet());
		   copyNonNullProperties(projet, existing);
		repo.save(projet);
		return projet;
	}
	public static void copyNonNullProperties(Object src, Object target) {
	    BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
	}
	public static String[] getNullPropertyNames (Object source) {
	    final BeanWrapper src = new BeanWrapperImpl(source);
	    java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

	    Set<String> emptyNames = new HashSet<String>();
	    for(java.beans.PropertyDescriptor pd : pds) {
	        Object srcValue = src.getPropertyValue(pd.getName());
	        if (srcValue == null) emptyNames.add(pd.getName());
	    }
	    String[] result = new String[emptyNames.size()];
	    return emptyNames.toArray(result);
	}

	@Override
	public void Supprimer(String nom) {
		List<Projet> projets = new ArrayList<>();
		repo.findAll().forEach(projets::add);
		for (Projet projet : projets) {
			if(projet.getNom_projet().equals(nom)) {
				repo.delete(projet);
			}
		}	
		
	}

	@Override
	public List<Projet> listAll() {
		List<Projet> projets = new ArrayList<>();
		 repo.findAll().forEach(projets::add);
		 return projets;
	}

	public List<Projet> listProjetCollab(String nom) {
		List<Projet> projets = new ArrayList<>();
		List<Projet> projet1 = new ArrayList<Projet>();
		repo.findAll().forEach(projets::add);
		for (Projet projet : projets) {
			for (Collaborateurs collab : projet.getCollaborateurs()) {
				if(collab.getName().equals(nom)) {
					projet1.add(projet);
				}
			}
		}	
		return projet1;
	}

	@Override
	public List<Projet> listProjetTechno(String nom) {
		List<Projet> projets = new ArrayList<>();
		List<Projet> projet1 = new ArrayList<Projet>();
		repo.findAll().forEach(projets::add);
		for (Projet projet : projets) {
			for (Technologies tech : projet.getTechnologies()) {
				if(tech.getNom().equals(nom)) {
					projet1.add(projet);
				}
			}
		}	
		return projet1;
	}
	public Projet getById(Long id) {
		return repo.findById(id).orElse(null);
	}
	public Projet AjouterTechnologies(Long id,Technologies t) {
		Projet p = getById(id);
		List<Technologies>techs= new ArrayList<>();
		for (Technologies technologies : p.getTechnologies()) {
			techs.add(technologies);
		}
		techs.add(t);
		p.setTechnologies(techs);
		return repo.save(p);
	}
	
	public Projet AjouterCollaborateurs(Long id,Collaborateurs c) {
		Projet p = getById(id);
		List<Collaborateurs>collabs= new ArrayList<>();
		for (Collaborateurs collaborateurs : p.getCollaborateurs()) {
			collabs.add(collaborateurs);
		}
		collabs.add(c);
		p.setCollaborateurs(collabs);
		return repo.save(p);
	}

}
