/*Guillermo Arredondo 
 * 18 noviembre 2020 
 * Examen cuarto parcial- Tipo C2- Clase con método estatico y main Problema 1.
 */
public class ManipulaMatrizGenericaC2 {
	public static <T> String concatMatInf(T[][] mat, int m, int n) {
		StringBuilder cad=new StringBuilder();
		int j=1; 	//considerando que 0,0 jamás va a cumplir la condición 
		int i;
						//tendrías que haber validado que m y n fueran iguales, es decir matriz cuadrada
		while(j<m) {
			i=0;
			while(i<n && j!=i) {
				cad.append(mat[j][i].toString());
				cad.append(" ");
				i++;
			}
			j++;
		}
		return cad.toString();
	}
	public static <T> String concatMatInf(T[][] mat, int m) { // esta es la buena
		StringBuilder cad=new StringBuilder();
				
		for(int j=1; j<m; j++) {
			for(int i=0; i<j; i++) {
				cad.append(mat[j][i].toString());
				cad.append(" ");
			}
		}
		return cad.toString();
	}
	public static <T> void imprimeMatriz(T[][] mat, int m, int n) {
		
		for(int j=0; j<m; j++) {
			for(int i=0; i<n; i++) {
			System.out.print("\t"+mat[j][i].toString());
			}
			System.out.println();
		}
		System.out.println();
	}	

	public static void main(String[] args) {
		Double[][] mat= {{5.0, 11.0, 21.5, 12.4, 8.6, 41.4, 66.2},{71.6, 5.6, 13.75, 32.6, 4.7, 7.8, 61.1}, {9.2, 7.4, 5.5, 23.6, 24.8, 25.9, 26.1}, {6.5, 93.6, 72.9, 5.8, 40.4, 41.7, 42.4}};
		String res;
		
		imprimeMatriz(mat, 4, 7);
		res=concatMatInf(mat, 4, 7);
		System.out.println(res);

	}

}
