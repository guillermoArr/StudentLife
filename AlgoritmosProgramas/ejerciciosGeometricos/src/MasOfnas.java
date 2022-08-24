import java.util.Scanner;

/*Guillermo Arredondo
 * 7 septiembre 2020
 * circulo
 */
public class MasOfnas {

	public static void main(String[] args) {
		Rectangulo ofna;
		Circulo tapt;
		Scanner lec;
		double largo, ancho, radio;
		double aTotTapetes, aTotOfnas, areaLibreTot;
		int nOfnas, kTapetes;
		
		// inicializaciones
		aTotTapetes=0;
		aTotOfnas=0;
		areaLibreTot=0;
		
		lec=new Scanner(System.in);
		System.out.println("Dime el número de oficinas");
		nOfnas=lec.nextInt();
		
		for(int o=1; o<=nOfnas; o++) {
			System.out.println("Medidas de la oficina "+o);
			largo=lec.nextDouble();
			ancho=lec.nextDouble();
		
			ofna=new Rectangulo(largo, ancho);
			System.out.println("Dime el número de Tapetes");
			kTapetes=lec.nextInt();
			
			for(int t=1; t<=kTapetes; t++) {
				System.out.println("Radio del tapete "+t);
				radio=lec.nextDouble();
				
				tapt=new Circulo(radio);
				aTotTapetes=aTotTapetes+=tapt.calculaArea();
				
			}
			
			aTotOfnas=aTotOfnas+=ofna.calculaArea();
		}
				
		areaLibreTot=aTotOfnas-aTotTapetes;
		System.out.println("El area libre total de las oficinas es de: "+areaLibreTot);
		
	}
		
}

