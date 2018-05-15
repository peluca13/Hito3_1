package manejadoresDAO;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import entidades.Usuario;
import entidades.Rol;
import entidades.TipoPublico;
import entidades.TipoReceta;
import manejadoresDAO.DatabaseManager;
import java.util.Date;
import java.util.LinkedList;

public class UsuarioDAO {

	private static final String LOGIN = "SELECT U.ID_USUARIO,U.DOCUMENTO,U.NOMBRE,U.APELLIDO,U.GENERO,U.CONTRASENA,U.CORREO_ELECTRONICO,R.NOMBRE ROL,U.FECHA_NACIMIENTO,U.NOM_USUARIO,P.NOMBRE PUBLICO,D.NOMBRE DIETA FROM USUARIO U INNER JOIN PUBLICO P ON U.TIPO_PUBLICO=P.ID_PUBLICO INNER JOIN DIETA D ON U.TIPO_RECETA=D.ID_DIETA INNER JOIN ROL R ON U.ROL=R.ID_ROL WHERE NOM_USUARIO = ? AND CONTRASENA = ?";
	private static final String INSERT_USUARIO = "INSERT INTO USUARIO (ID_USUARIO,DOCUMENTO,NOMBRE,APELLIDO,GENERO,CONTRASENA,CORREO_ELEC,ROL,FEC_NAC,NOM_USUARIO) VALUES (?,?,?,?,?,?,?,?,?,?)";
	private static final String ALL_USUARIO = "SELECT * FROM USUARIO WHERE APELLIDO=? OR NOM_USUARIO=?";
	private static final String UPDATE_CONT_USUARIO = "UPDATE USUARIO SET CONTRASENA=? WHERE ID_USUARIO=? OR NOM_USUARIO=?";
	private static final String DELETE_USUARIO = "DELETE FROM USUARIO WHERE ID_USUARIO=? OR NOM_USUARIO=?";
	private static final String UPDATE_USUARIO= "UPDATE USUARIO SET DOCUMENTO=?,NOMBRE=?,APELLIDO=?,GENERO=?,CONTRASENA=?,CORREO_ELEC=?FEC_NAC=? WHERE NOM_USUARIO=?";
	private static final String USUARIO_ID = "SELECT * FROM USUARIO WHERE ID_USUARIO=?";
	
	//Obtener un Usuario por Nombre Usuario y Contraseña para LOGIN.
		public static Usuario login(String nomUsuario,String contrasena){
			try{
				PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(LOGIN);
				statement.setString(1, nomUsuario);
				statement.setString(2, contrasena);
				ResultSet resultado = statement.executeQuery();
				Usuario usuario = null;
					if (resultado.next()){
						usuario = getUsuarioFromResultSet(resultado);
					}
						return usuario;
			}catch(SQLException e){
				e.printStackTrace();
				return null;
			}
		}
	
	//Insertar Usuario pasado por parámetro (Administrador).
	public static boolean insert(Usuario usuario){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_USUARIO);
			statement.setInt(1, usuario.getIdUsuario());
			statement.setString(2, usuario.getDocumento());
			statement.setString(3, usuario.getNombre());
			statement.setString(4, usuario.getApellido());
			statement.setString(5, usuario.getGenero());
			statement.setString(6, usuario.getContrasena());
			statement.setString(7, usuario.getCorreoElec());
			statement.setString(8, usuario.getRol().name());
			statement.setDate(9,new java.sql.Date(usuario.getFecNac().getTime()));
			statement.setString(10, usuario.getNomUsuario());			
														
			int retorno = statement.executeUpdate();
									
			return retorno>0;
				
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	//Editar contraseña de Usuario pasado por parámetro (Administrador).
	public static boolean editCont(Usuario usuario){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE_CONT_USUARIO);
			statement.setString(1, usuario.getContrasena());
			statement.setInt(2, usuario.getIdUsuario());
			statement.setString(3, usuario.getNomUsuario());
			statement.execute();
		
			int retorno = statement.executeUpdate();
		
			return retorno>0;
			}catch(SQLException e){
				e.printStackTrace();
				return false;
			}
	}
	
	//Borrar Usuario pasado por parámetro (Administrador).
	public static boolean delete(Usuario usuario){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE_USUARIO);
			statement.setInt(1, usuario.getIdUsuario());
			statement.setString(2, usuario.getNomUsuario());
			
			int retorno = statement.executeUpdate();
		
			return retorno>0;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	//Obtener todos los Usuarios por apellido o nombre (Administrador).
	public static LinkedList<Usuario> findAll(String apellido,String nomUsuario){
		LinkedList<Usuario> usuarios = new LinkedList<>();
		
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(ALL_USUARIO);
			statement.setString(1, apellido);
			statement.setString(2,nomUsuario);
			ResultSet resultado = statement.executeQuery();
				while (resultado.next()){
					Usuario usuario = getUsuarioFromResultSet(resultado);
					usuarios.add(usuario);
				}
		
				return usuarios;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	//Editar todos los datos de un Usuario excepto el Nombre Usuario, ID y Rol (Usuario común).
	public static boolean edit(Usuario usuario){
		try{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE_USUARIO);
			statement.setString(1, usuario.getDocumento());
			statement.setString(2, usuario.getNombre());
			statement.setString(3, usuario.getApellido());
			statement.setString(4, usuario.getGenero());
			statement.setString(5, usuario.getContrasena());
			statement.setString(6, usuario.getCorreoElec());
			statement.setDate(7,new java.sql.Date(usuario.getFecNac().getTime()));
			statement.setString(8, usuario.getNomUsuario());
			statement.execute();
		
			int retorno = statement.executeUpdate();
		
			return retorno>0;
			}catch(SQLException e){
				e.printStackTrace();
				return false;
			}
	}
	
		//Obtener un Usuario por ID.
		public static Usuario find(int idUsuario){
			try{
				PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(USUARIO_ID);
				statement.setInt(1, idUsuario);
				ResultSet resultado = statement.executeQuery();
				Usuario usuario = null;
					if (resultado.next()){
						usuario = getUsuarioFromResultSet(resultado);
					}
						return usuario;
			}catch(SQLException e){
				e.printStackTrace();
				return null;
			}
		}
	
	//Método auxiliar para mappear la clase Usuario.
	private static Usuario getUsuarioFromResultSet(ResultSet resultado) throws SQLException{
		int idUsuario = resultado.getInt("ID_USUARIO");
		String documento = resultado.getString("DOCUMENTO");
		String nombre = resultado.getString("NOMBRE");
		String apellido = resultado.getString("APELLIDO");
		Date fecNac = new Date(resultado.getDate("FECHA_NACIMIENTO").getTime());
		String genero = resultado.getString("GENERO");
		String correoElec = resultado.getString("CORREO_ELECTRONICO");
		String nomRol = resultado.getString("ROL");
		Rol rol = Rol.valueOf(nomRol);
		String contrasena = resultado.getString("CONTRASENA");
		String nomUsuario = resultado.getString("NOM_USUARIO");
		String publico = resultado.getString("PUBLICO");
		TipoPublico tipoPublico =TipoPublico.valueOf(publico);
		String dieta = resultado.getString("DIETA");
		TipoReceta tipoReceta= TipoReceta.valueOf(dieta);
		Usuario usuario = new Usuario(idUsuario,documento,nombre,apellido,fecNac,genero,correoElec,tipoPublico,tipoReceta,rol,contrasena,nomUsuario);
		return usuario;
	}
	
}


