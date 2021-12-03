package com.ESNLEADER.converters;

import java.util.function.Function;

import org.springframework.util.StringUtils;

import com.ESNLEADER.dto.FilialeDto;
import com.ESNLEADER.model.Filiale;



public enum FilialeDtoToFiliale implements Function<FilialeDto, Filiale>{
INSTANCE;


@SuppressWarnings("deprecation")
@Override
public Filiale apply(FilialeDto t) {
	Filiale f = new Filiale();
			if(t.getIdFiliale() != null && !StringUtils.isEmpty(t.getIdFiliale())) {
				f.setIdFiliale(t.getIdFiliale());
			}
			f.setAdresse(t.getAdresse());
			f.setAdresse(t.getAdresse());
			f.setEmail(t.getEmail());
			f.setTel(t.getTel());
			f.setNomFiliale(t.getNomFiliale());
			f.setProjets(t.getProjets());
			return f;
}
}
