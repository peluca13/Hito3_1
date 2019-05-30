package com.bean.controladores;


import javax.ejb.EJB;

import java.util.ArrayList;
import java.util.List;


import javax.naming.NamingException;
import com.entidades.*;
import com.servicios.*;

public class ControladorUsuario {
	
	@EJB
    private static UsuarioBeanRemote usuRemote;
	@EJB
    private static ImcBeanRemote imcRemote;
	
	public ControladorUsuario() {}
	
	    
 //Login de Usuario
    
    public static boolean loginUsuario(String user, String password) throws NamingException {
    	boolean validar=false;
    	
    	Usuario usuario=usuRemote.loginUsuario(user,password);
		if(usuario!=null) {
			validar=true;
			System.out.println("USUARIO LOGEADO");
		}		
			return validar;
    	 	
    	}
    
 //Validar si existe CI
    
    public static boolean existeCi(String ci){
    	boolean existe=true;
    	existe=usuRemote.existeCi(ci);
    	return existe;
    }
    
 //Validar si existe Username
    
    public static boolean existeUsername(String username){
    	boolean existe=true;
    	existe=usuRemote.existeUsername(username);
    	return existe;
    	
    }

 //Alta Usuario
    	
    public static boolean ingresarNuevoUsuario(Usuario user){
    	
    	boolean crear=false; 
    	crear=usuRemote.ingresarNuevoUsuario(user);
    	return crear;
    	
    }


 //Baja Usuario

    public static boolean borrarUsuario(Long id) {
    	
    	boolean puedeBorrar=usuRemote.borrarUsuario(id);    	
    	return puedeBorrar;   	
    }
     

    //Obtener Usuario

    public static Usuario ObtenerUsuario(Long id) {
    	Usuario usuario = null;
    	usuario=usuRemote.ObtenerUsuario(id);
    	return usuario; 	
    }

    //Admin Cambio contrasena

    public static boolean cambiarPass(String password,Long id) {
    	boolean puedeCambiar;
    	
    	puedeCambiar=usuRemote.cambiarPass(password, id);
    	return puedeCambiar;
    	
    }

    //Controlar peso fecha

    public static boolean validarPesoFecha(Usuario id, java.util.Date fecha) {
    	boolean existe;
    	existe=imcRemote.validarPesoFecha(id, fecha);
    	return existe;
    }


    //Obtener todos los usuarios
    public static ArrayList<Usuario> obtenerInfoUsuarios(String apellido, String username){
    	
    	ArrayList<Usuario> infoUsuarios=usuRemote.obtenerInfoUsuarios(apellido, username);
    	
    	return infoUsuarios;
    }


    //Ingresar IMC
    public static boolean ingresarIMC(Usuario user, float altura, float peso, java.util.Date fecha) {
    	boolean imcOk;
    	imcOk=imcRemote.ingresarIMC(user, altura, peso, fecha);
    	return imcOk;
    }


    //Actualizar Usuario
    public static boolean ActualizarUsuario(Usuario User) {
    	boolean update;
    	update=usuRemote.ActualizarUsuario(User);
    	
    	return update;

    }

    //Obtener Roles
    public static List<Rol> obtenerRoles(){
    	List<Rol> roles;
    	roles=usuRemote.verRoles();
    	return roles;
    }
	

}
