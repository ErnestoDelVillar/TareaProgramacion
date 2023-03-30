package logico;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
	
	private static String codigo;
	private String id;
	private Date fecha;
	private int descuento;
	private Cliente cliente;
	private ArrayList<Componente> Venta;
	private ArrayList<Combo> VCOmbo;
	
	public Factura(String id, Date fecha, int descuento, Cliente cliente, ArrayList<Componente> venta,
			ArrayList<Combo> vCOmbo) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.descuento = descuento;
		this.cliente = cliente;
		Venta = venta;
		VCOmbo = vCOmbo;
	}

	public static String getCodigo() {
		return codigo;
	}

	public static void setCodigo(String codigo) {
		Factura.codigo = codigo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Componente> getVenta() {
		return Venta;
	}

	public void setVenta(ArrayList<Componente> venta) {
		Venta = venta;
	}

	public ArrayList<Combo> getVCOmbo() {
		return VCOmbo;
	}

	public void setVCOmbo(ArrayList<Combo> vCOmbo) {
		VCOmbo = vCOmbo;
	}
	
	
}
