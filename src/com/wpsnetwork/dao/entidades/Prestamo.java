package com.wpsnetwork.dao.entidades;

import java.time.LocalDateTime;

public final class Prestamo extends EntidadIndexada {
	private static int sequence = 0;
	private LocalDateTime fechaInicio = LocalDateTime.now();
	private LocalDateTime fechaFin;
	private boolean       devuelto;
	private int           libro;
	private int           persona;

	public Prestamo ( int id, LocalDateTime fechaInicio, LocalDateTime fechaFin, boolean devuelto, int libro, int persona ) {
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.devuelto = devuelto;
		this.libro = libro;
		this.persona = persona;
	}
}
