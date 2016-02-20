package com.wpsnetwork.custom.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AutorDto extends com.wpsnetwork.custom.entidad.Autor {
	@JsonIgnore
	@ManyToMany( cascade=CascadeType.ALL, mappedBy="autores" )
	protected Set<LibroDto> libros;

	public AutorDto( String nombre ) {
		this.nombre = nombre;
	}

	public Set<LibroDto> getLibros() {
		return libros;
	}
}
