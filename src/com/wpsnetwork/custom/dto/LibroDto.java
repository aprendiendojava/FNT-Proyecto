package com.wpsnetwork.custom.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class LibroDto extends com.wpsnetwork.custom.entidad.Libro {
	@ManyToMany( cascade=CascadeType.ALL )
	@JoinTable( name="libro_autor", joinColumns=@JoinColumn( name="idLibro" ), inverseJoinColumns=@JoinColumn( name="idAutor" ))
	private Set<AutorDto> autores;

	public LibroDto( String titulo, int paginas, String editorial, int edicion ) {
		this.titulo = titulo;
		this.paginas = paginas;
		this.editorial = editorial;
		this.edicion = edicion;
	}

	public void addAutor( AutorDto autor ) {
		autores.add(autor);
	}
}
