package frutasplanetas;

public class Fruta implements Comparable<Fruta> {

	private String nombre;
	
	public Fruta(String nombre){
		this.nombre = nombre;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int compareTo(Fruta o) {
		// TODO Auto-generated method stub
		return this.nombre.compareTo(o.getNombre());
	}
	
	public String toString() {
		return nombre;
	
}
}