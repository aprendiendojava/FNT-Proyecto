package com.wpsnetwork.datos.entidades;

import java.time.LocalDateTime;

public class PrestamoDto extends com.wpsnetwork.entidades.Prestamo {
	public PrestamoDto ( LocalDateTime fechaInicio, LocalDateTime fechaFin, boolean devuelto, int libro, int persona ) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.devuelto = devuelto;
		this.libro = libro;
		this.persona = persona;
	}
}
