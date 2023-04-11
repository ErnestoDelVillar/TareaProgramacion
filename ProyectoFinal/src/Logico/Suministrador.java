package Logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Suministrador implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String nombre;
	private String pais;
	private int entrega;
	private ArrayList<Componente> componentes;
	
	
	public Suministrador(String id, String nombre, String pais, int entrega) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
		this.entrega = entrega;
		this.componentes = new ArrayList<Componente>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getEntrega() {
		return entrega;
	}

	public void setEntrega(int entrega) {
		this.entrega = entrega;
	}

	public ArrayList<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(ArrayList<Componente> comps) {
		this.componentes = comps;
	}
	
}