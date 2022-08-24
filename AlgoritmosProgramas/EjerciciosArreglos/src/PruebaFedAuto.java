/*Guillermo Arredondo
 * 17 octubre 2020
 * Prueba Fed Automovilistico Examen tercer parcial pasado
 */
public class PruebaFedAuto {

	public static void main(String[] args) {
		FedAutomovilismo femadac=new FedAutomovilismo("FEMADAC");
		
		if(femadac.altaPiloto("Alonso A", "hombre", 60, 175, 3, false)) {
			System.out.println("Alta exitosa");
		}
		else {
			System.out.println("error en alta");
		}
		//System.out.println(femadac.toString());
		if(femadac.altaPiloto("Marco Antonio", "hombre", 60, 175, 7, true)) {
			System.out.println("Alta exitosa");
		}
		else {
			System.out.println("error en alta");
		}
		//System.out.println(femadac.toString());
		if(femadac.altaPiloto("Alonso C", "hombre", 60, 175, 3, false)) {
			System.out.println("Alta exitosa");
		}
		else {
			System.out.println("error en alta");
		}
		System.out.println(femadac.toString());
		System.out.println("El promedio de puntos actual es: "+femadac.promPuntosTot());
		

	}

}
