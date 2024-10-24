package model;

import java.sql.Blob;

public class ModeloAeropuertoPrivado extends ModeloAeropuerto {

	int numSocios;

	public ModeloAeropuertoPrivado(String nombre, int anioInauguracion, int capacidad,
			ModeloDireccion direccion, Blob imagen, int numSocios) {
		super(nombre, anioInauguracion, capacidad, direccion, imagen);
		this.numSocios = numSocios;
	}

	public int getNumSocios() {
		return numSocios;
	}
	
}
