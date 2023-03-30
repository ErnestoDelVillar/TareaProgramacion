package logico;

import java.util.ArrayList;

public class MotherBoard extends Componente {
	
	private String modelo;
	private String tipoSocket;
	private String tipoRam;
	private ArrayList<String> compatible;
	
	public MotherBoard(String id, String marca, String serial, float precio, int cantMin, int cantMax, int cantReal,
			String modelo, String tipoSocket, String tipoRam, ArrayList<String> compatible) {
		super(id, marca, serial, precio, cantMin, cantMax, cantReal);
		this.modelo = modelo;
		this.tipoSocket = tipoSocket;
		this.tipoRam = tipoRam;
		this.compatible = compatible;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipoSocket() {
		return tipoSocket;
	}

	public void setTipoSocket(String tipoSocket) {
		this.tipoSocket = tipoSocket;
	}

	public String getTipoRam() {
		return tipoRam;
	}

	public void setTipoRam(String tipoRam) {
		this.tipoRam = tipoRam;
	}

	public ArrayList<String> getCompatible() {
		return compatible;
	}

	public void setCompatible(ArrayList<String> compatible) {
		this.compatible = compatible;
	}
	
	
}
