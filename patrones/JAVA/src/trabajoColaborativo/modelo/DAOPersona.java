package trabajoColaborativo.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOPersona {
	private static final String ALL_PERSONAS = "SELECT * FROM PERSONAS";
	private static final String INSERT_PERSONAS = "INSERT INTO PERSONAS (ID_PERSONA,DOCUMENTO,APELLIDO1,APELLIDO2,NOMBRE1,NOMBRE2,FECHA_NAC,CLAVE,MAIL,ID_ROL) values (PERSONA_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?)";
	private static final String BUSCAR_PERSONAS = "SELECT * FROM PERSONAS WHERE DOCUMENTO=?";
	private static final String UPDATE_PERSONA = "UPDATE PERSONAS SET DOCUMENTO=?,NOMBRE1=?,NOMBRE2=?,APELLIDO1=?,APELLIDO2=?,FECHA_NAC=?,CLAVE=?,MAIL=?,ID_ROL=? WHERE ID_PERSONA =?";
	private static final String DELETE_PERSONA = "DELETE FROM PERSONAS WHERE ID_PERSONA=?";

	public static boolean insert(Persona p) {

		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_PERSONAS);

			statement.setString(1, p.getDocumento());
			statement.setString(2, p.getApellido1());
			statement.setString(3, p.getApellido2());
			statement.setString(4, p.getNombre1());
			statement.setString(5, p.getNombre2());
			statement.setString(6, p.getFechaNac());
			statement.setString(7, p.getClave());
			statement.setString(8, p.getMail());
			statement.setInt(9, p.getRol().getIdRol());

			int Retorno = statement.executeUpdate();
			return Retorno > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static ArrayList<Persona> findAll() {
		ArrayList<Persona> personas = new ArrayList<Persona>();
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_PERSONAS);
			ResultSet resultado = statement.executeQuery();
			while (resultado.next()) {
				Persona persona = getPersonaFromResultSet(resultado);
				personas.add(persona);
			}
			return personas;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Persona findPersona(String documento) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(BUSCAR_PERSONAS);
			statement.setString(1, documento);

			ResultSet resultado = statement.executeQuery();
			Persona persona = null;
			if (resultado.next()) {
				persona = getPersonaFromResultSet(resultado);
			}
			return persona;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static Persona getPersonaFromResultSet(ResultSet resultado) throws SQLException {
		int id = resultado.getInt("ID_PERSONA");
		String documento = resultado.getString("DOCUMENTO");
		String apellido1 = resultado.getString("APELLIDO1");
		String apellido2 = resultado.getString("APELLIDO2");
		String nombre1 = resultado.getString("NOMBRE1");
		String nombre2 = resultado.getString("NOMBRE2");
		String fechaNac = resultado.getString("FECHA_NAC");
		String clave = resultado.getString("CLAVE");
		String mail = resultado.getString("MAIL");

		Persona persona = new Persona(id, documento, apellido1, apellido2, nombre1, nombre2, fechaNac, clave, mail, null);

		return persona;

	}

	public static boolean update(Persona persona) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE_PERSONA);

			statement.setString(1, persona.getDocumento());
			statement.setString(2, persona.getNombre1());
			statement.setString(3, persona.getNombre2());
			statement.setString(4, persona.getApellido1());
			statement.setString(5, persona.getApellido2());
			statement.setString(6, persona.getFechaNac());
			statement.setString(7, persona.getClave());
			statement.setString(8, persona.getMail());
			statement.setInt(9, persona.getRol().getIdRol());
			statement.setInt(10, persona.getId());
			int retorno = statement.executeUpdate();

			return retorno > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean delete(Persona p) {
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE_PERSONA);
			statement.setInt(1, p.getId());

			int retorno = statement.executeUpdate();
			return retorno > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

}
