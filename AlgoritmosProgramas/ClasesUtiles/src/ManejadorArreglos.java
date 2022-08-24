import java.util.ArrayList;
/*Guillermo Arredondo
 * 28 septiembre 2020
 * Clase para uso de arreglos en Cuaderno de Ejercicios (pag. 43)
 */
public class ManejadorArreglos {
	public static double sumaArreglos(double[] a, int n) {
		double suma=0;
		
		for(int i=0; i<n; i++) {
			suma+=a[i];
		}
		return suma;
	}
	public static double promArreglos(double[] a, int n) {
		double prom=0;
		
		if(n!=0) {
			prom=sumaArreglos(a, n)/n;
		}
		return prom;
	}
	public static int posMayor(double[] a, int n) {
		double max=a[0];
		int indiceMax=0;
		
		for(int i=1; i<n; i++) {
			if(max<a[i]) {
				max=a[i];
				indiceMax=i;
			}
		}
		return indiceMax;
	}
	public static int posMenor(double[] a, int n) {
		double min=a[0];
		int indiceMin=0;
		
		for(int i=1; i<n; i++) {
			if(min>a[i]) {
				min=a[i];
				indiceMin=i;
			}
		}
		return indiceMin;
	}
	public static int cuantosMayorX(double[] a, int n, double comp) {
		int numMayores=0;
		
		for(int i=0; i<n; i++) {
			if(a[i]>comp) {
				numMayores++;
			}
		}
		return numMayores;
	}
	public static ArrayList<Integer> cualesMayX(double[] a, int n, double comp){
		ArrayList<Integer> lista=new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			if(a[i]>comp) {
				lista.add(i);
			}
		}
		return lista;
	}
	public static int cuantosMenX(double[] a, int n, double comp) {
		int numMenores=0;
		
		for(int i=0; i<n; i++) {
			if(a[i]<comp) {
				numMenores++;
			}
		}
		return numMenores;
	}
	public static ArrayList<Integer> cualesMenX(double[] a, int n, double comp){
		ArrayList<Integer> lista=new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			if(a[i]<comp) {
				lista.add(i);
			}
		}
		return lista;
	}
	public static void swap(double[] a, int i1, int i2) {
		double aux=a[i1];
		
		a[i1]=a[i2];
		a[i2]=aux;
	}
	public static void invierte(double[] a, int n) {
		double aux;
		
		for(int i=0; i<n; i++) {
			n--;
			aux=a[i];
			a[i]=a[n];
			a[n]=aux;
		}
	}
	public static void correKDerecha(double[] a, int n, int k) {
		
		for(int j=1; j<=k; j++) {
			for(int i=n-1; i>0; i--) {
				a[i]=a[i-1];
			}
			a[0]=0;
		}
	}
	public static void correKIzquierda(double[] a, int n, int k) {
		
		for(int j=1; j<=k; j++) {
			for(int i=0; i<n-1; i++) {
				a[i]=a[i+1];
			}
			a[n-1]=0;
		}
	}
	public static void unCorrimientoDer(double[] a, int n, int pos) {
		
		for(int i=n; i>pos; i--) {
			a[i]=a[i-1];
		}
	}
	public static void unCorrimientoIzq(double[] a, int n, int pos) {
		
		for(int i=pos; i<n-1; i++) {
			a[i]=a[i+1];
		}
	}
	public static int posMinimo(double[] a, int n, int inicio) {
		int indiceMin=inicio;
		
		for(int i=inicio+1; i<n; i++) {
			if(a[indiceMin]>a[i]) {
				indiceMin=i;
			}
		}
		return indiceMin;
	}
	public static void selecDirecta(double[] a, int n) {
		int indiceMin;
		
		for(int i=0; i<n; i++) {
			indiceMin=posMinimo(a, n, i);
			swap(a, indiceMin, i);
		}
	}
	public static int buscaSecDesorden(double[] a, int n, double busca) {
		int i=0;
		
		while(i<n && a[i]!=busca) {
			i++;
		}
		if(i==n) {
			i=-1;
		}
		return i;
	}
	public static int buscaSecOrdenada(double[] a, int n, double busca) {
		int i=0;
		
		while(i<n  && a[i]<busca) {
			i++;
		}
		if(i==n || a[i]!=busca) {
			i=-i-1;
		}
		
		return i;
	}
	public static int buscaBinaria(double[] a, int n, double busca) {
		int res;
		int inicio=0;
		int fin=n-1;
		int mitad=(inicio+fin)/2;
		
		while(inicio<=fin && a[mitad]!=busca) {	
			if(busca<a[mitad]) {
				fin=mitad-1;
			}
			else {
				inicio=mitad+1;
			}
			mitad=(inicio+fin)/2;
		}
		if(fin<inicio) {
			res=-inicio-1;
		}
		else {
			res=mitad;
		}
		
		return res;
	}
	public static int inserta(double[] a, int n, int pos, double x) {
		if(n<a.length) {
			unCorrimientoDer(a, n, pos);
			a[pos]=x;
			n++;
		}
		return n;
	}
	public static int insertaEnOrden(double[] a, int n, double x) {
		int pos;
		
		if(n<a.length) {
			pos=ManejadorArreglos.buscaBinaria(a, n, x);
			if(pos<0) {
				pos=-pos-1;
				unCorrimientoDer(a, n, pos);
				a[pos]=x;
				n++;
			}	
		}
		return n;
	}
	public static int insertaFinal(double[] a, int n, double x) {
		return inserta(a, n, n, x);
	}
	public static int insertaInicio(double[] a, int n, double x) {
		return inserta(a, n, 0, x);
	}

	public static int eliminaEnOrden(double[] a, int n, double x) {
		int pos;
		
		pos=ManejadorArreglos.buscaBinaria(a, n, x);
		if(pos>=0) {
			unCorrimientoIzq(a, n, pos);
			n--;
		}
		return n;
	}
	public static int eliminaEnDesorden(double[] a, int n, double x) {
		int pos;
		
		pos=ManejadorArreglos.buscaSecDesorden(a, n, x);
		if(pos>=0) {
			unCorrimientoIzq(a, n, pos);
			n--;
		}
		return n;
	}
	
	public static void swapS(String[] b, int i1, int i2) {
		String aux=b[i1];
		
		b[i1]=b[i2];
		b[i2]=aux;
	}
	public static int posMinimoS(String[] b, int n, int inicio) {
		int indiceMin=inicio;
		
		for(int i=inicio+1; i<n; i++) {
			if(b[indiceMin].compareToIgnoreCase(b[i])>0) {
				indiceMin=i;
			}
		}
		return indiceMin;
	}		
	public static void selecDirectaS(String[] b, int n) {
		int indiceMin;
		
		for(int i=0; i<n; i++) {
			indiceMin=posMinimoS(b, n, i);
			swapS(b, indiceMin, i);
		}
	}	
	public static int buscaBinariaS(String[] a, int n, String busca) {
		int res;
		int inicio=0;
		int fin=n-1;
		int mitad=(inicio+fin)/2;
		
		while(inicio<=fin && !a[mitad].contentEquals(busca)) {	
			if(busca.compareToIgnoreCase(a[mitad])<0) {
				fin=mitad-1;
			}
			else {
				inicio=mitad+1;
			}
			mitad=(inicio+fin)/2;
		}
		if(fin<inicio) {
			res=-inicio-1;
		}
		else {
			res=mitad;
		}
		
		return res;
	}
	public static int insertaEnOrdenS(String[] a, int n, String x) {
		int pos;
		
		if(n<a.length) {
			pos=ManejadorArreglos.buscaBinariaS(a, n, x);
			if(pos<0) {
				pos=-pos-1;
				unCorrimientoDerS(a, n, pos);
				a[pos]=x;
				n++;
			}	
		}
		return n;
	}
	public static void unCorrimientoDerS(String[] a, int n, int pos) {
		
		for(int i=n; i>pos; i--) {
			a[i]=a[i-1];
		}
	}
	
	

}
