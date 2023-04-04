package logico;

import java.util.ArrayList;

public class Combo {
	
	private String codigo;
	private String id;
	private String nombre;
	private ArrayList<Componente> misComponentes;
	private int descuento;
	
	public Combo(String codigo, String id, String nombre, ArrayList<Componente> misComponentes, int descuento) {
		super();
		this.codigo = codigo;
		this.id = id;
		this.nombre = nombre;
		this.misComponentes = misComponentes;
		this.descuento = descuento;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public ArrayList<Componente> getMisComponentes() {
		return misComponentes;
	}

	public void setMisComponentes(ArrayList<Componente> misComponentes) {
		this.misComponentes = misComponentes;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	public float precio() 
	{
		float total = 0;
		for (Componente c : componentes)
		{
			total += c.getPrecio();
		}
		return total - (total * ((float)descuento/100) );
	}
	
}
