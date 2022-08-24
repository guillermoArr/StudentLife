import java.util.ArrayList;
/*Guillermo Arredondo
 * 17 de octubre 2020
 * Examen anterior para tercer parcial pregunta 1
 */
public class AnalizaArreglo {
	public static void unCorrimientoIzq(int[] a, int n, int pos) {
		
		for(int i=pos; i<n-1; i++) {
			a[i]=a[i+1];
		}
	}
	public static int buscaSecOrdenada(int[] a, int n, int busca) {
		int i=0;
		
		while(i<n  && a[i]<busca) {
			i++;
		}
		if(i==n || a[i]!=busca) {
			i=-i-1;
		}
		
		return i;
	}
	public static int eliminaEnOrden(int[] a, int n, int x) {
		int pos;
		
		pos=buscaSecOrdenada(a, n, x);
		if(pos>=0) {
			unCorrimientoIzq(a, n, pos);
			n--;
		}
		return n;
	}
	public static int encuentraEliminaMultiplos(int[] arreglo, int totalElem, int numero, ArrayList<Integer> res) {
		int i=0;
		
		while(i<totalElem) {
			if((arreglo[i]%numero)==0) {
				res.add(arreglo[i]);
				totalElem=eliminaEnOrden(arreglo, totalElem, arreglo[i]);
			}
			else {
				i++;
			}
		}
		return totalElem;
	}

}
