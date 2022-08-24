import java.util.ArrayList;
/*Guillermo Arredondo
 * 7 octubre 2020
 * Galeria de Arte ej 10 pag 46
 */
public class GaleriaArte {
	private String nombre;
	private int telefono;
	private Pintura[] pinturas;
	private final int MAX_PINTURAS=100;
	private int totPinturas;
	
	public GaleriaArte() {
		this.pinturas=new Pintura[MAX_PINTURAS];
		this.totPinturas=0;
	}
	public GaleriaArte(String nombre, int telefono) {
		this();
		this.nombre=nombre;
		this.telefono=telefono;
	}
	public GaleriaArte(String nombre, int telefono, int numPinturas) {
		this.pinturas=new Pintura[numPinturas];
		this.totPinturas=0;
		this.nombre=nombre;
		this.telefono=telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public int getTelefono() {
		return telefono;
	}
	public int getTotPinturas() {
		return totPinturas;
	}
	public String getUnaPintura(int posPared) {
		String res;
		
		if(posPared>=1 && posPared<=totPinturas) {
			res=pinturas[posPared-1].toString(); //considerando que no haya alberca 0
		}
		else {
			res="Pintura no registrada";
		}
		return res;
	}
	public String getUnaPinturaXNom(String nombre) {
		String res;
		int i=0;
		Pintura p=new Pintura(nombre);
		
		while(i<totPinturas && !pinturas[i].equals(p)) { //busqueda desordenada por nombre
			i++;
		}
		if(i==totPinturas) {
			res="Pintura no encontrada";
		}
		else {
			res=pinturas[i].toString();
		}
		return res;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public void setUnaPintura(int posPared, String nombre, String autor, String tecnica, int ahoTerm, double precio){
		Pintura pieza;
		
		if(posPared>=1 && posPared<=totPinturas) {
			pieza=new Pintura(nombre, autor, tecnica, ahoTerm, precio);
			pinturas[posPared-1]=pieza;
		}
	}	
	public boolean altaPintura(String nomPintura, String autor, String tecnica, int ahoTerm, double prec) {
		boolean res=false;
		Pintura pieza;
		
		if(totPinturas<pinturas.length) {
			pieza=new Pintura(nomPintura, autor, tecnica, ahoTerm, prec);
			this.pinturas[totPinturas]=pieza;
			totPinturas++;
			res=true;
		}
		return res;
	}
	public String vendePintura(String nombre) {
		Pintura p;
		int i=0;
		String res="Pintura no registrada";
		
		p=new Pintura(nombre);
		while(i<totPinturas && !pinturas[i].equals(p)) {
			i++;
		}
		if(i!=totPinturas) {
			res=pinturas[i].toString();
			for(int j=i; j<totPinturas-1; j++) {
				pinturas[j]=pinturas[j+1];
			}
			totPinturas--;
			pinturas[totPinturas]=null;
		}
		return res;
	}
	public ArrayList<String> consultaPintorTecnica(String autor, String tecnica){
		ArrayList<String> lista=new ArrayList<String>();
		
		for(int i=0; i<totPinturas; i++) {
			if(pinturas[i].getAutor().equals(autor) && pinturas[i].getTecnica().equals(tecnica)) {
				lista.add(pinturas[i].getNombre());
			}
		}
		if(lista.isEmpty()) {
			lista=null;
		}
		return lista;
	}

	public boolean consultaPorPrecio(double prec) {
		boolean res=false;
		double p;
		int i=0;
		
		do {
			p=pinturas[i].getPrecio();
			if(p<prec) {
				res=true;
			}
			i++;
		} while(!res && i<totPinturas);
		return res;
	}
	public double precioPromVenta() {
		double prom=0;
		double total=0;
		
		for(int i=0; i<totPinturas; i++) {
			total+=pinturas[i].getPrecio();
		}
		if(totPinturas!=0) {
			prom=total/totPinturas;
		}
		
		return prom;
	}

	public String pinturaMasBarata() {
		int indiceMin=0;
		double minPrec=pinturas[0].getPrecio();
		
		
		for(int i=1; i<totPinturas; i++) {
			if(minPrec>pinturas[i].getPrecio()) {
				minPrec=pinturas[i].getPrecio();
				indiceMin=i;
			}
		}
		return pinturas[indiceMin].toString();
	}

	public int cuantosTecnica(String tecnica) {
		int numTecnica=0;
		
		for(int i=0; i<totPinturas; i++) {
			if(pinturas[i].getTecnica().equals(tecnica)) {
				numTecnica++;
			}
		}
		return numTecnica;
	}
	public int cuantasPinturasEnRango(int ahoI, int ahoF) {
		int piezasEnRango=0;
		
		for(int i=0; i<totPinturas; i++) {
			if(pinturas[i].getAhoTerm()>=ahoI && pinturas[i].getAhoTerm()<=ahoF) {
				piezasEnRango++;
			}
		}
		return piezasEnRango;
	}
	
	public String toString() {
		StringBuilder cad=new StringBuilder();
		
		cad.append("\n    Galeria de arte "+nombre);
		cad.append("\n      con telefono: "+telefono);
		cad.append("\n      con total de: "+totPinturas+" pinturas");
		for(int i=0; i<totPinturas; i++) {
			cad.append("\n"+pinturas[i].toString());
		}
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
		GaleriaArte other = (GaleriaArte) obj;
		if (nombre == null) {
			if (other.nombre != null) {
				return false;
			}
		} else if (!nombre.equals(other.nombre)) {
			return false;
		}
		return true;
	}
	public int compareTo(GaleriaArte otro) {
		return this.nombre.compareTo(otro.nombre);
	}

}
