/*Guillermo Arredondo
 * 17 septiembre 2020
 * Examen agosto 2019
 */
public class Piloto {
	private String nombre;
	private String genero;
	private double peso;
	private double estatura;
	private int puntosComp;
	private boolean campeon;
	private int clveUnica;
	private static int generadorClveUnica=1000;
	
	public Piloto(String nombre, String genero, double peso, double estatura, int puntosComp, boolean campeon) {
		this.nombre=nombre;
		this.genero=genero;
		this.peso=peso;
		this.estatura=estatura;
		this.puntosComp=puntosComp;
		this.campeon=campeon;
		
		clveUnica=generadorClveUnica;
		generadorClveUnica+=4;
	}
	public Piloto(String nombre) {
		this.nombre=nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public int getClveUnica() {
		return clveUnica;
	}
	public int getPuntosComp() {
		return puntosComp;
	}
	public void setPeso(double peso) {
		this.peso=peso;
	}
	public void setEstatura(double estatura) {
		this.estatura=estatura;
	}
	public void actualizaPuntos(int puntosObt) {
		this.puntosComp+=puntosObt;
	}
	public double calculaCarbohidratos() {
		double carbsA, carbsB;
		
		if(this.estatura<170) {
			carbsA=20;
		}
		else if(this.estatura<180) {
			carbsA=25;
		}
		else {
			carbsA=30;
		}
		if(this.genero.contentEquals("hombre")) {
			if(this.peso<70) {
				carbsB=150+40;
			}
			else {
				carbsB=150;
			}
		}
		else {
			if(this.peso<50) {
				carbsB=120+20;
			}
			else {
				carbsB=120;
			}
		}
		carbsA+=carbsB;
		return carbsA;
	}
	public String toString() {
		StringBuilder cad=new StringBuilder();
		
		cad.append("\nPiloto de clveUnica: "+clveUnica);
		cad.append("\n          de nombre: "+nombre);
		cad.append("\n          de genero: "+genero);
		cad.append("\n       de peso (kg): "+peso);
		cad.append("\n   de estatura (cm): "+estatura);
		cad.append("\n     con los puntos: "+puntosComp);
		cad.append("\n        es campeon?: "+campeon);
		return cad.toString();
	}
	public int compareTo(Piloto otro) {
		int res;
		
		if(this.clveUnica==otro.clveUnica) {
			res=0;
		}
		else if(this.clveUnica<otro.clveUnica){
			res=-1;
		}
		else {
			res=1;
		}
		return res;
	}
	public boolean equals(Piloto otro) {
		boolean res=false;
		
		if(this.clveUnica==otro.clveUnica) {
			res=true;
		}
		return res;
	}

}
