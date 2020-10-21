package trabajoColaborativo.modelo;

import java.sql.*;

public class DatabaseManager {

	private static Connection databaseConnection;
	private static String CONNECTION_STRING = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USUARIO = "INSTITUTO";
	private static String CLAVE = "INSTITUTO";

	static {
		databaseConnection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Se encontro el driver Oracle DB.");

			try {
				databaseConnection = DriverManager.getConnection(CONNECTION_STRING, USUARIO, CLAVE);
				System.out.println("Conectado con exito!.");
			} catch (SQLException e) {
				System.out.println("No se pudo conectar a la base de datos.");
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("No tienes el driver.");
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		return databaseConnection;
	}

}
