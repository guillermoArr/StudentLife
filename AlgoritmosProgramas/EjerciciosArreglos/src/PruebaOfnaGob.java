/*Guillermo Arredondo
 *04 octubre 2020
 *Clase para probar la Oficina de Gobierno 
 */
public class PruebaOfnaGob {

	public static void main(String[] args) {
		OfnaGob ofna;
		
		ofna=new OfnaGob("Martin Cuenta");
		if(ofna.altaInfoEdos("CDMX", 20))
			System.out.println("Alta exitosa");
		else
			System.out.println("error en el alta");
		
		if(ofna.altaInfoEdos("Aguascalientes", 3))
			System.out.println("Alta exitosa");
		else
			System.out.println("error en el alta");
		
		if(ofna.altaInfoEdos("Hidalgo", 2.7))
			System.out.println("Alta exitosa");
		else
			System.out.println("error en el alta");
		
		if(ofna.altaInfoEdos("Nuevo Leon", 20))
			System.out.println("Alta exitosa");
		else
			System.out.println("error en el alta");
		
		System.out.println(ofna.toString());
		
		System.out.println("Edo de 2"+ofna.getUnNomEdo(2));
		System.out.println("Poblacion de 1"+ofna.getUnaPoblacion(1));
		System.out.println("Prom hab "+ofna.promHab());
		System.out.println("Estados mayor al prom "+ofna.totEdosPobMayorProm());
		System.out.println("Edo mayor pob "+ofna.nomEdoMayPob());
		

	}

}
