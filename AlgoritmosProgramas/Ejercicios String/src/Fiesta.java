/*Guillermo Arredondo
 * 26 octubre 2020
 * Clase fiesta, grupo de personas, ejercicio de arreglos genericos
 */
public class Fiesta {
	private String lugar;
	private String fecha;
	private Persona[] invitados;
	private int numInvitados;
	private final int MAX_INVITADOS=50;
	
	public Fiesta(String lugar, String fecha) {
		this.lugar=lugar;
		this.fecha=fecha;
		this.numInvitados=0;
		this.invitados=new Persona[MAX_INVITADOS];
	}

	public String getLugar() {
		return lugar;
	}

	public String getFecha() {
		return fecha;
	}

	public String getUnInvitado(int pos) {
		String res="Persona no registrada";
		
		if(pos>=0 && pos<numInvitados) {
			res=invitados[pos].toString();
		}
		return res;
	}
	public String getUnInvitado(String curp) {
		String res="Persona no registrada";
		Persona p=new Persona(curp);
		int pos;
		
		pos=ManejadorArreglosGenericos.buscaSecOrdenada(invitados, numInvitados, p);
		if(pos>=0) {
			res=invitados[pos].toString();
		}
		return res;
	}

	public int getNumInvitados() {
		return numInvitados;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public boolean altaInvitado(String nombre, String curp, String edoCivil) {
		boolean res=false;
		Persona p=new Persona(nombre, curp, edoCivil);
		int n;
		
		n=ManejadorArreglosGenericos.insertaEnOrden(invitados, numInvitados, p);
		if(n!=numInvitados) {
			numInvitados=n;
			res=true;
		}
		return res;
	}
	public boolean altaVacunaInvitado(String curp, String vacuna, String fecha) {
		boolean res=false;
		int pos;
		Persona p=new Persona(curp);
		
		pos=ManejadorArreglosGenericos.buscaSecOrdenada(invitados, numInvitados, p);
		if(pos>=0) {
			res=invitados[pos].altaVacuna(vacuna, fecha);
		}
		return res;
	}

	public String bajaInvitado(String curp) {
		String res="Persona no habia sido invitada";
		int pos;
		Persona p=new Persona(curp);
		
		pos=ManejadorArreglosGenericos.buscaSecOrdenada(invitados, numInvitados, p);
		if(pos>=0) {
			res=invitados[pos].toString();
			numInvitados=ManejadorArreglosGenericos.elimina(invitados, numInvitados, pos);
		}
		return res;
	}

	public int cuantosGenero(char genero) {
		int res=0;
		
		for(int i=0; i<numInvitados; i++){
			if(invitados[i].getGenero()==genero) {
				res++;
			}
		}
		return res;
	}

	public boolean estaInvitado(String curp) {
		boolean res=false;
		int pos;
		Persona p=new Persona(curp);
		
		pos=ManejadorArreglosGenericos.buscaSecOrdenada(invitados, numInvitados, p);
		if(pos>=0) {
			res=true;
		}
		return res;
	}

	public String elMasJoven() {
		int pos=0;
		int min;
		String res="No hay invitados";
		
		if(numInvitados!=0) {
			min=invitados[pos].calculaEdad(2020);
			for(int i=1; i<numInvitados; i++) {
				if(min>invitados[i].calculaEdad(2020)) {
					min=invitados[i].calculaEdad(2020);
					pos=i;
				}
			}
			res=invitados[pos].toString();
		}
		return res;
	}

	private String elMasViejo() {
		int pos=0;
		int max;
		String res="No hay invitados";
		
		if(numInvitados!=0) {
			max=invitados[pos].calculaEdad(2020);
			for(int i=1; i<numInvitados; i++) {
				if(max<invitados[i].calculaEdad(2020)) {
					max=invitados[i].calculaEdad(2020);
					pos=i;
				}
			}
			res=invitados[pos].toString();
		}
		return res;
	}

	public double promedioEdad() {
		double prom=0;
		int edades=0;
		
		for(int i=0; i<numInvitados; i++) {
			edades+=invitados[i].calculaEdad(2020);
		}
		if(numInvitados!=0) {
			prom=(double) edades/numInvitados;
		}
		return prom;
	}

	public int cuantosEdoCivil(String edoCivil) {
		int res=0;
		
		for(int i=0; i<numInvitados; i++){
			if(invitados[i].getEdoCivil().equalsIgnoreCase(edoCivil)) {
				res++;
			}
		}
		return res;
	}

	public int cuantosVacunaAplicada(String vacuna) {
		int res=0;
		
		for(int i=0; i<numInvitados; i++){
			if(invitados[i].vacunaAplicada(vacuna)) {
				res++;
			}
		}
		return res;
	}

	public String toString() {
		StringBuilder cad=new StringBuilder();
		
		cad.append("\n   Fiesta del dia: "+fecha);
		cad.append("\n               en: "+lugar);
		cad.append("\n              con: "+numInvitados+"invitados");
		cad.append("\n       lista de invitados:");
		for(int i=0; i<numInvitados; i++) {
			cad.append("\n"+invitados[i].toString());
		}
		return cad.toString();
	}

	public int compareTo(Fiesta otro){
		return fecha.compareTo(otro.fecha);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
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
		Fiesta other = (Fiesta) obj;
		if (fecha == null) {
			if (other.fecha != null) {
				return false;
			}
		} else if (!fecha.equals(other.fecha)) {
			return false;
		}
		return true;
	}
	
	
	

}
