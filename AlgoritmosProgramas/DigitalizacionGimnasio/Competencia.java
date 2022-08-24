
/*Guillermo Arredondo
 * 21 de noviembre de 2020
 * Clase Competencia para arreglo de clase Gimnasta
 */
public class Competencia {
	private String nombre;
	private String lugar;
	private int anioFecha;
	private int logro;
	private String categoria;
	
	public Competencia(String nombre) {
		this.nombre=nombre;
	}
	public Competencia(String nombre, String lugar, String categoria, int anioFecha) {
		this.nombre=nombre;
		this.lugar=lugar;
		this.categoria=categoria;
		this.anioFecha=anioFecha;
		this.logro=0;
	}
	public Competencia(String nombre, String lugar, String categoria, int anioFecha, int logro) {
		this.nombre=nombre;
		this.lugar=lugar;
		this.categoria=categoria;
		this.anioFecha=anioFecha;
		this.logro=logro;
	}
	public String getNombre() {
		return nombre;
	}
	public String getLugar() {
		return lugar;
	}
	public int getAnioFecha() {
		return anioFecha;
	}
	public int getLogro() {
		return logro;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public void setAnioFecha(int anioFecha) {
		this.anioFecha = anioFecha;
	}
	public void setLogro(int logro) {
		this.logro = logro;
	}
	public int compareTo(Competencia otro) {
		return this.nombre.compareTo(otro.nombre);
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
		Competencia other = (Competencia) obj;
		if (nombre == null) {
			if (other.nombre != null) {
				return false;
			}
		} else if (!nombre.equals(other.nombre)) {
			return false;
		}
		return true;
	}
	public String toString() {
		StringBuilder cad=new StringBuilder();
		
		cad.append("\n Competencia de Gimnasia de nombre: "+nombre);
		cad.append("\n                        ubicada en: "+lugar);
		cad.append("\n                    durante el año: "+anioFecha);
		cad.append("\n                      de categoria: "+categoria);
		cad.append("\n                         resultado: "+logro);
		return cad.toString();
	}
}
