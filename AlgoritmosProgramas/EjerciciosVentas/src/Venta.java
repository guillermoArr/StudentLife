/* Guillermo Arredondo
 * 8 septiembre 2020
 * Clase venta ejercicio 17 pag 29
 */
public class Venta {
	private double monto;
	private String vendedor;
	
	public Venta() {
	}
	public Venta(double monto, String vendedor) {
		this.monto=monto;
		this.vendedor=vendedor;
	}
	
	public void setMonto(double monto) {
		this.monto=monto;
	}
	public void setVendedor(String vendedor) {
		this.vendedor=vendedor;
	}
	
	public double getMonto() {
		return monto;
	}
	public String getVendedor() {
		return vendedor;
	}
	
	public double calculaComision() {
		double com;
		
		if(monto<1000) {
			com=monto*0.03;
		}else {
			com=monto*0.05;
		}
		return com;
	}
	
	public String toString() {
		StringBuilder cad=new StringBuilder();
		
		cad.append("\nVenta de monto: "+monto);
		cad.append("\npor el vendedor: "+vendedor);
		return cad.toString();
	}
	
	public int compareTo(Venta otro) {
		int res;
		
		if(this.monto<otro.monto) {
			res=-1;
		}else {
			res=1;
		}
		return res;
	}
	
	public boolean equals(Venta otro) {
		boolean res;
		
		if(this.monto==otro.monto) {
			res=true;
		} else {
			res=false;
		}
		return res;
	}

}
