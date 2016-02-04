package com.wpsnetwork.dao.memoria;

import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.dao.entidades.Libro;

public final class RepositorioLibrosMemoriaDao extends RepositorioMemoriaDao<Libro> {
	private static List<Libro> libros = new ArrayList<>();
	static {
		libros.add(new Libro( "Moby Dick" ));
	}

	public RepositorioLibrosMemoriaDao() {
		super(libros);
	}
}
