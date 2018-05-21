package manejadoresDAO;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import entidades.Usuario;
import entidades.Rol;
import entidades.TipoPublico;
import entidades.TipoReceta;
import manejadoresDAO.DatabaseManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class UsuarioDAO {

	private static final String LOGIN = "SELECT U.ID_USUARIO,U.DOCUMENTO,U.NOMBRE,U.APELLIDO,U.GENERO,U.CONTRASENA,U.CORREO_ELEC,R.NOMBRE ROL,U.FEC_NAC,U.NOM_USUARIO,P.NOMBRE PUBLICO,D.NOMBRE DIETA FROM USUARIO U INNER JOIN PUBLICO P ON U.TIPO_PUBLICO=P.ID_PUBLICO INNER JOIN DIETA D ON U.TIPO_RECETA=D.ID_DIETA INNER JOIN ROL R ON U.ROL=R.ID_ROL WHERE U.NOM_USUARIO = ? AND U.CONTRASENA = ?";
	private static final String INSERT_USUARIO = "INSERT INTO USUARIO (ID_USUARIO,DOCUMENTO,NOMBRE,APELLIDO,GENERO,CONTRASENA,CORREO_ELEC,ROL,FEC_NAC,NOM_USUARIO,TIPO_PUBLICO,TIPO_RECETA) VALUES (SEQ_ID_USUARIO.NEXTVAL,?,?,?,?,?,?,?,?,?,1,1)";
	private static final String ALL_USUARIO = "SELECT U.ID_USUARIO,U.DOCUMENTO,U.NOMBRE,U.APELLIDO,U.GENERO,U.CONTRASENA,U.CORREO_ELEC,R.NOMBRE ROL,U.FEC_NAC,U.NOM_USUARIO,P.NOMBRE PUBLICO,D.NOMBRE DIETA FROM USUARIO U INNER JOIN PUBLICO P ON U.TIPO_PUBLICO=P.ID_PUBLICO INNER JOIN DIETA D ON U.TIPO_RECETA=D.ID_DIETA INNER JOIN ROL R ON U.ROL=R.ID_ROL WHERE U.APELLIDO=? OR U.NOM_USUARIO=?";
	private static final String UPDATE_CONT_USUARIO = "UPDATE USUARIO SET CONTRASENA=? WHERE ID_USUARIO=?";
	private static final String DELETE_USUARIO = "DELETE FROM USUARIO WHERE ID_USUARIO=?";
	private static final String UPDATE_USUARIO= "UPDATE USUARIO SET DOCUMENTO=?,NOMBRE=?,APELLIDO=?,GENERO=?,CONTRASENA=?,CORREO_ELEC=?FEC_NAC=? WHERE NOM_USUARIO=?";
	private static final String USUARIO_ID = "SELECT U.ID_USUARIO,U.DOCUMENTO,U.NOMBRE,U.APELLIDO,U.GENERO,U.CONTRASENA,U.CORREO_ELEC,R.NOMBRE ROL,U.FEC_NAC,U.NOM_USUARIO,P.NOMBRE PUBLICO,D.NOMBRE DIETA FROM USUARIO U INNER JOIN PUBLICO P ON U.TIPO_PUBLICO=P.ID_PUBLICO INNER JOIN DIETA D ON U.TIPO_RECETA=D.ID_DIETA INNER JOIN ROL R ON U.ROL=R.ID_ROL WHERE U.ID_USUARIO=?";
	private static final String USUARIO_USERNAME = "SELECT U.ID_USUARIO,U.DOCUMENTO,U.NOMBRE,U.APELLIDO,U.GENERO,U.CONTRASENA,U.CORREO_ELEC,R.NOMBRE ROL,U.FEC_NAC,U.NOM_USUARIO,P.NOMBRE PUBLICO,D.NOMBRE DIETA FROM USUARIO U INNER JOIN PUBLICO P ON U.TIPO_PUBLICO=P.ID_PUBLICO INNER JOIN DIETA D ON U.TIPO_RECETA=D.ID_DIETA INNER JOIN ROL R ON U.ROL=R.ID_ROL WHERE U.NOM_USUARIO=?";
	private static final String USUARIO_DOCUMENTO = "SELECT U.ID_USUARIO,U.DOCUMENTO,U.NOMBRE,U.APELLIDO,U.GENERO,U.CONTRASENA,U.CORREO_ELEC,R.NOMBRE ROL,U.FEC_NAC,U.NOM_USUARIO,P.NOMBRE PUBLICO,D.NOMBRE DIETA FROM USUARIO U INNER JOIN PUBLICO P ON U.TIPO_PUBLICO=P.ID_PUBLICO INNER JOIN DIETA D ON U.TIPO_RECETA=D.ID_DIETA INNER JOIN ROL R ON U.ROL=R.ID_ROL WHERE U.DOCUMENTO=?";
	
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
	public static void insert(Usuario usuario) throws SQLException{

			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(INSERT_USUARIO);
			//statement.setInt(1, usuario.getIdUsuario());
			if(usuario.getDocumento().isEmpty()) {
				statement.setString(1, "");
			}else {
				statement.setString(1, usuario.getDocumento());
			}			
			statement.setString(2, usuario.getNombre());
			statement.setString(3, usuario.getApellido());
			statement.setInt(4, usuario.getGenero());
			statement.setString(5, usuario.getContrasena());
			if(usuario.getCorreoElec().isEmpty()) {
				statement.setString(6, "");
			}else {
				statement.setString(6, usuario.getCorreoElec());
			}
			statement.setInt(7, usuario.getRol().getIdRol());
			statement.setDate(8,new java.sql.Date(usuario.getFecNac().getTime()));

			statement.setString(9, usuario.getNomUsuario());			
			statement.executeUpdate();
									
			
	}
	
	//Editar contraseña de Usuario pasado por parámetro (Administrador).
	public static void editCont(String password, int id) throws SQLException{
			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(UPDATE_CONT_USUARIO);
			statement.setString(1, password);
			statement.setInt(2, id);
			statement.executeUpdate();

	}
	
	//Borrar Usuario pasado por parámetro (Administrador).
	public static void delete(int id)throws SQLException{

			PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(DELETE_USUARIO);
			statement.setInt(1,id);
			
			statement.executeUpdate();
	
	}
	
	//Obtener todos los Usuarios por apellido o nombre (Administrador).
	public static ArrayList<Usuario> findAll(String apellido,String nomUsuario){
		ArrayList<Usuario> usuarios = new ArrayList<>();
		
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
			statement.setInt(4, usuario.getGenero());
			statement.setString(5, usuario.getContrasena());
			statement.setString(6, usuario.getCorreoElec());
			statement.setDate(7,new java.sql.Date(usuario.getFecNac().getTime()));
			statement.setString(8, usuario.getNomUsuario());
					
			int retorno = statement.executeUpdate();
		
			return retorno>0;
			}catch(SQLException e){
				e.printStackTrace();
				return false;
			}
	}
	
	//Obtener un Usuario por id.
		public static Usuario findId(int idUsuario){
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
	
		//Obtener un Usuario por username.
		public static Usuario findByUser(String username){
			try{
				PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(USUARIO_USERNAME);
				statement.setString(1, username);
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
		
		//Obtener un Usuario por documento.
				public static Usuario findByDoc(String documentoUsuario){
					try{
						PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(USUARIO_DOCUMENTO);
						statement.setString(1, documentoUsuario);
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
		Date fecNac = new Date(resultado.getDate("FEC_NAC").getTime());
		int genero = resultado.getInt("GENERO");
		String correoElec = resultado.getString("CORREO_ELEC");
		//if(correoElec.isEmpty()) {correoElec="";}
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


