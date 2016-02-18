package com.wpsnetwork.custom.repositorio;

import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.base.repositorio.RepositorioMemoriaDao;
import com.wpsnetwork.custom.dto.AutorDto;

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
