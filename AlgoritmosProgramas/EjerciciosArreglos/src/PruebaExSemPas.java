import java.util.ArrayList;

public class PruebaExSemPas {

	public static void main(String[] args) {
		double[] a= {20, 3, 23, 11, 44, 6, 32, 10, 2};
		double[] b= {2, 21, 15, 22, 31, 11, 5, 70, 26};
		ArrayList<Integer> res;
		double mult;
		StringBuilder cad=new StringBuilder();
		
		res=ExSemPasado.generaLista(a, b, a.length);
		System.out.print(res.toString());
		for(int i=0; i<res.size(); i++) {
			if(a[res.get(i)]<=b[res.get(i)]){
				mult=a[res.get(i)];
			}
			else {
				mult=b[res.get(i)];
			}
			cad.append("  "+mult);
		}
		System.out.println("\n"+cad.toString());
		

	}

}
