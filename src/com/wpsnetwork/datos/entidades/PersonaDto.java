package com.wpsnetwork.datos.entidades;

import java.time.LocalDate;

public class PersonaDto extends com.wpsnetwork.entidades.Persona {
	public PersonaDto( String nombre, String dni, LocalDate fechaNacimiento, String direccion, String telefono, String provincia, String pais, int codigoPostal ) {
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
