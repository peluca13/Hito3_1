package entidades;

public enum TipoPublico {
	TODOS(1,"Todos"),NINOS(2,"Niños"),ADULTOS(3,"Adultos");
	
	private int id;
	private String tipo;
	
	//constructor
	private TipoPublico(int id,String tipo) {
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
