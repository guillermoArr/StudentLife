import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*Guillermo Arredondo
 * 12 de noviembre 2020
 * Ejercicio 8 Clase Estacionamiento
 */
public class PruebaEstacionamiento {
	public static void imprimeArreglo(int [] a, int n) {
		
		for(int i=0; i<n; i++) {
			System.out.print("\t"+a[i]);
		}
		System.out.println(); 
	}

	public static void main(String[] args) {
		Estacionamiento e;
		File entrada=new File("estacionamiento.txt");
		String nombre, ubicacion, placa, marca, modelo, tipo, servicio, fecha, curp, edoCivil;
		int hora, piso, cajon, anio;
		
		try(Scanner lec=new Scanner(entrada)) {
			nombre=lec.next();
			ubicacion=lec.nextLine();
			ubicacion=lec.nextLine();
			e=new Estacionamiento(nombre, ubicacion);
			System.out.println(e.toString());
			while(lec.hasNext()) {
				hora=lec.nextInt();
				piso=lec.nextInt();
				cajon=lec.nextInt();
				anio=lec.nextInt();
				placa=lec.next();
				marca=lec.next();
				modelo=lec.next();
				tipo=lec.next();
				if(e.altaAutomovil(hora, piso, cajon, placa, marca, modelo, anio, tipo)) {
					System.out.println("Alta auto exitosa");
				}
				else {
					System.out.println("Error en alta auto");
				}
				nombre=lec.nextLine();
				nombre=lec.nextLine();
				curp=lec.next();
				edoCivil=lec.next();
				if(e.altaDuenio(placa, nombre, curp, edoCivil)) {
					System.out.println("Alta duenio exitosa");
				}
				else {
					System.out.println("Error en alta duenio");
				}
				while(lec.hasNext() && !lec.hasNextInt()) {
					placa=lec.next();
					servicio=lec.nextLine();
					servicio=lec.nextLine();
					fecha=lec.next();
					if(e.altaServicioAuto(placa, servicio, fecha)) {
						System.out.println("Alta servicio exitosa");
					}
					else {
						System.out.println("Error en alta servicio");
					}
				}
				
			}
			lec.close();
			System.out.println("\n"+e.toString());
			System.out.println("\n El numero de automoviles tipo Sedan en piso 4: "+e.cuantosAutosTipo("Sedan", 4));
			System.out.println("\n El numero de cajones libres: "+e.cuantosDisponibles());
			System.out.println("\n Numero de servicios del auto con placa ZYA-509: "+e.cuantosServiciosAuto("ZYA-509"));
			System.out.println("\n Lista de placas con servicio cambio de aceite: "+e.cualesAutosConServicio("cambio aceite"));
			System.out.println("\n El auto más viejo se encuentra en el piso: "+e.cajonAutoMasViejo()[0]+" en el cajon "+e.cajonAutoMasViejo()[1]);
			System.out.println("\n Numero de autos de marca Mazda: "+e.cuantosAutosMarca("Mazda"));
			System.out.println("\n Piso con todos los lugares disponibles: "+e.pisoVacio());
			System.out.println("\n Primer lugar disponible: en el piso "+e.primerLugarLibre()[0]+" en el cajon "+e.primerLugarLibre()[1]);
			System.out.println("\n El estacionamiento está lleno? "+e.estaLLeno());
			
			System.out.println("\n _____________________");
			System.out.println("\n Auto estacionado cuyo dueño es el más longevo: "+e.autoDuenioMayor());
			System.out.println("\n Numero de autos con dueño de genero Hombre: "+e.cuantosDuenioGenero('H'));
			System.out.println("\n");
		}
		catch(FileNotFoundException fnfe) {
			System.err.println("E R R O R "+fnfe);
			System.exit(-1);
		}

	}

}
