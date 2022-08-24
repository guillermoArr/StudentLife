import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*Guillermo Arredondo
 * 30 noviembre 2020
 * Prueba con Archivo de la Clase Gimnasio
 */
public class PruebaGimnasioArchivo {

	public static void main(String[] args) {
		File entrada=new File("gimnasio.txt");
		Gimnasio g;
		String nombre, ubicacion, encargado, curp, estilo, aparato, posicionEjecucion, categoria;
		int antiguedad, horario, logro, anio;
		double peso;
		char dificultad;
		boolean obligatorio;
		try(Scanner lec=new Scanner(entrada)){
			nombre=lec.next();
			lec.nextLine();
			ubicacion=lec.nextLine();
			encargado=lec.next();
			g=new Gimnasio(nombre, ubicacion, encargado);
			System.out.println("Gimnasio esta vacio? "+g.isGimnasioVacio());
			while(lec.hasNext()) {
				lec.nextLine();
				nombre=lec.nextLine();
				System.out.println(nombre);
				curp=lec.next();
				System.out.println(curp);
				antiguedad=lec.nextInt();
				System.out.println(antiguedad);
				estilo=lec.next();
				System.out.println(estilo);
				horario=lec.nextInt();
				System.out.println(horario);
				peso=lec.nextDouble();
				System.out.println(peso);
				if(g.altaGimnasta(nombre, curp, antiguedad, estilo, horario, peso)) {
					System.out.println("Alta exitosa");
				}
				else {
					System.out.println("Error en alta");
				}
				lec.nextLine();
				nombre=lec.nextLine();
				System.out.println(nombre);
				aparato=lec.next();
				System.out.println(aparato);
				posicionEjecucion=lec.next();
				System.out.println(posicionEjecucion);
				dificultad=lec.next().charAt(0);
				System.out.println(dificultad);
				obligatorio=lec.nextBoolean();
				System.out.println(obligatorio);
				if(g.altaMovimientoGimnasta(curp, nombre, aparato, posicionEjecucion, dificultad, obligatorio)) {
					System.out.println("Alta exitosa");
				}
				else {
					System.out.println("Error en alta");
				}
				lec.nextLine();
				nombre=lec.nextLine();
				aparato=lec.next();
				posicionEjecucion=lec.next();
				dificultad=lec.next().charAt(0);
				obligatorio=lec.nextBoolean();
				if(g.altaMovimientoGimnasta(curp, nombre, aparato, posicionEjecucion, dificultad, obligatorio)) {
					System.out.println("Alta exitosa");
				}
				else {
					System.out.println("Error en alta");
				}
				lec.nextLine();
				nombre=lec.nextLine();
				aparato=lec.next();
				posicionEjecucion=lec.next();
				dificultad=lec.next().charAt(0);
				obligatorio=lec.nextBoolean();
				if(g.altaMovimientoGimnasta(curp, nombre, aparato, posicionEjecucion, dificultad, obligatorio)) {
					System.out.println("Alta exitosa");
				}
				else {
					System.out.println("Error en alta");
				}
				lec.nextLine();
				nombre=lec.nextLine();
				System.out.println(nombre);
				ubicacion=lec.nextLine();
				System.out.println(ubicacion);
				categoria=lec.nextLine();
				System.out.println(categoria);
				anio=lec.nextInt();
				System.out.println(anio);
				logro=lec.nextInt();
				System.out.println(logro);
				if(g.altaCompetenciaGimnasta(curp, nombre, ubicacion, categoria, anio)) {
					System.out.println("Alta exitosa");
				}
				else {
					System.out.println("Error en alta");
				}
				System.out.println(g.setLogroCompetenciaGimnasta(curp, nombre, logro));
				lec.nextLine();
				nombre=lec.nextLine();
				System.out.println(nombre);
				ubicacion=lec.nextLine();
				System.out.println(ubicacion);
				categoria=lec.nextLine();
				System.out.println(categoria);
				anio=lec.nextInt();
				System.out.println(anio);
				logro=lec.nextInt();
				System.out.println(logro);
				if(g.altaCompetenciaGimnasta(curp, nombre, ubicacion, categoria, anio)) {
					System.out.println("Alta exitosa");
				}
				else {
					System.out.println("Error en alta");
				}
				System.out.println(g.setLogroCompetenciaGimnasta(curp, nombre, logro));
				lec.nextLine();
				nombre=lec.nextLine();
				System.out.println(nombre);
				ubicacion=lec.nextLine();
				System.out.println(ubicacion);
				categoria=lec.nextLine();
				System.out.println(categoria);
				anio=lec.nextInt();
				System.out.println(anio);
				logro=lec.nextInt();
				System.out.println(logro);
				if(g.altaCompetenciaGimnasta(curp, nombre, ubicacion, categoria, anio)) {
					System.out.println("Alta exitosa");
				}
				else {
					System.out.println("Error en alta");
				}
				System.out.println(g.setLogroCompetenciaGimnasta(curp, nombre, logro));
			}
			System.out.print(g.toString());
			g.actualizaGimnasio();
			System.out.print(g.bajaGimnasta("CANA010126HDFxxx"));
			System.out.print(g.toString());
			if(g.altaGimnasta("Abraham Chalita","CANA010126HDFxxx" , 3, "Olímpica", 1430, 69.6)) {
				System.out.println("Alta exitosa");
			}
			else {
				System.out.println("E R R O R  en alta con constantes");
			}
			if(g.altaMovimientoGimnasta("CANA010126HDFxxx", "Arabe", "suelo", "extendida", 'A', true)) {
				System.out.println("Alta exitosa");
			}
			else {
				System.out.println("Error en alta");
			}
			if(g.altaCompetenciaGimnasta("CANA010126HDFxxx", "TEC GYM", "TEC Monterrey", "Patito", 2018)) {
				System.out.println("Alta exitosa");
			}
			else {
				System.out.println("Error en alta");
			}
			System.out.println(g.setLogroCompetenciaGimnasta("CANA010126HDFxxx", "TEC Gym", 10));
			System.out.println("Gimnasio esta vacio? "+g.isGimnasioVacio());
			System.out.println("Gimnastas en nivel EXCEL1 "+g.getGimnastasNivel("EXCEL 1"));
			System.out.println(g.getProteinasGimnasta("CAFM020621MDFXXX", true));
			System.out.println(g.getListaMovimientosGimnastaAparato("CAFM020621MDFXXX", "suelo"));
			System.out.println(g.getGimnastasNivel("EXCEL 6"));
			System.out.println(g.cuantasAntiguedad(7));
			System.out.println(g.cuantasAntiguedad(3));
			System.out.println(g.cuantosGimnastasConMovimiento("Mortal atras"));
			System.out.println(g.gimnastaMayDificul());
			System.out.println(g.cuantosGimnastasEnCompetencia("Nacional Juvenil"));
			System.out.println(g.cuantosGimnastasEnCompetencia("Sirius"));
			System.out.println(g.mejoresCompetenciasGimnastasNivel("EXCEL 6"));
			System.out.println(g.mejoresCompetenciasGimnastasNivel("Excel 6"));
		}
		catch(FileNotFoundException fnfe) {
			System.err.println("E R R O R "+fnfe);
			System.exit(-1);
		}

	}

}
