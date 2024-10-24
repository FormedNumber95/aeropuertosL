package model;

public class ModeloAvion {

	String modelo;
	int numAsientos;
	int velMaxima;
	boolean activado;//en la base de datos en int(1), 1 si es true
	public String getModelo() {
		return modelo;
	}

	public int getNumAsientos() {
		return numAsientos;
	}

	public int getVelMaxima() {
		return velMaxima;
	}

	public boolean isActivado() {
		return activado;
	}

	public ModeloAeropuerto getAeropuerto() {
		return aeropuerto;
	}

	ModeloAeropuerto aeropuerto;
	
	public ModeloAvion(String modelo, int numAsientos, int velMaxima, boolean activado, ModeloAeropuerto aeropuerto) {
		super();
		this.modelo = modelo;
		this.numAsientos = numAsientos;
		this.velMaxima = velMaxima;
		this.activado = activado;
		this.aeropuerto = aeropuerto;
	}
	
}
