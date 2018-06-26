package com.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TipoRecetas
 *
 */
@Entity
@Table(name="DIETA")

public class TipoDieta implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="TipoDietaSeq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="TipoDietaSeq",sequenceName="SEQ_ID_DIETA",initialValue=1,allocationSize=1)
	@Column(name="ID_DIETA")
	private Long idDieta;
	
	@Column(name="NOMBRE",length=50,unique=true,nullable=false)
	private String nombre;
	
	//constructor por defecto.
	public TipoDieta() {
		super();
	}
	
	//constructor
	public TipoDieta(String nombre) {
		super();
		this.nombre=nombre;
	}
	
	//getters
	public Long getIdDieta() {
		return idDieta;
	}
	public void setIdDieta(Long idDieta) {
		this.idDieta=idDieta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	
   
}
