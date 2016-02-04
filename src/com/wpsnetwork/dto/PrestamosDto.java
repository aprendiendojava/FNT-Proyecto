package com.wpsnetwork.dto;

import com.wpsnetwork.dao.memoria.RepositorioPrestamosMemoriaDao;
import com.wpsnetwork.dto.entidades.Prestamo;

public class PrestamosDto extends Dto<RepositorioPrestamosMemoriaDao,Prestamo,com.wpsnetwork.dao.entidades.Prestamo> {
	public PrestamosDto() {
		super( new RepositorioPrestamosMemoriaDao(), new Prestamo());
	}
}
