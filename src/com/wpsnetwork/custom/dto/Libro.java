package com.wpsnetwork.custom.dto;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.wpsnetwork.base.entity.Col;

@Entity
public class Libro extends com.wpsnetwork.custom.entidad.Libro {
	@ManyToMany( cascade=CascadeType.ALL )
	@JoinTable( name="libro_autor", joinColumns=@JoinColumn( name="idLibro" ), inverseJoinColumns=@JoinColumn( name="idAutor"))
	protected Set<Autor> autores = new HashSet<>();

	@ManyToMany( cascade=CascadeType.ALL )
	@JoinTable( name="categoria_libro", joinColumns=@JoinColumn( name="idLibro" ), inverseJoinColumns=@JoinColumn( name="idCategoria" ))
	protected Set<CategoriaLibro> categorias = new HashSet<>();

	public Libro( String titulo, int paginas, String editorial, int edicion ) {
		this.titulo = titulo;
		this.paginas = paginas;
		this.editorial = editorial;
		this.edicion = edicion;
	}

	public Collection<com.wpsnetwork.custom.entidad.Autor> getAutores() {
		return Col.getInstance(autores);
	}

	public Collection<com.wpsnetwork.custom.entidad.CategoriaLibro> getCategorias() {
		return Col.getInstance(categorias);
	}
}
