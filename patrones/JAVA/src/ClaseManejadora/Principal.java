package ClaseManejadora;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {

		System.out.println();
		System.out.println("*************** DAO PERSONA ***************");
		System.out.println();
		
		
		String documento = JOptionPane.showInputDialog("Documento: ");
		String apellido1 = JOptionPane.showInputDialog("Apellido1: ");
		String apellido2 = JOptionPane.showInputDialog("Apellido2: ");
		String nombre1 = JOptionPane.showInputDialog("Nombre1: ");
		String nombre2 = JOptionPane.showInputDialog("Nombre2: ");

		Persona p = new Persona(documento, apellido1, apellido2, nombre1, nombre2);

		if (DAOPersona.insert(p)) {
			System.out.println("Se ha insertado una persona en la base de datos.");
		} else {
			System.out.println("No se ha insertado una persona en la base de datos.");
		}

		int cuenta = DAOPersona.cuentaPersonas();
		if (cuenta > 0) {
			System.out.println("Hay " + cuenta + " registros en la tabla PERSONA");
			LinkedList<Persona> personas = null;
			personas = DAOPersona.findAll();
			for (Persona p1 : personas) {
				System.out.println(p1.nombre1);
			}
		} else {
			System.out.println("No hay registros en la tabla PERSONA");
		}
		
		
		/*
		 * String apellidoBuscar = JOptionPane.showInputDialog("Apellido1: "); String
		 * nombreBuscar = JOptionPane.showInputDialog("Nombre1: "); Persona
		 * personaEncontrada = DAOPersona.findPersona(apellidoBuscar, nombreBuscar);
		 * System.out.println("Se encontro a: "+personaEncontrada.nombre1+" "
		 * +personaEncontrada.apellido1+" que posee el documento "+personaEncontrada.
		 * documento);
		 */
		

		/*
		 * boolean asd = DAOPersona.delete(200); System.out.println(asd);
		 */
		
		
		
		String editDocumento = JOptionPane.showInputDialog("Documento: ");
		String editApellido1 = JOptionPane.showInputDialog("Apellido1: ");
		String editApellido2 = JOptionPane.showInputDialog("Apellido2: ");
		String editNombre1 = JOptionPane.showInputDialog("Nombre1: ");
		String editNombre2 = JOptionPane.showInputDialog("Nombre2: ");
		
		Persona personaEditada = new Persona(editDocumento, editApellido1, editApellido2, editNombre1, editNombre2);
		
		DAOPersona.edit(200, personaEditada);
		
		
		
	}

}
