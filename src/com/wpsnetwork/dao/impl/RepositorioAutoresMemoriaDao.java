package com.wpsnetwork.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.dao.entidades.Autor;

public final class RepositorioAutoresMemoriaDao extends RepositorioMemoriaDao<Autor> {
	private static List<Autor> autores = new ArrayList<>();
	static {
		autores.add(new Autor( "Herman Melville" ));
		autores.add(new Autor( "Charles Baudelaire" ));
		autores.add(new Autor( "Gabriel García Márquez" ));
		autores.add(new Autor( "Pablo Neruda" ));
	}

	public RepositorioAutoresMemoriaDao() {
		super( autores );
	}
}
