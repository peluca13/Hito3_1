package com.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TipoPublicos
 *
 */
@Entity
@Table(name="PUBLICO")

public class TipoPublico implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="TipoPublicoSeq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="TipoPublicoSeq",sequenceName="SEQ_ID_PUBLICO",initialValue=1,allocationSize=1)
	@Column(name="ID_PUBLICO")
	private Long idPublico;
	
	@Column(name="NOMBRE",length=50,unique=true,nullable=false)
	private String nombre;
	
	//constructor por defecto.
	public TipoPublico() {
		super();
	}
	
	//constructor
		public TipoPublico(String nombre) {
			super();
			this.nombre=nombre;
		}
		
	//getters
	public Long getIdPublico() {
		return idPublico;
	}
	public void setIdPublico(Long idPublico) {
		this.idPublico=idPublico;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
   
}
