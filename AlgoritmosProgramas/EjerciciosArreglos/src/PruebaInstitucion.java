import java.util.Scanner;
/*Guillermo Arredondo
 * 6 octubre 2020
 * Calculo del costo de la remodelación para el ejercicio 9 pag 46 Institucion de Natacion
 */
public class PruebaInstitucion {

	public static void main(String[] args) {
		InstitucionNatacion club1;
		double area, montoTotal;
		
		club1=new InstitucionNatacion("Vargas", "Av. Popocatepetl 197", 4);
		if(club1.altaAlberca(50, 25)) {
			System.out.println("Alta exitosa");
		}
		else {
			System.out.println("error en alta");
		}
		
		if(club1.altaAlberca(30, 15)) {
			System.out.println("Alta exitosa");
		}
		else {
			System.out.println("error en alta");
		}
		
		if(club1.altaAlberca(50, 10)) {
			System.out.println("Alta exitosa");
		}
		else {
			System.out.println("error en alta");
		}
		
		if(club1.altaAlberca(35, 10)) {
			System.out.println("Alta exitosa");
		}
		else {
			System.out.println("error en alta");
		}
		
		System.out.println(club1.toString());
		
		club1.setUnaAlberca(4, 30, 75);
		System.out.println(club1.toString());
		
		area=club1.calculaAreaTotAlbercas();
		System.out.println("El area total es de: "+area);
		montoTotal=area*1000;
		System.out.println("El costo por la remodelacion del techo de las albercas es de: $"+montoTotal);
	}

}
