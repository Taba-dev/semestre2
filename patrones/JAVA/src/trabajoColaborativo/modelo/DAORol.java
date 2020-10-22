package trabajoColaborativo.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAORol {

	private static final String ALL_ROL = "SELECT * FROM ROL";
	private static final String INSERT_ROL = "INSERT INTO ROL (ID_ROL, NOMBRE, DESCRIPCION) VALUES (ROL_SEQ.NEXTVAL, ?,?)";
	private static final String DELETE_ROL = "DELETE FROM ROL WHERE ID_ROL=?";
	private static final String UPDATE_ROL = "UPDATE ROL SET NOMBRE=?, DESCRIPCION=? WHERE ID_ROL=?";

	public static ArrayList<Rol> findAll() {
		ArrayList<Rol> rol = new ArrayList<Rol>();
		try {
			PreparedStatement st = DatabaseManager.getConnection().prepareStatement(ALL_ROL);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Rol r = new Rol(rs.getString("NOMBRE"),
						rs.getString("DESCRIPCION"));
				r.setIdRol(rs.getInt("ID_ROL"));
				rol.add(r);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rol;
	}

	public static boolean insert(Rol r) {
		try {
			PreparedStatement st = DatabaseManager.getConnection().prepareStatement(INSERT_ROL);

			st.setString(1, r.getNombre());
			st.setString(2, r.getDescripcion());
			return st.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean delete(int idRol) {
		try {
			PreparedStatement st = DatabaseManager.getConnection().prepareStatement(DELETE_ROL);
			st.setInt(1, idRol);
			return st.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean edit(Rol r) {
		try {
			PreparedStatement st = DatabaseManager.getConnection().prepareStatement(UPDATE_ROL);
			st.setString(1, r.getNombre());
			st.setString(2, r.getDescripcion());
			st.setInt(3, r.getIdRol());
			return st.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}

