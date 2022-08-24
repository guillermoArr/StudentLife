/*Guillermo Arredondo
 * 7 septiembre 2020
 * circulo
 */
public class Circulo {
	private double radio;
	
	public Circulo() {
	}
	public Circulo(double radio) {
		this.radio=radio;
	}
	
	public double getRadio() {
		return radio;
	}
	
	public void setRadio(double radio) {
		this.radio=radio;
	}
	
	public double calculaArea() {
		double a;
		
		a=Math.PI*Math.pow(radio, 2);
		return a;
	}
	
	public double circunferencia() {
		double c;
		
		c=Math.PI*2*radio;
		return c;
	}
	
	public String toString() {
		StringBuilder cad=new StringBuilder();
		
		cad.append("\nCirculo de radio: "+radio);
		return cad.toString();
	}
	
	public int compareTo(Circulo otro) {
		int res;
		
		if(this.radio<otro.radio) {
			res=-1;
		}else {
			res=1;
		}
		return res;
	}
	
	public boolean equals(Circulo otro) {
		boolean res;
		
		if(this.radio==otro.radio) {
			res=true;
		} else {
			res=false;
		}
		return res;
	}

}
