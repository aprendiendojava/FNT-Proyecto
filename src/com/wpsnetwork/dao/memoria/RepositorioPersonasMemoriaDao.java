package com.wpsnetwork.dao.memoria;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.dao.entidades.Persona;

public final class RepositorioPersonasMemoriaDao extends RepositorioMemoriaDao<Persona> {
	private static List<Persona> personas = new ArrayList<>();
	static {
		personas.add( new Persona( "FerN", "000000", LocalDate.of(1979, Month.MARCH, 12), "", "00000", "Madrid", "España", 3323 ));
	}

	public RepositorioPersonasMemoriaDao() {
		super(personas);
	}
}
