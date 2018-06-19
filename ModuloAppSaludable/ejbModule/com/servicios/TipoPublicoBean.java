package com.servicios;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import com.daos.TipoPublicoDAO;
import com.entidades.TipoPublico;

/**
 * Session Bean implementation class TipoPublico
 */
@Stateful
@LocalBean
public class TipoPublicoBean {

	@EJB
	TipoPublicoDAO tipoPublico;
	
    /**
     * Default constructor. 
     */
    public TipoPublicoBean() {
    }

    public List<TipoPublico> obtenerTodos() {
		return this.tipoPublico.obtenerTodosPublicos();
	}

	
	public TipoPublico obtenerId(Long idPublico) {
		return this.tipoPublico.obtenerPublicoId(idPublico);
	}
}
