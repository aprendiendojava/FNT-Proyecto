package com.wpsnetwork.dao.memoria;

import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.dao.entidades.LibroNNAutor;

public class RepositorioLibrosNNAutores extends RepositorioMemoriaDao<LibroNNAutor> {
	public static List<LibroNNAutor> librosNNAutores = new ArrayList<>();
	static {
		librosNNAutores.add(new LibroNNAutor(0, 0));
		librosNNAutores.add(new LibroNNAutor(1, 1));
	}

	public RepositorioLibrosNNAutores() {
		super(librosNNAutores);
	}
}
