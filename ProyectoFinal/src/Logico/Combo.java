package Logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Combo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String nombre;
	private ArrayList<Componente> misComponentes;
	private int descuento;
	public static int codigo = 1;
	
	public Combo(String id, String nombre, int descuento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.misComponentes = new ArrayList<>();
		this.descuento = descuento;
		Combo.codigo++;
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

	public ArrayList<Componente> getComponentes() {
		return misComponentes;
	}

	public void setComponentes(ArrayList<Componente> componentes) {
		this.misComponentes = componentes;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	public void agregarComponente(Componente c) {
		misComponentes.add(c);
	}
	
	public float precio() {
		float total = 0;
		for (Componente c : misComponentes) {
			total += c.getPrecio();
		}
		return total - (total * ((float)descuento/100) );
	}
}
