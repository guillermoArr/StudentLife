/*Guillermo Arredondo
 * 21 de noviembre 2020
 * Clase movimiento gimnasitico para arreglo de clase Gimnasta
 */
public class MovimientoGym {
	private String nombre;
	private String aparato;
	private String posicionEjecucion;
	private char dificultad;		// la dificultad esta basado en letras
	private boolean obligatorio;
	
	public MovimientoGym(String nombre) {
		this.nombre=nombre;
	}
	public MovimientoGym(String nombre, String aparato, String posicionEjecucion, char dificultad, boolean obligatorio) {
		this.nombre=nombre;
		this.aparato=aparato;
		this.posicionEjecucion=posicionEjecucion;
		this.dificultad=dificultad;
		this.obligatorio=obligatorio;
	}
	public String getNombre() {
		return nombre;
	}
	public String getAparato() {
		return aparato;
	}
	public String getPosicionEjecucion() {
		return posicionEjecucion;
	}
	public char getDificultad() {
		return dificultad;
	}
	public boolean isObligatorio() {
		return obligatorio;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setAparato(String aparato) {
		this.aparato = aparato;
	}
	public void setPosicionEjecucion(String posicionEjecucion) {
		this.posicionEjecucion = posicionEjecucion;
	}
	public void setDificultad(char dificultad) {
		this.dificultad = dificultad;
	}
	public void setObligatorio(boolean obligatorio) {
		this.obligatorio = obligatorio;
	}
	public int compareTo(MovimientoGym otro) {
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
		MovimientoGym other = (MovimientoGym) obj;
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
		
		cad.append("\n Movimiento Gimnastico de nombre: "+nombre);
		cad.append("\n                sobre el aparato: "+aparato);
		cad.append("\n        en posicion de ejecucion: "+posicionEjecucion);
		cad.append("\n                   de dificultad: "+dificultad);
		if(obligatorio) {
			cad.append("\n       es de tipo obligatorio");
		}
		else {
			cad.append("\n    no es de tipo obligatorio");
		}
		return cad.toString();
	}

}
