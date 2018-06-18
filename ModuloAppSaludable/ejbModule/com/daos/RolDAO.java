package com.daos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entidades.Rol;

/**
 * Session Bean implementation class RolDAO
 */
@Stateless
@LocalBean
public class RolDAO {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public RolDAO() {
    }

    
    //Guardar un nuevo ROL.
    public Long guardarRol(String nombre) {
    	Rol rol = new Rol();
    	rol.setNombre(nombre);
    	this.em.persist(rol);
    	return rol.getIdRol();
    }
    
    //Actualizar el nombre de un ROL.
    public void actualizarRol(Long idRol,String nombre) {
    	Rol r = this.em.find(Rol.class, idRol);
    	if(r!=null) {
    		r.setNombre(nombre);
    	}
    	this.em.flush();
    }
    
    //Eliminar un ROL.
    public void eliminarRol(Rol rol) {
    	this.em.remove(rol);
    }

    //Obtener un ROL por ID.
    public Rol obtenerRolId(Long idRol) {
    	return this.em.find(Rol.class, idRol);
    }
    
    //Obtener un ROL por su nombre.
    public Rol obtenerRol(String nombre) {
    	return this.em.find(Rol.class, nombre);
    }
    
    //Obtener todos los ROLES.
    public List<Rol> obtenerTodosRoles(){
    	TypedQuery<Rol> query = this.em.createQuery("SELECT r FROM Rol r", Rol.class);
		return query.getResultList();
    }
}
