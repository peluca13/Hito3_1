package com.daos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entidades.TipoDieta;
import com.entidades.TipoPublico;

/**
 * Session Bean implementation class TipoPublicoDAO
 */
@Stateless
@LocalBean
public class TipoPublicoDAO {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public TipoPublicoDAO() {
    }
    
  //Guardar un nuevo TipoPublico.
    public Long guardarTipoPublico(TipoPublico tipoPublico) {
    	this.em.persist(tipoPublico);
    	return tipoPublico.getIdPublico();
    }
    
    //Actualizar el nombre de un TipoPublico.
    public void actualizarTipoPublico(Long idPublico,String nombre) {
    	TipoPublico p = this.em.find(TipoPublico.class, idPublico);
    	if(p!=null) {
    		p.setNombre(nombre);
    	}
    	this.em.flush();
    }
    
    //Eliminar un TipoPublico.
    public void eliminarTipoPublico(TipoPublico tipoPublico) {
    	this.em.remove(tipoPublico);
    }

    //Obtener un TipoPublico por ID.
    public TipoPublico obtenerPublicoId(Long idPublico) {
    	return this.em.find(TipoPublico.class, idPublico);
    }
    
    //Obtener un TipoPublico por su nombre.
    public TipoPublico obtenerTipoPublico(String nombre) {
    	return this.em.find(TipoPublico.class, nombre);
    }
    
    //Obtener todos los TipoPublico.
    public List<TipoPublico> obtenerTodosPublicos(){
    	TypedQuery<TipoPublico> query = this.em.createQuery("SELECT p FROM PUBLICO p", TipoPublico.class);
		return query.getResultList();
    }

}
