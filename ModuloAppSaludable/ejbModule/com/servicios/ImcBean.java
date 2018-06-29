package com.servicios;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.daos.ImcDAO;
import com.entidades.Imc;
import com.entidades.Usuario;


/**
 * Session Bean implementation class ImcBean
 */
@Stateless
public class ImcBean implements ImcBeanRemote {
	@EJB
	private ImcDAO imcDao;
	@EJB
	private static UsuarioBeanRemote usuRemote;
	

    /**
     * Default constructor. 
     */
    public ImcBean() {
        // TODO Auto-generated constructor stub
    }
    
    //Controlar peso fecha
    @Override
    public boolean validarPesoFecha(Usuario usuario, Date fecha) {
    	boolean existe;
    	ArrayList<Imc> imc = null;
    	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
		DATE_FORMAT.format(fecha);
		try {
			imc = imcDao.findId(usuario,fecha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Imc i:imc) {
			System.out.println("EL IMC TIENE ESTOS DATOS GUARDADOS"+i.getFecha()+i.getAltura());
		}
    	
    	if (imc.isEmpty()){
    		existe = false;
    	}
    	else{
    		existe = true;
    	}
    	
    	return existe;
    }

    //Ingresar IMC
    @Override
    public boolean ingresarIMC(Usuario user, double altura, double peso, Date fecha) {
    	boolean imcOk = false;
    	Imc imc = new Imc(fecha,altura,peso,user);
    	try {
			imcDao.insert(imc);
			imcOk=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
    	
    	
    	return imcOk;
    }
   
    

}
