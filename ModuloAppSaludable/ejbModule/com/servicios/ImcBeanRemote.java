package com.servicios;

import java.util.Date;

import javax.ejb.Remote;

@Remote
public interface ImcBeanRemote {

	boolean validarPesoFecha(Long id, Date fecha);

	boolean ingresarIMC(Long identificador, double altura, double peso, Date fecha);

}
