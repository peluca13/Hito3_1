package com.entidades;

public enum TipoReceta_borrar {
	TODOS(1,"Todos"),DIABETICOS(2,"Diabéticos"),CELIACOS(3,"Celíacos"),VEGANOS(4,"Veganos");
	
	private int id;
	private String nombre;
	
	//constructor
	private TipoReceta_borrar(int id,String nombre) {
		this.id=id;
		this.nombre=nombre;
	}
	
	//getters
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}

}
