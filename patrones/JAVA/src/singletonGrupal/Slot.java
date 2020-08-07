package singletonGrupal;

public class Slot extends Juego{

	private TipoSlot tipoSlot;

	public Slot(String nombreJuego, TipoSlot tipoSlot) {
		super(nombreJuego);
		this.tipoSlot = tipoSlot;
	}

	public TipoSlot getTipoSlot() {
		return tipoSlot;
	}

	public void setTipoSlot(TipoSlot tipoSlot) {
		this.tipoSlot = tipoSlot;
	}
	
}
