/*Guillermo Arredondo
 * 7 octubre 2020
 * Clase pintura como apoyo para clase galeria
 */
public class Pintura {
	private String nombre;
	private String autor;
	private String tecnica;
	private int ahoTerm;
	private double precio;
	
	public Pintura() {
	}
	public Pintura(String nombre) {
		this.nombre=nombre;
	}
	public Pintura(String nombre, String autor, String tecnica, int ahoTerm, double precio) {
		this.nombre=nombre;
		this.autor=autor;
		this.tecnica=tecnica;
		this.ahoTerm=ahoTerm;
		this.precio=precio;
	}
	public String getNombre() {
		return nombre;
	}
	public String getAutor() {
		return autor;
	}
	public String getTecnica() {
		return tecnica;
	}
	public int getAhoTerm() {
		return ahoTerm;
	}
	public double getPrecio() {
		return precio;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}
	public void setAhoTerm(int ahoTerm) {
		this.ahoTerm = ahoTerm;
	}
	public void setPrecio(double precio) {     // checa esta
		this.precio = precio;
	}
	public String toString() {
		StringBuilder cad=new StringBuilder();
		
		cad.append("\n Pintura de nombre: "+nombre);
		cad.append("\n          de autor: "+autor);
		cad.append("\n           tecnica: "+tecnica);
		cad.append("\n   termina el anio: "+ahoTerm);
		cad.append("\n            precio: $"+precio);
		
		return cad.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Pintura other = (Pintura) obj;
		if (nombre == null) {
			if (other.nombre != null) {
				return false;
			}
		} else if (!nombre.equals(other.nombre)) {
			return false;
		}
		return true;
	}
	public int compareTo(Pintura otro) {
		return this.nombre.compareTo(otro.nombre);
	}

}
