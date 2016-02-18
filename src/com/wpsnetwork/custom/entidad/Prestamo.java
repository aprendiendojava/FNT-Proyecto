package com.wpsnetwork.custom.entidad;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

import com.wpsnetwork.base.entidad.EntidadIndexada;

@MappedSuperclass
public abstract class Prestamo extends EntidadIndexada {
	protected LocalDateTime fechaInicio;
	protected LocalDateTime fechaFin;
	protected boolean       devuelto;
	protected int           libro;
	protected int           persona;
}
