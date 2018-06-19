package com.servicios;

import java.util.List;

import javax.ejb.Local;

import com.entidades.TipoDieta;

@Local
public interface TipoDietaBeanRemote {

	List<TipoDieta> obtenerTodos();
	List<TipoDieta> obtenerTodos(Long idTipoDieta);
}
