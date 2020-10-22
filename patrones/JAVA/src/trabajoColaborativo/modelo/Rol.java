package trabajoColaborativo.modelo;

//import java.util.ArrayList;

public class Rol {

	private int idRol;
	private String nombre;
	private String descripcion;
	// private ArrayList<Funcionalidad> funcionalidades;

	public Rol(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Rol() {
		super();
	}

	public Rol(int idRol, String nombre, String descripcion) {
		super();
		this.idRol = idRol;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
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

//	public ArrayList<Funcionalidad> getFuncionalidades() {
//		return funcionalidades;
//	}
//
//	public void setFuncionalidades(ArrayList<Funcionalidad> funcionalidades) {
//		this.funcionalidades = funcionalidades;
//	}

	@Override
	public String toString() {
		return idRol + " Rol [nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
}
