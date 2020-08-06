package singletonIndividual;

public class Robot {

	private static Robot instancia = new Robot();
	private String nombreRobot;
	private byte cantidadVidasRobot;
	
	private Robot() {
		
	}

	public static Robot getInstancia() {
		return instancia;
	}

	public String getNombreRobot() {
		return nombreRobot;
	}

	public void setNombreRobot(String nombreRobot) {
		this.nombreRobot = nombreRobot;
	}

	public byte getCantidadVidasRobot() {
		return cantidadVidasRobot;
	}

	public void setCantidadVidasRobot(byte cantidadVidasRobot) {
		this.cantidadVidasRobot = cantidadVidasRobot;
	}
	
	public String toString() {
		return "El Robot es: " + this.nombreRobot + ", y tiene " + this.cantidadVidasRobot + " vidas."; 
	}
	
}
