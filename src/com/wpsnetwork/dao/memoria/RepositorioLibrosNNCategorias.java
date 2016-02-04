package com.wpsnetwork.dao.memoria;

import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.dao.entidades.LibroNNCategoria;

public class RepositorioLibrosNNCategorias extends RepositorioMemoriaDao<LibroNNCategoria> {
	private static List<LibroNNCategoria> libroNNCategoria = new ArrayList<>();

	protected RepositorioLibrosNNCategorias() {
		super(libroNNCategoria);
	}
}
