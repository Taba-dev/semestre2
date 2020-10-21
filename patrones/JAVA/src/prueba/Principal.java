package prueba;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int b = DAO.cuentaMecanicos();
		System.out.println("hay " + b + " mecanicos registrados");

		LinkedList<Mecanico> mecanicos = DAO.findAll();
		for (int num = 0; num < mecanicos.size(); num++) {
			System.out.println(mecanicos.get(num).nombre);
		}

		
		String nombre = JOptionPane.showInputDialog("Nombre: ");
		String cedula = JOptionPane.showInputDialog("Cedula: ");
		Mecanico m = new Mecanico(nombre, cedula);
		DAO.insert(m);
		
		
		
		String matricula = JOptionPane.showInputDialog("Matricula: ");
		String fechaIngreso = JOptionPane.showInputDialog("Fecha de Ingreso: ");
		String marca = JOptionPane.showInputDialog("Marca: ");
		String modelo = JOptionPane.showInputDialog("Modelo: ");
		String idMecanico = JOptionPane.showInputDialog("Id del mecanico: ");
		Auto a = new Auto(matricula, fechaIngreso, marca, modelo, idMecanico);
		DAO.insertAuto(a);
		
		LinkedList<Auto> autos = DAO.findAllAutos();
		for (int num = 0; num < autos.size(); num++) {
			System.out.println(autos.get(num).matricula);
		}
		
		
		
	}

}
