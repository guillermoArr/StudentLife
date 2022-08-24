import java.util.ArrayList;
import java.util.Scanner;

/*Guillermo Arredondo 
 * 25 septiembre 2020
 * Prueba de clases con array list
 */ 
public class EjecutableListas {
	private static final int CELDAS=100;
	
	public static void imprimeArreglo(double[] a, int n) {
		StringBuilder cad=new StringBuilder();
		
		for(int i=0; i<n; i++) {
			cad.append(" "+a[i]); //o poner system.out.print("\t"+a[i]); de una vez, tal vez pueda ser mejor 
		}
		System.out.println(cad.toString()); // te ahorras esta instruccion y una variable // Lourdes: System.out.println();
	}
	public static int leeArreglo(double[] arr) {
		int n;
		Scanner lec=new Scanner(System.in);
		
		System.out.println("Dime el numero de celdas que quieres leer? Max: "+CELDAS);
		n=lec.nextInt();
		for(int i=0; i<n; i++) {
			System.out.println("Dime el valor a asignar en la celda "+i);
			arr[i]=lec.nextDouble();
		}
		
		return n;
	}

	public static void main(String[] args) {
		ArrayList<Double> listaRes;
		String ull, fib;
		double[] arrRes;
		int pos, nPrueba;
		double elemUll, elemFib;
		Scanner lec=new Scanner(System.in);
		
		double[] arrPrueba=new double [CELDAS];
		
		nPrueba=leeArreglo(arrPrueba);
		System.out.println("El arreglo es de: "+nPrueba+" celdas");
		imprimeArreglo(arrPrueba, nPrueba);
		
		ull=Calculadora.calculaUllman(23);
		System.out.println(ull);
		listaRes=Calculadora.ullmanList(23);
		System.out.println(listaRes.toString());
		
		fib=Calculadora.generaSerieFibonacci(10);
		System.out.println(fib);
		arrRes=Calculadora.fibonacciArr(10);
		//System.out.println(arrRes); //no sirve arrRes.toString() por ser array 
		imprimeArreglo(arrRes, arrRes.length);
		
		System.out.println("Que elemento quieres imprimir de ullman?");
		pos=lec.nextInt();
		elemUll=listaRes.get(pos);
		System.out.println(elemUll);
		
		System.out.println("Que elemento quieres imprimir de fibonacci?");
		pos=lec.nextInt();
		elemFib=arrRes[pos];
		System.out.println(elemFib);
		
		

	}

}
