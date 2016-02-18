package com.wpsnetwork.entidades;

import java.time.LocalDateTime;

import com.wpsnetwork.model.entidad.EntidadIndexada;

public abstract class Prestamo extends EntidadIndexada {
	protected LocalDateTime fechaInicio;
	protected LocalDateTime fechaFin;
	protected boolean       devuelto;
	protected int           libro;
	protected int           persona;
}
