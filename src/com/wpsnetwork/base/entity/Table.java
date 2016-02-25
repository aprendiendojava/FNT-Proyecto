package com.wpsnetwork.base.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@MappedSuperclass
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

/* La anotación anterior previene que al generar el JSON de una entidad (y sus relaciones) se entre en un bucle infinito.
 Básicamente indica que para cada objeto sólo se generará el JSON una única vez, donde ID es distintivo de cada objeto. */

public abstract class Table implements Indexed {
	@Id
	@GeneratedValue( strategy=GenerationType.TABLE )
	private Integer id;

	@Override
	public String toString() {
		ObjectMapper om = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
		om.setVisibility(
			om.getSerializationConfig()
			.getDefaultVisibilityChecker()
				.withFieldVisibility(Visibility.ANY)
				.withGetterVisibility(Visibility.NONE)
				.withSetterVisibility(Visibility.NONE)
				.withCreatorVisibility(Visibility.NONE));
		try {
			return om.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
	}

	public void setIndex( Serializable id ) {
		this.id = (Integer)id;
	}

	@Override
	public Serializable getIndex() {
		return id;
	}
}
