package controladores;


import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Imc;
import entidades.Rol;
import entidades.TipoPublico;
import entidades.TipoReceta;
import entidades.Usuario;
import manejadoresDAO.ImcDAO;
import manejadoresDAO.UsuarioDAO;
import interfaz.VentanaPrincipal;





//Manejador tipo de session por Rol
public class ControladorUsuarios {
	
	public static boolean loginUsuario(String username, String contrasena){
		boolean validar;
		final Usuario usuario=UsuarioDAO.login(username, contrasena);
		if(usuario==null) {
			validar=false;
		}else {	validar=true;
			VentanaPrincipal ventana= VentanaPrincipal.getFrame();
			ventana.setVisible(true);
			ventana.menuRol(usuario.getRol().getNombre(),usuario);
			
			}
		return validar;
	}
	
//Existe CI	
public static boolean existeCi(String ci){
		
		boolean existe;
		Usuario usuario = UsuarioDAO.findByDoc(ci);
		
		if (usuario==null){
			existe = false;
		}
		else{
			existe = true;
		}
		
		return existe;
		
	}

//Existe username

public static boolean existeUsername(String username){
	
	boolean existe;
	Usuario usuario = UsuarioDAO.findByUser(username);
	
	if (usuario==null){
		existe = false;
	}
	else{
		existe = true;
	}
	
	return existe;
	
}

//Alta Usuario
	

public static boolean ingresarNuevoUsuario(String nombre, String apellido, String doc, int genero, String correo, java.util.Date fecha,String usuario, String pass,int userrol){
	
	boolean pudeCrear;
	int idUser=1;
	TipoReceta tiporeceta=TipoReceta.TODOS;
	TipoPublico tipopublico=TipoPublico.TODOS;
	Rol rol = null;
	if(userrol==1) {rol=Rol.USUARIO;}
	if(userrol==2) {rol=Rol.PERSONAL_INSTITUCION;}	
	Usuario user = new Usuario(idUser,doc,nombre,apellido,fecha,genero,correo,tipopublico,tiporeceta,rol,pass,usuario);
	
	try{
		UsuarioDAO.insert(user);
		pudeCrear = true;
	}
	catch (SQLException e){
		e.printStackTrace();
		// ca va el codigo se falla el insert
		pudeCrear = false;
	}
	
	return pudeCrear;
	
}


//Baja Usuario

public static boolean borrarUsuario(int id) {
	boolean puedeBorrar;
	try {
		UsuarioDAO.delete(id);
		puedeBorrar = true;
	}catch (SQLException e){
		e.printStackTrace();
		// ca va el codigo se falla el insert
		puedeBorrar = false;
	}
	
	return puedeBorrar;
	
}
 

//Obtener Usuario

public static Usuario ObtenerUsuario(int id) {
	return UsuarioDAO.findId(id);
}

//Admin Cambio contraseña

public static boolean cambiarPass(String password,int id) {
	boolean puedeCambiar;
	try {
		UsuarioDAO.editCont(password,id);
		puedeCambiar = true;
	}catch (SQLException e){
		e.printStackTrace();
		// ca va el codigo se falla el insert
		puedeCambiar = false;
	}
	
	return puedeCambiar;
	
}

//Controlar peso fecha

public static boolean validarPesoFecha(int id, java.util.Date fecha) {
	boolean existe;
	Imc imc  = ImcDAO.findId(id,fecha);
	
	if (imc==null){
		existe = false;
	}
	else{
		existe = true;
	}
	
	return existe;
}


//Obtener todos los usuarios
public static ArrayList<Usuario> obtenerInfoUsuarios(String apellido, String username){


ArrayList<Usuario> infoUsuarios = UsuarioDAO.findAll(apellido,username);


return infoUsuarios;
}

public static boolean ingresarIMC(int identificador, double altura, double peso, java.util.Date fecha) {
	boolean imcOk;
	int valorIMC=0;
	Usuario usuario=ObtenerUsuario(identificador);
	Imc imc = new Imc(1,fecha,altura,peso,usuario);
	
	try{
		ImcDAO.insert(imc);
		imcOk = true;
	}
	catch (SQLException e){
		e.printStackTrace();
		// ca va el codigo se falla el insert
		imcOk = false;
	}
	
	return imcOk;
}


	
}
