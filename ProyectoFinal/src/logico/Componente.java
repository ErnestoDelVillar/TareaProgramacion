package logico;

public class Componente {
	
	protected static String codigo;
	protected String id;
	protected String marca;
	protected String serial;
	protected float precio;
	protected int cantMin;
	protected int cantMax;
	protected int cantReal;
	
	public Componente(String id, String marca, String serial, float precio, int cantMin, int cantMax, int cantReal) {
		super();
		this.id = id;
		this.marca = marca;
		this.serial = serial;
		this.precio = precio;
		this.cantMin = 0;
		this.cantMax = 0;
		this.cantReal = 0;
	}

	public static String getCodigo() {
		return codigo;
	}

	public static void setCodigo(String codigo) {
		Componente.codigo = codigo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantMin() {
		return cantMin;
	}

	public void setCantMin(int cantMin) {
		this.cantMin = cantMin;
	}

	public int getCantMax() {
		return cantMax;
	}

	public void setCantMax(int cantMax) {
		this.cantMax = cantMax;
	}

	public int getCantReal() {
		return cantReal;
	}

	public void setCantReal(int cantReal) {
		this.cantReal = cantReal;
	}
	
	
}
