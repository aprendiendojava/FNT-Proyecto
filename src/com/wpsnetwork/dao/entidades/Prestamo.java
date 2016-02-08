package com.wpsnetwork.dao.entidades;

import java.time.LocalDateTime;

public final class Prestamo extends EntidadIndexada {
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private boolean       devuelto;
	private int           libro;
	private int           persona;

	public Prestamo ( LocalDateTime fechaInicio, LocalDateTime fechaFin, boolean devuelto, int libro, int persona ) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.devuelto = devuelto;
		this.libro = libro;
		this.persona = persona;
	}

	public String toString() {
		return getId()
				+ " : FechaInicio:" + fechaInicio
				+ ", FechaFin:" + fechaFin
				+ ", Devuelto:" + devuelto
				+ ", Libro:" + libro
				+ ", Persona:" + persona;
	}
}
