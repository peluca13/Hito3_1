package com.servicios;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Remote;

import com.entidades.Usuario;

@Remote
public interface UsuarioBeanRemote {

	Long loginUsuario(String username, String contrasena);
	boolean existeCi(String ci);
	boolean existeUsername(String username);
	boolean ingresarNuevoUsuario(String nombre, String apellido, String doc, int genero, String correo, Date fecha,
			String usuario, String pass, Long userrol);
	boolean borrarUsuario(Long id);
	Usuario ObtenerUsuario(Long id);
	boolean cambiarPass(String password, Long id);
	ArrayList<Usuario> obtenerInfoUsuarios(String apellido, String username);
	boolean ActualizarUsuario(Usuario User);
	

}
