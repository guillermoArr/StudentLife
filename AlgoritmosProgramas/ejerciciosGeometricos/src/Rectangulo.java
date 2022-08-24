/* Guillermo Arredondo
 * 7 de septiembre 2020
 * clase para calcular rectangulo
 */
public class Rectangulo{
	private double largo;
	private double ancho;
	
	public Rectangulo() {
		
	}
	
	public Rectangulo(double ancho, double largo) {
		this.ancho=ancho;
		this.largo=largo;
	}
	
	public double getLargo() {
		return largo;
	}
	
	public double getAncho() {
		return ancho;
	}
	
	public void setLargo(double largo) {
		this.largo=largo;
	}
	
	public void setAncho(double ancho) {
		this.ancho=ancho;
	}
	
	public double calculaArea() {
		double a;
		
		a=ancho*largo;
		return a;
	}
	public double calculaPerimetro() {
		double p;
		
		p=2*ancho+2*largo;
		return p;
	}
	
	public String toString() {
		StringBuilder cad=new StringBuilder();
		
		cad.append("\nRectangulo de ancho: "+ancho);
		cad.append("\n         y de largo:"+largo);
		return cad.toString();
	}
	
	public int compareTo(Rectangulo otro) {
		int res=0;
		
		if(this.calculaArea()<otro.calculaArea()) {
			res=-1;
		}else if(this.calculaArea()>otro.calculaArea()) {
			res=1;
		}
		return res;
	}
	
	public boolean equals(Rectangulo otro) {
		boolean res;
		
		if(this.calculaArea()==otro.calculaArea()) {
			res=true;
		} else{
			res=false;
		}
		return res;
	}
	
	
	
	
}
