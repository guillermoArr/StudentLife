import java.util.Scanner;
import java.util.ArrayList;
/*Guillermo Arredondo
 * 8 de octubre 2020
 * Prueba de clase Galeria con todos sus metodos
 */
public class PruebaGaleria {

	public static void main(String[] args) {
		GaleriaArte gal;
		Scanner lec=new Scanner(System.in);
		int n, ahoTerm, ahoI, ahoF;
		String nomPintura, autor, tecnica;
		double prec;
		ArrayList<String> res=new ArrayList<String>();
		
		System.out.println("Dime cuantas pinturas");
		n=lec.nextInt();
		gal=new GaleriaArte("Bellas Artes", 55548672, n);
		for(int i=1; i<=n; i++) {
			System.out.println("Dime nombre de la pintura, autor, tecnica, anio de terminacion y el precio");
			nomPintura=lec.next();
			autor=lec.next();
			tecnica=lec.next();
			System.out.println("Dime anio term y ...");
			ahoTerm=lec.nextInt();
			prec=lec.nextDouble();
			if(gal.altaPintura(nomPintura, autor, tecnica, ahoTerm, prec)){
				System.out.println("Alta exitosa");
			}
			else {
				System.out.println("error en alta");
			}
		}
		System.out.println(gal.toString());
		gal.setUnaPintura(4, "MonaLisa", "Da Vinci", "acuarela", 1889, 30000000);
		System.out.println("Pintura en pos 5 "+gal.getUnaPintura(5));
		System.out.println(gal.toString());
		System.out.println("Dame los datos a consultar (pintor, tecnica): ");
		autor=lec.next();
		tecnica=lec.next();
		res=gal.consultaPintorTecnica(autor, tecnica);
		if(res!=null) {
			System.out.println("Pinturas: "+res.toString());
		}
		else {
			System.out.println("No hay pinturas con estos datos");
		}	
		System.out.println("Dame precio deseado: ");
		prec=lec.nextDouble();
		if(gal.consultaPorPrecio(prec)) {
			System.out.println("Sí existe una pintura debajo de ese precio.");
		}
		else {
			System.out.println("No hay pinturas por debajo de ese precio");
		}
		
		System.out.println("Promedio de precios de venta: "+gal.precioPromVenta());
		
		System.out.println("Pintura mas barata: "+gal.pinturaMasBarata());
		
		System.out.println("Dame rango de busqueda entre dos años: ");
		ahoI=lec.nextInt();
		ahoF=lec.nextInt();
		System.out.println("Pinturas en rango: "+gal.cuantasPinturasEnRango(ahoI, ahoF));
		
		System.out.println("Dame tecnica deseada: ");
		tecnica=lec.next();
		System.out.println("Pinturas con dicha tecnica: "+gal.cuantosTecnica(tecnica));

	}

}
