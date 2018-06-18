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
	
	@Column(name="AZUCAR",nullable=false)
	private double azucar;
	
	@Column(name="CLORURO_SODIO",nullable=false)
	private double cloruroSodio;
	
	@Column(name="VALORESXPORCION",nullable=false)
	private double valorXPorcion;
	
	@Column(name="GRASAS_TRANS",nullable=false)
	private double grasasTrans;
	
	@Column(name="VALOR_ENERGENTICO",nullable=false)
	private double valorEnergetico;
	
	@Column(name="CALORIAS",nullable=false)
	private double calorias;
		
	@Column(name="GRASAS_SATURADAS",nullable=false)
	private double grasasSaturadas;
	
	//constructor por defecto.
	public Alimento() {
		super();
	}
	
	//constructor
	public Alimento(String nombre,double azucar,double cloruroSodio,double valorXPorcion,double grasasTrans,double valorEnergetico,double calorias,double grasasSaturadas) {
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
	public double getValorXPorcion() {
		return valorXPorcion;
	}
	public void setValorXPorcion(double valorXPorcion) {
		this.valorXPorcion=valorXPorcion;
	}
	public double getCalorias() {
		return calorias;
	}
	public  void setCalorias(double calorias) {
		this.calorias=calorias;
	}
	public double getValorEnergetico() {
		return valorEnergetico;
	}
	public void setValorEnergetico(double valorEnergetico) {
		this.valorEnergetico=valorEnergetico;
	}
	public double getAzucar() {
		return azucar;
	}
	public void setAzucar(double azucar) {
		this.azucar=azucar;
	}
	public double getcloruroSodio() {
		return cloruroSodio;
	}
	public void setCloruroSodio(double cloruroSodio) {
		this.cloruroSodio=cloruroSodio;
	}
	public double getGrasasTrans() {
		return grasasTrans;
	}
	public void setGrasasTrans(double grasasTrans) {
		this.grasasTrans=grasasTrans;
	}
	public double getGrasasSaturadas() {
		return grasasSaturadas;
	}
	public void setGrasasSaturadas(double grasasSaturadas) {
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
