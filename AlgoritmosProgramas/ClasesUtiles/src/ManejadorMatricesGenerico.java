/*Guillermo Arredondo
 * 11 de noviembre 2020
 * Clase ManejadorMatrices generico
 */
public class ManejadorMatricesGenerico {
	public static <T extends Comparable<T>> int posMenorCol(T[][] mat, int col, int m) {
		T min=mat[0][col];
		int pos=0;
		
		for(int j=1; j<m; j++) {
			if(min.compareTo(mat[j][col])>0) {
				min=mat[j][col];
				pos=j;
			}
		}
		return pos;
	}
	public static <T extends Comparable<T>>int posMayorCol(T[][] mat, int col, int m) {
		T max=mat[0][col];			//int may=0
		int pos=0;
		
		for(int j=1; j<m; j++) {
			if(max.compareTo(mat[j][col])<0) {		//mat[may][col]<mat[j][col]
				max=mat[j][col];		//may=j
				pos=j;
			}
		}
		return pos;						//return may
	}
	public static <T extends Comparable <T>>int posMenorRen(T[][] mat, int ren, int n) {
		return ManejadorArreglosGenericos.posMenor(mat[ren], n);
	}
	public static <T extends Comparable <T>>int posMayorRen(T[][] mat, int ren, int n) {
		return ManejadorArreglosGenericos.posMayor(mat[ren], n);
	}
	public static <T extends Comparable <T>>int[] posMenor(T[][] mat, int m, int n) {
		int[] res= {0,0};
		int minRen=ManejadorArreglosGenericos.posMenor(mat[0], n);
		T minMat=mat[0][0];
		res[1]=minRen;
		
		for(int j=1; j<m; j++) {
			minRen=ManejadorArreglosGenericos.posMenor(mat[j], n);
			if(mat[j][minRen].compareTo(minMat)<0) {
				minMat=mat[j][minRen];
				res[0]=j;
				res[1]=minRen;
			}
		}
		return res;
	}
	public static <T extends Comparable <T>>int[] posMayor(T[][] mat, int m, int n) {
		int[] res= {0,0};
		int maxRen=ManejadorArreglosGenericos.posMayor(mat[0], n);
		T maxMat=mat[0][maxRen];
		res[1]=maxRen;
		
		for(int j=1; j<m; j++) {
			maxRen=ManejadorArreglosGenericos.posMayor(mat[j], n);
			if(mat[j][maxRen].compareTo(maxMat)>0) {
				maxMat=mat[j][maxRen];
				res[0]=j;
				res[1]=maxRen;
			}
		}
		return res;
	}
	public static <T> boolean esSimetrica(T[][] mat, int m) {
		boolean res=true;
		int i;
		int j=0;
		
		while(res && j<m) { //m-1
			i=j+1;
			while(i<m && mat[j][i].equals(mat[i][j])) {
				i++;
			}
			if(i!=m) {
				res=false;
			}
			j++;
		}
		
		return res;
	}
	public static <T> int buscaRenglonDesordenado(T[][] mat, int renglon, int n, T x) {
		return ManejadorArreglosGenericos.buscaSecDesorden(mat[renglon], n, x);
	}
	public static <T extends Comparable <T>> int buscaRenglonOrdenado(T[][] mat, int renglon, int n, T x) {
		return ManejadorArreglosGenericos.buscaSecOrdenada(mat[renglon], n, x);
	}
	public static <T> int buscaColumna(T[][] mat, int columna, int m, T x) {
		int j=0;
		
		while(j<m && !mat[j][columna].equals(x)) {
			j++;
		}
		if(j==m) {
			j=-1;
		}
		return j;
	}
	public static <T> int[] buscaEnMatriz(T[][] mat, int m, int n, T x) {
		int[] res= {-1, -1};
		int j=0;
		int pos;
		boolean encontre=false;
		
		while(!encontre && j<m) {
			pos=ManejadorArreglosGenericos.buscaSecDesorden(mat[j], n, x);
			if(pos>=0) {
				res[0]=j;
				res[1]=pos;
				encontre=true;
			}
			j++;
		}
		return res;
	}
	public static <T> boolean matEqualsOther(T[][] mat1, int m1, int n1, T[][] mat2, int m2, int n2) {
		boolean res=true;
		int i, j;
		
		if(m1==m2 && n1==n2 && mat1.getClass()==mat2.getClass()) {
			j=0;
			while(res && j<m1) {
				i=0;
				while(i<n1 && mat1[j][i].equals(mat2[j][i])) {
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

}
