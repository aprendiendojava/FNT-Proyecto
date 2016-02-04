
package com.wpsnetwork.dao.memoria;

import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.dao.entidades.Prestamo;

public final class RepositorioPrestamosMemoriaDao extends RepositorioMemoriaDao<Prestamo> {
	private static List<Prestamo> prestamos = new ArrayList<>();

	public RepositorioPrestamosMemoriaDao() {
		super(prestamos);
	}
}
