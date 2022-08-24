/*Guillermo Arredondo 
 * 24 septiembre 2020
 * CLase de numero complejo
 */
public class Complejo {
	private double parteReal;
	private double parteImagin;
	
	public Complejo() {
		
	}
	public Complejo(double parteReal, double parteImagin) {
		this.parteReal=parteReal;
		this.parteImagin=parteImagin;
	}
	public void setParteReal(double parteReal) {
		this.parteReal=parteReal;
	}
	public void setParteImagin(double parteImagin) {
		this.parteImagin=parteImagin;
	}
	public double getParteReal() {
		return parteReal;
	}
	public double getParteImagin() {
		return parteImagin;
	}
	
	private double magnitud() {
		double magnitud;
		
		magnitud=Math.sqrt(Math.pow(parteReal, 2)+Math.pow(parteImagin, 2));
		return magnitud;
	}
	
	public String toString() {
		StringBuilder cad=new StringBuilder();
		
		cad.append("\nNumero Complejo: "+parteReal);
		if(parteImagin>=0) {
			cad.append(" + "+parteImagin+"i");
		}
		else {
			cad.append(+parteImagin+"i");
		}
		return cad.toString();
	}
	
	public int compareTo(Complejo otro) {
		int res;
		
		if(this.magnitud()<otro.magnitud()) {
			res=-1;
		}else if(this.magnitud()==otro.magnitud()){
			res=0;
		}
		else {
			res=1;
		}
		return res;
	}
	
	public boolean equals(Complejo otro) {
		boolean res=false;
		
		if(this.magnitud()==otro.magnitud()) {
			res=true;
		}
		return res;
	}

}
