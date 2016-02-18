package com.wpsnetwork.custom.dto;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class PersonaDto extends com.wpsnetwork.custom.entidad.Persona {
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
