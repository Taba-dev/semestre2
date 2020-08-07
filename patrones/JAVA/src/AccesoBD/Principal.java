package AccesoBD;

import java.sql.*;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try { //refereciacion de libreria
			
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
		
		String consulta = "SELECT * FROM PERSONA";
		
		try {
			
			Statement sentencia = connection.createStatement();
			ResultSet personasRS = sentencia.executeQuery(consulta);
			while (personasRS.next()) {
				System.out.println("-> "+personasRS.getString("DOCUMENTO")+", "+personasRS.getString("APELLIDO1")+", "+personasRS.getString("NOMBRE1"));
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
