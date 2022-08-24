import java.util.ArrayList;

/*Guillermo Arredondo 
 * 21 septiembre 2020
 * estableciendo métodos estatáticos
 */
public class Calculadora {
	public static double multiplicacion(double num1, int num2) {
		double res=0;
		
		for(int i=1; i<=num2; i++) {
			res+=num1;
		}
		return res;
	}
	public static double potencia(double num1, int num2) {
		double res=1;
		
		for(int i=1; i<=num2; i++) {
			res*=num1;
		}
		return res;
	}
	public static String calculaUllman(int num) {
		StringBuilder cad=new StringBuilder();
		
		cad.append(num+" ");
		while(num!=1) {
			if(num%2==0) {
				num/=2;
			}
			else {
				num=num*3+1;
			}
			cad.append(" "+num);
		}
		return cad.toString();
	}
	
	public static ArrayList<Double> ullmanList(double num){
		ArrayList<Double> lista=new ArrayList<Double>();
		
		lista.add(num);
		while(num!=1) {
			if(num%2==0) {
				num/=2;
			}
			else {
				num=num*3+1;
			}
			lista.add(num);
		}
		return lista;
	}
	
	public static String generaSerieFibonacci(int n) {
		StringBuilder cad=new StringBuilder();
		int t1=0;
		int t2=1;
		int t3;
		
		cad.append(" "+t1);
		cad.append(" "+t2);
		for (int i=3; i<=n; i++) {
			t3=t2+t1;
			cad.append(" "+t3);
			t1=t2;
			t2=t3;
		}
		return cad.toString();
	}
	
	public static double[] fibonacciArr(int n) {
		double[] arr=new double[n];
		
		arr[0]=0;
		arr[1]=1;
		for (int i=2; i<n; i++) {
			arr[i]=arr[i-2]+arr[i-1];
		}
		return arr;
	}
	
	public static String generaCubosNicomaco(int n) {
		StringBuilder cad=new StringBuilder();
		int impar=1;
		int cubo;
		
		for(int i=1; i<=n; i++) {
			cubo=0;
			for(int j=0; j<i; j++) {
				cubo+=impar;
				
				if(j!=0) {
					cad.append("+");
				}
				cad.append(+impar);
				impar+=2;
			}
			cad.append("="+i+" **3= "+cubo+"\n");
		}
		return cad.toString();
	}
	public static int calculaFactorial(int n) {
		int fac=1;
		
		for(int i=2; i<=n; i++) {
			fac*=i;
		}
		return fac;
	}
	public static int calculaMaximoComDivisor(int m, int n) {
		int maxCD, residuo;
		maxCD=0;
		
		if(m==0) {
			maxCD=n;
		}
		else if(n==0) {
			maxCD=m;
		}
		else if(m>=n){
			while(m%n!=0) {
				residuo=m%n;
				m=n;
				n=residuo;
			}
			maxCD=n;
		}
		else{
			while(n%m!=0) {
				residuo=n%m;
				n=m;
				m=residuo;
			}
			maxCD=m;
		}
		return maxCD;
	}
	
	public static int calculaSerie1(int n) {
		int suma=0;
		int res;
		
		for(int i=1; i<=n; i++) {
			res=1;
			for(int j=1; j<=i; j++) {
				res*=i;
			}
			suma+=res;
		}
		return suma;
	}
	public static boolean esDivisiblePor11(int n) {
		boolean res=false;
		
		
		return res;
	}
}

