package com.wpsnetwork.dao.repositorios;

import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.datos.entidades.AutorDto;

public final class RepositorioAutoresMemoriaDao extends RepositorioMemoriaDao<AutorDto> {
	private static List<AutorDto> autores = new ArrayList<>();
	static {
		autores.add(new AutorDto( "Herman Melville" ));
		autores.add(new AutorDto( "Charles Baudelaire" ));
		autores.add(new AutorDto( "Gabriel García Márquez" ));
		autores.add(new AutorDto( "Pablo Neruda" ));
	}

	public RepositorioAutoresMemoriaDao() {
		super( autores );
	}
}
