package entidades;

import java.util.Date;

public class Usuario {
	
	private int idUsuario;
	private String ci;
	private String nombre;
	private String apellido;
	private Date fechaNac;
	private String genero;
	private String correo;
	private TipoPublico tipoPublico;
	private TipoReceta tipoReceta;
	private String contrasena;
	private String nomUsuario;
	
	//constructor
	public Usuario(int idUsuario,String ci,String nombre,String apellido,Date fechaNac,String genero,String correo,
			TipoPublico tipoPublico,TipoReceta tipoReceta,String contrasena,String nomUsuario) {
		super();
		this.idUsuario=idUsuario;
		this.ci = ci;
		this.nombre = nombre;
		this.apellido=apellido;
		this.fechaNac = fechaNac;
		this.genero = genero;
		this.correo = correo;
		this.tipoPublico = tipoPublico;
		this.tipoReceta = tipoReceta;
		this.contrasena = contrasena;
		this.nomUsuario = nomUsuario;
	}
		
	//getters and setters
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario=idUsuario;
	}
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido=apellido;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public TipoPublico getTipoPublico() {
		return tipoPublico;
	}
	public void setTipoPublico(TipoPublico tipoPublico) {
		this.tipoPublico = tipoPublico;
	}
	public TipoReceta getTipoReceta() {
		return tipoReceta;
	}
	public void setTipoReceta(TipoReceta tipoReceta) {
		this.tipoReceta = tipoReceta;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getNomUsuario() {
		return nomUsuario;
	}
	public void setUsername(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}
	
	//to String
	@Override
	public String toString() {
		return "Usuario [ID Usuario=" +idUsuario+",ci=" +ci+", nombre=" +nombre+",apellido=" +apellido+","
					+ "fechaNac=" +fechaNac+",género=" +genero+",correo=" +correo+",tipoPublico=" +tipoPublico+","
						+ "tipoReceta=" +tipoReceta+",contrasena="	+contrasena+",username=" +nomUsuario+"]";
	}
	
}
