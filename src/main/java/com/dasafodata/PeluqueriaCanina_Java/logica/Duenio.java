package com.dasafodata.PeluqueriaCanina_Java.logica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Duenio {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id_duenio;
	private String nombre;
	private String movil;



	public Duenio() {

	}

	public Duenio(int id_duenio, String nombre, String movil) {
		super();
		this.id_duenio = id_duenio;
		this.nombre = nombre;
		this.movil = movil;
	}

	public int getId_duenio() {
		return id_duenio;
	}

	public void setId_duenio(int id_duenio) {
		this.id_duenio = id_duenio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}



}
