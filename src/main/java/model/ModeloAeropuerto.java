package model;

import java.sql.Blob;
import java.util.Objects;

public class ModeloAeropuerto {

	int id;
	String nombre;
	int anioInauguracion;
	int capacidad;
	ModeloDireccion direccion;
	Blob imagen;
	
	public ModeloAeropuerto(String nombre, int anioInauguracion, int capacidad, ModeloDireccion direccion,
			Blob imagen) {
		super();
		this.nombre = nombre;
		this.anioInauguracion = anioInauguracion;
		this.capacidad = capacidad;
		this.direccion = direccion;
		this.imagen = imagen;
	}
	
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(anioInauguracion, capacidad, direccion, id, imagen, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModeloAeropuerto other = (ModeloAeropuerto) obj;
		return anioInauguracion == other.anioInauguracion && capacidad == other.capacidad
				&& Objects.equals(direccion, other.direccion) && id == other.id && Objects.equals(imagen, other.imagen)
				&& Objects.equals(nombre, other.nombre);
	}
	
}
