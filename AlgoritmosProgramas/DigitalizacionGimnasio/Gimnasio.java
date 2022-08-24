import java.util.ArrayList;

/*Guillermo Arredondo
 * 21 de noviembre 2020
 * Clase Gimnasio 
 */
public class Gimnasio {
	private String nombre;
	private String ubicacion;
	private String encargado;
	private Gimnasta[][] competidores;
	private final String[] NIVELES= {"EXCEL 1", "EXCEL 2","EXCEL 3","EXCEL 4","EXCEL 5","EXCEL 6","EXCEL 7","EXCEL 8","EXCEL 9","EXCEL 10","FIG"};
	private Integer[] numCompsNivel;
	private final int MAX_COMPETIDORES=20;
	private final int MAX_NIVELES=11;
	
	public Gimnasio() {
		this.competidores=new Gimnasta[MAX_NIVELES][MAX_COMPETIDORES];
		this.numCompsNivel=new Integer[MAX_NIVELES];
		for(int i=0; i<MAX_NIVELES; i++) {
			numCompsNivel[i]=0;
		}
	}
	public Gimnasio(String nombre, String ubicacion, String encargado) {
		this();
		this.nombre=nombre;
		this.ubicacion=ubicacion;
		this.encargado=encargado;
	}
	public boolean isGimnasioVacio() {
		boolean res=true;
		int j=0;
				
		while(j<MAX_NIVELES && numCompsNivel[j]==0) {
			j++;
		}
		if(j!=MAX_NIVELES) {
			res=false;
		}
		return res;
	}
	public String getNombre() {
		return nombre;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public String getEncargado() {
		return encargado;
	}
	public int getMAX_NIVELES() {
		return MAX_NIVELES;
	}
	public int getNumCompsNivel(int nivel) {
		int res=-1;
		
		nivel--;
		if(nivel>=0 && nivel<MAX_NIVELES) {
			res=numCompsNivel[nivel];
		}
		return res;
	}
	public int getNumCompsNivel(String nivel) {
		int res=-1;
		nivel=nivel.toUpperCase();
		int pos=ManejadorArreglosGenericos.buscaSecDesorden(NIVELES, MAX_NIVELES, nivel);
		
		if(pos>=0) {
			res=numCompsNivel[pos];
		}
		return res;
	}
	public String getUnGimnasta(String curp) {
		String res="Persona no encontrada";
		curp.toUpperCase();
		Gimnasta aux=new Gimnasta(curp);
		int j, i;
		boolean encontre=false;
		
		j=0;
		while(!encontre && j<MAX_NIVELES) {
			i=0;
			while(i<numCompsNivel[j] && !competidores[j][i].equals(aux)) {
				i++;
			}
			if(i!=numCompsNivel[j]) {
				res=competidores[j][i].toString();
				encontre=true;
			}
			j++;
		}
		return res;
	}
	public String getUnGimnasta(int nivel, int pos) {
		String res="";
		
		if(nivel>=0 && pos>=0 && nivel<MAX_NIVELES && pos<numCompsNivel[nivel]) {
			res=competidores[nivel][pos].getNombre();
		}
		return res;
	}
	public String getUnMovimientoGimnasta(String curpGimnasta, String nombreMov) {
		String res="Gimnasta no encontrado";
		Gimnasta g=new Gimnasta(curpGimnasta);
		int j=0;
		int pos;
		boolean encontre=false;
		
		while(!encontre && j<MAX_NIVELES) {
			pos=ManejadorArreglosGenericos.buscaSecDesorden(competidores[j], numCompsNivel[j], g);
			if(pos>=0) {
				res=competidores[j][pos].getUnMovimiento(nombreMov);
				encontre=true;
			}
			j++;
		}
		return res;
	}
	public String getUnaCompetenciaGimnasta(String curpGimnasta, String nombreCompetencia) {
		String res="Gimnasta no encontrado";
		Gimnasta g=new Gimnasta(curpGimnasta);
		int j=0;
		int pos;
		boolean encontre=false;
		
		while(!encontre && j<MAX_NIVELES) {
			pos=ManejadorArreglosGenericos.buscaSecDesorden(competidores[j], numCompsNivel[j], g);
			if(pos>=0) {
				res=competidores[j][pos].getUnaCompetencia(nombreCompetencia);
				encontre=true;
			}
			j++;
		}
		return res;
	}
	public double getProteinasGimnasta(String curpGimnasta, boolean masMusculo) {
		double res=-1;	//bandera de error, no encontro gimnasta
		curpGimnasta=curpGimnasta.toUpperCase();
		Gimnasta g=new Gimnasta(curpGimnasta);
		int j=0;
		int pos;
		boolean encontre=false;
		
		while(!encontre && j<MAX_NIVELES) {
			pos=ManejadorArreglosGenericos.buscaSecDesorden(competidores[j], numCompsNivel[j], g);
			if(pos>=0) {
				res=competidores[j][pos].calculaProteinas(masMusculo);
				encontre=true;
			}
			j++;
		}
		return res;
	}
	public String getMovMasDificilGimnasta(String curpGimnasta) {
		String res="Gimnasta no encontrado";
		Gimnasta g=new Gimnasta(curpGimnasta);
		int j=0;
		int pos;
		boolean encontre=false;
		
		while(!encontre && j<MAX_NIVELES) {
			pos=ManejadorArreglosGenericos.buscaSecDesorden(competidores[j], numCompsNivel[j], g);
			if(pos>=0) {
				res=competidores[j][pos].movimientoMasDificil();
				encontre=true;
			}
			j++;
		}
		return res;
	}
	public String getGimnastasNivel(String nivel) {
		nivel=nivel.toUpperCase();
		String res="No hay gimnastas registradas en "+nivel;
		StringBuilder cad=new StringBuilder();
		int pos;
		
		pos=ManejadorArreglosGenericos.buscaSecDesorden(NIVELES, MAX_NIVELES, nivel);
		if(pos>=0) {
			for(int i=0; i<numCompsNivel[pos]; i++) {
				cad.append("\t"+competidores[pos][i].getNombre());
			}
			res=cad.toString();
		}
		return res;
	}
	public String getGimnastasNivel(int nivel) {
		String res="No hay gimnastas registradas en "+nivel;
		StringBuilder cad=new StringBuilder();
		
		if(nivel>=0 && nivel<MAX_NIVELES) {
			for(int i=0; i<numCompsNivel[nivel]; i++) {
				cad.append("       "+competidores[nivel][i].getNombre());
			}
			res=cad.toString();
		}
		return res;
	}
	public String getListaMovimientosGimnastaAparato(String curpGimnasta, String aparato) {
		String res="Gimnasta no encontrado";
		Gimnasta g=new Gimnasta(curpGimnasta);
		int j=0;
		int pos;
		boolean encontre=false;
		
		while(!encontre && j<MAX_NIVELES) {
			pos=ManejadorArreglosGenericos.buscaSecDesorden(competidores[j], numCompsNivel[j], g);
			if(pos>=0) {
				res=competidores[j][pos].getListaMovimAparato(aparato);
				encontre=true;
			}
			j++;
		}
		return res;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}
	public String setLogroCompetenciaGimnasta(String curpGimnasta, String nomComp, int logro) {
		String res="Gimnasta no encontrado";
		Gimnasta g=new Gimnasta(curpGimnasta);
		int j=0;
		int pos;
		boolean encontre=false;
		
		while(!encontre && j<MAX_NIVELES) {
			pos=ManejadorArreglosGenericos.buscaSecDesorden(competidores[j], numCompsNivel[j], g);
			if(pos>=0) {
				res=competidores[j][pos].setLogroCompetencia(nomComp, logro);
				encontre=true;
			}
			j++;
		}
		return res;
	}
	public boolean altaGimnasta(String nombre, String curp, int antiguedad, String estilo, int horario, double pesoKg) {
		boolean res=false;
		Gimnasta g;
		int n;
		
		//dar de alta por default en el nivel 1
		g=new Gimnasta(nombre, curp, antiguedad, estilo, horario, pesoKg);
		n=numCompsNivel[0];
		numCompsNivel[0]=ManejadorArreglosGenericos.insertaFinal(competidores[0], numCompsNivel[0], g);
		if(numCompsNivel[0]!=n) {
			res=true;
		}
		return res;
	}
	public boolean altaMovimientoGimnasta(String curpGimnasta, String nombre, String aparato, String posicionEjecucion, char dificultad, boolean obligatorio) {
		boolean res=false;
		Gimnasta g=new Gimnasta(curpGimnasta);
		int j=0;
		int pos;
		boolean encontre=false;
		
		while(!encontre && j<MAX_NIVELES) {
			pos=ManejadorArreglosGenericos.buscaSecDesorden(competidores[j], numCompsNivel[j], g);
			if(pos>=0) {
				res=competidores[j][pos].altaMovimiento(nombre, aparato, posicionEjecucion, dificultad, obligatorio);
				encontre=true;
			}
			j++;
		}
		return res;
	}
	public boolean altaCompetenciaGimnasta(String curpGimnasta, String nombre, String lugar, String categoria, int anioFecha) {
		boolean res=false;
		Gimnasta g=new Gimnasta(curpGimnasta);
		int j=0;
		int pos;
		boolean encontre=false;
		
		while(!encontre && j<MAX_NIVELES) {
			pos=ManejadorArreglosGenericos.buscaSecDesorden(competidores[j], numCompsNivel[j], g);
			if(pos>=0) {
				res=competidores[j][pos].altaCompetencia(nombre, lugar, categoria, anioFecha);
				encontre=true;
			}
			j++;
		}
		return res;
	}
	
	public String bajaCompetenciaGimnasta(String curpGimnasta, String nombre) {
		String res="Gimnasta no encontrado";
		Gimnasta g=new Gimnasta(curpGimnasta);
		int j=0;
		int pos;
		boolean encontre=false;
		
		while(!encontre && j<MAX_NIVELES) {
			pos=ManejadorArreglosGenericos.buscaSecDesorden(competidores[j], numCompsNivel[j], g);
			if(pos>=0) {
				res=competidores[j][pos].bajaCompetencia(nombre);
				encontre=true;
			}
			j++;
		}
		return res;
	}
	public String bajaGimnasta(String curp) {
		String res="Gimnasta no encontrado";
		int j=0;
		int pos;
		Gimnasta g=new Gimnasta(curp);
		boolean encontre=false;
		
		while(!encontre && j<MAX_NIVELES) {
			pos=ManejadorArreglosGenericos.buscaSecDesorden(competidores[j], numCompsNivel[j], g);
			if(pos>=0) {
				res=competidores[j][pos].toString();
				numCompsNivel[j]=ManejadorArreglosGenericos.elimina(competidores[j], numCompsNivel[j], pos);
				encontre=true;
			}
			j++;
		}
		return res;
	}
	
	public void actualizaGimnasio() {
		int nivel;
		
		for(int j=0; j<MAX_NIVELES; j++) {
			for(int i=0; i<numCompsNivel[j]; i++) {
				nivel=competidores[j][i].calculaNivel()-1;
				if(nivel!=j) {
					numCompsNivel[nivel]=ManejadorArreglosGenericos.insertaFinal(competidores[nivel], numCompsNivel[nivel], competidores[j][i]);
					numCompsNivel[j]=ManejadorArreglosGenericos.elimina(competidores[j], numCompsNivel[j], i);
				}
			}
		}
	}
	public int cuantosGimnastasConMovimiento(String nombre) {
		int contador=0;
		boolean aux;
		
		for(int j=0; j<MAX_NIVELES; j++) {
			for(int i=0; i<numCompsNivel[j]; i++) {
				aux=competidores[j][i].conMovimiento(nombre);
				if(aux) {
					contador++;
				}
			}
		}
		return contador;
	}
	public int gimnastasHorario(int horario) {
		int contador=0;
				
		for(int j=0; j<MAX_NIVELES; j++) {
			for(int i=0; i<numCompsNivel[j]; i++) {
				if(competidores[j][i].getHorario()==horario) {
					contador++;
				}
			}
		}
		return contador;
	}
	public int gimnastasEdad(int edad) {
		int contador=0;
		
		for(int j=0; j<MAX_NIVELES; j++) {
			for(int i=0; i<numCompsNivel[j]; i++) {
				if(competidores[j][i].getEdad()==edad) {
					contador++;
				}
			}
		}
		return contador;
	}
	public int cuantosGimnastasEnCompetencia(String nombreComp) {
		int contador=0;
		
		for(int j=0; j<MAX_NIVELES; j++) {
			for(int i=0; i<numCompsNivel[j]; i++) {
				if(competidores[j][i].participoCompetencia(nombreComp)) {
					contador++;
				}
			}
		}
		return contador;
	}
	public String gimnastaMayDificul() {
		String res="Ninguna gimnasta registrada";
		char mayor=' ';
		
		for(int j=0; j<MAX_NIVELES; j++) {
			for(int i=0; i<numCompsNivel[j]; i++) {
				if(competidores[j][i].mayDificultad()>mayor) {
					mayor=competidores[j][i].mayDificultad();
					res=competidores[j][i].toString();
				}
			}
		}
		return res;
	}
	public int cuantasExpertiseAparato(String aparato) {
		int contador=0;
		
		for(int j=0; j<MAX_NIVELES; j++) {
			for(int i=0; i<numCompsNivel[j]; i++) {
				if(competidores[j][i].mejorAparato().equalsIgnoreCase(aparato)) {
					contador++;
				}
			}
		}
		return contador;
	}
	public int cuantasEstilo(String estilo) {
		int contador=0;
		
		for(int j=0; j<MAX_NIVELES; j++) {
			for(int i=0; i<numCompsNivel[j]; i++) {
				if(competidores[j][i].getEstilo().equalsIgnoreCase(estilo)) {
					contador++;
				}
			}
		}
		return contador;
	}
	public int cuantasAntiguedad(int antiguedad) {
		int contador=0;
		
		for(int j=0; j<MAX_NIVELES; j++) {
			for(int i=0; i<numCompsNivel[j]; i++) {
				if(competidores[j][i].getAntiguedad()==antiguedad) {
					contador++;
				}
			}
		}
		return contador;
	}
	public String mejoresCompetenciasGimnastasNivel(String nivel) {
		ArrayList<String> aux=null;
		String res="No hay gimnastas registradas en nivel";
		nivel=nivel.toUpperCase();
		int pos;
		
		pos=ManejadorArreglosGenericos.buscaSecDesorden(NIVELES, MAX_NIVELES, nivel);
		if(pos>=0) {
			aux=new ArrayList<String>();
			for(int i=0; i<numCompsNivel[pos]; i++) {
				aux.add(competidores[pos][i].mejorCompetencia());
			}
			res=aux.toString();
		}
		return res;
	} 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ubicacion == null) ? 0 : ubicacion.hashCode());
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
		Gimnasio other = (Gimnasio) obj;
		if (ubicacion == null) {
			if (other.ubicacion != null) {
				return false;
			}
		} else if (!ubicacion.equals(other.ubicacion)) {
			return false;
		}
		return true;
	}
	public int compareTo(Gimnasio otro) {
		return this.ubicacion.compareTo(otro.ubicacion);
	}
	public String toString() {
		StringBuilder cad=new StringBuilder();
		
		cad.append("\n Gimnasio de nombre: "+nombre);
		cad.append("\n         ubicado en: "+ubicacion);
		cad.append("\n  bajo direccion de: "+encargado);
		for(int j=0; j<MAX_NIVELES; j++) {
			if(numCompsNivel[j]!=0) {
				cad.append("\n   en el nivel "+NIVELES[j]);
				cad.append("\t   hay los siguientes "+numCompsNivel[j].toString()+" gimnastas:");
			}
			for(int i=0; i<numCompsNivel[j]; i++) {
				cad.append("\n "+competidores[j][i].toString());
			}
			cad.append("\n ");
		}
		return cad.toString();
	}
	
}
