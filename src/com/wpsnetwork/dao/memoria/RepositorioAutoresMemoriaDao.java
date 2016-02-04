package com.wpsnetwork.dao.memoria;

import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.dao.entidades.Autor;

public final class RepositorioAutoresMemoriaDao extends RepositorioMemoriaDao<Autor> {
	private static List<Autor> autores = new ArrayList<>();
	static {
		autores.add(new Autor( "Herman Melville" ));
		autores.add(new Autor( "Charles Baudelaire" ));
	}

	public RepositorioAutoresMemoriaDao() { super( autores ); }
}
