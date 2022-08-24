import java.util.Scanner;
/*Guillermo Arredondo
 * 17 septiembre 2020
 * Examen enero 2020 main
 */
public class PruebaArtesania {

	public static void main(String[] args) {
		Artesania art1, art2;
		Scanner lec;
		double prec;
		
		lec=new Scanner(System.in);
		
		art1=new Artesania("ceramica", "Oaxaca", 21, true);
		art2=new Artesania("tela", "Veracruz", 9, false);
		System.out.println(art1.toString());
		System.out.println(art2.toString());
		
		prec=art1.calculaPrecVenta();
		System.out.println("El precio de la artesania: "+art1.getClveUnica()+" es de: $"+prec);
		if(art1.equals(art2)) {
			System.out.println("La artesania uno es igual a la artesania 2");
		}
		else {
			System.out.println("La artesania uno es diferente a la artesania 2");
		}
		art1.setRegOrig("Xochimilco");
		System.out.println(art1.toString());
		

	}

}
