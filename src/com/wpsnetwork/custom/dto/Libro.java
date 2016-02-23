package com.wpsnetwork.custom.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Libro extends com.wpsnetwork.custom.entity.Libro {
	@ManyToMany( cascade=CascadeType.ALL, fetch=FetchType.EAGER )
	@JoinTable( name="libro_autor", joinColumns=@JoinColumn( name="idLibro" ), inverseJoinColumns=@JoinColumn( name="idAutor" ))
	private Set<Autor> autores = new HashSet<>();

	@ManyToMany( cascade=CascadeType.ALL, fetch=FetchType.EAGER )
	@JoinTable( name="categoria_libro", joinColumns=@JoinColumn( name="idLibro" ), inverseJoinColumns=@JoinColumn( name="idCategoria" ))
	private Set<Categoria> categorias = new HashSet<>();

	@OneToOne( cascade=CascadeType.ALL, mappedBy="libro" )
	private Prestamo prestamo;

	public Libro( String titulo, int paginas, String editorial, int edicion ) {
		this.titulo = titulo;
		this.paginas = paginas;
		this.editorial = editorial;
		this.edicion = edicion;
	}

	public Set<Autor> getAutores() {
		return autores;
	}

	public Set<Categoria> getCategorias() {
		return categorias;
	}
}
