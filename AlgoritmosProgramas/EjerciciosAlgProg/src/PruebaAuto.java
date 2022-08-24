import java.util.Scanner;
public class PruebaAuto {

	public static void main(String[] args) {
		Auto a1, a2, a3, a4, a5;
		double prec1, prec2;
		String cliente1, cliente2;
		int numLicClient1, numLicClient2;
		int dias1, dias2;
		double numKm;
		Scanner lec;
		
		lec=new Scanner(System.in);
		a1=new Auto("VolksWagen", 2005, 40000);
		a2=new Auto("Nissan", 2017, 20000);
		a3=new Auto("Mazda", 2010, 35000);
		a4=new Auto("Chevrolet", 2004, 40000);
		a5=new Auto("Ford", 2015, 19999);
		
		System.out.println(a1.toString());
		System.out.println(a2.toString());
		System.out.println(a3.toString());
		System.out.println(a4.toString());
		System.out.println(a5.toString());
		
		System.out.println("\nDame nombre de cliente, numero de licencia y numero de dias de renta");
		cliente1=lec.nextLine();
		numLicClient1=lec.nextInt();
		dias1=lec.nextInt();
		prec1=a1.renta(cliente1, numLicClient1, dias1);
		System.out.println("\nEl precio de renta del"+a1.toString()+"\npor "+dias1+" dias"+"\nes de: $"+prec1);
		
		System.out.println("\nDame nombre de cliente, numero de licencia y numero de dias de renta");
		lec.nextLine();
		cliente2=lec.nextLine();
		numLicClient2=lec.nextInt();
		dias2=lec.nextInt();
		prec2=a5.renta(cliente2, numLicClient2, dias2);
		System.out.println("\nEl precio de renta del"+a2.toString()+"\npor "+dias2+" dias"+"\nes de: $"+prec2);
		
		System.out.println("Dame numero de kilometros recorridos en la renta");
		numKm=lec.nextDouble();
		a1.devolucion(numKm);
		System.out.println(a1.toString());
		lec.close();

	}

}
