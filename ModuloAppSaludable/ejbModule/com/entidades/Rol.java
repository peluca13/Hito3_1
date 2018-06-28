package com.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Rol
 *
 */
@Entity
@Table(name="ROL")

public class Rol implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="RolSeq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="RolSeq",sequenceName="SEQ_ID_ROL",initialValue=1,allocationSize=1)
	@Column(name="ID_ROL")
	private Long idRol;
	
	@Column(name="NOMBRE",length=50,unique=true,nullable=false)
	private String nombre;
	
	//constructor por defecto.
	public Rol() {
		super();
	}
	
	//constructor
	public Rol(String nombre) {
		super();
		this.nombre=nombre;
	}
	
	//getters
	public Long getIdRol() {
		return idRol;
	}
	public void setIdRol(Long idRol) {
		this.idRol=idRol;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
   
}
