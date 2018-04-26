package entidades;

import java.util.Date;

public class IMC {
	private Usuario usuario;
	private Date fecha;
	private double altura;
	private double peso;
	
	//constructor
	public IMC(Usuario usuario, Date fecha, double altura, double peso) {
		super();
		this.usuario = usuario;
		this.fecha = fecha;
		this.altura = altura;
		this.peso = peso;
	}
	
	//getters and setters
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
	
	//to String
	@Override
	public String toString() {
		return "IMC [Usuario=" +usuario+ ",Fecha=" +fecha+",Altura=" +altura+",Peso=" +peso+"]";
	}
	
}
