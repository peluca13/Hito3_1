package com.daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.entidades.Usuario;

/**
 * Session Bean implementation class UsuarioDAO
 */
@Stateless
@LocalBean
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager em;
	
  
	//Obtener un Usuario por Nombre Usuario y Contraseña para LOGIN.
	public Usuario login(String nomUsuario,String contrasena) throws SQLException{
			Usuario usuario = null;
  			return usuario = (Usuario) em.createQuery("SELECT u FROM USUARIO u WHERE u.NOM_USUARIO LIKE :nomUsuario AND u.CONTRASENA LIKE :contrasena")
  					.setParameter("nomUsuario", nomUsuario)
  					.setParameter("contrasena",contrasena)
  					.getResultList();
	}
  	
  	//Insertar Usuario pasado por parámetro (Administrador).
  	public void insert(Usuario usuario) throws SQLException {
  		this.em.persist(usuario);
  		this.em.flush();
  	}
  		
   	
  	//Editar contraseña de Usuario pasado por parámetro (Administrador).
  	public void editCont(String password, Long idUsuario) throws SQLException{
  		Usuario u = this.em.find(Usuario.class, idUsuario);
  			u.setContrasena(password);
  			this.em.flush();
  	}
  	
  	//Borrar Usuario pasado por parámetro (Administrador).
  	public void delete(Long idUsuario)throws SQLException{
  		Usuario usuario = em.find(Usuario.class, idUsuario);
  		this.em.remove(usuario);
  		this.em.flush();
  	}
  	
  	//Obtener todos los Usuarios por apellido o nombreUsuario (Administrador).
  	public ArrayList<Usuario> findAll(String apellido,String nomUsuario) throws SQLException{
  		ArrayList<Usuario> usuarios = new ArrayList<>();
  		
  		TypedQuery<Usuario> query = this.em.createQuery("SELECT u FROM USUARIO u WHERE u.APELLIDO LIKE :apellido OR u.NOM_USUARIO WHERE LIKE :nomUsuario",Usuario.class)
				.setParameter("apellido", apellido)
				.setParameter("nomUsuario", nomUsuario);
  			return (ArrayList<Usuario>) query.getResultList();
  	}
  	
  	//Editar todos los datos de un Usuario excepto el Nombre Usuario, ID y Rol (Usuario común).
  	public void edit(Usuario usuario) throws SQLException{
  			this.em.merge(usuario);
  			this.em.flush();
  	}
  	
  	//Obtener un Usuario por id.
  	public Usuario findId(Long idUsuario) throws SQLException{
  		return this.em.find(Usuario.class,idUsuario);
  	}
  	
  	//Obtener un Usuario por username.
  	public Usuario findByUser(String username) throws SQLException{
  		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM USUARIO u WHERE u.NOM_USUARIO LIKE :nomUsuario",Usuario.class)
  				.setParameter("nomUsuario", username);
  		return (Usuario) query.getResultList();
  		}
  		
  	//Obtener un Usuario por documento.
  	public Usuario findByDoc(String documentoUsuario) throws SQLException{
  		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM USUARIO u WHERE u.DOCUMENTO LIKE :documento",Usuario.class)
				.setParameter("documento", documentoUsuario);
		return (Usuario) query.getResultList();
  	}
}
