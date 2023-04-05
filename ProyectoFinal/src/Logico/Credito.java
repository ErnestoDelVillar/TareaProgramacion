package Logico;

public class Credito extends Factura {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int diasCredito;
	private boolean pendiente;
	
	public Credito(String id, Cliente cliente, int descuento, Usuario usuario, int diasCredito) {
		super(id, cliente, descuento, usuario);
		this.diasCredito = diasCredito;
		this.pendiente = true;
	}

	public int getDiasCredito() {
		return diasCredito;
	}

	public void setDiasCredito(int diasCredito) {
		this.diasCredito = diasCredito;
	}

	public boolean isPendiente() {
		return pendiente;
	}

	public void setPendiente(boolean pendiente) {
		this.pendiente = pendiente;
	}
}