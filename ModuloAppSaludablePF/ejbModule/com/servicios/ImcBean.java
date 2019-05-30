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
    	boolean existe = false;
    	ArrayList<Imc> imc = null;
    	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
		try {
			imc = imcDao.findId(usuario,fecha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Imc i:imc) {
			Date compara=i.getFecha();
			String comp=DATE_FORMAT.format(compara);
			String fec=DATE_FORMAT.format(fecha);
			if(comp.equals(fec)) {
				existe=true;
			}
		}  	
    	return existe;
    }

    //Ingresar IMC
    @Override
    public boolean ingresarIMC(Usuario user, float altura, float peso, Date fecha) {
    	boolean imcOk = false;
    	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
		DATE_FORMAT.format(fecha);
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
