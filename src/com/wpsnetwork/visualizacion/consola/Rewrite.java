package com.wpsnetwork.visualizacion.consola;

import com.wpsnetwork.base.FactoriaDao;
import com.wpsnetwork.base.repository.Dao;
import com.wpsnetwork.custom.dto.Autor;

public class Rewrite {
	public static void main( String...strings ) {
		Dao<Autor> autores = FactoriaDao.forEntity( Autor.class );
		autores.getAll().forEach( a-> System.out.println(a));
	}
}
