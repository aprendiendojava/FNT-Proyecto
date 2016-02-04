package com.wpsnetwork.dao.entidades;

import com.wpsnetwork.dao.interfaces.Indexado;

public class Autor implements Indexado {
	private static int sequence = 0;
	private int id;
	private String nombre;

	public Autor( String nombre ) {
		this.id = sequence++;
		this.nombre = nombre;
	}

    public int        getId() { return id; }
    public String getNombre() { return nombre; }

    protected void     setId( int id )        { this.id = id; }
    protected void setNombre( String nombre ) { this.nombre = nombre; }
    public String toString() { return id + ":" + nombre; }
}
