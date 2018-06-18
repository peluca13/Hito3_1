package com.daos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entidades.Rol;
import com.entidades.TipoDieta;

/**
 * Session Bean implementation class TipoDietaDAO
 */
@Stateless
@LocalBean
public class TipoDietaDAO {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public TipoDietaDAO() {
    }

    //Guardar un nuevo TipoDieta.
    public Long guardarTipoDieta(TipoDieta tipoDieta) {
    	this.em.persist(tipoDieta);
    	return tipoDieta.getIdDieta();
    }
    
    //Actualizar el nombre de un TipoDieta.
    public void actualizarTipoDieta(Long idDieta,String nombre) {
    	TipoDieta d = this.em.find(TipoDieta.class, idDieta);
    	if(d!=null) {
    		d.setNombre(nombre);
    	}
    	this.em.flush();
    }
    
    //Eliminar un TipoDieta.
    public void eliminarTipoDieta(TipoDieta tipoDieta) {
    	this.em.remove(tipoDieta);
    }

    //Obtener un TipoDieta por ID.
    public TipoDieta obtenerDietaId(Long idDieta) {
    	return this.em.find(TipoDieta.class, idDieta);
    }
    
    //Obtener un TipoDieta por su nombre.
    public TipoDieta obtenerTipoDieta(String nombre) {
    	return this.em.find(TipoDieta.class, nombre);
    }
    
    //Obtener todos los TipoDieta.
    public List<TipoDieta> obtenerTodasDietas(){
    	TypedQuery<TipoDieta> query = this.em.createQuery("SELECT d FROM DIETA d", TipoDieta.class);
		return query.getResultList();
    }
}
