package AccesoBD;

import java.sql.*;

import javax.swing.JOptionPane;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//---------------------REFERENCIACION DE LIBRERIA---------------------
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Libreria referenciada");
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Libreria no referenciada");
			e.printStackTrace();
			
		}
		
		//---------------------INSTANCIAR EL OBJETO CONEXION---------------------
		
		Connection connection = null;
		
		try { 
			
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"JAVA",
					"JAVA");
			System.out.println("Logramos instanciar la conexion");
			
		} catch (SQLException e) {
			
			System.out.println("No logramos instanciar la conexion");
			e.printStackTrace();
			return;
			
		}
		
		//---------------------REALIZAR UNA CONSULTA---------------------


		String idPersonaST = JOptionPane.showInputDialog("Id: ");
		Integer idPersona; // Integer es el tipo wrapper del tipo nativo int
		idPersona = Integer.parseInt(idPersonaST);

		String documento = JOptionPane.showInputDialog("Documento: ");
		String apellido1 = JOptionPane.showInputDialog("Apellido1: ");
		String apellido2 = JOptionPane.showInputDialog("Apellido2: ");
		String nombre1 = JOptionPane.showInputDialog("Nombre1: ");
		String nombre2 = JOptionPane.showInputDialog("Nombre2: ");
		
		String INSERT_PERSONA = "INSERT INTO PERSONA (ID_PERSONA,DOCUMENTO,APELLIDO1, APELLIDO2, NOMBRE1, NOMBRE2) values (?,?,?,?,?,?)";
		
		String consulta = "SELECT NOMBRE1 FROM PERSONA";
	
		try {
			
			PreparedStatement statement = connection.prepareStatement(INSERT_PERSONA);
			statement.setInt(1, idPersona);
			statement.setString(2, documento);
			statement.setString(3, apellido1);
			statement.setString(4, apellido2);
			statement.setString(5, nombre1);
			statement.setString(6, nombre2);
			
			
			int filasIngresadas = statement.executeUpdate();
			
			System.out.println("Se ingresaron " + filasIngresadas + " filas");
			
			Statement sentencia = connection.createStatement();
			ResultSet personasRS = sentencia.executeQuery(consulta);
			while (personasRS.next()) {
				System.out.println("-> "+personasRS.getString("NOMBRE1"));
			}
			
		} catch (SQLException e) {
			
			System.out.println("Error al ejecutar la consulta");
			e.printStackTrace();
			return;
			
		}
		
		//---------------------CERRAR LA CONEXION---------------------	
		
		try {
			
			connection.close();
			System.out.println("Logramos cerrar la conexion");
			
		} catch (SQLException e) {
			
			System.out.println("No logramos cerrar la conexion");
			e.printStackTrace();
			return;
			
		}
			
	}

}
