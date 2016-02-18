package com.wpsnetwork.custom.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.wpsnetwork.base.FactoriaDao;
import com.wpsnetwork.base.interfaz.Dao;
import com.wpsnetwork.base.interfaz.DaoIndexado;

@Entity
public class AutorDto extends com.wpsnetwork.custom.entidad.Autor {
	@ManyToMany( cascade=CascadeType.ALL, mappedBy="autores" )
	private Set<LibroDto> libros;

	public AutorDto( String nombre ) {
		this.nombre = nombre;
	}

	public Dao<LibroDto> getLibros() {
		return FactoriaDao.forEntity(LibroDto.class);
	}

	public <DAOE extends DaoIndexado<LibroDto>> Dao<LibroDto> getLibros( Class<DAOE> repo ) {
		return FactoriaDao.getInstance( repo, LibroDto.class );
	}

	public void addLibro( LibroDto libro ) {
		libros.add(libro);
	}
}
