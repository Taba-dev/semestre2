package prueba;

public class Auto {
	String matricula;
	String fechaIngreso;
	String marca;
	String modelo;
	String idMecanico;
	
	
	public Auto(String matricula, String fechaIngreso, String marca, String modelo, String idMecanico) {
		super();
		this.matricula = matricula;
		this.fechaIngreso = fechaIngreso;
		this.marca = marca;
		this.modelo = modelo;
		this.idMecanico = idMecanico;
	}
	
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getIdMecanico() {
		return idMecanico;
	}


	public void setIdMecanico(String idMecanico) {
		this.idMecanico = idMecanico;
	}
	
	
	
	
}
