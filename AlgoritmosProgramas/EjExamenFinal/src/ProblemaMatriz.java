
public class ProblemaMatriz {
	public static void imprimeMatriz(int[][] mat, int m) {
		
		for(int j=0; j<m; j++) {
			for(int i=0; i<m; i++) {
			System.out.print("\t"+mat[j][i]);
			}
			System.out.println();
		}
		System.out.println();
	}
	public static int [][] generaMatriz(int[][] matriz, int total){
		for(int j=0; j<total; j++) {
			for(int i=0; i<=j; i++) {
				if(j==i) {
					matriz[j][i]=0;
				}
				else {
					matriz[j][i]+=matriz[i][j];
					matriz[i][j]=0;
				}
			}
		}
		return matriz;
	}
	public static void main(String[] args) {
		int[][] a= {{5,10,9,2,12},{4,9,10,1,0},{0,7,0,3,0},
				{6,9,2,4,3},{2,7,9,5,5}};
		int[][] b;
		
		imprimeMatriz(a, 5);
		b=generaMatriz(a, 5);
		imprimeMatriz(b, 5);

	}

}
