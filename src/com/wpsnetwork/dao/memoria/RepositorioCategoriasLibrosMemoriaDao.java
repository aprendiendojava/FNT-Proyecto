package com.wpsnetwork.dao.memoria;

import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.dao.entidades.CategoriaLibro;

public final class RepositorioCategoriasLibrosMemoriaDao extends RepositorioMemoriaDao<CategoriaLibro> {
	private static List<CategoriaLibro> categorias = new ArrayList<>();
	static {
		categorias.add( new CategoriaLibro( "Novela" ));
		categorias.add( new CategoriaLibro( "Drama" ));
		categorias.add( new CategoriaLibro( "Poesía" ));
	}
	public RepositorioCategoriasLibrosMemoriaDao() { super(categorias); }
}
