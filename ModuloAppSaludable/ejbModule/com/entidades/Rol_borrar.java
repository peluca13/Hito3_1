package com.entidades;

public enum Rol_borrar {
	ADMINISTRADOR(1,"Administrador"),PERSONAL_INSTITUCION(2,"Personal Institución"),USUARIO(3,"Usuario");
	
	private int idRol;
	private String nombre;
	
	//constructor
	private Rol_borrar(int idRol,String nombre) {
		this.idRol=idRol;
		this.nombre=nombre;
	}
	
	//getters
	public int getIdRol() {
		return idRol;
	}
	public String getNombre() {
		return nombre;
	}

}
