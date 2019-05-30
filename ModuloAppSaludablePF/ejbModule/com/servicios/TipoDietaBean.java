package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import com.daos.TipoDietaDAO;
import com.entidades.TipoDieta;


/**
 * Session Bean implementation class TipoDietaBean
 */
@Stateful
@LocalBean
public class TipoDietaBean {

	@EJB
	TipoDietaDAO tipoDieta;
	
    /**
     * Default constructor. 
     */
    public TipoDietaBean() {
    }

	
	public List<TipoDieta> obtenerTodos() {
		return this.tipoDieta.obtenerTodasDietas();
	}

	
	public TipoDieta obtenerId(Long idDieta) {
		return this.tipoDieta.obtenerDietaId(idDieta);
	}

}
