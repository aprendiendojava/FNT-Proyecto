package com.wpsnetwork.dao.memoria;

import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.dao.entidades.Persona;

public final class RepositorioPersonasMemoriaDao extends RepositorioMemoriaDao<Persona> {
	private static List<Persona> personas = new ArrayList<>();
	static {
		personas.add( new Persona( "FerN" ));
	}

	public RepositorioPersonasMemoriaDao() { super(personas); }
}
