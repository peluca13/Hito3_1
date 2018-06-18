package com.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="COMPONE")
public class Ingrediente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="IngredienteSeq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="IngredienteSeq",sequenceName="SEQ_ID_COMPONE",initialValue=1,allocationSize=1)
	private Long idComposicion;
	
	@Column(name="CANTIDAD_PORCIONES",nullable=false)
	private int cantidadPorciones;
	
	@ManyToOne
	@Column(name="ID_ALIMENTO",unique=true,nullable=false)
	private Alimento alimento;
	
	//constructor por defecto.
	public Ingrediente() {
		super();
	}
	
	//constructor
	public Ingrediente(int cantidadPorciones,Alimento alimento) {
		super();
		this.cantidadPorciones=cantidadPorciones;
		this.alimento=alimento;
	}
	//getters and setters
	public Long getIdComposicion() {
		return idComposicion;
	}
	public void setIdComposicion(Long idComposicion) {
		this.idComposicion=idComposicion;
	}
	public int getCantidadPorciones() {
		return cantidadPorciones;
	}
	public void setCantidadPorciones(int cantidadPorciones) {
		this.cantidadPorciones=cantidadPorciones;
	}
	public Alimento getAlimento() {
		return alimento;
	}
	public void setAlimento(Alimento alimento) {
		this.alimento=alimento;
	}

	
	//to String
	@Override
	public  String toString() {
		return "Ingrediente [Id Composición=" +idComposicion+",cantidad porciones=" +cantidadPorciones+",alimento=" +alimento+"]";
	}
}
