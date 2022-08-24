import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*Guillermo Arredondo
 * 8 de noviembre 2020
 * Prueba de clase serpentario
 */
public class MainSerpentario {

	public static void main(String[] args) {
		Serpentario sept;
		File entrada=new File("serpentaario.txt");
		String nombre, tipo, alimentacion;
		double longitud, peso;
		char genero;
		
		try(Scanner lec=new Scanner(entrada)){
			nombre=lec.next();
			sept=new Serpentario(nombre);
			System.out.println(sept.toString());
			while(lec.hasNext()) {
				tipo=lec.next();
				alimentacion=lec.next();
				longitud=lec.nextDouble();
				peso=lec.nextDouble();
				genero=lec.next().charAt(0);
				if(sept.altaSerpiente(tipo, alimentacion, longitud, peso, genero)) {
					System.out.println("Alta exitosa");
				}
				else {
					System.out.println("E R R O R en alta");
				}
			}
			lec.close();
			System.out.println(sept.toString());
			System.out.println("Encontar serpiente de clave 115"+sept.getUnaSerpiente(115));
			System.out.println("Tipo con mayor numero de serpientes contenidas "+sept.tipoMayNumSerp());
			System.out.println("Serpiente 120 transferida: "+sept.bajaSerpiente(120));
			System.out.println(sept.toString());
			System.out.println("Num serpientes que comen ratones "+sept.cuentaPorAlimento("ratones"));
		}
		catch(FileNotFoundException fnfe) {
			System.err.println("E R R O R "+fnfe);
			System.exit(-1);
		}

	}

}
