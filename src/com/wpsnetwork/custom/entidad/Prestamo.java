package com.wpsnetwork.custom.entidad;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

import com.wpsnetwork.base.entity.Table;

@MappedSuperclass
public abstract class Prestamo extends Table {
	protected LocalDateTime fechaInicio;
	protected LocalDateTime fechaFin;
	protected boolean       devuelto;
	protected int           libro;
	protected int           persona;
}
