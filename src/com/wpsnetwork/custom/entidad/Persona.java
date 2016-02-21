package com.wpsnetwork.custom.entidad;

import java.time.LocalDate;

import javax.persistence.MappedSuperclass;

import com.wpsnetwork.base.entity.Table;

@MappedSuperclass
public abstract class Persona extends Table {
	protected String nombre;
	protected String dni;
	protected LocalDate fechaNacimiento;
	protected String direccion;
	protected String telefono;
	protected String provincia;
	protected String pais;
	protected int codigoPostal;
}
