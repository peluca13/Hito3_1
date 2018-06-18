package com.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="USUARIO")

public class Usuario implements Serializable{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="UsuarioSeq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="UsuarioSeq",sequenceName="SEQ_ID_USUARIO",initialValue=1,allocationSize=1)
	@Column(name="ID_USUARIO")
	private Long idUsuario;
	
	@Column(name="DOCUMENTO",length=20)
	private String documento;
	
	@Column(name="NOMBRE",length=50,nullable=false)
	private String nombre;
	
	@Column(name="APELLIDO",length=50,nullable=false)
	private String apellido;
	
	@Column(name="GENERO",nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private Genero genero;
	
	@Column(name="CONTRASENA",length=50,nullable=false)
	private String contrasena;
	
	@Column(name="CORREO_ELEC",length=50)
	private String correoElec;
	
	@ManyToOne
	@JoinColumn(name="ROL",nullable=false)
	private Rol rol;
		
	@Column(name="FEC_NAC",nullable=false)
	private Date fecNac;
	
	@Column(name="NOM_USUARIO",length=50,nullable=false,unique=true)
	private String nomUsuario;
	
	@ManyToOne
	@JoinColumn(name="TIPO_PUBLICO")
	private TipoPublico tipoPublico;
	
	@ManyToOne
	@JoinColumn(name="TIPO_DIETA")
	private TipoDieta tipoDieta;
	
	@OneToMany(cascade ={CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name="ID_USUARIO",nullable=false)
	private List<Imc> imcs;
	
	
	
	//constructor por defecto.
	public Usuario() {
		super();
	}
	
	//constructor con parámetros.
	public Usuario(String documento,String nombre,String apellido,Date fecNac,Genero genero,String correoElec,
			TipoPublico tipoPublico,TipoDieta tipoDieta,Rol rol,String contrasena,String nomUsuario,List<Imc> imcs) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.apellido=apellido;
		this.fecNac = fecNac;
		this.genero = genero;
		this.correoElec = correoElec;
		this.tipoPublico = tipoPublico;
		this.tipoDieta = tipoDieta;
		this.rol=rol;
		this.contrasena = contrasena;
		this.nomUsuario = nomUsuario;
		this.imcs=imcs;
	}
		
	//getters and setters
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario=idUsuario;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido=apellido;
	}
	public Date getFecNac() {
		return fecNac;
	}
	public void setFechaNac(Date fecNac) {
		this.fecNac = fecNac;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public String getCorreoElec() {
		return correoElec;
	}
	public void setCorreoElec(String correoElec) {
		this.correoElec = correoElec;
	}
	public TipoPublico getTipoPublico() {
		return tipoPublico;
	}
	public void setTipoPublico(TipoPublico tipoPublico) {
		this.tipoPublico = tipoPublico;
	}
	public TipoDieta getTipoDieta() {
		return tipoDieta;
	}
	public void setTipoDieta(TipoDieta tipoDieta) {
		this.tipoDieta = tipoDieta;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRols(Rol rol) {
		this.rol=rol;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getNomUsuario() {
		return nomUsuario;
	}
	public void setUsername(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}
	public List<Imc> getImcs(){
		return imcs;
	}
	public void setImcs(List<Imc> imcs) {
		this.imcs=imcs;
	}
	
	//to String
	@Override
	public String toString() {
		return "Usuario [ID Usuario=" +idUsuario+", ci=" +documento+", nombre=" +nombre+", apellido=" +apellido+", "
					+ "fechaNac=" +fecNac+", género=" +genero+", correo=" +correoElec+", tipoPublicos=" +tipoPublico+", "
						+ "tipoDieta=" +tipoDieta+", rol=" +rol+", contrasena="	+contrasena+", username=" +nomUsuario+", imcs=" +imcs+"]";
	}
	
}
