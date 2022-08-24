/*Guillermo Arredondo
 * 
 */
public class Tarjeta {
	private int numTarjeta;
	private String tipo;
	private int categoria;
	private int numCuenta;
	private int ahoAdq;
	private int ahoVenc;
	private int numSecreto;
	private int limitCred;
	private double saldo;
	
	public Tarjeta(int numTarjeta, int numCuenta, String tipo, int categoria) {
		this.numTarjeta=numTarjeta;
		this.numCuenta=numCuenta;
		this.tipo=tipo;
		this.categoria=categoria;
		
		ahoAdq=2020;
		ahoVenc=ahoAdq+5;
		switch(categoria) {
			case 0: 
				limitCred=20000;
			break;
			case 1: 
				limitCred=30000;
			break;
			case 2: 
				limitCred=50000;
		}
	}
}
