package entidades;

public enum TipoPublico {
	TODOS(1,"Todos"),NINOS(2,"Niños"),ADULTOS(3,"Adultos");
	
	private int id;
	private String nombre;
	
	//constructor
	private TipoPublico(int id,String nombre) {
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
