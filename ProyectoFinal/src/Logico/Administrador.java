package Logico;

import java.io.Serializable;

public class Administrador extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private float salario;
	
	public Administrador(String id, String nombre, String userName, String passWord,float salario) {
		super(id, nombre, userName, passWord);
		this.salario=salario;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}
	
}