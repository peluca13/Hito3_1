package com.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="RECETA")

public class Receta  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="RecetaSeq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="RecetaSeq",sequenceName="SEQ_ID_RECETA",initialValue=1,allocationSize=1)
	private Long idReceta;
	
	@Column(name="NOMBRE",length=50,unique=true,nullable=false)
	private String nombre;
	
	@Column(name="CALORIAS_TOTALES",nullable=false)
	private double caloriasTotales;
	
	@Column(name="DESCCRIPCION",length=50,nullable=false)
	private String descripcion;
	
	@ManyToOne
	@Column(name="ID_CATEGORIA",nullable=false)
	private Categoria categoria;
	
	@ManyToOne
	@Column(name="ID_PUBLICO",nullable=false)
	private TipoPublico tipoPublico;
	
	@ManyToOne
	@Column(name="ID_DIETA",nullable=false)
	private TipoDieta tipoDieta;
	
	@OneToMany
	@JoinColumn(name="ID_RECETA",unique=true,nullable=false)
	private List <Ingrediente> ingredientes;
	
	
	//constructor por defecto.
	public Receta() {
		super();
	}
		
	//constructor
	public Receta(String nombre,String descripcion,double caloriasTotales,Categoria categoria,TipoPublico tipoPublico,
			TipoDieta tipoDieta,List<Ingrediente> ingredientes) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.caloriasTotales = caloriasTotales;
		this.categoria = categoria;
		this.tipoPublico = tipoPublico;
		this.tipoDieta = tipoDieta;
		this.ingredientes = ingredientes;
	}
	
	//getters and setters
	public Long getIdReceta() {
		return idReceta;
	}
	public void setId(Long idReceta) {
		this.idReceta=idReceta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion=descripcion;
	}
	public double getCaloriasTotales() {
		return caloriasTotales;
	}
	public void setCaloriasTotales(double caloriasTotales) {
		this.caloriasTotales=caloriasTotales;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria=categoria;
	}
	public TipoPublico getTipoPublico() {
		return tipoPublico;
	}
	public void setTipoPublico(TipoPublico tipoPublico) {
		this.tipoPublico=tipoPublico;
	}
	public TipoDieta getTipoDieta() {
		return tipoDieta;
	}
	public void setTipoDieta(TipoDieta tipoDieta) {
		this.tipoDieta=tipoDieta;
	}
	public List <Ingrediente> getIngredientes(){
		return ingredientes;
	}
	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes=ingredientes;
	}
	
	//to String
	@Override
	public  String toString() {
		return "Receta [ID Receta=" +idReceta+",nombre=" +nombre+",ingrediente=" +ingredientes+","
				+ "descripcion=" +descripcion+",calorías totales=" +caloriasTotales+",categoría=" +categoria+","
						+ "tipo público=" +tipoPublico+",tipo dieta=" +tipoDieta+"]";
	}
}
