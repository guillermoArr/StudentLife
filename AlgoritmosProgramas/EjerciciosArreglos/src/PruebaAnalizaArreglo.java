import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
/*Guillermo Arredondo
 * 17 de octubre 2020
 * Inciso b del examen para segundo parcial anterior
 */
public class PruebaAnalizaArreglo {
	public static final int CELDAS=100;
	public static void imprimeArreglo(int[] a, int n) {
		
		for(int i=0; i<n; i++) {
			System.out.print("\t"+a[i]);
		}
		System.out.println(); 
	}
	
	public static void main(String[] args) {
		int n;
		File entrada=new File("datos.txt");
		int [] arr;
		
		try(Scanner lec=new Scanner(entrada)){
			arr=new int[CELDAS];
			ArrayList<Integer> res=new ArrayList<Integer>();
			
			n=lec.nextInt();
			for(int i=0; i<n; i++) {
				arr[i]=lec.nextInt();
			}
			
			System.out.println("Elementos originales: "+n);
			imprimeArreglo(arr, n);
			n=AnalizaArreglo.encuentraEliminaMultiplos(arr, n, 3, res);
			System.out.println("Nuevo total de elementos: "+n);
			imprimeArreglo(arr,n);
			System.out.println("\nElementos eliminados: "+res.toString());
		}
		catch(FileNotFoundException fnfe) {
			System.err.println("E R R O R "+fnfe);
			System.exit(-1);
		}

	}

}
