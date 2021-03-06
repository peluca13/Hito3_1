package entidades;

public enum Categoria {
	DESAYUNO(1,"Desayuno"),ALMUERZO(2,"Almuerzo"),MERIENDA(3,"Merienda"),CENA(4,"Cena");
	
	private int id;
	private String nombre;
	
	//constructor
	private Categoria(int id,String nombre) {
		this.id=id;
		this.nombre=nombre;
	}
	
	//getters
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}

}
