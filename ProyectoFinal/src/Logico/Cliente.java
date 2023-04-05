package Logico;

public class Cliente {
	
	private String cedula;
	private String nombre;
	private String direccion;
	private String telefono;
	private float credito;
	private float creditoEnUso;
	public Cliente(String cedula, String nombre, String direccion, String telefono, float credito, float creditoEnUso) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.credito = credito;
		this.creditoEnUso = creditoEnUso;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public float getCredito() {
		return credito;
	}

	public void setCredito(float credito) {
		this.credito = credito;
	}

	public float getCreditoEnUso() {
		return creditoEnUso;
	}

	public void setCreditoEnUso(float creditoEnUso) {
		this.creditoEnUso = creditoEnUso;
	}
	
	
}