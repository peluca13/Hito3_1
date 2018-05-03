package entidades;

import java.util.Date;

public class Usuario {
	
	private int idUsuario;
	private String documento;
	private String nombre;
	private String apellido;
	private Date fecNac;
	private String genero;
	private String correoElec;
	private TipoPublico tipoPublico;
	private TipoReceta tipoReceta;
	private int rol;
	private String contrasena;
	private String nomUsuario;
	
	//constructor
	public Usuario(int idUsuario,String documento,String nombre,String apellido,Date fecNac,String genero,String correoElec,
			TipoPublico tipoPublico,TipoReceta tipoReceta,int rol,String contrasena,String nomUsuario) {
		super();
		this.idUsuario=idUsuario;
		this.documento = documento;
		this.nombre = nombre;
		this.apellido=apellido;
		this.fecNac = fecNac;
		this.genero = genero;
		this.correoElec = correoElec;
		this.tipoPublico = tipoPublico;
		this.tipoReceta = tipoReceta;
		this.rol=rol;
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
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
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
	public Date getFecNac() {
		return fecNac;
	}
	public void setFechaNac(Date fecNac) {
		this.fecNac = fecNac;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getCorreoElec() {
		return correoElec;
	}
	public void setCorreoElec(String correoElec) {
		this.correoElec = correoElec;
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
	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol=rol;
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
		return "Usuario [ID Usuario=" +idUsuario+",ci=" +documento+", nombre=" +nombre+",apellido=" +apellido+","
					+ "fechaNac=" +fecNac+",género=" +genero+",correo=" +correoElec+",tipoPublico=" +tipoPublico+","
						+ "tipoReceta=" +tipoReceta+",rol=" +rol+",contrasena="	+contrasena+",username=" +nomUsuario+"]";
	}
	
}
