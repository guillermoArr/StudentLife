/*Guillermo Arredondo
 * 23 octubre 2020
 * Peueba de metodos string y manejador string
 */
public class PruebaString {

	public static void main(String[] args) {
		String str="LA CASA AZUL ESTA ENCIMA DE LA COLINA";
		int numPal;
		
		System.out.println(str);
		numPal=ManejadorString.cuentaPalabras(str);
		System.out.println("El numero de palabras es: "+numPal);

	}

}
