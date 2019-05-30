package com.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ALIMENTO")

public class Alimento implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="AlimentoSeq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="AlimentoSeq",sequenceName="SEQ_ID_ALIMENTO",initialValue=1,allocationSize=1)
	@Column(name="ID_ALIMENTO")
	private Long idAlimento;
	
	@Column(name="NOMBRE",length=50,unique=true,nullable=false)
	private String nombre;
	
	@Column(name="AZUCAR",length=50,nullable=false)
	private String azucar;
	
	@Column(name="CLORURO_SODIO",nullable=false)
	private int cloruroSodio;
	
	@Column(name="VALORESXPORCION",nullable=false)
	private int valorXPorcion;
	
	@Column(name="GRASAS_TRANS",nullable=false)
	private int grasasTrans;
	
	@Column(name="VALOR_ENERGETICO",nullable=false)
	private int valorEnergetico;
	
	@Column(name="CALORIAS",nullable=false)
	private int calorias;
		
	@Column(name="GRASAS_SATURADAS",nullable=false)
	private int grasasSaturadas;
	
	//constructor por defecto.
	public Alimento() {
		super();
	}
	
	//constructor
	public Alimento(String nombre,String azucar,int cloruroSodio,int valorXPorcion,int grasasTrans,int valorEnergetico,int calorias,int grasasSaturadas) {
		super();
		this.nombre=nombre;
		this.azucar=azucar;
		this.cloruroSodio=cloruroSodio;
		this.valorXPorcion=valorXPorcion;
		this.grasasTrans=grasasTrans;
		this.valorEnergetico=valorEnergetico;
		this.calorias=calorias;		
		this.grasasSaturadas=grasasSaturadas;
	}
	
	//getters and setters
	public Long getIdAlimento() {
		return idAlimento;
	}
	public void setIdAlimento(Long idAlimento) {
		this.idAlimento=idAlimento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public int getValorXPorcion() {
		return valorXPorcion;
	}
	public void setValorXPorcion(int valorXPorcion) {
		this.valorXPorcion=valorXPorcion;
	}
	public int getCalorias() {
		return calorias;
	}
	public  void setCalorias(int calorias) {
		this.calorias=calorias;
	}
	public int getValorEnergetico() {
		return valorEnergetico;
	}
	public void setValorEnergetico(int valorEnergetico) {
		this.valorEnergetico=valorEnergetico;
	}
	public String getAzucar() {
		return azucar;
	}
	public void setAzucar(String azucar) {
		this.azucar=azucar;
	}
	public int getcloruroSodio() {
		return cloruroSodio;
	}
	public void setCloruroSodio(int cloruroSodio) {
		this.cloruroSodio=cloruroSodio;
	}
	public int getGrasasTrans() {
		return grasasTrans;
	}
	public void setGrasasTrans(int grasasTrans) {
		this.grasasTrans=grasasTrans;
	}
	public int getGrasasSaturadas() {
		return grasasSaturadas;
	}
	public void setGrasasSaturadas(int grasasSaturadas) {
		this.grasasSaturadas=grasasSaturadas;
	}
	
	//to String
	@Override
	public String toString(){
		return "Alimento [id=" +idAlimento+",nombre=" +nombre+",valor por porción=" +valorXPorcion+","
				+ "calorias=" +calorias+",valor energético=" +valorEnergetico+",azúcar=" +azucar+","
				+ "cloruro de sodio=" +cloruroSodio+",grasas trans=" +grasasTrans+",grasas saturadas=" +grasasSaturadas+"]";
	}
	
}
