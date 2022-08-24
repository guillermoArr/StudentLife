import java.util.ArrayList;

/*Guillermo Arredondo
 * 23 octubre 2020
 * METODOS DEL MANEJADOR ARREGLOS PARA CUALQUIER TIPO DE DATO
 */
public class ManejadorArreglosGenericos {
	/*public static <T> void imprimeArreglo(T [] a, int n) {
		
		for(int i=0; i<n; i++) {
			System.out.print("\t"+a[i]);
		}
		System.out.println(); 
	}*/
	
	public static <T extends Comparable<T>> int posMayor(T [] a, int n) {
		T max=a[0];
		int indiceMax=0;
		
		for(int i=1; i<n; i++) {
			if(max.compareTo(a[i])<0) {
				max=a[i];
				indiceMax=i;
			}
		}
		return indiceMax;
	}
	public static <T extends Comparable<T>> int posMenor(T[] a, int n) {
		T min=a[0];
		int indiceMin=0;
		
		for(int i=1; i<n; i++) {
			if(min.compareTo(a[i])>0) {
				min=a[i];
				indiceMin=i;
			}
		}
		return indiceMin;
	}
	public static <T extends Comparable<T>> int cuantosMayorX(T[] a, int n, T comp) {
		int numMayores=0;
		
		for(int i=0; i<n; i++) {
			if(a[i].compareTo(comp)>0) {
				numMayores++;
			}
		}
		return numMayores;
	}
	public static <T extends Comparable<T>> ArrayList<Integer> cualesMayX(T[] a, int n, T comp){
		ArrayList<Integer> lista=new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			if(a[i].compareTo(comp)>0) {
				lista.add(i);
			}
		}
		return lista;
	}
	public static <T extends Comparable<T>> int cuantosMenX(T[] a, int n, T comp) {
		int numMenores=0;
		
		for(int i=0; i<n; i++) {
			if(a[i].compareTo(comp)<0) {
				numMenores++;
			}
		}
		return numMenores;
	}
	public static <T extends Comparable<T>> ArrayList<Integer> cualesMenX(T[] a, int n, T comp){
		ArrayList<Integer> lista=new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			if(a[i].compareTo(comp)<0) {
				lista.add(i);
			}
		}
		return lista;
	}
	public static <T> void swap(T[] a, int i1, int i2) {
		T aux=a[i1];
		
		a[i1]=a[i2];
		a[i2]=aux;
	}
	public static <T> void invierte(T[] a, int n) {
		T aux;
		
		for(int i=0; i<n; i++) {
			n--;
			aux=a[i];
			a[i]=a[n];
			a[n]=aux;
		}
	}
	public static <T> void correKDerecha(T[] a, int n, int k) {
		
		for(int j=1; j<=k; j++) {
			for(int i=n-1; i>0; i--) {
				a[i]=a[i-1];
			}
			a[0]=null;
		}
	}
	public static <T> void correKIzquierda(T[] a, int n, int k) {
		
		for(int j=1; j<=k; j++) {
			for(int i=0; i<n-1; i++) {
				a[i]=a[i+1];
			}
			a[n-1]=null;
		}
	}
	public static <T> void unCorrimientoDer(T[] a, int n, int pos) {
		
		for(int i=n; i>pos; i--) {
			a[i]=a[i-1];
		}
	}
	public static <T> void unCorrimientoIzq(T[] a, int n, int pos) {
		
		for(int i=pos; i<n-1; i++) {
			a[i]=a[i+1];
		}
	}
	public static <T extends Comparable<T>> int posMinimo(T[] a, int n, int inicio) {
		int indiceMin=inicio;
		
		for(int i=inicio+1; i<n; i++) {
			if(a[indiceMin].compareTo(a[i])>0) {
				indiceMin=i;
			}
		}
		return indiceMin;
	}
	public static <T extends Comparable<T>> void selecDirecta(T[] a, int n) {
		int indiceMin;
		
		for(int i=0; i<n; i++) {
			indiceMin=posMinimo(a, n, i);
			swap(a, indiceMin, i);
		}
	}
	public static <T> int buscaSecDesorden(T[] a, int n, T busca) {
		int i=0;
		
		while(i<n && !a[i].equals(busca)) {
			i++;
		}
		if(i==n) {
			i=-1;
		}
		return i;
	}
	public static <T extends Comparable<T>> int buscaSecOrdenada(T[] a, int n, T busca) {
		int i=0;
		
		while(i<n  && a[i].compareTo(busca)<0) {
			i++;
		}
		if(i==n || !a[i].equals(busca)) {
			i=-i-1;
		}
		
		return i;
	}
	public static <T extends Comparable<T>> int buscaBinaria(T[] a, int n, T busca) {
		int res;
		int inicio=0;
		int fin=n-1;
		int mitad=(inicio+fin)/2;
		
		while(inicio<=fin && !a[mitad].equals(busca)) {	
			if(busca.compareTo(a[mitad])<0) {
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
	public static <T> int inserta(T[] a, int n, int pos, T x) {
		if(n<a.length) {
			unCorrimientoDer(a, n, pos);
			a[pos]=x;
			n++;
		}
		return n;
	}
	public static <T extends Comparable<T>> int insertaEnOrden(T[] a, int n, T x) {
		int pos;
		
		if(n<a.length) {
			pos=buscaBinaria(a, n, x);
			if(pos<0) {
				pos=-pos-1;
				unCorrimientoDer(a, n, pos);
				a[pos]=x;
				n++;
			}	
		}
		return n;
	}
	public static <T> int insertaFinal(T[] a, int n, T x) {
		return inserta(a, n, n, x);
	}
	public static <T> int insertaInicio(T[] a, int n, T x) {
		return inserta(a, n, 0, x);
	}
	
	public static <T> int elimina(T[] a, int n, int pos) {
			unCorrimientoIzq(a, n, pos);
			n--;
			a[n]=null;
		return n;
	}
	public static <T extends Comparable<T>> int eliminaEnOrden(T[] a, int n, T x) {
		int pos;
		
		pos=buscaBinaria(a, n, x);
		if(pos>=0) {
			unCorrimientoIzq(a, n, pos);
			n--;
			a[n]=null;
		}
		return n;
	}
	public static <T> int eliminaEnDesorden(T[] a, int n, T x) {
		int pos;
		
		pos=buscaSecDesorden(a, n, x);
		if(pos>=0) {
			unCorrimientoIzq(a, n, pos);
			n--;
			a[n]=null;
		}
		return n;
	}

}
