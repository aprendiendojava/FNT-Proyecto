package com.wpsnetwork.custom.entity;

import java.util.Date;

import javax.persistence.MappedSuperclass;

import com.wpsnetwork.base.entity.Table;

@MappedSuperclass
public abstract class Prestamo extends Table {
	protected Date fechaInicio;
	protected Date fechaFin;
	protected boolean devuelto;
}
