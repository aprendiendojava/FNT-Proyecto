package com.wpsnetwork.base.entidad;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wpsnetwork.base.interfaz.Indexado;

@MappedSuperclass
public abstract class EntidadIndexada implements Indexado {
	@Id
	@GeneratedValue( strategy=GenerationType.TABLE )
	private Integer id;

	@Override
	public String toString() {
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(
			om.getSerializationConfig()
			.getDefaultVisibilityChecker()
				.withFieldVisibility(Visibility.PROTECTED_AND_PUBLIC)
				.withGetterVisibility(Visibility.NONE)
				.withSetterVisibility(Visibility.NONE)
				.withCreatorVisibility(Visibility.NONE));
		return om.valueToTree(this).toString();
	}

	public void setId( Integer id ) {
		this.id = id;
	}

	@Override
	public Serializable getIndex() {
		return id;
	}
}
