package trabajoColaborativo;

import java.util.ArrayList;

public class Rol {

	private String nombre;
	private String descripcion;
	
	private ArrayList<Funcionalidad> funcionalidades;

	public Rol(String nombre, String descripcion, ArrayList funcionalidades) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.funcionalidades = funcionalidades;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ArrayList getFuncionalidades() {
		return funcionalidades;
	}

	public void setFuncionalidades(ArrayList funcionalidades) {
		this.funcionalidades = funcionalidades;
	}
	
	
	
	
}
