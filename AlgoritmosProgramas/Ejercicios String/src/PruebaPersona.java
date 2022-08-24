/*Guillermo Arredondo
 * 25 octubre 2020
 * Prueba de clase persona
 */
public class PruebaPersona {

	public static void main(String[] args) {
		Persona p1;
		
		p1=new Persona("Georgina", "RERG700112MDF", "casada");
		System.out.println(p1.getGenero());
		System.out.println(p1.getAhoNac());
		System.out.println(p1.calculaEdad(2020));
		if(p1.altaVacuna("influenza", "28 octubre")) {
			System.out.println("Alta de vacuna exitosa");
		}
		else {
			System.out.println("E R R O R en alta de vacuna");
		}
		if(p1.altaVacuna("Hepatitis B", "10 enero")) {
			System.out.println("Alta de vacuna exitosa");
		}
		else {
			System.out.println("E R R O R en alta de vacuna");
		}
		if(p1.altaVacuna("Sarampion", "13 Julio")) {
			System.out.println("Alta de vacuna exitosa");
		}
		else {
			System.out.println("E R R O R en alta de vacuna");
		}
		System.out.println(p1.getFechaDeVacuna("Sarampion"));
		System.out.println(p1.getVacunaEnFecha("28 octubre"));
		System.out.println(p1.vacunaAplicada("Hepatitis B"));
		System.out.println(p1.toString());
		

	}

}
