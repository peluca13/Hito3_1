package com.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Categoria
 *
 */
@Entity
@Table(name="CATEGORIA")
public class Categoria implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="CategoriaSeq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="CategoriaSeq",sequenceName="SEQ_ID_CATEGORIA",initialValue=1,allocationSize=1)
	@Column(name="ID_CATEGORIA")
	private Long idCategoria;
	
	@Column(name="NOMBRE",length=50,unique=true,nullable=false)
	private String nombre;
	
	public Categoria() {
		super();
	}
	
	//constructor
	public Categoria(String nombre) {
		super();
		this.nombre=nombre;
	}
	
	//getters
	public Long getIdCategroia() {
		return idCategoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria=idCategoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setnombre(String nombre) {
		this.nombre=nombre;
	}
	
   
}
