/*Guillermo Arredondo 
 * 28 octubre 2020
 * Manejador de matrices de double
 */
public class ManejadorMatrices {
	/*public static void imprimeMatriz(double[][] mat, int m, int n) {
		
		for(int j=0; j<m; j++) {
			for(int i=0; i<n; i++) {
			System.out.print("\t"+mat[j][i]);
			}
			System.out.println();
		}
		System.out.println(); 
	}*/
	public static double sumaCol(double[][] mat, int col, int m) {
		double suma=0;
		
		for(int j=0; j<m; j++) {
			suma+=mat[j][col]; //col-1
		}
		return suma;
	}
	public static double sumaRen(double[][] mat, int ren, int n) {
		return ManejadorArreglos.sumaArreglos(mat[ren], n);
	}
	public static double sumaElemTot(double[][] mat, int m, int n) {
		double suma=0;
		
		for(int j=0; j<m; j++) {
			suma+=ManejadorArreglos.sumaArreglos(mat[j], n);
		}
		return suma;
	}
	public static double sumaDiagonPrime(double[][] mat, int m) {//es cuadrada entonces solo usar m
		double suma=0;
		
		//se asume que la matriz es cuadrada
		for(int j=0; j<m; j++) {
			suma+=mat[j][j];
		}
		return suma;
	}
	public static double sumaDiagonSec(double[][] mat, int m) { //es cuadrada entonces solo usar m
		double suma=0;
		int i=m-1;
		
		//se asume que la matriz es cuadrada
		for(int j=0; j<m; j++) {
			suma+=mat[j][i];
			i--;
		}
		return suma; 
	}
	public static int posMenorCol(double[][] mat, int col, int m) {
		double min=mat[0][col];
		int pos=0;
		
		for(int j=1; j<m; j++) {
			if(min>mat[j][col]) {
				min=mat[j][col];
				pos=j;
			}
		}
		return pos;
	}
	public static int posMayorCol(double[][] mat, int col, int m) {
		double max=mat[0][col];			//int may=0
		int pos=0;
		
		for(int j=1; j<m; j++) {
			if(max<mat[j][col]) {		//mat[may][col]<mat[j][col]
				max=mat[j][col];		//may=j
				pos=j;
			}
		}
		return pos;						//return may
	}
	public static int posMenorRen(double[][] mat, int ren, int n) {
		return ManejadorArreglos.posMenor(mat[ren], n);
	}
	public static int posMayorRen(double[][] mat, int ren, int n) {
		return ManejadorArreglos.posMayor(mat[ren], n);
	}
	public static int[] posMenor(double[][] mat, int m, int n) {
		int[] res= {0,0};
		int minRen=ManejadorArreglos.posMenor(mat[0], n);
		double minMat=mat[0][0];
		res[1]=minRen;
		
		for(int j=1; j<m; j++) {
			minRen=ManejadorArreglos.posMenor(mat[j], n);
			if(mat[j][minRen]<minMat) {
				minMat=mat[j][minRen];
				res[0]=j;
				res[1]=minRen;
			}
		}
		return res;
	}
	public static int[] posMayor(double[][] mat, int m, int n) {
		int[] res= {0,0};
		int maxRen=ManejadorArreglos.posMayor(mat[0], n);
		double maxMat=mat[0][maxRen];
		res[1]=maxRen;
		
		for(int j=1; j<m; j++) {
			maxRen=ManejadorArreglos.posMayor(mat[j], n);
			if(mat[j][maxRen]>maxMat) {
				maxMat=mat[j][maxRen];
				res[0]=j;
				res[1]=maxRen;
			}
		}
		return res;
	}
	public static double[][] sumaAyB(double[][] mat1, int m1, int n1, double[][] mat2, int m2, int n2) {
		double[][] suma;
		
		if(m1==m2 && n1==n2) {
			suma=new double[m1][n1];
			for(int j=0; j<m1; j++) {
				for(int i=0; i<n1; i++) {
					suma[j][i]=mat1[j][i]+mat2[j][i];
				}
			}
		}
		else {
			suma=null;
		}
		return suma;
	}
	public static double[][] multiplicaAyB(double[][] mat1, int m1, int n1, double[][] mat2, int m2, int n2){
		double[][] res;
		double sumaParcial; //m(m1) ; n(n1,m2) y  p(n2)
		
		if(n1==m2) {
			res=new double[m1][n2];
			for(int j=0; j<m1; j++) {
				for(int k=0; k<n2; k++) {
					sumaParcial=0;
					for(int i=0; i<n1; i++) {
						sumaParcial+=(mat1[j][i]*mat2[i][k]);
					}
					res[j][k]=sumaParcial;
				}
			}
			
		}
		else {
			res=null;
		}
		return res;
	}
	public static double[][] traspuesta(double[][] mat, int m, int n) {
		double[][] res=new double[n][m];
		
		for(int j=0; j<m; j++) {
			for(int i=0; i<n; i++) {
				res[i][j]=mat[j][i];
			}
		}
		return res;
	}
	public static boolean esSimetrica(double[][] mat, int m) {
		boolean res=true;
		int i;
		int j=0;
		
		while(res && j<m) { //m-1
			i=j+1;
			while(i<m && mat[j][i]==mat[i][j]) {
				i++;
			}
			if(i!=m) {
				res=false;
			}
			j++;
		}
		
		return res;
	}
	public static boolean esIdentidad(double[][] mat, int m) {
		boolean res=true;
		int j=0;
		int i;
		
		while(res && j<m) {
			i=0;
			while(res && i<m) {
				if(i==j && mat[j][i]!=1) {
					res=false;
				}
				else if(i!=j && mat[j][i]!=0) {
					res=false;
				}
				i++;
			}
			j++;
		}
		return res;
	}
	public static int buscaRenglonDesordenado(double[][] mat, int renglon, int n, double x) {
		return ManejadorArreglos.buscaSecDesorden(mat[renglon], n, x);
	}
	public static int buscaRenglonOrdenado(double[][] mat, int renglon, int n, double x) {
		return ManejadorArreglos.buscaSecOrdenada(mat[renglon], n, x);
	}
	public static int buscaColumna(double[][] mat, int columna, int m, double x) {
		int j=0;
		
		while(j<m && mat[j][columna]!=x) {
			j++;
		}
		if(j==m) {
			j=-1;
		}
		return j;
	}
	public static int[] buscaEnMatriz(double[][] mat, int m, int n, double x) {
		int[] res= {-1, -1};
		int j=0;
		int pos;
		boolean encontre=false;
		
		while(!encontre && j<m) {	// o en lugar de boolean buscar pos[0]==-1
			pos=ManejadorArreglos.buscaSecDesorden(mat[j], n, x);
			if(pos>=0) {
				res[0]=j;
				res[1]=pos;
				encontre=true;
			}
			j++;
		}
		return res;
	}
	public static boolean matEqualsOther(double[][] mat1, int m1, int n1, double[][] mat2, int m2, int n2) {
		boolean res=true;
		int i, j;
		
		if(m1==m2 && n1==n2) {
			j=0;
			while(res && j<m1) {
				i=0;
				while(i<n1 && mat1[j][i]==mat2[j][i]) {
					i++;
				}
				if(i!=n1) {
					res=false;
				}
				j++;
			}
		}
		else {
			res=false;
		}
		return res;
	}
	public static void main(String[] args) {
		double[][] m1={{5,-3,2,8},{4,-1,9,2}};
        double[][] m2={{3,5,8,1},{1,5,6,8},{0,9,7.6,3.6}/*,{3.2,5,3.3,7}*/};
        double[][] m3={{-4,2,7},{8,-1,9},{6,5,-2},{-1,6,3}};
        
        double[][] res=multiplicaAyB(m1,2,4,m3,4,3);
        for(int j=0; j<res.length; j++) {
        	for(int i=0; i<res[0].length; i++) {
        		System.out.print(res[j][i]+"\t");
        	}
        	System.out.println();
        }
        res=traspuesta(m1,2,4);
        for(int j=0; j<res.length; j++) {
        	for(int i=0; i<res[0].length; i++) {
        		System.out.print(res[j][i]+"\t");
        	}
        	System.out.println();
        }
        
	}

}
