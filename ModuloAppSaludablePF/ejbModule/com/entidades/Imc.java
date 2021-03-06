package com.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="IMC",uniqueConstraints=@UniqueConstraint(columnNames= {"FECHA","ID_USUARIO"}))

public class Imc implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="ImcSeq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="ImcSeq",sequenceName="SEQ_ID_IMC",initialValue=1,allocationSize=1)
	@Column(name="ID_IMC")
	private Long idImc;
	
	@Column(name="FECHA",nullable=false,columnDefinition = "DATE")
	private Date fecha;
	
	@Column(name="ALTURA",nullable=false)
	private float altura;
	
	@Column(name="PESO",nullable=false)
	private float peso;
	
	
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario idUsuario;
	
	
	
	//constructor por defecto.
	public Imc() {
		super();
	}
	
	//constructor
	public Imc(Date fecha, float altura, float peso,Usuario user) {
		super();
		this.fecha = fecha;
		this.altura = altura;
		this.peso = peso;
		this.idUsuario=user;
	}
	
	//getters and setters
	public Long getIdImc() {
		return idImc;
	}
	public void setIdImc(Long idImc) {
		this.idImc=idImc;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	//to String
	@Override
	public String toString() {
		return "IMC [IdImc=" +idImc+", Fecha=" +fecha+", Altura= " +altura+", Peso=" +peso+"]";
	}
	
}
