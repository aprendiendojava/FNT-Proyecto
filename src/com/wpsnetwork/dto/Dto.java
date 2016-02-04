package com.wpsnetwork.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.wpsnetwork.dao.interfaces.Dao;
import com.wpsnetwork.dao.interfaces.Indexado;
import com.wpsnetwork.dto.entidades.EntidadDto;

public abstract class Dto<REPO extends Dao<ENTIDAD>, ENT_DTO extends EntidadDto<ENTIDAD>, ENTIDAD extends Indexado> implements Dao<ENT_DTO> {
	private final REPO repositorio;
	private final ENT_DTO ent_dto;

	public Dto( REPO repositorio, ENT_DTO ent_dto ) {
		this.repositorio = repositorio;
		this.ent_dto = ent_dto;
	}

	protected REPO getRepositorio() { return repositorio; }

	@Override
	public ENT_DTO get(int id) {
		ENT_DTO clon = (ENT_DTO) ent_dto.clone();
		clon.setEntidad( repositorio.get(id));
		return clon;
	}

	@Override
	public void insert(ENT_DTO element) {
		repositorio.insert( element.getEntidad());
	}

	@Override
	public void update(ENT_DTO element) {
		repositorio.update( element.getEntidad());
	}

	@Override
	public void delete(ENT_DTO element) {
		repositorio.delete( element.getEntidad());
	}

	@Override
	public List<ENT_DTO> getAll() {
		List<ENTIDAD> entidades = repositorio.getAll();

		return entidades.stream().map( entidad -> {
			ENT_DTO clon = (ENT_DTO) ent_dto.clone();
			clon.setEntidad(entidad);
			return clon;
		}).collect(Collectors.toList());		
	}
}
