package com.wpsnetwork.entidades;

import java.time.LocalDateTime;

public abstract class Prestamo {
	protected Integer id;
	protected LocalDateTime fechaInicio;
	protected LocalDateTime fechaFin;
	protected boolean       devuelto;
	protected int           libro;
	protected int           persona;
}
