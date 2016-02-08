package com.wpsnetwork.dao.entidades;

import java.time.LocalDate;

public final class Persona extends EntidadIndexada {
	private String nombre;
	private String dni;
	private LocalDate fechaNacimiento;
	private String direccion;
	private String telefono;
	private String provincia;
	private String pais;
	private int codigoPostal;

	public Persona( String nombre, String dni, LocalDate fechaNacimiento, String direccion, String telefono, String provincia, String pais, int codigoPostal ) {
		this.nombre = nombre;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.provincia = provincia;
		this.pais = pais;
		this.codigoPostal = codigoPostal;
	}

	public String toString() {
		return getId()
				+ " : Nombre:" + nombre
				+ ", Dni:" + dni
				+ ", FechaNacimiento:" + fechaNacimiento
				+ ", Dirección:" + direccion
				+ ", Teléfono:" + telefono
				+ ", Provincia:" + provincia
				+ ", País:" + pais
				+ ", CódigoPostal:" + codigoPostal;
	}
}
