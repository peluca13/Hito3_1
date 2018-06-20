package com.servicios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

import com.daos.RolDAO;
import com.daos.TipoDietaDAO;
import com.daos.TipoPublicoDAO;
import com.daos.UsuarioDAO;
import com.entidades.Imc;
import com.entidades.Rol;
import com.entidades.TipoDieta;
import com.entidades.TipoPublico;
import com.entidades.Usuario;




/**
 * Session Bean implementation class UsuarioBean
 */
@Stateless
public class UsuarioBean implements UsuarioBeanRemote {

	@EJB
    private RolDAO rolDao;

	@EJB
    private TipoDietaDAO dietaDao;
	
	@EJB
    private TipoPublicoDAO publicoDao;
	
	@EJB
    private UsuarioDAO userDao;

	/**
     * Default constructor. 
     */
    public UsuarioBean() {
        // TODO Auto-generated constructor stub
    }
    
    //Manejador session por ROL
    @Override 
	public Long loginUsuario(String username, String contrasena){
    	
		Usuario usuario = null;
		try {
			usuario = this.userDao.login(username, contrasena);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario.getIdUsuario();
	}
    
    
  //Existe CI
    @Override
    public boolean existeCi(String ci){
    		
    		boolean existe;
    		Usuario usuario = null;
			try {
				usuario = this.userDao.findByDoc(ci);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		if (usuario==null){
    			existe = false;
    		}
    		else{
    			existe = true;
    		}
    		
    		return existe;
    		
    	}
    
  //Existe username
    @Override
    public boolean existeUsername(String username){
    	
    	boolean existe;
    	Usuario usuario = null;
		try {
			usuario = this.userDao.findByUser(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	if (usuario==null){
    		existe = false;
    	}
    	else{
    		existe = true;
    	}
    	
    	return existe;
    	
    } 
  /*
  //Alta Usuario
	
    @Override
    public boolean ingresarNuevoUsuario(String nombre, String apellido, String doc, int genero, String correo, java.util.Date fecha,String usuario, String pass,Long userrol){
    	
    	boolean pudeCrear;
    	int idUser=1;
    	TipoDieta tiporeceta=TipoDieta.TODOS;
    	TipoPublico tipopublico=TipoPublico.TODOS;
    	Rol rol = null;
    	rol=this.rolDAO.obtenerRolId(userrol);
    	Usuario user = new Usuario(idUser,doc,nombre,apellido,fecha,genero,correo,tipopublico,tiporeceta,rol,pass,usuario);
    	
    	try{
    		userDao.insert(user);
    		pudeCrear = true;
    	}
    	catch (SQLException e){
    		e.printStackTrace();
    		// ca va el codigo se falla el insert
    		pudeCrear = false;
    	}
    	
    	return pudeCrear;
    	
    }
*/    
  //Baja Usuario
    
    @Override
    public boolean borrarUsuario(Long id) {
    	boolean puedeBorrar;
    	try {
    		userDao.delete(id);
    		puedeBorrar = true;
    	}catch (SQLException e){
    		e.printStackTrace();
    		// ca va el codigo se falla el insert
    		puedeBorrar = false;
    	}
    	
    	return puedeBorrar;
    	
    }
     

    //Obtener Usuario
    @Override
    public Usuario ObtenerUsuario(Long id) {
    	Usuario usuario = null;
    	try {
			usuario = userDao.findId(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario;
    }

    //Admin Cambio contraseña
    @Override
    public boolean cambiarPass(String password,Long id) {
    	boolean puedeCambiar;
    	try {
    		userDao.editCont(password,id);
    		puedeCambiar = true;
    	}catch (SQLException e){
    		e.printStackTrace();
    		// ca va el codigo se falla el insert
    		puedeCambiar = false;
    	}
    	
    	return puedeCambiar;
    	
    }

    //Obtener todos los usuarios
    @Override
    public ArrayList<Usuario> obtenerInfoUsuarios(String apellido, String username){


    ArrayList<Usuario> infoUsuarios = null;
	try {
		infoUsuarios = userDao.findAll(apellido,username);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


    return infoUsuarios;
    }
    
    
   //Actualizar Usuario
    @Override
    public boolean ActualizarUsuario(Usuario User) {
    	boolean update;
    	try{
    		userDao.edit(User);
    		update = true;
    	}
    	catch (SQLException e){
    		e.printStackTrace();
    		// ca va el codigo se falla el insert
    		update = false;
    	}
    	
    	return update;

    }

	@Override
	public boolean ingresarNuevoUsuario(String nombre, String apellido, String doc, int genero, String correo,
			Date fecha, String usuario, String pass, Long userrol) {
		// TODO Auto-generated method stub
		return false;
	}
    
    
    

}
