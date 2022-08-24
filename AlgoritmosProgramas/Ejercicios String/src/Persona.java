/*Guillermo Arredondo
 * 23 Octubre 2020
 * Clase Persona para ejercicio Fiesta
 */
public class Persona implements Comparable <Persona> {
	private String nombre;
	private String curp;
	private int ahoNac;
	private String edoCivil;
	private char genero;
	private String edoNac;
	
	private String[] vacunas;
	private String[] fecha;
	private int numVacunas;
	private final int MAX_VACUNAS=100;
	
	public Persona(String curp) {
		this.curp=curp;
	}
	public Persona(String nombre, String curp, String edoCivil) {
		String aho;
		
		this.nombre=nombre;
		this.curp=curp;
		this.edoCivil=edoCivil;
		this.curp=curp.toUpperCase();
		this.genero=curp.charAt(10);
		this.edoNac=curp.substring(11, 13);
		
		aho=curp.substring(4, 6);
		this.ahoNac=Integer.parseInt(aho);
		if(ahoNac>20) {
			this.ahoNac+=1900;
		}
		else {
			this.ahoNac+=2000;
		}
		this.numVacunas=0;
		this.vacunas=new String[MAX_VACUNAS];
		this.fecha=new String[MAX_VACUNAS];
		
	}

	public String getNombre() {
		return nombre;
	}

	public String getCurp() {
		return curp;
	}

	public int getAhoNac() {
		return ahoNac;
	}

	public String getEdoCivil() {
		return edoCivil;
	}

	public char getGenero() {
		return genero;
	}
	
	public String getEdoNac() {
		return edoNac;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getVacunaEnFecha(String fecha) {
		String res="Vacuna no encontrada";
		int pos;
		
		pos=ManejadorArreglosGenericos.buscaSecDesorden(this.fecha, numVacunas, fecha);
		if(pos!=-1) {
			res=vacunas[pos].toString();
		}
		return res;
	}
	public String getFechaDeVacuna(String vacuna) {
		int pos;
		String res="Vacuna no encontrada";
		
		pos=ManejadorArreglosGenericos.buscaSecDesorden(vacunas, numVacunas, vacuna);
		if(pos>=0) {
			res=fecha[pos].toString();
		}
		return res;
	}
	public int getNumVacunas() {
		return numVacunas;
	}
	public void setEdoCivil(String edoCivil) {
		this.edoCivil = edoCivil;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}
	public boolean altaVacuna(String vacuna, String fecha) {
		boolean res=false;
		
		if(numVacunas<MAX_VACUNAS) {
			vacunas[numVacunas]=vacuna;
			this.fecha[numVacunas]=fecha;
			numVacunas++;
			res=true;
		}
		return res;
	}
	public int calculaEdad(int ahoActual) {
		return ahoActual-ahoNac;
	}
	public boolean vacunaAplicada(String vacuna) {
		boolean res=false;
		int pos;
		
		pos=ManejadorArreglosGenericos.buscaSecDesorden(vacunas, numVacunas, vacuna);
		if(pos>=0) {
			res=true;
		}
		return res;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curp == null) ? 0 : curp.hashCode());
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
		Persona other = (Persona) obj;
		if (curp == null) {
			if (other.curp != null) {
				return false;
			}
		} else if (!curp.equals(other.curp)) {
			return false;
		}
		return true;
	}
	public int compareTo(Persona otro) {
		return this.curp.compareTo(otro.curp);
	}
	public String toString() {
		StringBuilder cad=new StringBuilder();
		
		cad.append("\n Persona de nombre: "+nombre);
		cad.append("\n           de CURP: "+curp);
		cad.append("\n   que nació en el: "+ahoNac);
		cad.append("\n      en el estado: "+edoNac);
		cad.append("\n         de genero: "+genero);
		cad.append("\n      estado civil: "+edoCivil);
		cad.append("\n     numero de Vacunas aplicadas: "+numVacunas);
		for(int i=0; i<numVacunas; i++) {
			cad.append("\n              vacuna: "+vacunas[i].toString());
			cad.append("\n fecha de aplicacion: "+fecha[i].toString());
		}
		return cad.toString();
	}

}
