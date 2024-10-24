package model;

import java.sql.Blob;

public class ModeloAeropuertoPublico extends ModeloAeropuerto {

	public ModeloAeropuertoPublico(String nombre, int anioInauguracion, int capacidad,
			ModeloDireccion direccion, Blob imagen, float financiacion, int numTrabajadores) {
		super(nombre, anioInauguracion, capacidad, direccion, imagen);
		this.financiacion = financiacion;
		this.numTrabajadores = numTrabajadores;
	}
	float financiacion;
	int numTrabajadores;
	public float getFinanciacion() {
		return financiacion;
	}
	public int getNumTrabajadores() {
		return numTrabajadores;
	}
	
}
