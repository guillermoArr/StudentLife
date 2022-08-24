
import java.util.ArrayList;
/*Guillermo Arredondo
 * 28 septiembre 2020
 * Main para probar manejar arreglos
 */
public class PruebaManejador {
		
	public static void imprimeArreglo(double[] a, int n) {
	
		for(int i=0; i<n; i++) {
			System.out.print("\t"+a[i]);
		}
		System.out.println(); 
	}
	public static void imprimeArregloS(String[] b, int n) {
		StringBuilder cad=new StringBuilder();
		
		for(int i=0; i<n; i++) {
			cad.append("    "+b[i]);
		}
		System.out.println(cad.toString());
	}
	
	public static void main(String[] args) {
		double[] arr= {12,23,35,7,44,72,4,45};
		double res;
		int cant, nAlterada;
		ArrayList<Integer> lista=new ArrayList<Integer>();
		
		double[] arre= {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 0, 0, 0, 0};
		int n=8;
		
		String[] arreglo= {"Guillermo", "Arredondo", "Ay", "Que", "Flojera", "Tengo", "arredonda", "arreglo", "ayuda", "sascuatch", "a", "baja california", "baja california norte"};
		
		
		imprimeArreglo(arr, arr.length);
		res=ManejadorArreglos.sumaArreglos(arr, arr.length);
		System.out.println(res);
		
		res=ManejadorArreglos.promArreglos(arr, arr.length);
		System.out.println(res);
		
		cant=ManejadorArreglos.posMayor(arr, arr.length);
		System.out.println(cant);
		
		cant=ManejadorArreglos.posMenor(arr, arr.length);
		System.out.println(cant);
		
		cant=ManejadorArreglos.cuantosMayorX(arr, arr.length, 35);
		System.out.println(cant);
		
		lista=ManejadorArreglos.cualesMayX(arr, arr.length, 35);
		System.out.println(lista.toString());
		
		cant=ManejadorArreglos.cuantosMenX(arr, arr.length, 15);
		System.out.println(cant);
		
		lista=ManejadorArreglos.cualesMenX(arr, arr.length, 15);
		System.out.println(lista.toString());
		
		ManejadorArreglos.swap(arr, 4, 5);
		imprimeArreglo(arr, arr.length);
		
		ManejadorArreglos.invierte(arr, arr.length);
		imprimeArreglo(arr, arr.length);
		
		ManejadorArreglos.selecDirecta(arr, 0);
		imprimeArreglo(arr, arr.length);
		
		System.out.println("La posicion deseada es: "+ManejadorArreglos.buscaSecDesorden(arr, arr.length, 72));
		ManejadorArreglos.selecDirecta(arr, arr.length);
		imprimeArreglo(arr, arr.length);
		System.out.println("La posicion deseada es: "+ManejadorArreglos.buscaSecOrdenada(arr, arr.length, 73));
		System.out.println("La posicion deseada es: "+ManejadorArreglos.buscaBinaria(arr, arr.length , 73));
		
		System.out.println("________");
				
		imprimeArreglo(arre, n);
		nAlterada=ManejadorArreglos.eliminaEnOrden(arre, n, 6.6);
		if(nAlterada!=n) {
			System.out.println("Arreglo modificado en "+nAlterada);
			imprimeArreglo(arre, nAlterada);
		}
		else {
			System.out.println("Arreglo no modificado");
		}
		n=nAlterada;
		nAlterada=ManejadorArreglos.insertaEnOrden(arre, n, 50);
		if(nAlterada!=n) {
			System.out.println("Arreglo modificado en "+nAlterada);
			imprimeArreglo(arre, nAlterada);
		}
		else {
			System.out.println("Arreglo no modificado");
		}
		n=nAlterada;
		nAlterada=ManejadorArreglos.insertaInicio(arre, n, 25);
		if(nAlterada!=n) {
			System.out.println("Arreglo modificado en "+nAlterada);
			imprimeArreglo(arre, nAlterada);
		}
		else {
			System.out.println("Arreglo no modificado");
		}
		n=nAlterada;
		nAlterada=ManejadorArreglos.insertaFinal(arre, n, 42);
		if(nAlterada!=n) {
			System.out.println("Arreglo modificado en "+nAlterada);
			imprimeArreglo(arre, nAlterada);
		}
		else {
			System.out.println("Arreglo no modificado");
		}
		n=nAlterada;
		nAlterada=ManejadorArreglos.eliminaEnDesorden(arre, n, 4.4);
		if(nAlterada!=n) {
			System.out.println("Arreglo modificado en "+nAlterada);
			imprimeArreglo(arre, nAlterada);
		}
		else {
			System.out.println("Arreglo no modificado");
		}
		n=nAlterada;
		nAlterada=ManejadorArreglos.inserta(arre, n, 4, 4.4);
		if(nAlterada!=n) {
			System.out.println("Arreglo modificado en "+nAlterada);
			imprimeArreglo(arre, nAlterada);
		}
		else {
			System.out.println("Arreglo no modificado");
		}
		
		System.out.println("____________________________________");
		imprimeArregloS(arreglo, arreglo.length);
		ManejadorArreglos.selecDirectaS(arreglo, arreglo.length);
		imprimeArregloS(arreglo, arreglo.length);

	}

}
