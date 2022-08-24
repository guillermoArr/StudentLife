/*Guillermo Arredondo 
 * 10 de septiembre 2020
 * Clase Ejercicio Diseño de clase cuenta y programación
 */
public class Cuenta {
	private int numCuenta;
	private String nomTitular;
	private double saldo;
	//double cantRecibida;
	
	public Cuenta() {
	}
	public Cuenta(int numCuenta, String nomTitular, double saldo) {
		this.numCuenta=numCuenta;
		this.nomTitular=nomTitular;
		this.saldo=saldo;
	}
	public void setNomTitular(String nomTitular) {
		this.nomTitular=nomTitular;
	}
	public void setNumCuenta(int numCuenta) {
		this.numCuenta=numCuenta;
	}
	
	public int getNumCuenta() {
		return numCuenta;
	}
	public String getNomTitular() {
		return nomTitular;
	}
	public double getSaldo() {
		return saldo;
	}
	
	public boolean retiro(double cantRecibida) {
		boolean res= false;
		
		if(cantRecibida<=saldo) {
			saldo-=cantRecibida;
			res=true;
		}
		/*else {
		 * JAMAS!!!! System.out.println("Imposible realizar accion.\nCantidad requerida mayor al saldo disponible");
		*/
		
		return saldo; 
	}
	
	public void deposito(double cantRecibida) {
			
		//if(cantRecibida>0) {
			saldo+=cantRecibida;
		//}
		/*else {
			System.out.println("Deposito debe ser mayor a 0, por favor intente de nuevo");
		}*/
	}
	
	public String toString() {
		StringBuilder cad=new StringBuilder();
		
		cad.append("\n     El numero de cuenta es : "+numCuenta);
		cad.append("\n          bajo el nombre de : "+nomTitular);
		cad.append("\nTiene un saldo disponible de: "+saldo);
		return cad.toString();
	}
	public int compareTo(Cuenta otro) {
		int res;
		
		if(this.saldo<otro.saldo) {
			res=-1;
		}
		else if(this.saldo>otro.saldo) {
			res=1;
		}
		else {
			res=0;
		}
		return res;
	}
	public boolean equals(Cuenta otro) {
		boolean res=false;
		
		if(this.saldo==otro.saldo) {
			res=true;
		}
		return res;
	}
	

}
