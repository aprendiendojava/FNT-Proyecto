package com.wpsnetwork.dao.entidades;

import java.time.LocalDate;

import com.wpsnetwork.dao.interfaces.Indexado;

public final class Persona extends EntidadIndexada {
	private static int sequence = 0;
	private String nombre;
	private String dni;
	private LocalDate fechaNacimiento;
	private String direccion;
	private String telefono;
	private String provincia;
	private String pais;
	private int codigoPostal;

	public Persona( String nombre ) {
		this.id = sequence++;
		this.nombre = nombre;
	}

	public Persona( int id, String nombre, String dni, LocalDate fechaNacimiento, String direccion, String telefono, String provincia, String pais, int codigoPostal ) {
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.provincia = provincia;
		this.pais = pais;
		this.codigoPostal = codigoPostal;
	}
}
