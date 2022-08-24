/*Guillermo Arredondo 
 * 19 de octubre 2020
 * Problema 2 Parte 2: Prueba de CLase Tienda Abarrotes
 */
public class PruebaTiendaAbarrotes {

	public static void main(String[] args) {
		TiendaAbarrotes t=new TiendaAbarrotes("La Tia");
		double res;
		
		if(t.altaProducto("jabon de baño", "dove", 75, "higiene", false)) {
			System.out.println("Alta exitosa");
		}
		else {
			System.out.println("E R R O R en alta");
		}
		if(t.altaProducto("platano", "oaxaca", 100, "frutas", true)) {
			System.out.println("Alta exitosa");
		}
		else {
			System.out.println("E R R O R en alta");
		}
		if(t.altaProducto("saborizante de agua", "tang", 50, "hidratacion", false)) {
			System.out.println("Alta exitosa");
		}
		else {
			System.out.println("E R R O R en alta");
		}
		
		if(t.existeProducto("higiene")) {
			System.out.println("Sí existe un producto en el depto de higiene");
		}
		else {
			System.out.println("No hay productos en el depto de higiene");
		}
	
		res=t.porcentajeProdConDescuentoCorreccion();
		System.out.println("Porcentaje de productos que tienen descuento: "+res+"%");

	}

}
