package com.wpsnetwork.entidades;

import java.time.LocalDate;

public abstract class Persona {
	protected Integer id;
	protected String nombre;
	protected String dni;
	protected LocalDate fechaNacimiento;
	protected String direccion;
	protected String telefono;
	protected String provincia;
	protected String pais;
	protected int codigoPostal;
}
