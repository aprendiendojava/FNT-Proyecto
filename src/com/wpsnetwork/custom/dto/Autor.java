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
public class Autor extends com.wpsnetwork.custom.entidad.Autor {
	@ManyToMany( cascade=CascadeType.ALL )
	@JoinTable( name="libro_autor", joinColumns=@JoinColumn( name="idAutor" ), inverseJoinColumns=@JoinColumn( name="idLibro"))
	protected Set<Libro> libros = new HashSet<>();

	public Autor( String nombre ) {
		this.nombre = nombre;
	}

	public Collection<com.wpsnetwork.custom.entidad.Libro> getLibros() {
		return Col.getInstance(libros);
	}
}
