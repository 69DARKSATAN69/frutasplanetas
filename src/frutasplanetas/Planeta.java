package frutasplanetas;

public class Planeta implements Comparable<Planeta> {

	private String nombre;
	
	public Planeta(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int compareTo(Planeta o) {
		// TODO Auto-generated method stub
		return this.nombre.compareTo(o.getNombre());
	}
	
	
	public String toString() {
		return nombre;
	}
	
	
	
}
