package com.ESNLEADER.converters;

import java.util.function.Function;

import org.springframework.util.StringUtils;

import com.ESNLEADER.dto.TechnologiesDto;
import com.ESNLEADER.model.Technologies;

public enum TechnologiesDtoToTechnologies implements Function<TechnologiesDto, Technologies>{
	INSTANCE;

	@SuppressWarnings("deprecation")
	@Override
	public Technologies apply(TechnologiesDto tec) {
		Technologies t = new Technologies();
				if(t.getIdTechnologie() != null && !StringUtils.isEmpty(t.getIdTechnologie())) {
					t.setNom(tec.getNom());
				}
				return t;
	}
}