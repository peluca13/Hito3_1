package objetos;

public class Alimento {
	
	private int idAlimento;
	private String nombre;
	private double valorXPorcion;
	private double calorias;
	private double valorEnergetico;
	private double azucar;
	private double cloruroSodio;
	private double grasasTrans;
	private double grasasSaturadas;
	
	//constructor
	public Alimento(int idAlimento,String nombre,double valorXPorcion,double calorias,double valorEnergetico,double azucar,double cloruroSodio,double grasasTrans,double grasasSaturadas) {
		super();
		this.idAlimento=idAlimento;
		this.nombre=nombre;
		this.valorXPorcion=valorXPorcion;
		this.calorias=calorias;
		this.valorEnergetico=valorEnergetico;
		this.azucar=azucar;
		this.cloruroSodio=cloruroSodio;
		this.grasasTrans=grasasTrans;
		this.grasasSaturadas=grasasSaturadas;
	}
	
	//getters and setters
	public int getIdAlimento() {
		return idAlimento;
	}
	public void setIdAlimento(int idAlimento) {
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
