import java.util.ArrayList;

/*Guillermo Arredondo 
 * 11 de noviembre 2020
 * Clase Estacionamiento
 */
public class Estacionamiento {
	private String nombre;
	private String ubicacion;
	private Automovil[][] lugares;
	private final int MAX_PISOS=6;
	private final int MAX_LUGARES=10;
	
	public Estacionamiento(String nombre, String ubicacion) {
		Automovil relleno=new Automovil("vacio");
		
		this.lugares=new Automovil[MAX_PISOS][MAX_LUGARES];
		this.nombre=nombre;
		this.ubicacion=ubicacion;
		for(int j=0; j<MAX_PISOS; j++) {
			for(int i=0; i<MAX_LUGARES; i++) {
				lugares[j][i]=relleno;
			}
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public boolean altaAutomovil(int hora, int piso, int cajon, String placa, String marca, String modelo, int anio, String tipo) {
		boolean res=false;
		Automovil auto=new Automovil("vacio");
		
		if(piso>=0 && piso<MAX_PISOS && cajon>=0 && cajon<MAX_LUGARES) {
			if(lugares[piso][cajon].equals(auto)) {
				auto=new Automovil(placa, marca, modelo, anio, tipo, hora);
				lugares[piso][cajon]=auto;
				res=true;
			}
		}
		return res;
	}
	public boolean altaServicioAuto(String placa, String servicio, String fecha) {
		boolean res=false;
		Automovil aux=new Automovil(placa);
		int[] pos=ManejadorMatricesGenerico.buscaEnMatriz(lugares, MAX_PISOS, MAX_LUGARES, aux);
		
		if(pos[0]>=0) {
			res=lugares[pos[0]][pos[1]].altaServicio(servicio, fecha);
		}
		return res;
	}
	public boolean altaDuenio(String placa, String nombre, String curp, String edoCivil) {
		boolean res=false;
		Automovil aux=new Automovil(placa);
		int[] pos=ManejadorMatricesGenerico.buscaEnMatriz(lugares, MAX_PISOS, MAX_LUGARES, aux);
		
		if(pos[0]>=0) {
			res=lugares[pos[0]][pos[1]].setDuenio(nombre, curp, edoCivil);
		}
		return res;
	}
	
	public int cuantosAutosTipo(String tipo, int piso) {
		Automovil aux=new Automovil("vacio");
		int contador=0;
				
		if(piso>=0 && piso<MAX_PISOS) {
			for(int i=0; i<MAX_LUGARES; i++) {
				if(!lugares[piso][i].equals(aux) && lugares[piso][i].getTipo().equalsIgnoreCase(tipo)) {
					contador++;
				}
			}
		}
		return contador;
	}
	public int cuantosDisponibles() {
		int contador=0;
		Automovil aux=new Automovil("vacio");
		
		for(int j=0; j<MAX_PISOS; j++) {
			for(int i=0; i<MAX_LUGARES; i++) {
				if(lugares[j][i].equals(aux)) {
					contador++;
				}
			}
		}
		return contador;
	}
	public int cuantosServiciosAuto(String placa) {
		Automovil a=new Automovil(placa);
		int[] pos=ManejadorMatricesGenerico.buscaEnMatriz(lugares, MAX_PISOS, MAX_LUGARES, a);
		int numServicios=-1;
		
		if(pos[0]>=0) {
			numServicios=lugares[pos[0]][pos[1]].getNumServicios();
		}
		return numServicios;
	}
	public String cualesAutosConServicio(String servicio){
		ArrayList<String> res=new ArrayList<String>();
		
		for(int j=0; j<MAX_PISOS;j++) {
			for(int i=0; i<MAX_LUGARES; i++) {
				if(lugares[j][i].conServicio(servicio)) {
					res.add(lugares[j][i].getPlaca());
				}
			}
		}
		return res.toString();
	}
	public int[] cajonAutoMasViejo() {
		Automovil aux=new Automovil("vacio");
		int[] res=this.primerLugarOcupado();
		Automovil menor=lugares[res[0]][res[1]];
		
		for(int j=res[0]; j<MAX_PISOS; j++) {
			for(int i=0; i<MAX_LUGARES; i++) {
				if(!lugares[j][i].equals(aux) && lugares[j][i].compareTo(menor)<0){
					menor=lugares[j][i];
					res[0]=j;
					res[1]=i;
				}
			}
		}
		return res;
	}
	public int cuantosAutosMarca(String marca) {
		int contador=0;
		Automovil aux=new Automovil("vacio");
		
		for(int j=0; j<MAX_PISOS; j++) {
			for(int i=0; i<MAX_LUGARES; i++) {
				if(!lugares[j][i].equals(aux) && lugares[j][i].getMarca().equalsIgnoreCase(marca)) {
					contador++;
				}
			}
		}
		return contador;
	}
	
	public int pisoVacio() {
		int res=-1;
		boolean existe=false;
		int j=0;
		int i;
		Automovil aux=new Automovil("vacio");
		
		while(!existe && j<MAX_PISOS) {
			i=0;
			while(i<MAX_LUGARES && lugares[j][i].equals(aux)) {
				i++;
			}
			if(i==MAX_LUGARES) {
				res=j;
				existe=true;
			}
			j++;
		}
		return res; 
	}
	public int[] primerLugarLibre() {
		Automovil aux=new Automovil("vacio");
		
		return ManejadorMatricesGenerico.buscaEnMatriz(lugares, MAX_PISOS, MAX_LUGARES, aux);
	}
	public boolean estaLLeno() {
		boolean res=true;
		Automovil aux=new Automovil("vacio");
		int j=0;
		int i;
		
		while(res && j<MAX_PISOS) {
			i=0;
			while(i<MAX_LUGARES && !lugares[j][i].equals(aux)) {
				i++;
			}
			if(i!=MAX_LUGARES) {
				res=false;
			}
			j++;
		}
		return res;
	}
	public int[] primerLugarOcupado() {
		Automovil aux=new Automovil("vacio");
		int[] res= {-1, -1};
		int j=0;
		int i;
		boolean encontre=false;
		
		while(!encontre && j<MAX_PISOS) {
			i=0;
			while(i<MAX_LUGARES && lugares[j][i].equals(aux)) {
				i++;
			}
			if(i!=MAX_LUGARES) {
				res[0]=j;
				res[1]=i;
				encontre=true;
			}
			j++;
		}
		return res;
	}
	public String autoDuenioMayor() {
		Automovil aux=new Automovil("vacio");
		int[] pos=this.primerLugarOcupado();
		int mayor=lugares[pos[0]][pos[1]].getDuenio().calculaEdad(2020);
		String res=lugares[pos[0]][pos[1]].getPlaca();
		
		for(int j=0; j<MAX_PISOS; j++) {
			for(int i=0; i<MAX_LUGARES; i++) {
				if(!lugares[j][i].equals(aux) && lugares[j][i].getDuenio().calculaEdad(2020)>mayor) {
					mayor=lugares[j][i].getDuenio().calculaEdad(2020);
					res=lugares[j][i].getPlaca();
				}
			}
		}
		return res;
	}
	public int cuantosDuenioGenero(char genero) {
		int contador=0;
		//Automovil aux=new Automovil("vacio");
		
		for(int j=0; j<MAX_PISOS; j++) {
			for(int i=0; i<MAX_LUGARES; i++) {
				if(/*!lugares[j][i].equals(aux) &&*/ lugares[j][i].getDuenio().getGenero()==genero) {	// tipo primitivo, no importa si es null
					contador++;
				}
			}
		}
		return contador;
	}
	public int cuantosConVacunaInfluenza() {
		int contador=0; 
		String vacuna="influenza";
		Automovil aux=new Automovil("vacio");
		
		for(int j=0; j<MAX_PISOS; j++) {
			for(int i=0; i<MAX_LUGARES; i++) {
				if(!lugares[j][i].equals(aux) && lugares[j][i].getDuenio().vacunaAplicada(vacuna)) {
					contador++;
				}
			}
		}
		return contador;
	}
	
	public String toString() {
		StringBuilder cad=new StringBuilder();
		Automovil aux=new Automovil("vacio");
		
		cad.append("\n Estacionamiento de nombre: "+nombre);
		cad.append("\n     			  ubicado en: "+ubicacion);
		cad.append("\ncon un total de lugares de: "+MAX_PISOS*MAX_LUGARES);
		for(int j=0; j<MAX_PISOS; j++) {
			for(int i=0; i<MAX_LUGARES; i++) {
				if(!lugares[j][i].equals(aux)) {
					cad.append("\n\n ** En el piso "+j+" cajon "+i);
					cad.append(" Esta el "+lugares[j][i].toString());
				}
			}
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
		Estacionamiento other = (Estacionamiento) obj;
		if (nombre == null) {
			if (other.nombre != null) {
				return false;
			}
		} else if (!nombre.equals(other.nombre)) {
			return false;
		}
		return true;
	}
	public int compareTo(Estacionamiento otro) {
		return this.nombre.compareTo(otro.nombre);
	}
}
