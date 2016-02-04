package com.wpsnetwork.dto.entidades;

import com.wpsnetwork.dao.interfaces.Indexado;

public abstract class EntidadDto <ENTIDAD extends Indexado> implements Indexado, Cloneable {
	private ENTIDAD entidad;

	public ENTIDAD getEntidad() { return entidad; }
	public void setEntidad( ENTIDAD entidad ) { this.entidad = entidad; }

	@Override
	public int getId() {
		return entidad.getId();
	}

	public EntidadDto<ENTIDAD> clone() {
		try {
			return (EntidadDto<ENTIDAD>) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			throw new RuntimeException( "La clase no es clonable. Es indispensable implementar esta funcionalidad." );
		}
	}

	public String toString() {
		return "DTO: " + entidad.toString();
	}
}
