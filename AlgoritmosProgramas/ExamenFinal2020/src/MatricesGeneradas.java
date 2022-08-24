import java.util.ArrayList;
/*Guillermo Arredondo Renero
 * 8 de diciembre de 2020
 * Problema 3 Examen Final 2020 metodo estatico para matrices con main
 */
public class MatricesGeneradas {
	public static void imprimeMatriz(double[][] mat) {
		
		for(int j=0; j<mat.length; j++) {
			for(int i=0; i<mat[0].length; i++) {
			System.out.print("\t"+mat[j][i]);
			}
			System.out.println();
		}
		System.out.println();
	}
	public static double[][] generaMatrizPorLista(ArrayList<Double> lista){
		int size=lista.size();
		double[][] res=new double[size][size];
		double relleno;
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(j==0 || (lista.get(i)%2!=0 && j%2!=0) || (lista.get(i)%2==0 && j%2==0)) {
					relleno=lista.get(i);
				}
				else {
					relleno=(lista.get(i)/2);
				}
				res[j][i]=relleno;
			}
			
		}
		return res;
	}
	
	public static void main(String[] args) {
		ArrayList<Double> a=new ArrayList();
		double[][] res;
		
		a.add(11.6);
		a.add(8.0);
		a.add(5.0);
		a.add(4.0);
		a.add(8.0);
		a.add(9.0);
		a.add(2.0);
		a.add(10.5);
		
		res=generaMatrizPorLista(a);
		imprimeMatriz(res);
		
		
	}

}
