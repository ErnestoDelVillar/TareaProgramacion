package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Tienda implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Usuario> usuarios;
	private ArrayList<Componente> inventario;
	private ArrayList<Factura> facturas;
	private ArrayList<Cliente> clientes;
	private ArrayList<Suministrador> suministradores;
	private ArrayList<OrdenCompra> ordenesCompra;
	private ArrayList<Combo> combos;
	
	private int codUsuario;
	private int codComponente;
	private int codCombo;
	private int codFactura;
	private int codOrden;
	private int codSumi;
	
	private static Usuario loginUser;
	private static Tienda shop = null;
		
	private Tienda() {
		this.usuarios = new ArrayList<Usuario>();
		this.inventario = new ArrayList<Componente>();
		this.facturas = new ArrayList<Factura>();
		this.clientes = new ArrayList<Cliente>();
		this.suministradores = new ArrayList<Suministrador>();
		this.ordenesCompra = new ArrayList<OrdenCompra>();
		this.combos=new ArrayList<Combo>();
	}
	
	public static Tienda getInstance() {
		if (shop == null) {
			shop = new Tienda();
		}
		return shop;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public ArrayList<Componente> getInventario() {
		return inventario;
	}

	public void setInventario(ArrayList<Componente> inventario) {
		this.inventario = inventario;
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Suministrador> getSuministradores() {
		return suministradores;
	}

	public void setSuministradores(ArrayList<Suministrador> suministradores) {
		this.suministradores = suministradores;
	}

	public ArrayList<OrdenCompra> getOrdenesCompra() {
		return ordenesCompra;
	}

	public void setOrdenesCompra(ArrayList<OrdenCompra> ordenesCompra) {
		this.ordenesCompra = ordenesCompra;
	}
	
	public ArrayList<Combo> getCombos() {
		return combos;
	}

	public void setCombos(ArrayList<Combo> combos) {
		this.combos = combos;
	}

	public static Usuario getLoginUser() {
		return loginUser;
	}

	public static void setLoginUser(Usuario loginUser) {
		Tienda.loginUser = loginUser;
	}

	public static Tienda getTienda() {
		return shop;
	}

	public static void setTienda(Tienda tienda) {
		Tienda.shop = tienda;
	}
	
	
	public float montoTotalFactura(String codFactura) {
		Factura factura = buscarFacturaById(codFactura);
		if (factura != null) {
			return factura.precioTotal();
		} else {
			return -1;
		}
	}
	
	
	public Factura buscarFacturaById(String codFactura) {
		
		for(Factura f:facturas) {
			if(f.getId().equalsIgnoreCase(codFactura)) {
				return f;
			}
		}
		return null;
	}
	
	
	public Componente buscarComponenteById(String id) {
		
		for(Componente c : inventario) {
			if(c.getId().equalsIgnoreCase(id)) {
				return c;
			}
		}
		return null;
	}
	
	
	public Cliente buscarClienteByCedula(String cedula) {
		
		for(Cliente c : clientes) {
			if(c.getCedula().equalsIgnoreCase(cedula)) {
				return c;
			}
		}
		return null;
	}
	
	
	
	
	
}
