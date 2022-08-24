/*Guillermo Arredondo
 * 18 nov de 2020
 * Clase main para probar clase cultivo con constantes
 */
public class PruebaCultivo {
	
	public static void main(String[] args) {
		Cultivo c=new Cultivo("La granja", 4, 4);
		
		if(c.siembraPlanta("Tulipan", "Tulipanis corrientis", 3, "azul", true, 1, 1)) {
			System.out.println("Alta exitosa");
		}
		else {
			System.out.println("Error en alta");
		}
		if(c.siembraPlanta("Girasol", "Girasolis corrientis", 4, "amarillo", false, 2, 3)) {
			System.out.println("Alta exitosa");
		}
		else {
			System.out.println("Error en alta");
		}
		if(c.siembraPlanta("Dispara guisantes", "Peeshooter", 2, "verde", true, 0, 4)) {
			System.out.println("Alta exitosa");
		}
		else {
			System.out.println("Error en alta");
		}
		if(c.siembraPlanta("Lanza sandias", "Catapultis sandiis", 4, "verde", false, 3, 1)) {
			System.out.println("Alta exitosa");
		}
		else {
			System.out.println("Error en alta");
		}
		//System.out.println(c.toString());
		if(c.sonAmargas(1)) {
			System.out.println("En la segunda columna de izquierda a derecha hay puras plantas amargas");
		}
		else {
			System.out.println("En la segunda columna de izquierda a derecha no todas las plantas son amargas");
		}
		

	}

}
