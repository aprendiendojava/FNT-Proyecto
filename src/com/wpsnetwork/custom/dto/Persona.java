package com.wpsnetwork.custom.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Persona extends com.wpsnetwork.custom.entity.Persona {
	@OneToMany( cascade=CascadeType.ALL, mappedBy="persona", orphanRemoval=true)
	private Set<Prestamo> prestamos = new HashSet<>();

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
}
