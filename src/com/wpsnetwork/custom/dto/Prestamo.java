package com.wpsnetwork.custom.dto;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Prestamo extends com.wpsnetwork.custom.entity.Prestamo {
	@ManyToOne( cascade =CascadeType.ALL )
	@JoinColumn(name="idPersona")
	private Persona persona;

	@OneToOne( cascade=CascadeType.ALL )
	@JoinColumn(name="idLibro")
	private Libro libro;

	public Prestamo ( Libro libro, Persona persona ) {
		LocalDateTime ldt = LocalDateTime.now();
		this.fechaInicio = Date.from(ldt.toInstant(ZoneOffset.UTC));
		this.fechaFin = Date.from(ldt.plusDays(3).toInstant(ZoneOffset.UTC));
		this.devuelto = false;
		this.libro = libro;
		this.persona = persona;
	}

	public com.wpsnetwork.custom.entity.Libro getLibro() {
		return libro;
	}

	public com.wpsnetwork.custom.entity.Persona getPersona() {
		return persona;
	}
}
