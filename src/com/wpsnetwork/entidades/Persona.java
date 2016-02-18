package com.wpsnetwork.entidades;

import java.time.LocalDate;

import com.wpsnetwork.model.entidad.EntidadIndexada;

public abstract class Persona extends EntidadIndexada {
	protected String nombre;
	protected String dni;
	protected LocalDate fechaNacimiento;
	protected String direccion;
	protected String telefono;
	protected String provincia;
	protected String pais;
	protected int codigoPostal;
}
