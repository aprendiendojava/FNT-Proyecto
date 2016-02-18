package com.wpsnetwork.datos.entidades;

import java.time.LocalDateTime;

public class Prestamo extends com.wpsnetwork.entidades.Prestamo implements EntidadIndexada {
	public Prestamo ( LocalDateTime fechaInicio, LocalDateTime fechaFin, boolean devuelto, int libro, int persona ) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.devuelto = devuelto;
		this.libro = libro;
		this.persona = persona;
	}

	@Override
	public Object getIndex() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}
}
