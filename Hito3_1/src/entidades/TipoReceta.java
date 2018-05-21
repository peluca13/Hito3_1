package entidades;

public enum TipoReceta {
	TODOS(1,"Todos"),DIABETICOS(2,"Diab�ticos"),CELIACOS(3,"Cel�acos"),VEGANOS(4,"Veganos");
	
	private int id;
	private String nombre;
	
	//constructor
	private TipoReceta(int id,String nombre) {
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
