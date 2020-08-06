package singletonGrupal;

public class Persona {
	
	private String nombrePersona;
	private int cedulaPersona;
	private Status statusPersona;

	public Persona(String nombrePersona, int cedulaPersona, Status statusPersona) {
		this.nombrePersona = nombrePersona;
		this.cedulaPersona = cedulaPersona;
		this.statusPersona = statusPersona;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public int getCedulaPersona() {
		return cedulaPersona;
	}

	public void setCedulaPersona(int cedulaPersona) {
		this.cedulaPersona = cedulaPersona;
	}

	public Status getStatusPersona() {
		return statusPersona;
	}

	public void setStatusPersona(Status statusPersona) {
		this.statusPersona = statusPersona;
	}

	public String toString() {
		return "Esta Persona es: " + this.nombrePersona + ", su cedula es " + this.cedulaPersona + ", y su status es " + this.statusPersona; 
	}	
	
	
	
}
