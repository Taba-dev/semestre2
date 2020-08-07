package singletonGrupal;

public class Mesa extends Juego{
	
	private int areaMesa;
	private int jugadoresMin;
	private int jugadoresMax;
	
	public Mesa(String nombreJuego, int areaMesa, int jugadoresMin, int jugadoresMax) {
		super(nombreJuego);
		this.areaMesa = areaMesa;
		this.jugadoresMin = jugadoresMin;
		this.jugadoresMax = jugadoresMax;
	}

	public int getAreaMesa() {
		return areaMesa;
	}

	public void setAreaMesa(int areaMesa) {
		this.areaMesa = areaMesa;
	}

	public int getJugadoresMin() {
		return jugadoresMin;
	}

	public void setJugadoresMin(int jugadoresMin) {
		this.jugadoresMin = jugadoresMin;
	}

	public int getJugadoresMax() {
		return jugadoresMax;
	}

	public void setJugadoresMax(int jugadoresMax) {
		this.jugadoresMax = jugadoresMax;
	}
	
}
