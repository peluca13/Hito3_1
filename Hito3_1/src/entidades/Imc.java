package entidades;

import java.util.Date;

public class Imc {
	private int idImc;
	private Date fecha;
	private double altura;
	private double peso;
	private Usuario usuario;
	
	//constructor
	public Imc(int idImc,Date fecha, double altura, double peso,Usuario usuario) {
		super();
		this.idImc=idImc;
		this.fecha = fecha;
		this.altura = altura;
		this.peso = peso;
		this.usuario = usuario;
	}
	
	//getters and setters
	public int getIdImc() {
		return idImc;
	}
	public void setIdImc(int idImc) {
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
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	//to String
	@Override
	public String toString() {
		return "IMC [Usuario=" +usuario+ ",Fecha=" +fecha+",Altura=" +altura+",Peso=" +peso+"]";
	}
	
}
