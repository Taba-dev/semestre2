package ClaseManejadora;

public class Persona {
	

	String documento;
	String apellido1;
	String apellido2;
	String nombre1;
	String nombre2;
	
	
	public Persona(String documento, String apellido1, String apellido2, String nombre1, String nombre2) {
		super();
		this.documento = documento;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
	}


	public Persona() {
		// TODO Auto-generated constructor stub
	}


	public String getDocumento() {
		return documento;
	}


	public void setDocumento(String documento) {
		this.documento = documento;
	}


	public String getApellido1() {
		return apellido1;
	}


	public void setApellido1(String apellido) {
		this.apellido1 = apellido;
	}


	public String getApellido2() {
		return apellido2;
	}


	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}


	public String getNombre1() {
		return nombre1;
	}


	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}


	public String getNombre2() {
		return nombre2;
	}


	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}
	
	
	

}
