import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*Guillermo Arredondo 
 * 28 octubre 2020
 * Main de prueba de matrices
 */
public class MainMatrices {
	public static final int NUM_REN=8;
	public static final int NUM_COL=9;
	
	public static void imprimeArreglo(int[] a, int n) {		
		for(int i=0; i<n; i++) {
			System.out.print("\t"+a[i]);  
		}
		System.out.println(); 
	}
	public static void imprimeMatriz(double[][] mat, int m, int n) {
		
		for(int j=0; j<m; j++) {
			for(int i=0; i<n; i++) {
				System.out.print("\t"+mat[j][i]);
			}
			System.out.println();
		}
		System.out.println(); 
	}
	public static void leeMatrizArchivo(double[][] mat, int m, int n, String nomArch) {
		File entrada=new File(nomArch);
		
		try(Scanner lec=new Scanner(entrada)){
			for(int j=0; j<m; j++) {
				for(int i=0; i<n; i++) {
					mat[j][i]=lec.nextDouble();
				}
			}
			lec.close();
		}
		catch(FileNotFoundException fnfe) {
			System.err.println("E R R O R "+fnfe);
			System.exit(-1);
		}
		
	}

	public static void main(String[] args) {
		double[][] mat= {{5,4,7,9}, {6,2,3,1}, {8,5,3,10}};
		double[][] mat2=new double[NUM_REN][NUM_COL];
		int[] res=new int[2];
		
		imprimeMatriz(mat, mat.length, mat[0].length);
		leeMatrizArchivo(mat2, 4, 5, "leeMatriz.txt");
		imprimeMatriz(mat2, 4, 5);
		
		System.out.println("Suma de columna 2: (matriz 2) "+ManejadorMatrices.sumaCol(mat2, 2, 4));
		System.out.println("Suma de columna 3: (matriz 1) "+ManejadorMatrices.sumaCol(mat, 3, mat.length));
		
		System.out.println("Suma de renglon 2: (matriz 1) "+ManejadorMatrices.sumaRen(mat, 1, mat[1].length));
		System.out.println("Suma de renglon 1: (matriz 2) "+ManejadorMatrices.sumaRen(mat2, 1, 5));
		
		System.out.println("Suma de elementos totales (matriz 1) "+ManejadorMatrices.sumaElemTot(mat, mat.length, mat[0].length));
		System.out.println("Suma de elementos totales (matriz 2) "+ManejadorMatrices.sumaElemTot(mat2, 4, 5));
		
		System.out.println("Suma de diagonales principal (matriz 1) "+ManejadorMatrices.sumaDiagonPrime(mat, mat.length));
		System.out.println("Suma de diagonales principal (matriz 2) "+ManejadorMatrices.sumaDiagonPrime(mat2, 4));
		
		System.out.println("Suma de diagonales secundaria (matriz 1) "+ManejadorMatrices.sumaDiagonSec(mat, mat.length));
		System.out.println("Suma de diagonales secundaria (matriz 2) "+ManejadorMatrices.sumaDiagonSec(mat2, 4));
		
		System.out.println("Pos menor en columna 3: (matriz 1) "+ManejadorMatrices.posMenorCol(mat, 3, mat.length));
		System.out.println("                     4: (matriz 2) "+ManejadorMatrices.posMenorCol(mat2, 4, 4));
		
		System.out.println("Pos mayor en columna 3: (matriz 1) "+ManejadorMatrices.posMayorCol(mat, 3, mat.length));
		System.out.println("                     4: (matriz 2) "+ManejadorMatrices.posMayorCol(mat2, 4, 4));
		
		System.out.println("Pos mayor en reglon 2: (matriz 1) "+ManejadorMatrices.posMayorRen(mat, 2, mat[0].length));
		System.out.println("                    0: (matriz 2) "+ManejadorMatrices.posMayorRen(mat2, 0, 5));
		
		System.out.println("Pos menor en reglon 2: (matriz 1) "+ManejadorMatrices.posMenorRen(mat, 2, mat[0].length));
		System.out.println("                    0: (matriz 2) "+ManejadorMatrices.posMenorRen(mat2, 0, 5));
		
		res=ManejadorMatrices.posMenor(mat, mat.length, mat[0].length);
		System.out.println("Pos menor en toda la matriz: (matriz 1) ");
		imprimeArreglo(res, res.length);
		res=ManejadorMatrices.posMenor(mat2, 4, 5);
		System.out.println("Pos menor en toda la matriz: (matriz 2) ");
		imprimeArreglo(res, res.length);
		
		res=ManejadorMatrices.posMayor(mat, mat.length, mat[0].length);
		System.out.println("Pos mayor en toda la matriz: (matriz 1) ");
		imprimeArreglo(res, res.length);
		res=ManejadorMatrices.posMayor(mat2, 4, 5);
		System.out.println("Pos mayor en toda la matriz: (matriz 2) ");
		imprimeArreglo(res, res.length);


	}

}
