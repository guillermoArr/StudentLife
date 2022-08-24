/*Guillermo Arredondo
 * 23 octubre 2020
 * Clase Manejador String 
 */
public class ManejadorString {
	public static int cuentaPalabras(String frase){
		int n=0;
		
		frase=frase.trim();
		while(!frase.isEmpty() && frase.indexOf(' ')!=-1) {
			frase=frase.substring(frase.indexOf(' ')+1);
			n++;
		}
		if(!frase.isEmpty()) {
			n++;
		}
		return n;
	}
}
