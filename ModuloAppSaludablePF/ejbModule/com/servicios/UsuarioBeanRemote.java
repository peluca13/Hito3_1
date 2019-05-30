package com.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import com.entidades.Rol;
import com.entidades.Usuario;

@Remote
public interface UsuarioBeanRemote {

	Usuario loginUsuario(String username, String contrasena);
	boolean existeCi(String ci);
	boolean existeUsername(String username);
	boolean borrarUsuario(Long id);
	Usuario ObtenerUsuario(Long id);
	boolean cambiarPass(String password, Long id);
	ArrayList<Usuario> obtenerInfoUsuarios(String apellido, String username);
	boolean ActualizarUsuario(Usuario User);
	List<Rol> verRoles();
	boolean ingresarNuevoUsuario(Usuario usuario);
	

}
