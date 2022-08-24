import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;;
/*Guillermo Arredondo
 * 21 de noviembre 2020
 * Clase Gimnasta para Matriz Gimnasio 
 */
public class Gimnasta {
	private String nombre;
	private String curp;
	private int edad;
	private char genero;
	private int antiguedad;
	private String estilo;
	private int horario;
	private double peso;
	private MovimientoGym[] movimientos;
	private Competencia[] competencias;
	private int numCompetencias;
	private int numMovimientos;
	private final int MAX_MOVIMIENTOS=100;
	private final int MAX_COMPETENCIAS=10; 	//pensemoslo en lapso de 3 años porque sino es un numero muy grande e innecesario
	// cada 3 años es bueno hacer un reciclaje del sistema, llamemoslo apoyo a la re-inscripcion 
	
	public Gimnasta(String curp) {
		this.curp=curp.toUpperCase();
	}
	public Gimnasta(String nombre, String curp, int antiguedad, String estilo, int horario, double pesoKg) {
		int ahoNac, ahoActual, mesActual, mesNac;
		String aho, mes;
		Calendar aux=new GregorianCalendar();
		
		this.movimientos=new MovimientoGym[MAX_MOVIMIENTOS];
		this.competencias=new Competencia[MAX_COMPETENCIAS];
		this.nombre=nombre;
		this.curp=curp.toUpperCase();
		this.genero=curp.charAt(10);
		
		aho=curp.substring(4, 6);
		ahoNac=Integer.parseInt(aho);
		if(ahoNac>20) {
			ahoNac+=1900;
		}
		else {
			ahoNac+=2000;
		}
		mes=curp.substring(6, 8);
		mesNac=Integer.parseInt(mes);
		//Calendar considera Enero como mes 0
		mesActual=aux.get(Calendar.MONTH)+1;
		ahoActual=aux.get(Calendar.YEAR);
		this.edad=ahoActual-ahoNac;
		if(mesNac>mesActual) {
			edad--;
		}
		
		this.antiguedad=antiguedad;
		this.estilo=estilo;
		this.horario=horario;
		this.peso=pesoKg;
		this.numCompetencias=0;
		this.numMovimientos=0;
	}
	public String getNombre() {
		return nombre;
	}
	public String getCurp() {
		return curp;
	}
	public char getGenero() {
		return genero;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public String getEstilo() {
		return estilo;
	}
	public int getHorario() {
		return horario;
	}
	
	public int getEdad() {
		return edad;
	}
	public double getPeso() {
		return peso;
	}
	
	public int getNumCompetencias() {
		return numCompetencias;
	}
	public int getNumMovimientos() {
		return numMovimientos;
	}
	// este metodo fue una idea para buscar gimnastas activas desde el incio del anio, pero despues murio la idea
	// es muy complicado y la verdad no hace algo que alguien quisiera saber en realidad
	public String getPrimeraCompetenciaAnio(int anio) {
		String res="Ninguna competencia registrada";
		int i=0;
		
		while(i<numCompetencias && competencias[i].getAnioFecha()!=anio) {
			i++;
		}
		if(i!=numCompetencias) {
			res=competencias[i].toString();
		}
		return res;
	}
	public String getUnaCompetencia(String nombre) {
		String res="Ninguna competencia registrada";
		Competencia aux=new Competencia(nombre);
		int pos;
		
		pos=ManejadorArreglosGenericos.buscaSecDesorden(competencias, numCompetencias, aux);
		if(pos>=0) {
			res=competencias[pos].toString();
		}
		return res;
	}
	public String getUnMovimiento(String nombre) {
		String res="Sin movimiento realizable";
		MovimientoGym aux=new MovimientoGym(nombre);
		int pos;
		
		pos=ManejadorArreglosGenericos.buscaSecDesorden(movimientos, numMovimientos, aux);
		if(pos>=0) {
			res=movimientos[pos].toString();
		}
		return res;
	}
	public String getListaMovimAparato(String aparato) {
		ArrayList<String> aux=new ArrayList<String>();
		
		for(int i=0; i<numMovimientos; i++) {
			if(movimientos[i].getAparato().equalsIgnoreCase(aparato)) {
				aux.add(movimientos[i].getNombre());
			}
		}
		if(aux.isEmpty()) {
			aux.add("Sin movimientos");
		}
		return aux.toString();
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setGenero(char genero) {
		this.genero = genero;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	public void setHorario(int horario) {
		this.horario = horario;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String setLogroCompetencia(String nomComp, int logro) {
		String res="Competencia no encontrada";
		Competencia aux=new Competencia(nomComp);
		int pos=ManejadorArreglosGenericos.buscaSecDesorden(competencias, numCompetencias, aux);
		
		if(pos>=0) {
			competencias[pos].setLogro(logro);
			res=competencias[pos].toString();
		}
		return res;
	}
	
	public boolean altaMovimiento(String nombre, String aparato, String posicionEjecucion, char dificultad, boolean obligatorio) {
		boolean res=false;
		MovimientoGym mov;
		int n;
		// existen movimientos con mismo nombre y diferente dificultad o posicion por lo que no se pregunta si ya existe
		n=numMovimientos;
		dificultad=Character.toUpperCase(dificultad);
		mov=new MovimientoGym(nombre, aparato, posicionEjecucion, dificultad, obligatorio);
		numMovimientos=ManejadorArreglosGenericos.insertaFinal(movimientos, numMovimientos, mov);
		if(numMovimientos!=n) {
			res=true;
		}
		return res;
	}
	//pensando que es registro antes de llevarse a cabo la competencia, no se pide el logro, y se espera que se establezca posteriormente
	public boolean altaCompetencia(String nombre, String lugar, String categoria, int anioFecha) {
		boolean res=false;
		Competencia aux=new Competencia(nombre);
		int n;
		int pos=ManejadorArreglosGenericos.buscaSecDesorden(competencias, numCompetencias, aux);
		
		//se considera que no hay competencias con el mismo nombre
		if(pos<0) {
			aux=new Competencia(nombre, lugar, categoria, anioFecha);
			n=numCompetencias;
			numCompetencias=ManejadorArreglosGenericos.insertaFinal(competencias, numCompetencias, aux);
			if(numCompetencias!=n) {
				res=true;
			}
		}
		return res;
	}
	public String bajaCompetencia(String nombre) {
		String res="Competencia no encontrada";
		Competencia aux=new Competencia(nombre);
		int pos=ManejadorArreglosGenericos.buscaSecDesorden(competencias, numCompetencias, aux);
		
		if(pos>=0) {
			res=competencias[pos].toString();
			numCompetencias=ManejadorArreglosGenericos.elimina(competencias, numCompetencias, pos);
		}
		return res;
	}
	public int numMovimientosAparato(String aparato) {
		int contador=0;
		
		for(int i=0; i<numMovimientos; i++) {
			if(movimientos[i].getAparato().equalsIgnoreCase(aparato)) {
				contador++;
			}
		}
		return contador;
	}
	/* los dos metodos siguientes son para uso meramente interno, a traves de los cuales se facilita el proceso del metodo
	 * calcula nivel
	 */
	public int numMovimientosDificultad(char dificultad) {
		int contador=0;
		dificultad=Character.toUpperCase(dificultad);
		
		for(int i=0; i<numMovimientos; i++) {
			if(movimientos[i].getDificultad()==dificultad) {
				contador++;
			}
		}
		return contador;
	}
	public int numMovimientosObligatorios() {
		int contador=0;
		
		for(int i=0; i<numMovimientos; i++) {
			if(movimientos[i].isObligatorio()) {
				contador++;
			}
		}
		return contador;
	}
	// el siguiente metodo tambien fue utilizado como criterio en calcula nivel, sin enbargo este sí tiene otros usos en Gimnasio
	public char mayDificultad() {
		char mayor='!';	//bandera: no hay movimientos registrados, es menor que cualquier dificultad
		
		for(int i=0; i<numMovimientos; i++) {
			if(mayor<movimientos[i].getDificultad()) {
				mayor=movimientos[i].getDificultad();
			}
		}
		return mayor;
	}
	/* metodo para calcular el nivel de cada uno de los gimnastas, es utilizado para colocar de forma adecuada los gimnastas en 
	 * su correspondiente nivel en la matriz
	 */
	public int calculaNivel() {
		int nivel=1;
		/*para facilitar la comprension los niveles van a ser representados como en la realidad 
		 * en clase Gimnasio será necesario restar un uno a este metodo para encontrarlo en el arreglo de niveles
		 * el principal punto a evaluar es el 75% de eficiencia en movimiento
		 * se considera que para entrar en la alta de Movimiento ya se considera suficiente eficiencia en realizacion
		 * 
		 * en gimnasia los niveles del 1-4 y a veces el 5 son basicamente para recreacion y motivacion
		 * por lo que es el inicio competitivo y el criterio de movimientos de acuerdo a dificultad los que aportan el correspondiente nivel
		 */
		if(numMovimientos==0 && numCompetencias<2) {
			if(numMovimientosObligatorios()<5) {
				nivel=1;
			}
			else if(numMovimientosObligatorios()<10) {
				nivel=2;
			}
			else if(numMovimientosObligatorios()<15 || mayDificultad()=='A') {
				nivel=3;
			}
			else if(numMovimientosObligatorios()<20 || numMovimientosDificultad('A')>5) {
				nivel=4;
			}
			else if(numMovimientosObligatorios()<20 && mayDificultad()=='B') {
				nivel=5;
			}
		}
		else if(numCompetencias>=2 && mayDificultad()>'B'){
			if(numMovimientosDificultad('B')<10 && mayDificultad()=='C') {
				nivel=6;
			}
			else if(numMovimientosDificultad('C')<10 && numMovimientosDificultad('D')<5) {
				nivel=7;
			}
			else if(numMovimientosDificultad('D')<10) {
				nivel=8;
			}
			else if((numMovimientosDificultad('D')<10 && numMovimientosDificultad('E')<5) || mayDificultad()=='F') {
				nivel=9;
			}
			else if(numMovimientosDificultad('F')<10 || mayDificultad()=='G') {
				nivel=10;
			}
			else if(numMovimientosDificultad('F')<20 || mayDificultad()>='H') {
				nivel=11;
			}
		}
		return nivel;
	}
	public double calculaProteinas(boolean masMusculo) {
		/* despues de cada entrenamiento es recomendable tomar 20 gramos de proteina
		 * se considera un entrenamiento por dia
		 * de acuerdo a expertos en nutriologia se considera que un atleta debe, en forma general (hay que recordar que cada
		 * cuerpo es diferente) debe consumor las proporciones entre 1.2 para mujeres y 1.5 para hombres
		 */
		double proteinas=20; 
		double proporcion;
		
		if(masMusculo) {
			proporcion=1.5;
		}
		else {
			proporcion=1.2;
		}
		switch(this.genero) {
			case 'M':proteinas+=(peso*proporcion);
				break;
			case 'H':
				proporcion+=2.5;
				proteinas+=(peso*proporcion);
				break;
			default: 
		}
		return proteinas;
	}
	public boolean participoCompetencia(String nombre) {
		boolean res=false;
		Competencia aux=new Competencia(nombre);
		int pos;
		
		pos=ManejadorArreglosGenericos.buscaSecDesorden(competencias, numCompetencias, aux);
		//pensando que puede no darse de baja una Competencia, por descuido, si no hay logro es porque no asistio
		if(pos>=0 && competencias[pos].getLogro()!=0) {
			res=true;
		}
		return res;
	}
	public boolean conMovimiento(String nombre) {
		boolean res=false;
		MovimientoGym aux=new MovimientoGym(nombre);
		int pos;
		
		pos=ManejadorArreglosGenericos.buscaSecDesorden(movimientos, numMovimientos, aux);
		if(pos>=0) {
			res=true;
		}
		return res;
	}
	public String movimientoMasDificil() {
		String res="Ningun movimiento registrado";
		char mayor=' ';				// en tablas ASCII el espacio es mayor que cualquier letra del alfabeto
		
		for(int i=0; i<numMovimientos; i++) {
			if(mayor<movimientos[i].getDificultad()) { 	// la menor dificultad es la letra A 
				mayor=movimientos[i].getDificultad();
				res=movimientos[i].toString();
			}
		}
		return res;
	}
	public String mejorAparato() {
		String res="Ningun movimiento aprendido";
		char mayDif=' ';
		
		for(int i=0; i<numMovimientos; i++) {
			if(movimientos[i].getDificultad()>mayDif) {
				mayDif=movimientos[i].getDificultad();
				res=movimientos[i].getAparato();
			}
		}
		return res;
	}
	public String mejorCompetencia() {
		String res="Ninguna competencia registrada";
		int mayorLogro=-1;
		
		for(int i=0; i<numCompetencias; i++) {
			if(competencias[i].getLogro()>mayorLogro) {
				mayorLogro=competencias[i].getLogro();
				res=competencias[i].getNombre();
			}
		}
		return res;
	}
	public int compareTo(Gimnasta otro) {
		return this.curp.compareTo(otro.curp);
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
		Gimnasta other = (Gimnasta) obj;
		if (curp == null) {
			if (other.curp != null) {
				return false;
			}
		} else if (!curp.equals(other.curp)) {
			return false;
		}
		return true;
	}
	public String toString() {
		StringBuilder cad=new StringBuilder();
		
		cad.append("\n Gimnasta de nombre: "+nombre);
		cad.append("\n            de curp: "+curp);
		cad.append("\n            de edad: "+edad);
		cad.append("\n          de genero: "+genero);
		cad.append("\n  con antiguedad de: "+antiguedad+" año(s)");
		cad.append("\n  compite en estilo: "+estilo);
		cad.append("\n entrena en horario: "+(horario/100)+":");
		if(horario%100==0) {
			cad.append("00");
		}
		else {
			cad.append(horario%100);
		}
		cad.append("\n               peso: "+peso+" Kg");
		cad.append("\n       numero de competencias: "+numCompetencias);
		for(int i=0; i<numCompetencias; i++) {
			cad.append("\n   participo en: "+competencias[i].toString());
		}
		cad.append("\n            capaz de realizar: "+numMovimientos+" movimiento(s)");
		for(int j=0; j<numMovimientos; j++) {
			cad.append("\n     "+movimientos[j].toString());
		}
		return cad.toString();
	}
	
}
