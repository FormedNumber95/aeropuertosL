package model;

import java.sql.Blob;
import java.util.Objects;

public class ModeloAeropuertoPublico extends ModeloAeropuerto {

	float financiacion;
	int numTrabajadores;
	
	public ModeloAeropuertoPublico(String nombre, int anioInauguracion, int capacidad,
			ModeloDireccion direccion, Blob imagen, float financiacion, int numTrabajadores) {
		super(nombre, anioInauguracion, capacidad, direccion, imagen);
		this.financiacion = financiacion;
		this.numTrabajadores = numTrabajadores;
	}
	
	public float getFinanciacion() {
		return financiacion;
	}
	public int getNumTrabajadores() {
		return numTrabajadores;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(financiacion, numTrabajadores);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModeloAeropuertoPublico other = (ModeloAeropuertoPublico) obj;
		return Float.floatToIntBits(financiacion) == Float.floatToIntBits(other.financiacion)
				&& numTrabajadores == other.numTrabajadores&&anioInauguracion == other.anioInauguracion && capacidad == other.capacidad
						&& Objects.equals(direccion, other.direccion) && id == other.id && Objects.equals(imagen, other.imagen)
						&& Objects.equals(nombre, other.nombre);
	}
	
}
