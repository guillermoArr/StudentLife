/*Guillermo Arredondo
 * 30 septiembre 2020
 * Clase de ejercicios de arreglos
 */
public class OfnaGob {
	private String encargado;
	private double[] poblacion;
	private String[] nomEdo;
	private int totEdos;
	private static final int MAX_EDOS=32;
	
	public OfnaGob() {
		poblacion=new double[MAX_EDOS];
		nomEdo=new String[MAX_EDOS];
		totEdos=0;
	}

	public OfnaGob(String encargado) {
		this();
		this.encargado = encargado;
	}

	public String getEncargado() {
		return encargado;
	}

	public double getUnaPoblacion(int posIndice) {
		double res=-1;
		
		if(posIndice>=0 && posIndice<totEdos) {
			res=poblacion[posIndice];
		}
		return res;
	}

	public String getUnNomEdo(int posIndice) {
		String res="Estado no registrado";
		
		if(posIndice>=0 && posIndice<totEdos) {
			res=nomEdo[posIndice];
		}
		return res;
	}

	public int getTotEdos() {
		return totEdos;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}
	
	public boolean altaInfoEdos(String nomEdo, double pob) {
		boolean res=false;
		
		if(this.totEdos<MAX_EDOS) {
			this.nomEdo[totEdos]=nomEdo;
			this.poblacion[totEdos]=pob;
			res=true;
			totEdos++;
		}
		return res;
	}
	
	public String nomEdoMayPob() {
		int max=ManejadorArreglos.posMayor(poblacion, totEdos);
		
		return nomEdo[max];
	}
	
	public double promHab() {
		double prom=ManejadorArreglos.promArreglos(poblacion, totEdos);
		
		return prom;
	}
	
	public int totEdosPobMayorProm() {
		// primero establecer variables lueo invocar a manejador arreglos
		double prom=ManejadorArreglos.promArreglos(poblacion, totEdos); // prom=promHab(); 
		int tot=ManejadorArreglos.cuantosMayorX(poblacion, totEdos, prom); // recuerda no usar p
				
		return tot;
	}

	public String toString() {
		StringBuilder cad=new StringBuilder();
		
		cad.append("\nOficina de Gobierno bajo el cargo de:"+encargado);
		cad.append("\n        total de estados registrados:"+totEdos);
		for(int i=0; i<totEdos; i++) {
			cad.append("\n nombre del estado: "+nomEdo[i]);
			cad.append("\n     con poblacion: "+poblacion[i]);
		}
		
		return cad.toString();
	}
	
	public int compareTo(OfnaGob otro) {
		return encargado.compareTo(otro.encargado);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((encargado == null) ? 0 : encargado.hashCode());
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
		OfnaGob other = (OfnaGob) obj;
		if (encargado == null) {
			if (other.encargado != null) {
				return false;
			}
		} else if (!encargado.equals(other.encargado)) {
			return false;
		}
		return true;
	}
	
}
