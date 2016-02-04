package com.wpsnetwork.dto;

import com.wpsnetwork.dao.memoria.RepositorioPersonasMemoriaDao;
import com.wpsnetwork.dto.entidades.Persona;

public final class PersonasDto extends Dto<RepositorioPersonasMemoriaDao,Persona,com.wpsnetwork.dao.entidades.Persona> {
	public PersonasDto() {
		super( new RepositorioPersonasMemoriaDao(), new Persona());
	}
}
