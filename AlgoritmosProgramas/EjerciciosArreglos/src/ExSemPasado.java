import java.util.ArrayList;
public class ExSemPasado {
	public static ArrayList<Integer> generaLista(double[] a, double[] b, int n){
		ArrayList<Integer> res=new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			if(a[i]%b[i]==0 || b[i]%a[i]==0) {
				res.add(i);
			}
		}
		return res;
	}

}
