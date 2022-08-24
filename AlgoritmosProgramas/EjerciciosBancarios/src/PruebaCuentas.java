import java.util.Scanner;
/*Guillermo Arredondo 
 * 10 de septiembre 2020
 * Prueba de dos clases cuenta con retiros y depósitos
 */
public class PruebaCuentas {

	public static void main(String[] args) {
		Cuenta cta1, cta2;
		int numCuenta;
		String nomTitular;
		double saldo, cantRecibida;
		Scanner lec;
		
		lec=new Scanner(System.in);
		System.out.println("Nombre del titular de la cuenta");
		nomTitular=lec.nextLine();
		System.out.println("Dame el saldo con el que abrirá la cuenta");
		saldo=lec.nextDouble();
		System.out.println("Ingrese el número de cuenta de acuerdo a parámetros establecidos por banco");
		numCuenta=lec.nextInt();
		
		cta1=new Cuenta(numCuenta, nomTitular, saldo);
		System.out.println(cta1.toString());
		System.out.println("¿Cuanto desea retirar?");
		cantRecibida=lec.nextDouble();
		System.out.println("El nuevo saldo es de: "+cta1.retiro(cantRecibida));
		
		lec=new Scanner(System.in); //no sé porque pero sin meter esta nueva instanciación el programa se saltaba lectura siguiente
		cta2=new Cuenta();
		System.out.println("\nNombre del titular de la cuenta");
		nomTitular=lec.nextLine();
		cta2.setNomTitular(nomTitular);
		System.out.println("\nDime el numero de cuenta");
		numCuenta=lec.nextInt();
		cta2.setNumCuenta(numCuenta);
		System.out.println("La cuenta 2 es:"+cta2.toString());
		System.out.println("Dame una cantidad a depositar");
		cantRecibida=lec.nextDouble();
		cta2.deposito(cantRecibida);
		System.out.println("Cuenta 1: "+cta1.toString()+"\nCuenta 2: "+cta2.toString());
	
	}

}
