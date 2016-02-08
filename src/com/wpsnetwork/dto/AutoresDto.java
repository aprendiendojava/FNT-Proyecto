package com.wpsnetwork.dto;

import com.wpsnetwork.dao.entidades.Autor;
import com.wpsnetwork.dao.interfaces.Dao;

public final class AutoresDto extends Dto<Autor> {
	public AutoresDto( Dao<Autor> repositorio ) {
		super( repositorio );
	}
}