package logico;

import java.util.ArrayList;

public class Tienda {
	
	private ArrayList<Cliente> misClientes;
	private ArrayList<Componente> misComp;
	private ArrayList<Factura> misFacturas;
	private ArrayList<Combo> misCombos;
	private String codCliente;
	private String codComp;
	private String codFactura;
	private String codCombo;
	
	public Tienda(ArrayList<Cliente> misClientes, ArrayList<Componente> misComp, ArrayList<Factura> misFacturas,
			ArrayList<Combo> misCombos, String codCliente, String codComp, String codFactura, String codCombo) {
		super();
		this.misClientes = misClientes;
		this.misComp = misComp;
		this.misFacturas = misFacturas;
		this.misCombos = misCombos;
		this.codCliente = codCliente;
		this.codComp = codComp;
		this.codFactura = codFactura;
		this.codCombo = codCombo;
	}

	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}

	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}

	public ArrayList<Componente> getMisComp() {
		return misComp;
	}

	public void setMisComp(ArrayList<Componente> misComp) {
		this.misComp = misComp;
	}

	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}

	public void setMisFacturas(ArrayList<Factura> misFacturas) {
		this.misFacturas = misFacturas;
	}

	public ArrayList<Combo> getMisCombos() {
		return misCombos;
	}

	public void setMisCombos(ArrayList<Combo> misCombos) {
		this.misCombos = misCombos;
	}

	public String getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}

	public String getCodComp() {
		return codComp;
	}

	public void setCodComp(String codComp) {
		this.codComp = codComp;
	}

	public String getCodFactura() {
		return codFactura;
	}

	public void setCodFactura(String codFactura) {
		this.codFactura = codFactura;
	}

	public String getCodCombo() {
		return codCombo;
	}

	public void setCodCombo(String codCombo) {
		this.codCombo = codCombo;
	}
	
	
}
