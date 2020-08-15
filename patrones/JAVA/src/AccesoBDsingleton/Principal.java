package AccesoBDsingleton;

import java.sql.Connection;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection connection = DatabaseManager.getConnection();
		
	}

}
