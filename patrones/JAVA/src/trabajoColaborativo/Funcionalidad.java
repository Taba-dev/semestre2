package trabajoColaborativo;

public class Funcionalidad {

	private String nombre;
	private String descripcion;
	
	
	
	private boolean acceso(Persona p) {
		return false;
		
	}



	public Funcionalidad(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
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
	
	
	
	
}
