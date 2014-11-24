package es.concesionario.modelo;

public class Coche {
	private int id;
	private String matricula;
	private String marca;
	private String modelo;
	private String color;
	private int numCaballos;
	private boolean marchas;
	//constructores
	public Coche(int id, String matricula, String marca, String modelo,
			String color, int numCaballos, boolean marchas) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.numCaballos = numCaballos;
		this.marchas = marchas;
	}
	public Coche(String matricula, String marca, String modelo, String color,
			int numCaballos, boolean marchas) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.numCaballos = numCaballos;
		this.marchas = marchas;
	}
	public Coche(){
		super();
	}
	// gettes y setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getNumCaballos() {
		return numCaballos;
	}
	public void setNumCaballos(int numCaballos) {
		this.numCaballos = numCaballos;
	}
	public boolean isMarchas() {
		return marchas;
	}
	public void setMarchas(boolean marchas) {
		this.marchas = marchas;
	}
	
	
	

}
