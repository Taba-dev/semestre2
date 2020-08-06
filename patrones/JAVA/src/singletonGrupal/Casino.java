package singletonGrupal;

public class Casino {
	
	private static Casino instancia = new Casino();
	private String nombreCasino;
	private Persona responsable;

	
	
	private Casino() {
		
	}

	public static Casino getInstancia() {
		return instancia;
	}

	
	
	public String getNombreCasino() {
		return nombreCasino;
	}

	public void setNombreCasino(String nombreCasino) {
		this.nombreCasino = nombreCasino;
	}

	public Persona getNombreResponsable() {
		return responsable;
	}

	public void setNombreResponsable(Persona nombreResponsable) {
		this.responsable = nombreResponsable;
	}

	public String toString() {
		return "El Casino es: " + this.nombreCasino + ", y su responsable es " + this.responsable.getNombrePersona(); 
	}
	
}
