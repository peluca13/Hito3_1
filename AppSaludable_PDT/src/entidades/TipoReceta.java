package entidades;

public enum TipoReceta {
	TODOS(1,"Todos"),DIABETICOS(2,"Diabéticos"),CELIACOS(3,"Celíacos"),VEGANOS(4,"Veganos");
	
	private int id;
	private String tipo;
	
	//constructor
	private TipoReceta(int id,String tipo) {
		this.id=id;
		this.tipo=tipo;
	}
	
	//getters
	public int getId() {
		return id;
	}
	public String getTipo() {
		return tipo;
	}

}
