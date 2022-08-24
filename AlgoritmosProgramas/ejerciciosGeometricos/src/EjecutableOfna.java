import java.util.Scanner;

/*Guillermo Arredondo
 * 7 septiembre 2020
 * circulo
 */
public class EjecutableOfna {

	public static void main(String[] args) {
		Rectangulo ofna;
		Circulo t1, t2, t3;
		Scanner lec;
		double largo, ancho, r1, r2, r3, areaLibre;
		
		lec=new Scanner(System.in);
		System.out.println("¿Cuales son las medidas de la oficina?");
		largo=lec.nextDouble();
		ancho=lec.nextDouble();
		System.out.println("¿Cuales es el radio del tapete 1?");
		r1=lec.nextDouble();
		System.out.println("¿Cuales es el radio del tapete 2?");
		r2=lec.nextDouble();
		System.out.println("¿Cuales es el radio del tapete 3?");
		r3=lec.nextDouble();
		
		ofna=new Rectangulo(largo, ancho);
		t1=new Circulo(r1);
		t2=new Circulo(r2);
		t3=new Circulo(r3);
		
		areaLibre=ofna.calculaArea()-(t1.calculaArea()+t2.calculaArea()+t3.calculaArea());
		System.out.println("El area libre de la oficina es de: "+areaLibre);
		
	}

}
