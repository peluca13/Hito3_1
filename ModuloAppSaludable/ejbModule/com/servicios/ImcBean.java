package com.servicios;

import java.sql.SQLException;
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

    //Ingresar IMC
    @Override
    public boolean ingresarIMC(Long identificador, double altura, double peso, java.util.Date fecha) {
    	boolean imcOk;
    	Usuario usuario=usuRemote.ObtenerUsuario(identificador);
    	Imc imc = new Imc(fecha,altura,peso);
    	List<Imc> imcUsuario=usuario.getImcs();
    	imcUsuario.add(imc);
    	usuario.setImcs(imcUsuario);
    	imcOk=usuRemote.ActualizarUsuario(usuario);
    	
    	return imcOk;
    }
   
    

}