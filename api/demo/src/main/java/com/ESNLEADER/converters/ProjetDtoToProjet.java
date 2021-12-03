package com.ESNLEADER.converters;

import java.util.function.Function;

import org.springframework.util.StringUtils;

import com.ESNLEADER.dto.ProjetDto;
import com.ESNLEADER.model.Projet;

public enum ProjetDtoToProjet implements Function<ProjetDto, Projet>{
	INSTANCE;

	@SuppressWarnings("deprecation")
	@Override
	public Projet apply(ProjetDto t) {
		Projet p = new Projet();
				if(p.getIdProjet() != null && !StringUtils.isEmpty(p.getIdProjet())) {
					p.setClient(t.getClient());
					p.setDescription(t.getDescription());
					p.setDuree(t.getDuree());
					p.setNom_projet(t.getNom_projet());
					p.setType_projet(t.getType_projet());
				}
				return p;
	}
	}