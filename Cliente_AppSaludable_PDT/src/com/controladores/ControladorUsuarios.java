package com.controladores;


import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.entidades.Imc;
import com.entidades.Rol;
import com.entidades.TipoPublico;
import com.entidades.TipoDieta;
import com.entidades.Usuario;
import com.servicios.ImcBeanRemote;
import com.servicios.UsuarioBeanRemote;
import com.cliente.EJBLocator;
import com.cliente.ventanas.VentanaPrincipal;





//Manejador tipo de session por Rol
public class ControladorUsuarios {
	public static UsuarioBeanRemote usuarioRemote;
	public static ImcBeanRemote imcRemote;
	
	public static boolean loginUsuario(String username, String contrasena){
		boolean validar = false;
		try {			
			
			usuarioRemote=EJBLocator.getInstance().lookup(UsuarioBeanRemote.class);
			Usuario usuario=usuarioRemote.loginUsuario(username, contrasena);
			if(usuario==null) {
				validar=false;
			}else {	
				validar=true;
				VentanaPrincipal ventana= VentanaPrincipal.getFrame();
				ventana.setVisible(true);
				System.out.println("EL ROL DEL USUARIO ES: "+usuario.getRol().getNombre());
				ventana.menuRol(usuario.getRol().getNombre(),usuario);			
				}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return validar;
	}
	
//Existe CI	
public static boolean existeCi(String ci){
		
		boolean existe = true;
		try {
			usuarioRemote=EJBLocator.getInstance().lookup(UsuarioBeanRemote.class);				
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		existe=usuarioRemote.existeCi(ci);	
		return existe;
		
	}

//Existe username

public static boolean existeUsername(String username){
	
	boolean existe = true;
	try {
		usuarioRemote=EJBLocator.getInstance().lookup(UsuarioBeanRemote.class);
		existe=usuarioRemote.existeUsername(username);		
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return existe;
	
}

//Alta Usuario
	

public static boolean ingresarNuevoUsuario(Usuario user){
	
	boolean crear = false;
	try {
		usuarioRemote=EJBLocator.getInstance().lookup(UsuarioBeanRemote.class);
		crear=usuarioRemote.ingresarNuevoUsuario(user);		
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return crear;
	
}


//Baja Usuario

public static boolean borrarUsuario(Long id) {
	
	boolean puedeBorrar;
	puedeBorrar=usuarioRemote.borrarUsuario(id);
	
	return puedeBorrar;
	
}
 

//Obtener Usuario

public static Usuario ObtenerUsuario(Long id) {
	Usuario usuario = null;
	try {
		usuarioRemote=EJBLocator.getInstance().lookup(UsuarioBeanRemote.class);
		usuario=usuarioRemote.ObtenerUsuario(id);
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return usuario;
	
}

//Admin Cambio contraseņa

public static boolean cambiarPass(String password,Long id) {
	boolean puedeCambiar;
	try {
		usuarioRemote=EJBLocator.getInstance().lookup(UsuarioBeanRemote.class);
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	puedeCambiar=usuarioRemote.cambiarPass(password, id);

	
	return puedeCambiar;
	
}

//Controlar peso fecha

public static boolean validarPesoFecha(Usuario id, java.util.Date fecha) {
	boolean existe;
	try {
		imcRemote=EJBLocator.getInstance().lookup(ImcBeanRemote.class);
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	existe=imcRemote.validarPesoFecha(id, fecha);
	return existe;
}


//Obtener todos los usuarios
public static ArrayList<Usuario> obtenerInfoUsuarios(String apellido, String username){
	try {
		usuarioRemote=EJBLocator.getInstance().lookup(UsuarioBeanRemote.class);
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ArrayList<Usuario> infoUsuarios=usuarioRemote.obtenerInfoUsuarios(apellido, username);
	
	return infoUsuarios;
}


//Ingresar IMC
public static boolean ingresarIMC(Usuario user, float altura, float peso, java.util.Date fecha) {
	boolean imcOk;
	try {
		imcRemote=EJBLocator.getInstance().lookup(ImcBeanRemote.class);
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	imcOk=imcRemote.ingresarIMC(user, altura, peso, fecha);
	return imcOk;
}


//Actualizar Usuario
public static boolean ActualizarUsuario(Usuario User) {
	boolean update;
	try {
		usuarioRemote=EJBLocator.getInstance().lookup(UsuarioBeanRemote.class);
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	update=usuarioRemote.ActualizarUsuario(User);
	
	return update;

}

//Obtener Roles
public static List<Rol> obtenerRoles(){
	List<Rol> roles;
	try {
		usuarioRemote=EJBLocator.getInstance().lookup(UsuarioBeanRemote.class);
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	roles=usuarioRemote.verRoles();
	return roles;
}


	
}
