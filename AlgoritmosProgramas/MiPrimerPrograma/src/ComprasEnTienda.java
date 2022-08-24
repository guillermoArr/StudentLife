import java.util.Scanner; 

/* Guillermo Arredondo
 * 2 de septiembre de 2020
 * program. Primer Parcial: Tienda con compras en departamentos
 */
public class ComprasEnTienda {

	public static void main(String[] args) {
		double totPrec;
		int totProd, numT4, maxC;
		boolean existe, comp3;
		int tienda, claveMax;
		double monT3, prec, promT;
		int dpto, numProd, dptoMax;
		Scanner lec;
		
		totPrec=0;
		totProd=0;
		numT4=0;
		maxC=0;
		claveMax=0;
		dptoMax=0;
		lec=new Scanner(System.in);
		System.out.println("Dime la clave de tienda");
		tienda=lec.nextInt();
		
		while (tienda!=-1) {
			comp3=false;
			monT3=0;
			existe=false;
			System.out.println("Dime el número del departamento");
			dpto=lec.nextInt();
			System.out.println("Dime el número de productos");
			numProd=lec.nextInt();
			System.out.println("Dime el precio total de compra");
			prec=lec.nextDouble();
			
			while (!(dpto==-1 && numProd==-1 && prec==-1)) {
				totPrec=totPrec+prec;
				totProd=totProd+=numProd;
				
				switch (dpto) {
				case 3: comp3=true;
						monT3=monT3+=prec;
						break;
				case 4: existe=true;
						break;
				}
				
				if (numProd>maxC) {
					maxC=numProd;
					claveMax=tienda;
					dptoMax=dpto;
				}
				
				System.out.println("Dime el número del departamento");
				dpto=lec.nextInt();
				System.out.println("Dime el número de productos");
				numProd=lec.nextInt();
				System.out.println("Dime el precio total de compra");
				prec=lec.nextDouble();	
			}
			
			if (comp3) {
				System.out.println("Sí hubo compras en depto. 3");
				System.out.println("El total en depto. 3 es: $"+monT3);
			} else {
				System.out.println("No hubo compras en depto. 3");
			}
			
			if (existe) {
				numT4++;
			}
			
			System.out.println("Dime la clave de tienda");
			tienda=lec.nextInt();
		}
		
		if (totProd!=0) {
			promT=totPrec/totProd;	
			System.out.println("Promedio total: "+promT);
		} else {
			System.out.println("Promedio total: 0");
		}
		
		System.out.println("Número de Tiendas con compras en depto 4: "+numT4);
		System.out.println("Tienda con mayor compra (en productos): "+claveMax);
		System.out.println("en el departamento: "+dptoMax);
		
			
	}

}
