import java.util.ArrayList;

/*Guillermo Arredondo
 * 4 de octubre 2020
 * Clase Compania, ejercicio 5 pag 44
 */
public class Compania {
	private String nombre;
	private String direccion;
	private String ciudad;
	private String director;
	private double[] ventas;
	private final String[] NOM_MES= {"enero", "febrero", "marzo", "abril", "mayo", "junio", 
			"julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
	private int totalVentas;
	private final int TOTAL_MESES=12;
	
	public Compania() {
		ventas=new double[TOTAL_MESES];
		totalVentas=0;
	}
	public Compania(String nombre, String direccion, String ciudad, String director) { // añades int tam
		this(); // quitas este y repites el totalVentas=0 y añades 
		this.nombre=nombre;		//ventas=new double[tam]
		this.direccion=direccion;
		this.ciudad=ciudad;
		this.director=director;
	}
	public Compania(String nombre, String direccion, String ciudad, String director, int tam) {
		ventas=new double[tam];
		totalVentas=0;
		this.nombre=nombre;		
		this.direccion=direccion;
		this.ciudad=ciudad;
		this.director=director;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public String getDirector() {
		return director;
	}
	public int getTotalVentas() {
		return totalVentas;
	}
	public double getUnaVenta(int mes) {
		double venta=-1;
		
		if(mes>=1 && mes<=totalVentas) {
			venta=ventas[mes-1]; //nadie asume que hay un mes 0 
		}
		return venta;
	}
	public String getUnMes(int mes) {
		String nomMes="Mes no valido";
		
		if(mes>=1 && mes<=ventas.length) {
			nomMes=NOM_MES[mes-1];
		}
		return nomMes;
	}
	public void setUnaVenta(int indice, double venta){
		if(indice<totalVentas) {
			 ventas[indice]=venta;
		 }
	}
	 
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
	public boolean altaInfoVenta(double venta) {
		boolean exito=false;
		
		if(this.totalVentas<ventas.length) { //<ventas.length -> esto solo se podría si se crea el parametro tam en constructor
			this.ventas[totalVentas]=venta;
			totalVentas++;
			exito=true;
		}
		return exito;
	}
	public String mesMayor() {
		int max;
		
		max=ManejadorArreglos.posMayor(ventas, totalVentas);
		return NOM_MES[max];
	}
	public String mesMenor() {
		int min;
		
		min=ManejadorArreglos.posMenor(ventas, totalVentas);
		return NOM_MES[min];
	}
	public double promAnual() {
		double prom;
		
		prom=ManejadorArreglos.promArreglos(ventas, totalVentas);
		return prom;
	}
	
	public int mesesArribaProm() {
		double prom;
		int tot;
		
		prom=ManejadorArreglos.promArreglos(ventas, totalVentas);
		tot=ManejadorArreglos.cuantosMayorX(ventas, totalVentas, prom); 
		return tot;
	}
	public String cualesMesesMayProm() {
		StringBuilder cad=new StringBuilder();
		ArrayList<Integer> lista;
		double prom;
		int indice;
		
		prom=ManejadorArreglos.promArreglos(ventas, totalVentas);
		lista=ManejadorArreglos.cualesMayX(ventas, totalVentas, prom);
		for(int i=0; i<lista.size(); i++) {
			indice=lista.get(i);
			cad.append("\n"+NOM_MES[indice]);
		}
		return cad.toString();
	}
	
	public String toString() {
		StringBuilder cad=new StringBuilder();
		
		cad.append("\n   Compania de nombre: "+nombre);
		cad.append("\n           ubicada en: "+direccion);
		cad.append("\n      en la ciudad de: "+ciudad);
		cad.append("\n bajo la direccion de: "+director);
		cad.append("\ntotal de ventas registradas: "+totalVentas);
		for(int i=0; i<totalVentas; i++) {
			cad.append("\n      durante el mes de: "+NOM_MES[i]);
			cad.append("\n   el monto de venta es: "+ventas[i]);
		}
		return cad.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Compania other = (Compania) obj;
		if (nombre == null) {
			if (other.nombre != null) {
				return false;
			}
		} else if (!nombre.equals(other.nombre)) {
			return false;
		}
		return true;
	}
	public int compareTo(Compania otro) {
		return this.nombre.compareTo(otro.nombre);
	}
		
}
