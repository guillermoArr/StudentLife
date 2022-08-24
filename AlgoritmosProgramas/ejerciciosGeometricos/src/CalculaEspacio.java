import java.util.Scanner;

/*Guillermo Arredondo
 * 7 septiembre 2020
 * ejercicio 3 de ATPS
 */
public class CalculaEspacio {

	public static void main(String[] args) {
		Rectangulo m1, m2, m3;
		double a1, a2, a3, aTotal;
		Scanner lec;
		
		lec=new Scanner(System.in);
		m1=new Rectangulo(2, 1.8);
		a1=m1.calculaArea();
		m2=new Rectangulo(1, 1.5);
		a2=m2.calculaArea();
		m3=new Rectangulo(3, 2);
		a3=m3.calculaArea();
		
		aTotal=a1+a2+a3;
		System.out.println("El espacio ocupado por las tres mesas es: "+aTotal);
		

	}

}
