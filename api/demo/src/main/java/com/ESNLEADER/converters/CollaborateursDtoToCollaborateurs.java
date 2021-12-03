package com.ESNLEADER.converters;

import java.util.function.Function;

import org.springframework.util.StringUtils;

import com.ESNLEADER.dto.CollaborateursDto;
import com.ESNLEADER.model.Collaborateurs;



public enum CollaborateursDtoToCollaborateurs implements Function<CollaborateursDto, Collaborateurs>{
INSTANCE;


@SuppressWarnings("deprecation")
@Override
public Collaborateurs apply(CollaborateursDto t) {
	Collaborateurs c = new Collaborateurs();
			if(t.getIdCollaborateur() != null && !StringUtils.isEmpty(t.getIdCollaborateur())) {
				c.setIdCollaborateur(t.getIdCollaborateur());
			}
			
			c.setAnciennete(t.getAnciennete());
			c.setFormation(t.getFormation());
			c.setGrade(t.getGrade());
			c.setName(t.getName());
			c.setSalaire(t.getSalaire());
			return c;
}
}
