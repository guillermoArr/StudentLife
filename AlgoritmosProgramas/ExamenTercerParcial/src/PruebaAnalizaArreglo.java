import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*Guillermo Arredondo 
 * 19 de octubre 2020
 * Problema 1, iniciso b: Prueba de Analiza Arreglo
 */
public class PruebaAnalizaArreglo {
	public static void imprimeArreglo(double[] a, int n) {
		
		for(int i=0; i<n; i++) {
			System.out.print("\t"+a[i]);
		}
		System.out.println(); 
	}
	public static final int MAX_CELDAS=50;

	public static void main(String[] args) {
		File entrada=new File("datoss.txt");
		int n;
		double[] arr=new double[MAX_CELDAS]; 
		ArrayList<Double> res=new ArrayList<Double>();
		double a;
		
		try(Scanner lec=new Scanner(entrada)){
			n=lec.nextInt();
			for(int i=0; i<n; i++) {
				arr[i]=lec.nextDouble();
			}
			while(lec.hasNext()) {
				a=lec.nextDouble();
				res.add(a);
			}
			lec.close(); //menso esto te costó una decima jajaja
			
			n=AnalizaArregloExam.agregaElem(arr, n, res);
			System.out.println("El nuevo numero de elementos es: "+n);
			imprimeArreglo(arr, n);
			System.out.println(res.toString());
			
		}
		catch(FileNotFoundException fnfe) {
			System.err.println("E R R O R "+fnfe);
			System.exit(-1);
		}

	}

}
