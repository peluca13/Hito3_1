package com.servicios;

import java.sql.SQLException;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.daos.ImcDAO;
import com.entidades.Imc;


/**
 * Session Bean implementation class ImcBean
 */
@Stateless
public class ImcBean implements ImcBeanRemote {
	@EJB
	private ImcDAO imcDao;
	

    /**
     * Default constructor. 
     */
    public ImcBean() {
        // TODO Auto-generated constructor stub
    }
    
    //Controlar peso fecha

    public boolean validarPesoFecha(Long id, java.util.Date fecha) {
    	boolean existe;
    	Imc imc = null;
		try {
			imc = imcDao.findId(id,fecha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	if (imc==null){
    		existe = false;
    	}
    	else{
    		existe = true;
    	}
    	
    	return existe;
    }
/*
    //Ingresar IMC
    
    public static boolean ingresarIMC(int identificador, double altura, double peso, java.util.Date fecha) {
    	boolean imcOk;
    	int valorIMC=0;
    	Usuario usuario=ObtenerUsuario(identificador);
    	Imc imc = new Imc(1,fecha,altura,peso,usuario);
    	
    	try{
    		ImcDAO.insert(imc);
    		imcOk = true;
    	}
    	catch (SQLException e){
    		e.printStackTrace();
    		// ca va el codigo se falla el insert
    		imcOk = false;
    	}
    	
    	return imcOk;
    }
  */  
    

}
