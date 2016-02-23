package com.wpsnetwork.custom.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Categoria extends com.wpsnetwork.custom.entity.Categoria {
	@ManyToMany( cascade=CascadeType.ALL )
	@JoinTable( name="categoria_libro", joinColumns=@JoinColumn( name="idLibro" ), inverseJoinColumns=@JoinColumn( name="idCategoria" ))
	private Set<Libro> libros = new HashSet<>();

	public Categoria( String nombre ) {
		this.nombre = nombre;
	}
}
