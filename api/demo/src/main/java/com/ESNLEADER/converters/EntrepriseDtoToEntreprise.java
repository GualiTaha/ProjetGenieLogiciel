package com.ESNLEADER.converters;

import java.util.function.Function;

import org.springframework.util.StringUtils;

import com.ESNLEADER.dto.EntrepriseDto;
import com.ESNLEADER.model.Entreprise;



public enum EntrepriseDtoToEntreprise implements Function<EntrepriseDto, Entreprise>{
INSTANCE;


@SuppressWarnings("deprecation")
@Override
public Entreprise apply(EntrepriseDto t) {
	Entreprise e = new Entreprise();
			if(t.getIdEntreprise() != null && !StringUtils.isEmpty(t.getIdEntreprise())) {
				e.setIdEntreprise(t.getIdEntreprise());
			}
			e.setAdresse(t.getAdresse());
			e.setNom(t.getNom());
			e.setSecteur(t.getSecteur());
			e.setSite(t.getSite());
			e.setNumTel(t.getNumTel());
			e.setFiliales(t.getFiliales());
			return e;
}
}
