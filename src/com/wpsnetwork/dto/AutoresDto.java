package com.wpsnetwork.dto;

import com.wpsnetwork.dao.memoria.RepositorioAutoresMemoriaDao;
import com.wpsnetwork.dto.entidades.Autor;

public final class AutoresDto extends Dto<RepositorioAutoresMemoriaDao,Autor,com.wpsnetwork.dao.entidades.Autor> {
	public AutoresDto() {
		super( new RepositorioAutoresMemoriaDao(), new Autor());
	}
}
