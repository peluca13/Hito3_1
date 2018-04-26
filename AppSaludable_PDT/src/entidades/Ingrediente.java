package entidades;

public class Ingrediente {
	private Alimento alimento;
	private int cantidadPorciones;
	
	public Ingrediente(Alimento alimento,int cantidadPorciones) {
		super();
		this.alimento=alimento;
		this.cantidadPorciones=cantidadPorciones;
	}
	//getters and setters
	public Alimento getAlimento() {
		return alimento;
	}
	public void setAlimento(Alimento alimento) {
		this.alimento=alimento;
	}
	public int getCantidadPorciones() {
		return cantidadPorciones;
	}
	public void setCantidadPorciones(int cantidadPorciones) {
		this.cantidadPorciones=cantidadPorciones;
	}
	
	//to String
	@Override
	public  String toString() {
		return "Ingrediente [alimento=" +alimento+",cantidad porciones=" +cantidadPorciones+"]";
	}
}
