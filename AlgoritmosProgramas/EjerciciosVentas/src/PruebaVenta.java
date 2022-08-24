/* Guillermo Arredondo 
 * 8 septiembre 2020
 * Prueba de la clase venta ejercicio 17 pag 29
 */
public class PruebaVenta {

	public static void main(String[] args) {
		double monto;
		String vendedor;
		Venta v1, v2;
		//int res;
		
		v1=new Venta();
		v1.setMonto(850.00);
		v1.setVendedor("Guillermo");
		v2=new Venta();
		v2.setMonto(2350.00);
		v2.setVendedor("Georgina");
		
		System.out.println("La comisión del vendedor "+v1.getVendedor()+" es: $"+v1.calculaComision()+" por el monto de: $"+v1.getMonto());
		System.out.println("La comisión del vendedor "+v2.getVendedor()+" es: $"+v2.calculaComision()+" por el monto de: $"+v2.getMonto());
		
		/*res=v1.compareTo(v2);
		System.out.println(res);*/
	}

}
