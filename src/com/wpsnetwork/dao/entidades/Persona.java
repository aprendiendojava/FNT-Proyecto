package com.wpsnetwork.dao.entidades;

import java.time.LocalDate;

import com.wpsnetwork.dao.interfaces.Indexado;

public class Persona implements Indexado {
	private static int sequence = 0;
	private int id;
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

	public int                    getId() { return id; }
	public String             getNombre() { return nombre; }
	public String                getDni() { return dni; }
	public LocalDate getFechaNacimiento() { return fechaNacimiento; }
	public String          getDireccion() { return direccion; }
	public String           getTelefono() { return telefono; }
	public String          getProvincia() { return provincia; }
	public String               getPais() { return pais; }
	public int          getCodigoPostal() { return codigoPostal; }

	protected void              setId( int id )                    { this.id = id; }
	protected void          setNombre( String nombre )             { this.nombre = nombre; }
	protected void             setDni( String dni )                { this.dni = dni; }
	protected void setFechaNacimiento( LocalDate fechaNacimiento ) { this.fechaNacimiento = fechaNacimiento; }
	protected void       setDireccion( String direccion )          { this.direccion = direccion; }
	protected void        setTelefono( String telefono )           { this.telefono = telefono; }
	protected void       setProvincia( String provincia )			{ this.provincia = provincia; }
	protected void            setPais( String pais )               { this.pais = pais; }
	protected void    setCodigoPostal( int codigoPostal )          { this.codigoPostal = codigoPostal; }
}
