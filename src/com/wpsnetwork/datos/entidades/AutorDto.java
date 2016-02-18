package com.wpsnetwork.datos.entidades;

import javax.persistence.Entity;

import com.wpsnetwork.dao.interfaces.DaoIndexado;
import com.wpsnetwork.dto.Dto;
import com.wpsnetwork.model.factoria.FactoriaDto;

@Entity
public class AutorDto extends com.wpsnetwork.entidades.Autor {
	public AutorDto( String nombre ) {
		this.nombre = nombre;
	}

	public Dto<LibroDto> getLibros() {
		return FactoriaDto.forEntity(LibroDto.class);
	}

	public <DAOE extends DaoIndexado<LibroDto>> Dto<LibroDto> getLibros( Class<DAOE> repo ) {
		return FactoriaDto.getInstance( repo, LibroDto.class );
	}
}
