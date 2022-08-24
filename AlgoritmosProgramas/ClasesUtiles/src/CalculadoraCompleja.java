/*Guillermo Arredondo
 * 24 septiembre 2020
 * Clase Claculadora Compleja
 */
public class CalculadoraCompleja {
	
	public static Complejo sumaComplejo(Complejo num1, Complejo num2) {
		Complejo suma;
		double sumaR, sumaI;
		
		sumaR=num1.getParteReal()+num2.getParteReal();
		sumaI=num1.getParteImagin()+num2.getParteImagin();
		suma=new Complejo(sumaR, sumaI);
		return suma;
	}
	public static Complejo restaComplejo(Complejo minuendo, Complejo sustraendo) {
		Complejo resta;
		double restaR, restaI;
		
		restaR=minuendo.getParteReal()-sustraendo.getParteReal();
		restaI=minuendo.getParteImagin()-sustraendo.getParteImagin();
		resta=new Complejo(restaR, restaI);
		return resta;		
	}
	public static Complejo multiplicacionComplejo(Complejo factor1, Complejo factor2) {
		Complejo mult;
		double multR, multI;
		
		multR=factor1.getParteReal()*factor2.getParteReal()-factor1.getParteImagin()*factor2.getParteImagin();
		multI=factor1.getParteReal()*factor2.getParteImagin()+factor1.getParteImagin()*factor2.getParteReal();
		mult=new Complejo(multR, multI);
		return mult;
	}
	public static Complejo divisionComplejo(Complejo dividendo, Complejo divisor) {
		Complejo div;
		double numR, numI, den;
		
		numR=(dividendo.getParteReal()*divisor.getParteReal()+dividendo.getParteImagin()*divisor.getParteImagin());
		numI=(dividendo.getParteImagin()*divisor.getParteReal())-(dividendo.getParteReal()*divisor.getParteImagin());
		den=(Math.pow(divisor.getParteReal(), 2)+Math.pow(divisor.getParteImagin(), 2));
		if(den!=0) {
			numR/=den;
			numI/=den;
			div=new Complejo(numR, numI);
		}
		else {
			div=null;
		}
		return div;
	}

	
}
