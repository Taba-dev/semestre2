package prueba;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class DAO { //DAO: DATA ACCES OBJECT
	
	//***************************************** CONSTANTES *****************************************
	
	private static final String CUENTA_MECANICOS = "SELECT COUNT (ID) AS CUENTA FROM MECANICOS";
	private static final String ALL_MECANICOS = "SELECT * FROM MECANICOS";
	private static final String INSERT_MECANICO = "INSERT INTO MECANICOS (ID,NOMBRE,CEDULA) values (?,?,?)";	
	private static final String DELETE_MECANICO = "DELETE FROM MECANICO WHERE ID_PERSONA=?";
	private static final String MAX_PK_MECANICOS = "SELECT MAX(ID) AS MAXID FROM MECANICOS";

	
	private static final String CUENTA_AUTOS = "SELECT COUNT (ID_PERSONA) AS CUENTA FROM PERSONA";
	private static final String ALL_AUTOS = "SELECT * FROM AUTOS";
	private static final String INSERT_AUTO = "INSERT INTO AUTOS (MATRICULA,FECHA_INGRESO,MARCA,MODELO,ID_MECANICO) values (?,?,?,?,?)";
	
	private static final String DELETE_AUTO = "DELETE FROM AUTOS WHERE MATRICULA=?";


	
	
	
	
	
	
	//***************************************** METODOS MECANICOS *****************************************
	
	
	//***************************************** CONTAR PERSONAS *****************************************
	public static int cuentaMecanicos() {
		int Cuenta = 0;
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(CUENTA_MECANICOS);
			ResultSet resultado = statement.executeQuery();
			while(resultado.next()) {
				Cuenta = resultado.getInt("CUENTA");	
			}
		} catch(SQLException e) {
			e.printStackTrace();	
		}
		return Cuenta;	
	}
	
	
	//***************************************** LISTAR MECANICOS *****************************************
	public static LinkedList<Mecanico> findAll() {
		LinkedList<Mecanico> mecanicos = new LinkedList<>();
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_MECANICOS);
			ResultSet resultado = statement.executeQuery();
			while(resultado.next()) {

				String nombre = resultado.getString("NOMBRE");
				String cedula = resultado.getString("CEDULA");
				
				Mecanico m = new Mecanico(nombre, cedula);
				mecanicos.add(m);
			}
		} catch(SQLException e) {
			e.printStackTrace();	
		}
		return mecanicos;
	}
	
	
	//***************************************** INSERTAR MECANICO *****************************************
	public static boolean insert(Mecanico m) {
		
		
		int maxID = 0;
		int nextID = 0;
		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(MAX_PK_MECANICOS);
			ResultSet resultado = statement.executeQuery();
			while(resultado.next()) {
				maxID = resultado.getInt("MAXID");	
			}
		} catch(SQLException e) {
			e.printStackTrace();	
		}
		nextID = maxID+1;

		try {
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_MECANICO);
			statement.setLong(1, nextID);
			statement.setString(2, m.getNombre());
			statement.setString(3, m.getCedula());
			int Retorno =statement.executeUpdate();
			return Retorno>0;
			
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
		

	//***************************************** ELIMINAR PERSONA *****************************************
	  public static boolean delete(int Id) {
		  Long IdPersona = new Long(Id);
		  try {
				PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE_MECANICO);
				statement.setLong(1, IdPersona);
				int Retorno =statement.executeUpdate();
				return Retorno>0;
				
		  } catch(SQLException e) {
				e.printStackTrace();
				return false;
		  }
	  }
	
	  
	  
	  
	  
	  
		//***************************************** METODOS AUTOS *****************************************
	  
		//***************************************** INSERTAR AUTO *****************************************	  
	  
	  
		public static boolean insertAuto(Auto a) {
			

			try {
				PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_AUTO);
				statement.setString(1, a.matricula);
				statement.setString(2, a.fechaIngreso);
				statement.setString(3, a.marca);
				statement.setString(4, a.modelo);
				statement.setString(5, a.idMecanico);
				

				int Retorno =statement.executeUpdate();
				return Retorno>0;
				
			} catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
			
		
		//***************************************** CONTAR AUTOS *****************************************
		public static int cuentaAutos() {
			int Cuenta = 0;
			try {
				PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(CUENTA_AUTOS);
				ResultSet resultado = statement.executeQuery();
				while(resultado.next()) {
					Cuenta = resultado.getInt("CUENTA");	
				}
			} catch(SQLException e) {
				e.printStackTrace();	
			}
			return Cuenta;	
		}
		
		
		//***************************************** LISTAR MECANICOS *****************************************
		public static LinkedList<Auto> findAllAutos() {
			LinkedList<Auto> autos = new LinkedList<>();
			try {
				PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_AUTOS);
				ResultSet resultado = statement.executeQuery();
				while(resultado.next()) {

					String matricula = resultado.getString("MATRICULA");
					String fechaIngreso = resultado.getString("FECHA_INGRESO");
					String marca = resultado.getString("MARCA");
					String modelo = resultado.getString("MODELO");
					String idMecanico = resultado.getString("ID_MECANICO");
					
					Auto a = new Auto(matricula, fechaIngreso, marca, modelo, idMecanico);
					autos.add(a);
				}
			} catch(SQLException e) {
				e.printStackTrace();	
			}
			return autos;
		}
		
	  
		//***************************************** ELIMINAR PERSONA *****************************************
		  public static boolean deleteAuto(String matricula) {
			  String matriculaAuto = new String(matricula);
			  try {
					PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE_AUTO);
					statement.setString(1, matriculaAuto);
					int Retorno =statement.executeUpdate();
					return Retorno>0;
					
			  } catch(SQLException e) {
					e.printStackTrace();
					return false;
			  }
		  }
		
		  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	
	  
}
