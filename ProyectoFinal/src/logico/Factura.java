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
	
	public String generarTextoDeVenta() 
	{
    		String texto = generarTextoDeCabecera();
    		texto += generarTextoDeComponentes();
    		texto += generarTextoDeCombos();
   		texto += "\nTotal: $" + precioTotal();
   		return texto;
	}

	private String generarTextoDeCabecera() 
	{
    		DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
    		String strFecha = formatoFecha.format(fecha);
    		String texto = "ID: " + id + "\n";
    		texto += "Fecha: " + strFecha + "\n";
    		texto += "Cliente: " + cliente.getNombre() + "\n";
    		texto += "Vendedor: " + vendedor.getNombre() + "\n";
    		return texto;
	}

	private String generarTextoDeComponentes() 
	{
    		String texto = "\nComponentes: \n";
    		texto += "\tID Componente     Tipo           Precio\n";
    		for (Componente componente : venta) 
		{
        		String tipo = obtenerTipoDeComponente(componente);
        		texto += String.format("\t %-18s%-15s%-10.4f\n", componente.getId(), tipo, componente.getPrecio());
    		}
    		return texto;
	}

	private String obtenerTipoDeComponente(Componente componente) 
	{
    		if (componente instanceof Ram) 
		{
        		return "RAM";
    		} 
		else if (componente instanceof MotherBoard) 
		{
        		return "MotherBoard";
    		} 
		else if (componente instanceof MicroProcesador) 
		{
        		return "Micro";
    		} 
		else if (componente instanceof DiscoDuro) 
		{
        		return "Disco Duro";
    		} 
		else 
		{
        		return "";
    		}
	}

	private String generarTextoDeCombos() 
	{
		String texto = "\nCombos: \n";
    		texto += "\tID Combo          Descuento      Precio\n";
    	
		for (Combo combo : ventaCombos) 
		{
        		texto += String.format("\t %-18s%-12d   %-10.4f\n", combo.getId(), combo.getDescuento(), combo.precio());
    		}
    		return texto;
	}
}
