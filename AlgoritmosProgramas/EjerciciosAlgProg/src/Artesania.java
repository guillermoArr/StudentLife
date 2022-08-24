/*Guillermo Arredondo Renero
 * 17 septiembre 2020
 * Exmanen semestre Enero 2020
 */
public class Artesania {
	private String tipoMat;
	private String regOrig;
	private int diasElab;
	
	private int numElaboradores;
	
	private boolean derechAutor;
	private int clveUnica;
	private static int generadorClveUnica=5; // examen tercer parcial pide que sea 5
	
	public Artesania(String tipoMat, String regOrig,int numElaboradores, int diasElab, boolean derechAutor) {
		this.tipoMat=tipoMat;
		this.regOrig=regOrig;
		this.diasElab=diasElab;
		this.derechAutor=derechAutor;
		this.numElaboradores=numElaboradores;
		this.clveUnica=generadorClveUnica;
		generadorClveUnica+=5; //examen tercer parcial de 5 en 5
	}
	public Artesania(String tipoMat, String regOrig, int diasElab, boolean derechAutor) {
		this.tipoMat=tipoMat;
		this.regOrig=regOrig;
		this.diasElab=diasElab;
		this.derechAutor=derechAutor;
		this.clveUnica=generadorClveUnica;
		generadorClveUnica+=5; //examen tercer parcial de 5 en 5
	}
	public void setRegOrig(String regOrig) {
		this.regOrig=regOrig;
	}
	public String getTipoMat() {
		return tipoMat;
	}
	public String getRegOrig() {
		return regOrig;
	}
	public int getClveUnica() {
		return clveUnica;
	}
	
	//todas las funciones get, sin problema
	
	public int getNumElaboradores() {
		return numElaboradores;
	}
	public boolean isDerechAutor() {
		return derechAutor;
	}
	public void setDerechAutor(boolean derechAutor) {
		this.derechAutor = derechAutor;
	}
	public double calculaPrecVenta() {
		double sobPrec, prec; 
		
		if(tipoMat.equals("ceramica")) {
			prec=110;
		}
		else {
			prec=100;
		}
		if(diasElab<10) {
			sobPrec=15;
		}
		else if(diasElab<20) {
			sobPrec=30;
		}
		else {
			sobPrec=50;
		}
		prec+=sobPrec;
		if(derechAutor) {
			prec*=1.1;
		}
		return prec;
	}
	
	public String toString() {
		StringBuilder cad=new StringBuilder();
						
		cad.append("\nArtesania de clave unica: "+clveUnica);
		cad.append("\nde tipo de mat: "+tipoMat);
		cad.append("\n     de origen: "+regOrig);
		cad.append("\n      numero de Elaboradores: "+numElaboradores);
		cad.append("\ncon dias de elaboracion de: "+diasElab);
		cad.append("\nderechos de autor?: "+derechAutor);
		cad.append("\n            precio: $"+calculaPrecVenta());
		return cad.toString();
	}
	public int compareTo(Artesania otro) {
		int res;
		
		if(this.clveUnica<otro.clveUnica) {
			res=-1;
		}
		else if(this.clveUnica==otro.clveUnica) {
			res=0;
		}
		else {
			res=1;
		}
		return res;
	}
	public boolean equals(Artesania otro) {
		boolean res;
		
		if(this.clveUnica==otro.clveUnica) {
			res=true;
		}
		else {
			res=false;
		}
		return res;
	}
	
	

}
