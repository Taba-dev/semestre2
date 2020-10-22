package JTableGrupal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class DAOEmpleados {

	private static final String ALL_EMPLEADOS = "SELECT * FROM EMPLEADOS";
	// INSERT, AGREGO LA ID, POR SECUENCIA
	private static final String INSERTL_EMPLEADO = "INSERT INTO EMPLEADOS (ID_EMPLEADO, CEDULA, NOMBRE, APELLIDO) VALUES  (SEQ_ID_EMPLEADOS.NEXTVAL, ?, ?, ?)";
	private static final String UPDATE_EMPLEADO = "UPDATE EMPLEADOS SET  NOMBRE=?, APELLIDO=? WHERE CEDULA =?";
	private static final String DELETE_EMPLEADO = "DELETE FROM EMPLEADOS WHERE CEDULA=?";
	private static final String EMPLEADO_CI = "SELECT * FROM EMPLEADOS WHERE CEDULA=?";

	public static boolean insert(Empleado empleado) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERTL_EMPLEADO);

			statement.setString(1, empleado.getCedula());
			statement.setString(2, empleado.getNombre());
			statement.setString(3, empleado.getApellido());

			int retorno = statement.executeUpdate();

			return retorno > 0;

		} catch (SQLIntegrityConstraintViolationException ei) {//VALIDAMOS QUE NO SE REPITA LA CEDULA
			JOptionPane.showMessageDialog(null, "El documento ya esta registrado.", "Error",
					JOptionPane.ERROR_MESSAGE);//ENVIAMOS MENSAJE DE ERROR EN CASO QUE YA EXISTA LA CI
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public static boolean update(Empleado empleado) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE_EMPLEADO);

			statement.setString(1, empleado.getNombre());
			statement.setString(2, empleado.getApellido());
			statement.setString(3, empleado.getCedula());
			int retorno = statement.executeUpdate();

			return retorno > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public static boolean delete(Empleado empleado) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE_EMPLEADO);
			statement.setString(1, empleado.getCedula());

			int retorno = statement.executeUpdate();
			return retorno > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public static LinkedList<Empleado> findAll() {
		LinkedList<Empleado> empleados = new LinkedList<>();
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_EMPLEADOS);
			ResultSet resultado = statement.executeQuery();
			while (resultado.next()) {
				Empleado empleado = getEmpleadoFromResultSet(resultado);
				empleados.add(empleado);
			}

			return empleados;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static Empleado find(String ciEmpleado) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(EMPLEADO_CI);
			statement.setString(1, ciEmpleado);

			ResultSet resultado = statement.executeQuery();
			Empleado empleado = null;
			if (resultado.next()) {
				empleado = getEmpleadoFromResultSet(resultado);
			}
			return empleado;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static Empleado getEmpleadoFromResultSet(ResultSet resultado) throws SQLException {

		String nombre = resultado.getString("NOMBRE");
		String apellido = resultado.getString("APELLIDO");
		String cedula = resultado.getString("CEDULA");

		Empleado empleado = new Empleado(cedula, nombre, apellido);

		return empleado;

	}

}
