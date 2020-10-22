package prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

	private static Connection databaseConnection;

	private static String CONNECTION_STRING = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USUARIO = "SISTEMA";
	private static String CLAVE = "SISTEMA";

	static {

		databaseConnection = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Libreria referenciada");

			try {

				databaseConnection = DriverManager.getConnection(CONNECTION_STRING, USUARIO, CLAVE);
				System.out.println("Logramos instanciar la conexion");

			} catch (SQLException e) {

				System.out.println("No logramos instanciar la conexion");
				e.printStackTrace();

			}

		} catch (ClassNotFoundException e) {

			System.out.println("Libreria no referenciada");
			e.printStackTrace();

		}

	}

	public static Connection getConnection() {
		return databaseConnection;
	}
	
}
