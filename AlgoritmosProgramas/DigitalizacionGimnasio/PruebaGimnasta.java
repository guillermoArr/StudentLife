import java.util.Scanner;
/*Guillermo Arredondo
 * 30 de noviembre 2020
 * Clase de prueba de gimnasta
 */
public class PruebaGimnasta {

	public static void main(String[] args) {
		Gimnasta g=new Gimnasta("Amaya", "PEBA061102MDFxxx", 5, "olimpica", 1630, 47);
		
		System.out.println(g.toString());
		if(g.altaCompetencia("USA Open", "Texas", "Junior Elite", 2018)) {
			System.out.println("Alta competencia exitosa");
		}
		else {
			System.out.println("Error en alta competencia ");
		}
		System.out.println(g.setLogroCompetencia("USA Open", 3));
		if(g.altaCompetencia("Mex", "Mahalo", "Junior", 2016)) {
			System.out.println("Alta competencia exitosa");
		}
		else {
			System.out.println("Error en alta competencia ");
		}
		System.out.println(g.setLogroCompetencia("Mex", 1));
		if(g.altaCompetencia("Patricia", "Noa", "Junior", 2016)) {
			System.out.println("Alta competencia exitosa");
		}
		else {
			System.out.println("Error en alta competencia ");
		}
		//quito una letra para reconocer que no encuentre la competencia y marque error en alta
		System.out.println(g.setLogroCompetencia("Patrici", 3));
		if(g.altaMovimiento("Salida Backflip", "viga", "agrupado", 'C', true)) {
			System.out.println("Alta movimiento exitosa");
		}
		else {
			System.out.println("Error en alta movimiento");
		}
		if(g.altaMovimiento("Arabe", "viga", "extendido", 'C', true)) {
			System.out.println("Alta movimiento exitosa");
		}
		else {
			System.out.println("Error en alta movimiento");
		}
		if(g.altaMovimiento("Alemana", "barras", "carpado", 'A', true)) {
			System.out.println("Alta movimiento exitosa");
		}
		else {
			System.out.println("Error en alta movimiento");
		}
		System.out.println(g.toString());
		System.out.println(g.bajaCompetencia("USA Open"));
		System.out.println(g.bajaCompetencia("USA Open"));
		System.out.println(g.conMovimiento("Salida Backflip"));
		System.out.println(g.calculaProteinas(false));
		System.out.println(g.getListaMovimAparato("viga"));
		System.out.println(g.getListaMovimAparato("barras"));
		System.out.println(g.participoCompetencia("USA Open"));
		System.out.println(g.calculaNivel());
		System.out.println(g.numMovimientosDificultad('B'));
		System.out.println(g.getNumMovimientos());
		System.out.println(g.numMovimientosAparato("viga"));
		System.out.println(g.mejorCompetencia());
		System.out.println(g.mejorAparato());
		System.out.println(g.mayDificultad());
		System.out.println(g.getUnaCompetencia("Patricia"));
		System.out.println(g.getUnMovimiento("Alemana"));
		System.out.println(g.movimientoMasDificil());
		
	}

}
