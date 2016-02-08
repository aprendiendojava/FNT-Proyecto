package com.wpsnetwork.dto;

import com.wpsnetwork.dao.entidades.Persona;
import com.wpsnetwork.dao.interfaces.Dao;

public final class PersonasDto extends Dto<Persona> {
	public PersonasDto( Dao<Persona> repositorio ) {
		super( repositorio );
	}
}