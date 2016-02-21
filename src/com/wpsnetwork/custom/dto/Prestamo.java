package com.wpsnetwork.custom.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class Prestamo extends com.wpsnetwork.custom.entidad.Prestamo {
	public Prestamo ( LocalDateTime fechaInicio, LocalDateTime fechaFin, boolean devuelto, int libro, int persona ) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.devuelto = devuelto;
		this.libro = libro;
		this.persona = persona;
	}
}