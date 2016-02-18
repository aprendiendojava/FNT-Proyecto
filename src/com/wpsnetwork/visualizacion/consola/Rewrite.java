package com.wpsnetwork.visualizacion.consola;

import java.util.Arrays;

import com.wpsnetwork.dao.repositorios.RepositorioAutoresMemoriaDao;
import com.wpsnetwork.datos.entidades.Autor;
import com.wpsnetwork.datos.entidades.Libro;
import com.wpsnetwork.dto.Dto;
import com.wpsnetwork.dto.EntidadDto;
import com.wpsnetwork.factorias.FactoriaDto;

public class Rewrite {
	public static void main( String...strings ) {
		Dto<Autor> autores = FactoriaDto.forRepo( RepositorioAutoresMemoriaDao.class );
		Dto<Libro> libros = FactoriaDto.forEntity( Libro.class );
		Arrays.asList(
			new Libro( "Moby Dick", 300, "Astral", 34 ),
			new Libro( "Las flores del mal", 140, "Editorial3", 11 ),
			new Libro( "Rayuela", 400, "Editorial1", 14 ),
			new Libro( "La amabilidad de los extraños", 90, "Editorial2", 1 )
		).forEach( l -> libros.insert( new EntidadDto<Libro>( l )));

		autores.getAll().get(0).getEntidad().getLibros().getAll().forEach(l-> System.out.println(l));

	}
}
