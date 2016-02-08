package com.wpsnetwork.dto;

import com.wpsnetwork.dao.entidades.Prestamo;
import com.wpsnetwork.dao.interfaces.Dao;

public final class PrestamosDto extends Dto<Prestamo> {
	public PrestamosDto( Dao<Prestamo> repositorio ) {
		super( repositorio );
	}
}