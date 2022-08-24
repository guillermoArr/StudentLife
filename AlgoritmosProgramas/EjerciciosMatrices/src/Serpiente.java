/*Guillermo Arredondo
 * 6 de noviembre 2020
 * Necesaria para clase Serpentario
 */
public class Serpiente {
	private int claveUnica;
	private String tipo;
	private String alimentacion;
	private double longitud;
	private double peso;
	private char genero;
	private static int generadorClaveUnica=100;
	
	public Serpiente(String tipo, String alimentacion, double longitud, double peso, char genero) {
		this.tipo=tipo;
		this.alimentacion=alimentacion;
		this.longitud=longitud;
		this.peso=peso;
		this.genero=genero;
		this.claveUnica=generadorClaveUnica;
		generadorClaveUnica+=5;
	}
	public Serpiente(int claveUnica) {
		this.claveUnica=claveUnica;
	}

	public int getClaveUnica() {
		return claveUnica;
	}

	public String getTipo() {
		return tipo;
	}

	public String getAlimentacion() {
		return alimentacion;
	}
	
	public double getLongitud() {
		return longitud;
	}

	public double getPeso() {
		return peso;
	}

	public char getGenero() {
		return genero;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setAlimentacion(String alimentacion) {
		this.alimentacion = alimentacion;
	}
	
	public String toString() {
		StringBuilder cad=new StringBuilder();
		
		cad.append("\nSerpiente de clave: "+claveUnica);
		cad.append("\n              tipo: "+tipo);
		cad.append("\n   de alimentacion: "+alimentacion);
		cad.append("\n       de longitud: "+longitud);
		cad.append("\n           de peso: "+peso);
		cad.append("\n         de genero: "+genero);
		
		return cad.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + claveUnica;
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
		Serpiente other = (Serpiente) obj;
		if (claveUnica != other.claveUnica) {
			return false;
		}
		return true;
	}
	
	public int compareTo(Serpiente otra) {
		int res;
		
		if(this.claveUnica==otra.claveUnica) {
			res=0;
		}
		else if(this.claveUnica<otra.claveUnica){
			res=-1;
		}
		else {
			res=1;
		}
		return res;
	}

}
