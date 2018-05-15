package controladores;


import entidades.Usuario;
import manejadoresDAO.UsuarioDAO;
import interfaz.VentanaPrincipal;



public class ControladorUsuarios {
	
	public static boolean loginUsuario(String username, String contrasena){
		boolean validar;
		final Usuario usuario=UsuarioDAO.login(username, contrasena);
		if(usuario==null) {
			validar=false;
		}else {	validar=true;
			VentanaPrincipal ventana= VentanaPrincipal.getFrame();
			ventana.setVisible(true);
			ventana.menuRol(usuario.getRol().getNombre());
			
			}
		return validar;
	}
	
}
