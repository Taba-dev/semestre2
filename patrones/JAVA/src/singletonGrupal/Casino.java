package singletonGrupal;

import java.util.ArrayList;

public class Casino {
	
	private static Casino instancia = new Casino();
	private String nombreCasino;
	private Persona responsable;
	private ArrayList<Slot> listaSlot;
	private ArrayList<Slot> listaMesa;
	private int MaxSlots;
	private int MaxMesa;

	
	
	private void agregarSlot(Slot s) {
		
	};
	
	private void agregarMesa(Mesa m) {
		
	};
	
	
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
	
	public ArrayList<Slot> getListaSlot() {
		return listaSlot;
	}

	public void setListaSlot(ArrayList<Slot> listaSlot) {
		this.listaSlot = listaSlot;
	}

	public ArrayList<Slot> getListaMesa() {
		return listaMesa;
	}

	public void setListaMesa(ArrayList<Slot> listaMesa) {
		this.listaMesa = listaMesa;
	}

	public int getMaxSlots() {
		return MaxSlots;
	}

	public void setMaxSlots(int maxSlots) {
		MaxSlots = maxSlots;
	}

	public int getMaxMesa() {
		return MaxMesa;
	}

	public void setMaxMesa(int maxMesa) {
		MaxMesa = maxMesa;
	}

	public String toString() {
		return "El Casino es: " + this.nombreCasino + ", y su responsable es " + this.responsable.getNombrePersona(); 
	}
	
}
