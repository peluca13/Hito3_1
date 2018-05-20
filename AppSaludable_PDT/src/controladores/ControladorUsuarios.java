package controladores;


import java.sql.SQLException;

import entidades.Usuario;
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
			ventana.menuRol(usuario.getRol().getNombre());
			
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
	
/*
public static boolean ingresarNuevoUsuario(String nombre, String apellido, String doc, int genero, String correo, String usuario, String pass){
	
	boolean pudeCrear;
	Usuario usuario = new Usuario(nombre, apellido, ci);
	
	try{
		ManejadorClientes.guardarCliente(cliente);
		pudeCrear = true;
	}
	catch (SQLException e){
		// ca va el cofigo se falla el insert
		pudeCrear = false;
	}
	
	return pudeCrear;
	
}

*/

	
}
