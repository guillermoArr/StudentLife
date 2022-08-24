/*Guillermo Arredondo
 * 19 de octubre 2020
 * Problema 2 clase Tienda de Abarrotes que utiliza Clase Producto
 */
public class TiendaAbarrotes {
	private String nombre;
	private Producto[] productos;
	private int totProductos;
	private final int MAX_PROD=100;
	
	public TiendaAbarrotes(String nombre) {
		this.nombre=nombre;
		totProductos=0;
		productos=new Producto[MAX_PROD];
	}
	
	public boolean altaProducto(String nombre, String marca, double precio, String depto, boolean conDescuento) {
		boolean res=false;
		Producto p;
		
		if(totProductos<MAX_PROD) {
			p=new Producto(nombre, marca, precio, depto, conDescuento);
			this.productos[totProductos]=p;
			totProductos++;
			res=true;
		}
		return res;
	}
	public boolean existeProducto(String depto) {
		boolean res=false;
		int i=0;
		
		while(i<totProductos && !productos[i].getDepto().equals(depto)) {
			i++;
		}
		if(i!=totProductos) {
			res=true;
		}
		return res;	
	}
	public double porcentajeProdConDescuento() {
		double res=0.0;
		double totDescuento=0;
		
		for(int i=0; i<totProductos; i++) {
			if(productos[i].isConDescuento()) {
				totDescuento++;
			}
		}
		if(totProductos!=0) {
			res=(totDescuento/totProductos)*100;
		}
		return res;  //Lourdes: mejor totDescuento que sea entero y la division hacerla cast a double : (double) totDescuent/totProductos*100
	}
	public double porcentajeProdConDescuentoCorreccion() {
		double res=0;
		int totDescuento=0;
		
		for(int i=0; i<totProductos; i++) {
			if(productos[i].isConDescuento()) {
				totDescuento++;
			}
		}
		if(totProductos!=0) {
			res=(double)totDescuento/totProductos*100;
		}
		return res;
	}

}
