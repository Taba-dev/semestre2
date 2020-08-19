package ClaseManejadora;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class DAOPersona { //DAO: DATA ACCES OBJECT
	
	//***************************************** VARIABLES *****************************************
	
	private static final String CUENTA_PERSONAS = "SELECT COUNT (ID_PERSONA) AS CUENTA FROM PERSONA";
	private static final String ALL_PERSONAS = "SELECT * FROM PERSONA";
	private static final String INSERT_PERSONA = "INSERT INTO PERSONA (ID_PERSONA,DOCUMENTO,APELLIDO1,APELLIDO2,NOMBRE1,NOMBRE2) values (?,?,?,?,?,?)";
	private static final String BUSCAR_PERSONA = "SELECT * FROM PERSONA WHERE APELLIDO1=? AND NOMBRE1=?";
	private static final String UPDATE_PERSONA = "UPDATE PERSONA SET DOCUMENTO=?, APELLIDO1=?, APELLIDO2=?, NOMBRE1=?, NOMBRE2=? WHERE ID_PERSONA=?";
	private static final String DELETE_PERSONA = "DELETE FROM PERSONA WHERE ID_PERSONA=?";
	private static final String MAX_PK = "SELECT MAX(ID_PERSONA) AS MAXID FROM PERSONA";

	
	
	//***************************************** METODOS *****************************************
	
	
	//***************************************** CONTAR PERSONAS *****************************************
	public static int cuentaPersonas() {
		int Cuenta = 0;
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(CUENTA_PERSONAS);
			ResultSet resultado = statement.executeQuery();
			while(resultado.next()) {
				Cuenta = resultado.getInt("CUENTA");	
			}
		} catch(SQLException e) {
			e.printStackTrace();	
		}
		return Cuenta;	
	}
	
	
	//***************************************** LISTAR PERSONAS *****************************************
	public static LinkedList<Persona> findAll() {
		LinkedList<Persona> personas = new LinkedList<>();
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_PERSONAS);
			ResultSet resultado = statement.executeQuery();
			while(resultado.next()) {
				int idPersona = resultado.getInt("ID_PERSONA");
				String documento = resultado.getString("DOCUMENTO");
				String apellido1 = resultado.getString("APELLIDO1");
				String apellido2 = resultado.getString("APELLIDO2");
				String nombre1 = resultado.getString("NOMBRE1");
				String nombre2 = resultado.getString("NOMBRE2");
				
				Persona p = new Persona(documento, apellido1, apellido2, nombre1, nombre2);
				personas.add(p);
			}
		} catch(SQLException e) {
			e.printStackTrace();	
		}
		return personas;
	}
	
	
	//***************************************** INSERTAR PERSONA *****************************************
	public static boolean insert(Persona p) {
		
		
		int maxID = 0;
		int nextID = 0;
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(MAX_PK);
			ResultSet resultado = statement.executeQuery();
			while(resultado.next()) {
				maxID = resultado.getInt("MAXID");	
			}
		} catch(SQLException e) {
			e.printStackTrace();	
		}
		nextID = maxID+1;

		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_PERSONA);
			statement.setLong(1, nextID);
			statement.setString(2, p.getDocumento());
			statement.setString(3, p.getApellido1());
			statement.setString(4, p.getApellido2());
			statement.setString(5, p.getNombre1());
			statement.setString(6, p.getNombre2());
			int Retorno =statement.executeUpdate();
			return Retorno>0;
			
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
		
	
	//***************************************** BUSCAR PERSONA *****************************************
	public static Persona findPersona(String apellido1, String nombre1) {
		Persona personaEncontrada = new Persona();
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(BUSCAR_PERSONA);
			statement.setString(1, apellido1);
			statement.setString(2, nombre1);
			ResultSet resultado = statement.executeQuery();
			while(resultado.next()) {
				
				personaEncontrada.setDocumento(resultado.getString("DOCUMENTO"));
				personaEncontrada.setApellido1(resultado.getString("APELLIDO1"));
				personaEncontrada.setApellido2(resultado.getString("APELLIDO2"));
				personaEncontrada.setNombre1(resultado.getString("NOMBRE1"));
				personaEncontrada.setNombre2(resultado.getString("NOMBRE2"));
			}	
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return personaEncontrada;
	}
	
	
	//***************************************** EDITAR PERSONA *****************************************
	public static boolean edit(int IdPersona, Persona p) {


		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE_PERSONA);
			statement.setString(1, p.getDocumento());
			statement.setString(2, p.getApellido1());
			statement.setString(3, p.getApellido2());
			statement.setString(4, p.getNombre1());
			statement.setString(5, p.getNombre2());
			statement.setLong(6, IdPersona);

			int Retorno = statement.executeUpdate();
			return Retorno>0;
			
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

  
	//***************************************** ELIMINAR PERSONA *****************************************
	  public static boolean delete(int IdEmpleado) {
		  Long IdPersona = new Long(IdEmpleado);
		  try {
				PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE_PERSONA);
				statement.setLong(1, IdPersona);
				int Retorno =statement.executeUpdate();
				return Retorno>0;
				
		  } catch(SQLException e) {
				e.printStackTrace();
				return false;
		  }
	  }
	
}
