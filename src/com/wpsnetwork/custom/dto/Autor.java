package com.wpsnetwork.custom.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Autor extends com.wpsnetwork.custom.entity.Autor {
	@ManyToMany( cascade=CascadeType.ALL )
	@JoinTable( name="libro_autor", joinColumns=@JoinColumn( name="idAutor" ), inverseJoinColumns=@JoinColumn( name="idLibro"))
	private Set<Libro> libros = new HashSet<>();

	public Autor( String nombre ) {
		this.nombre = nombre;
	}

	public Set<Libro> getLibros() {
		return libros;
	}
}
