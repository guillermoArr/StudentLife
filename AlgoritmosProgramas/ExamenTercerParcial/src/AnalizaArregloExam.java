import java.util.ArrayList;

/*Guillermo Arredondo
 * 19 de octubre 2020
 * Problema 1 Examen Tercer PARCIAL 
 */
public class AnalizaArregloExam {
	public static int agregaElem(double[] a, int n, ArrayList<Double> result) {
		int m;
		
		for(int i=0; i<n; i++) {
			if(!result.contains(a[i])) { // while(j<result.size() && a[i]!=result.get(j)) {  //tu habias hecho esto y luego te diste cuenta
				result.add(a[i]);		//j++;													mil veces mas facil el contains jajaja
			}							//}
										//if(j==result.size()) {
											//result.add(a[i]);
		}								//}			
		
		for(int k=0; k<result.size(); k++) {
			if(n<a.length) {
				m=0;
				while(m<n && result.get(k)!=a[m]) {
					m++;
				}
				if(m==n) {
					a[n]=result.get(k);
					n++;
				}
			}
		}
		return n;
	}

}
