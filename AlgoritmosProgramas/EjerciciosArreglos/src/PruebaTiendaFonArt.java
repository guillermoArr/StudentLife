
public class PruebaTiendaFonArt {

	public static void main(String[] args) {
		TiendaFonArt t=new TiendaFonArt("Artesanias y Manias", "Cerca ITAM");
		
		if(t.altaArtesania("madera", "Oaxaca", 4, 5, false)) {
			System.out.println("Alta exitosa");
		}
		else {
			System.err.println("E R R O R en alta");
		}
		if(t.altaArtesania("ceramica", "Edo Mex", 6, 8, false)) {
			System.out.println("Alta exitosa");
		}
		else {
			System.err.println("E R R O R en alta");
		}
		if(t.altaArtesania("jade", "Chiapas", 8, 10, true)) {
			System.out.println("Alta exitosa");
		}
		else {
			System.err.println("E R R O R en alta");
		}
		System.out.println(t.toString());
		System.out.println("\n Artesania mas barata: (clave unica) "+t.artesaniaMasBarata());
		if(t.artesaniaConDerechos()) {
			System.out.println("Hay al menos una artesania con derechos de autor");
		}
		else {
			System.err.println("No hay ninguna artesania con derechos de autor");
		}
		System.out.println("El promedio de trabajadores es de: "+t.promElaboradores());
		

	}

}
