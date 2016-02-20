package com.wpsnetwork.custom.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LibroDto extends com.wpsnetwork.custom.entidad.Libro {
	@JsonIgnore
	@ManyToMany( cascade=CascadeType.ALL )
	@JoinTable( name="libro_autor", joinColumns=@JoinColumn( name="idLibro" ), inverseJoinColumns=@JoinColumn( name="idAutor" ))
	protected Set<AutorDto> autores = new HashSet<>();

	public LibroDto( String titulo, int paginas, String editorial, int edicion ) {
		this.titulo = titulo;
		this.paginas = paginas;
		this.editorial = editorial;
		this.edicion = edicion;
	}

	public Set<AutorDto> getAutores() {
		return autores;
	}
}
