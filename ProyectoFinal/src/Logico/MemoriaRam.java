package Logico;

public class MemoriaRam extends Componente {
	
	private float cantMemoria;
	private String tipoMemoria;
	
	public MemoriaRam(String id, String marca, String serial, float precio, int cantMin, int cantMax, int cantReal,
			float cantMemoria, String tipoMemoria) {
		super(id, marca, serial, precio, cantMin, cantMax, cantReal);
		this.cantMemoria = cantMemoria;
		this.tipoMemoria = tipoMemoria;
	}

	public float getCantMemoria() {
		return cantMemoria;
	}

	public void setCantMemoria(Float float1) {
		this.cantMemoria = float1;
	}

	public String getTipoMemoria() {
		return tipoMemoria;
	}

	public void setTipoMemoria(String tipoMemoria) {
		this.tipoMemoria = tipoMemoria;
	}
	
	
}