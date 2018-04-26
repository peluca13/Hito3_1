package entidades;

import java.util.List;

public class Receta {
	private int idReceta;
	private String nombre;
	private List <Ingrediente> ingrediente;
	private String descripcion;
	private double caloriasTotales;
	private Categoria categoria;
	private TipoPublico tipoPublico;
	private TipoReceta tipoReceta;
	
	//constructor
	public Receta(int idReceta, String nombre, List<Ingrediente> ingrediente, String descripcion, double caloriasTotales,
			Categoria categoria, TipoPublico tipoPublico, TipoReceta tipoReceta) {
		super();
		this.idReceta = idReceta;
		this.nombre = nombre;
		this.ingrediente = ingrediente;
		this.descripcion = descripcion;
		this.caloriasTotales = caloriasTotales;
		this.categoria = categoria;
		this.tipoPublico = tipoPublico;
		this.tipoReceta = tipoReceta;
	}
	
	//getters and setters
	public int getIdReceta() {
		return idReceta;
	}
	public void setId(int idReceta) {
		this.idReceta=idReceta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public List <Ingrediente> getIngrediente(){
		return ingrediente;
	}
	public void setIngrediente(List<Ingrediente> ingrediente) {
		this.ingrediente=ingrediente;
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
	public TipoReceta getTipoReceta() {
		return tipoReceta;
	}
	public void setTipoReceta(TipoReceta tipoReceta) {
		this.tipoReceta=tipoReceta;
	}
	
	//to String
	@Override
	public  String toString() {
		return "Receta [ID Receta=" +idReceta+",nombre=" +nombre+",ingrediente=" +ingrediente+","
				+ "descripcion=" +descripcion+",calorías totales=" +caloriasTotales+",categoría=" +categoria+","
						+ "tipo público=" +tipoPublico+",tipo receta=" +tipoReceta+"]";
	}
}
