package manejadoresDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import entidades.Imc;
import entidades.Usuario;
import manejadoresDAO.DatabaseManager;
import java.util.Date;
import java.util.LinkedList;


public class ImcDAO {

	private static final String INSERT_IMC = "INSERT INTO IMC (ID_IMC,FECHA,ALTURA,PESO,ID_USUARIO) VALUES (?,?,?,?,?)";
	private static final String ALL_IMC = "SELECT * FROM IMC";
	private static final String UPDATE_IMC = "UPDATE IMC SET FECHA=?,ALTURA=?,PESO=?,ID_USUARIO=? WHERE ID_IMC=?";
	private static final String DELETE_IMC = "DELETE FROM IMC WHERE ID_IMC=?";
	private static final String IMC_ID = "SELECT * FROM IMC WHERE ID_IMC=?";
	
	//Insertar IMC pasado por parámetro.
	public static boolean insert(Imc imc){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_IMC);
			statement.setInt(1, imc.getIdImc());
			statement.setDate(2,new java.sql.Date(imc.getFecha().getTime()));
			statement.setDouble(3, imc.getAltura());
			statement.setDouble(4, imc.getPeso());
			statement.setInt(5, imc.getUsuario().getIdUsuario());
														
			int retorno = statement.executeUpdate();
									
			return retorno>0;
				
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	//Editar IMC pasado por parámetro.
	public static boolean edit(Imc imc){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE_IMC);
			statement.setDate(1,new java.sql.Date(imc.getFecha().getTime()));
			statement.setDouble(2, imc.getAltura());
			statement.setDouble(3, imc.getPeso());
			statement.setInt(4, imc.getUsuario().getIdUsuario());
			statement.setInt(5, imc.getIdImc());
			statement.execute();
		
			int retorno = statement.executeUpdate();
		
			return retorno>0;
			}catch(SQLException e){
				e.printStackTrace();
				return false;
			}
	}
	
	//Borrar IMC pasado por parámetro.
	public static boolean delete(Imc imc){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE_IMC);
			statement.setInt(1, imc.getIdImc());
			
			int retorno = statement.executeUpdate();
		
			return retorno>0;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	//Obtener todos los IMC.
	public static LinkedList<Imc> findAll(){
		LinkedList<Imc> imcs = new LinkedList<>();
		
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_IMC);
			ResultSet resultado = statement.executeQuery();
				while (resultado.next()){
					Imc imc = getImcFromResultSet(resultado);
					imcs.add(imc);
				}
		
				return imcs;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	//Obtener un IMC por ID.
	public static Imc find(int idImc){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(IMC_ID);
			statement.setInt(1, idImc);
			ResultSet resultado = statement.executeQuery();
			Imc imc = null;
				if (resultado.next()){
					imc = getImcFromResultSet(resultado);
				}
					return imc;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	//Método auxiliar para mappear la clase Imc.
	private static Imc getImcFromResultSet(ResultSet resultado) throws SQLException{
		int idImc = resultado.getInt("ID_IMC");
		Date fecha = new Date(resultado.getDate("FECHA").getTime());
		double altura = resultado.getDouble("ALTURA");
		double peso = resultado.getDouble("PESO");
		int idUsaurio = resultado.getInt("ID_USUARIO");
		Usuario usuario = null;
		usuario = UsuarioDAO.find(idUsuario);
		Imc imc = new Imc(idImc,fecha,altura,peso,usuario);
		return imc;
	}
}
