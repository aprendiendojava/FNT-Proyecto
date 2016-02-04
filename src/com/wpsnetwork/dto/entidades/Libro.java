package com.wpsnetwork.dto.entidades;

import java.util.List;

public class Libro extends EntidadDto<com.wpsnetwork.dao.entidades.Libro> {
	private List<Autor> autores;
	private List<CategoriaLibro> categorias;
	public Libro(){}
	public Libro( String titulo ) {
		setEntidad( new com.wpsnetwork.dao.entidades.Libro( titulo ));
	}
}
