import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*Guillermo Arredondo
 * 2 de noviembre 2020
 * Prueba de clase compania
 */
public class MainCompania {

	public static void main(String[] args) {
		Compania c;
		File entrada=new File("ventasComp.txt");
		String nombre;
		double monto;
		String depto, mes;
		
		try(Scanner lec=new Scanner(entrada)){
			nombre=lec.next();
			c=new Compania(nombre);
			while(lec.hasNext()) {
				monto=lec.nextDouble();
				depto=lec.next();
				mes=lec.next();
				if(c.altaVenta(monto, depto, mes)) {
					System.out.println("Alta exitosa");
				}
				else {
					System.out.println("E R R O R en alta");
				}
			}
			lec.close();
			System.out.println(c.toString());
			System.out.println("Promedio de ventas en juguetes "+c.promVentasEnDepto("juguetes"));
			System.out.println("Promedio de ventas en febrero "+c.promVentasEnMes("febrero"));
			System.out.println("Promedio de ventas en juguetes "+c.promVentasEnDepto("JugueTeS"));
			System.out.println("Promedio de ventas en ASMA "+c.promVentasEnDepto("ASMA"));
			System.out.println("Mes con mayor venta en caballeros "+c.getMesMayorVentaEn("caballeros"));
			System.out.println("Mes sin ventas: "+c.mesNoVentas());
		}
		catch(FileNotFoundException fnfe) {
			System.err.println("E R R O R "+fnfe);
			System.exit(-1);
		}

	}

}
