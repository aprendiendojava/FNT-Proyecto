package com.wpsnetwork.datos.entidades;

import com.wpsnetwork.dao.interfaces.DaoIndexado;
import com.wpsnetwork.dto.Dto;
import com.wpsnetwork.factorias.FactoriaDto;

public class Autor extends com.wpsnetwork.entidades.Autor implements EntidadIndexada {
	public Autor( String nombre ) {
		this.nombre = nombre;
	}

	@Override
	public Object getIndex() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Dto<Libro> getLibros() {
		return FactoriaDto.forEntity(Libro.class);
	}

	public <DAOE extends DaoIndexado<Libro>> Dto<Libro> getLibros( Class<DAOE> repo ) {
		return FactoriaDto.getInstance( repo, Libro.class );
	}
}
