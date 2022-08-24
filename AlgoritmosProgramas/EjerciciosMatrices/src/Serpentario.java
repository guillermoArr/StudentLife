/*Guillermo Arredondo
 * 6 de noviembre 2020
 * Ejercicio 4 de matrices
 */
public class Serpentario {
	private String nombre;
	private Serpiente[][] serpientes;
	private String[] TIPOS= {"constrictor_man_gde", "constrictor_man_ch", "venenosa_oral", 
			"venenosa_cascabel", "venenosa_mamba"};
	private Integer[] numSerpientes;
	private static int NUM_TIPOS=5;
	private static int MAX_SERP=10;
	
	public Serpentario(String nombre) {
		this.nombre=nombre;
		this.serpientes=new Serpiente[NUM_TIPOS][MAX_SERP];
		/*for(int j=0; j<NUM_TIPOS; j++) {
			for(int i=0; i<MAX_SERP; i++) {
				serpientes[j][i]=null; 						CUANDO SE INSTANCIA UNA CLASE, POR DEFAULT EN JAVA TIENE VALORES NULL, NO HACE FALTA REPETIRLO
			}
		}*/
		this.numSerpientes=new Integer[NUM_TIPOS];
		for(int ren=0; ren<NUM_TIPOS; ren++) {
			numSerpientes[ren]=0;
		}
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUnaSerpiente(int claveSerp) {
		String res="Serpiente no registrada";
		Serpiente s=new Serpiente(claveSerp);
		int j=0;
		int pos;
		boolean encontre=false;
		
		while(!encontre && j<NUM_TIPOS) {
			pos=ManejadorArreglosGenericos.buscaSecDesorden(serpientes[j], numSerpientes[j], s);
			if(pos>=0) {
				res=serpientes[j][pos].toString();
				encontre=true;
			}
			j++;
		}
		return res;
	}
	public boolean altaSerpiente(String tipo, String alimentacion, double longitud, double peso, char genero) {
		boolean res=false;
		int pos;
		Serpiente s;
		int n;
		
		tipo=tipo.toLowerCase();
		pos=ManejadorArreglosGenericos.buscaSecDesorden(TIPOS, NUM_TIPOS, tipo);
		if(pos>=0 && numSerpientes[pos]<MAX_SERP) {
			s=new Serpiente(tipo, alimentacion, longitud, peso, genero);
			n=ManejadorArreglosGenericos.insertaFinal(serpientes[pos], numSerpientes[pos], s);
			numSerpientes[pos]=n;
			res=true;
		}
		return res;
	}
	
	public String bajaSerpiente(int claveSerp) {
		String res="Serpiente no registrada";
		Serpiente s=new Serpiente(claveSerp);
		int pos;
		int j=0;
		boolean existe=false;
		
		while(!existe && j<NUM_TIPOS) {
			pos=ManejadorArreglosGenericos.buscaSecDesorden(serpientes[j], numSerpientes[j], s);
			if(pos>=0) {
				existe=true;
				res=serpientes[j][pos].toString();
				numSerpientes[j]=ManejadorArreglosGenericos.elimina(serpientes[j], numSerpientes[j], pos);
			}
			j++;
		}
		return res;
	}
	public int cuentaPorAlimento(String alimento) {
		int cont=0;
		
		for(int j=0; j<NUM_TIPOS; j++) {
			for(int i=0; i<numSerpientes[j]; i++) {
				if(serpientes[j][i].getAlimentacion().equalsIgnoreCase(alimento)) {
					cont++;
				}
			}
		}
		return cont;
	}
	public String tipoMayNumSerp() {
		int pos=ManejadorArreglosGenericos.posMayor(numSerpientes, NUM_TIPOS);
		return TIPOS[pos];
	}
	public String toString() {
		StringBuilder cad=new StringBuilder();
		
		cad.append("\nSerpentario de nombre: "+nombre);
		cad.append("\n            contenido:");
		for(int j=0; j<NUM_TIPOS; j++) {
			cad.append("\n  Serpientes tipo: "+TIPOS[j]);
			cad.append("\t total de serpientes: "+numSerpientes[j]+"\n");
			for(int i=0; i<numSerpientes[j]; i++) {
				cad.append("\t"+serpientes[j][i]);
			}
			cad.append("\n");
		}
		return cad.toString();
	}
	public int compareTo(Serpentario otro) {
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
		Serpentario other = (Serpentario) obj;
		if (nombre == null) {
			if (other.nombre != null) {
				return false;
			}
		} else if (!nombre.equals(other.nombre)) {
			return false;
		}
		return true;
	}
	

}
