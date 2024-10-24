package model;

import java.sql.Blob;

public class ModeloAeropuerto {

	String nombre;
	int anioInauguracion;
	int capacidad;
	ModeloDireccion direccion;
	Blob imagen;
	
	public String getNombre() {
		return nombre;
	}

	public int getAnioInauguracion() {
		return anioInauguracion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public ModeloDireccion getDireccion() {
		return direccion;
	}

	public Blob getImagen() {
		return imagen;
	}

	public ModeloAeropuerto(String nombre, int anioInauguracion, int capacidad, ModeloDireccion direccion,
			Blob imagen) {
		super();
		this.nombre = nombre;
		this.anioInauguracion = anioInauguracion;
		this.capacidad = capacidad;
		this.direccion = direccion;
		this.imagen = imagen;
	}
	
}
