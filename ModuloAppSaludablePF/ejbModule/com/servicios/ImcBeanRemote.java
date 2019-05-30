package com.servicios;

import java.util.Date;

import javax.ejb.Remote;

import com.entidades.Usuario;

@Remote
public interface ImcBeanRemote {

	boolean validarPesoFecha(Usuario usuario, Date fecha);

	boolean ingresarIMC(Usuario user, float altura, float peso, Date fecha);

}
