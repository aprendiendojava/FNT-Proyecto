package com.wpsnetwork.custom.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class PrestamoDto extends com.wpsnetwork.custom.entidad.Prestamo {
	public PrestamoDto ( LocalDateTime fechaInicio, LocalDateTime fechaFin, boolean devuelto, int libro, int persona ) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.devuelto = devuelto;
		this.libro = libro;
		this.persona = persona;
	}
}
