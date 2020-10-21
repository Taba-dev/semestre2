package trabajoColaborativo.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class DAOFuncionalidad {

	private static final String ALL_FUNCIONALIDADES = "SELECT * FROM FUNCIONALIDAD";
	private static final String INSERT_FUNCIONALIDAD = "INSERT INTO FUNCIONALIDAD (ID_FUNCIONALIDAD, NOMBRE, DESCRIPCION) VALUES (FUNCIONALIDAD_SEQ.NEXTVAL, ?,?)";
	private static final String DELETE_FUNCIONALIDAD = "DELETE FROM FUNCIONALIDAD WHERE ID_FUNCIONALIDAD=?";
	private static final String UPDATE_FUNCIONALIDAD = "UPDATE FUNCIONALIDAD SET NOMBRE=?, DESCRIPCION=? WHERE ID_FUNCIONALIDAD=?";

	public static ArrayList<Funcionalidad> findAll() {
		ArrayList<Funcionalidad> funcionalidades = new ArrayList<Funcionalidad>();
		try {
			PreparedStatement st = DatabaseManager.getConnection().prepareStatement(ALL_FUNCIONALIDADES);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Funcionalidad f = new Funcionalidad(rs.getInt("ID_FUNCIONALIDAD"), rs.getString("NOMBRE"),
						rs.getString("DESCRIPCION"));
				funcionalidades.add(f);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return funcionalidades;
	}

	public static boolean insert(Funcionalidad f) throws Exception {
		try {
			PreparedStatement st = DatabaseManager.getConnection().prepareStatement(INSERT_FUNCIONALIDAD);

			st.setString(1, f.getNombre());
			st.setString(2, f.getDescripcion());
			return st.executeUpdate() > 0;

		} catch (SQLIntegrityConstraintViolationException ex) {
			throw new Exception("El rol ya esta registrado.");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean delete(int idFuncionalidad) {
		try {
			PreparedStatement st = DatabaseManager.getConnection().prepareStatement(DELETE_FUNCIONALIDAD);
			st.setInt(1, idFuncionalidad);
			return st.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean edit(Funcionalidad f) {
		try {
			PreparedStatement st = DatabaseManager.getConnection().prepareStatement(UPDATE_FUNCIONALIDAD);
			st.setString(1, f.getNombre());
			st.setString(2, f.getDescripcion());
			st.setInt(3, f.getId());
			return st.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
