package com.wpsnetwork.dao.entidades;

import com.wpsnetwork.dao.interfaces.Indexado;

public class Libro implements Indexado {
	private static int sequence = 0;
	private int    id;
	private String titulo;
	private int    paginas;
	private String editorial;
	private int    edicion;

	public Libro( String titulo ) {
		this.id = this.sequence++;
		this.titulo = titulo;
	}

	@Override
	public int           getId() { return id; }
	public String    getTitulo() { return titulo; }
	public int      getPaginas() { return paginas; }
	public String getEditorial() { return editorial; }
	public int      getEdicion() { return edicion; }

	public void        setId( int id )           { this.id = id; }
	public void    setTitulo( String titulo )    { this.titulo = titulo; }
	public void   setPaginas( int paginas )      { this.paginas = paginas; }
	public void setEditorial( String editorial ) { this.editorial = editorial; }
	public void   setEdicion( int edicion )      { this.edicion = edicion; }
	public String toString() { return id + " : " + titulo; }
}
