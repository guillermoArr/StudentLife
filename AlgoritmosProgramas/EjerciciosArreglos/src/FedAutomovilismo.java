/*Guillermo Arredondo
 * 17 octubre 2020
 * Examen tercer parcial FEMADAC
 */
public class FedAutomovilismo {
	private String nombre;
	private Piloto[] registroAlfab;
	private int totPilotos;
	private final int MAX_PILOTOS=100;
	
	public FedAutomovilismo() {
		registroAlfab=new Piloto[MAX_PILOTOS];
		totPilotos=0;
	}
	public FedAutomovilismo(String nombre) {
		this();
		this.nombre=nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public int getTotPilotos() {
		return totPilotos;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
/*	public boolean altaPiloto(String nombre, String genero, double peso, double estatura, int puntosComp, boolean campeon) {
		boolean res=false;
		Piloto p;
		int i=0;
		
		if(totPilotos<MAX_PILOTOS) {
			//p=new Piloto(nombre, genero, peso, estatura, puntosComp, campeon);
			while(i<totPilotos && registroAlfab[i].getNombre().compareTo(nombre)<0) {
				i++;
			}
			if(i==totPilotos || registroAlfab[i].getNombre().compareTo(nombre)>0) {
				p=new Piloto(nombre, genero, peso, estatura, puntosComp, campeon);
				if(i==0) {
					registroAlfab[totPilotos]=p;
				}
				else {
					for(int j=totPilotos; j>i; j--) {
						registroAlfab[j]=registroAlfab[j-1];
					}
					registroAlfab[i]=p;
				}
				res=true;
				totPilotos++;
			}
		}
		return res;
	}*/
	public boolean altaPiloto(String nombre, String genero, double peso, double estatura, int puntosComp, boolean campeon) {
		boolean res=false;
		Piloto p;
		int i=0;
		
		if(totPilotos<MAX_PILOTOS) {
			p=new Piloto(nombre, genero, peso, estatura, puntosComp, campeon);
			while(i<totPilotos && registroAlfab[i].compareTo(p)<0) {
				i++;
			}
			if(i==totPilotos || !registroAlfab[i].equals(p)) {
				for(int j=totPilotos; j>i; j--) {
					registroAlfab[j]=registroAlfab[j-1];
				}
				registroAlfab[i]=p;
				res=true;
				totPilotos++;
			}
			
		}
		return res;
	}
	public double promPuntosTot() {
		double prom=0;
		double total=0;
		
		for(int i=0; i<totPilotos; i++) {
			total+=registroAlfab[i].getPuntosComp();
		}
		if(totPilotos!=0) {
			prom=total/totPilotos;
		}
		
		return prom;
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
		FedAutomovilismo other = (FedAutomovilismo) obj;
		if (nombre == null) {
			if (other.nombre != null) {
				return false;
			}
		} else if (!nombre.equals(other.nombre)) {
			return false;
		}
		return true;
	}
	public int compareTo(FedAutomovilismo otro) {
		return this.nombre.compareTo(otro.nombre);
	}
	public String toString() {
		StringBuilder cad=new StringBuilder();
		
		cad.append("\n Federacion Automovilistica "+nombre);
		cad.append("\n             con total de: "+totPilotos+" pilotos");
		for(int i=0; i<totPilotos; i++) {
			cad.append("\n"+registroAlfab[i].toString());
		}
		return cad.toString();
	}

}
