package com.wpsnetwork.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.wpsnetwork.dao.entidades.EntidadRelacionalIndexada;
import com.wpsnetwork.factorias.FactoriaDto;

public class EntidadRelacionalDto <ERI extends EntidadRelacionalIndexada> extends EntidadDto<ERI> {
	public EntidadRelacionalDto(ERI entidad) {
		super(entidad);
	}

	public List<ERI> getRelation( Class<ERI> relacion ) {
		return (List<ERI>) FactoriaDto.forEntity( getEntidad().getRelation( relacion ))
					.getAll()
					.stream()
					.map( dto-> dto.getEntidad())
					.filter(
						e-> ((ERI)e)
								.getFk( getEntidad().getClass())
								.equals(getEntidad().getIndex())).collect(Collectors.toList());
		
	}
}
