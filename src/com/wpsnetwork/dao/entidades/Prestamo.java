package com.wpsnetwork.dao.entidades;

import java.time.LocalDateTime;

import com.wpsnetwork.dao.interfaces.Indexado;

public class Prestamo implements Indexado {
	private static int sequence = 0;
	private int           id;
	private LocalDateTime fechaInicio = LocalDateTime.now();
	private LocalDateTime fechaFin;
	private boolean       devuelto;
	private int           libro;
	private int           persona;

	public Prestamo ( int id, LocalDateTime fechaInicio, LocalDateTime fechaFin, boolean devuelto, int libro, int persona ) {
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.devuelto = devuelto;
		this.libro = libro;
		this.persona = persona;
	}

	public int                    getId() { return id; }
	public LocalDateTime getFechaInicio() { return fechaInicio; }
	public LocalDateTime    getFechaFin() { return fechaFin; }
	public boolean          getDevuelto() { return devuelto; }
	public int                 getLibro() { return libro; }
	public int               getPersona() { return persona; }

	public void          setId( int id )                    { this.id = id; }
	public void setFechaInicio( LocalDateTime fechaInicio ) { this.fechaInicio = fechaInicio; }
	public void    setFechaFin( LocalDateTime fechaFin )    { this.fechaFin = fechaFin; }
	public void    setDevuelto( boolean devuelto )          { this.devuelto = devuelto; }
	public void       setLibro( int libro )                 { this.libro = libro; }
	public void     setPersona( int persona )               { this.persona = persona; }
}
