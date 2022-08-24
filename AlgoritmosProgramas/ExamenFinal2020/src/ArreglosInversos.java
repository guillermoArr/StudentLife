/*Guillermo Arredondo Renero
 * 8 de diciembre de 2020
 * Problema 2 Examen Final 2020 metodo estatico para Arreglos con main
 */
public class ArreglosInversos {

	public static <T> int arregloInversoAOtro(T[]a, int nA, T[]b, int nB) {
		int res=0;
		int i, j;
		
		if(nA==nB) {
			i=0;
			j=nB-1;
			while(i<nA && a[i].equals(b[j])) { // en lugar de usar i<nA mejor usar i<=j, solo checar la mitad del arreglo
				i++;
				j--;
			}
			if(i!=nA) {
				res=i;
			}
			else {
				res=-1;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		String[] prueba1= {"negro", "amarillo", "verde", "azul", "rojo", "turquesa"};
		String[] prueba2= {"turquesa","rosa", "azul","verde","amarillo", "negro"};
		Integer[] prueba3= {1,4,6,8,10};
		Integer[] prueba4= {10,8,6,4,1};
		int res;
		
		res=arregloInversoAOtro(prueba1, 6, prueba2, 6);
		System.out.println(res);
		res=arregloInversoAOtro(prueba3, 5, prueba4, 5);
		System.out.println(res);
	}

}
