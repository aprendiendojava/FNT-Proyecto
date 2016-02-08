package com.wpsnetwork.dao.memoria;

import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.dao.entidades.Libro;

public final class RepositorioLibrosMemoriaDao extends RepositorioMemoriaDao<Libro> {
	private static List<Libro> libros = new ArrayList<>();
	static {
		libros.add(new Libro( "Moby Dick", 300, "Astral", 34 ));
		libros.add(new Libro( "Las flores del mal", 140, "Editorial3", 11));
	}

	public RepositorioLibrosMemoriaDao() {
		super(libros);
	}
}
