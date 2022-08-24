
public class ManejadorArregloEntero {
	public static void imprimeArreglo(int [] a, int n) {
		
		for(int i=0; i<n; i++) {
			System.out.print("\t"+a[i]);
		}
		System.out.println(); 
	}
	public static void unCorrimientoIzq(int[] a, int n, int pos) {
		
		for(int i=pos; i<n-1; i++) {
			a[i]=a[i+1];
		}
		a[n-1]=0;
	}
	public static int eliminaMultiplosArreglos(int[] a, int m1, int [] b, int m2) {
		int i;
		
		if(m1==m2) {
			i=0;
			while(i<m1) {
				if(a[i]%b[i]==0 || b[i]%a[i]==0) {
					unCorrimientoIzq(a, m1, i);
					unCorrimientoIzq(b, m1, i);
					m1--;
				}
				else {
					i++;
				}
			}
		}
		return m1;
	}
	public static void main(String[] args) {
		int[] a= {10,5,9,28,34,11,17};
		int[] b= {13,45,3,323,17,6,41};
		int res;
		
		imprimeArreglo(a, 7);
		imprimeArreglo(b, 7);
		res=eliminaMultiplosArreglos(a, 7, b, 7);
		System.out.println(res);
		imprimeArreglo(a, res);
		imprimeArreglo(b, res);

	}

}
