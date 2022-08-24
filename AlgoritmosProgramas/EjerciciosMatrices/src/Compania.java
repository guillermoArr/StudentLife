/*Guillermo Arredondo
 * 04/11/2020
 * Clase Compania para matrices y arreglos paralelos
 */
public class Compania {
	private String nombre;
	private double[][] ventas;
	private final String[] NOM_DEPTO= {"caballeros", "damas", "juguetes", "niños"};
	private final String[] NOM_MES= {"enero", "febrero", "marzo", "abril", "mayo", "junio", 
			"julio", "agosto", "septiem", "octubre", "noviem", "diciem"};
	private final int MESES=12;
	private final int DEPTOS=4;
	
	public Compania(String nombre) {
		this.nombre=nombre;
		this.ventas=new double[MESES][DEPTOS];
		for(int j=0; j<MESES; j++) {
			for(int i=0; i<DEPTOS; i++) {
				ventas[j][i]=0;
			}
		}
	}
	
	public String getNombre() {
		return nombre;
	}
	public double getUnaVenta(String depto, String mes) {
		double res=-1;
		int posMes, posDepto;
		
		posMes=ManejadorArreglosGenericos.buscaSecDesorden(NOM_MES, MESES, mes);
		posDepto=ManejadorArreglosGenericos.buscaSecDesorden(NOM_DEPTO, DEPTOS, depto);
		if(posMes>=0 && posDepto>=0) {
			res=ventas[posMes][posDepto];
		}
		return res;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getMesMayorVentaEn(String depto) {
		String res="Depto no encontrado";
		int col, pos;
		
		depto=depto.toLowerCase();
		col=ManejadorArreglosGenericos.buscaSecDesorden(NOM_DEPTO, DEPTOS, depto);
		if(col>=0) {
			pos=ManejadorMatrices.posMayorCol(ventas, col, MESES);
			res=NOM_MES[pos];
		}
		return res;
	}
	
	public boolean altaVenta(double monto, String depto, String mes) {
		boolean res=false;
		int ren, col;
		
		depto=depto.toLowerCase();
		mes=mes.toLowerCase();
		ren=ManejadorArreglosGenericos.buscaSecDesorden(NOM_MES, MESES, mes);
		col=ManejadorArreglosGenericos.buscaSecDesorden(NOM_DEPTO, DEPTOS, depto);
		if(ren>=0 && col>=0) {
			ventas[ren][col]=monto; // o mas igual si lo que consideramos es ir sumando
			res=true;
		}
		return res;
	}
	
	public double promVentasEnDepto(String depto) {
		double prom=-1;
		int col;
		
		depto=depto.toLowerCase();
		col=ManejadorArreglosGenericos.buscaSecDesorden(NOM_DEPTO, DEPTOS, depto);
		if(col>=0) {
			prom=(ManejadorMatrices.sumaCol(ventas, col, MESES)/MESES);
		}
		return prom;
	}
	
	public double promVentasEnMes(String mes) {
		double prom=-1;
		int ren;
		
		mes=mes.toLowerCase();
		ren=ManejadorArreglosGenericos.buscaSecDesorden(NOM_MES, MESES, mes);
		if(ren>=0) {
			prom=(ManejadorMatrices.sumaRen(ventas, ren, DEPTOS)/DEPTOS);
		}
		return prom;
	}
	
	public String mesNoVentas() {
		String res="Todos los meses tienen ventas";
		boolean existe=false;
		int j=0;
		int i;
		
		while(!existe && j<MESES) {
			i=0;
			while(i<DEPTOS && ventas[j][i]==0) {
				i++;
			}
			if(i==DEPTOS) {
				res=NOM_MES[j];
				existe=true;
			}
			j++;
		}
		return res;
	}
	
	public String toString() {
		StringBuilder cad=new StringBuilder();
		
		cad.append("\n Compania de nombre: "+nombre);
		cad.append("\nDEPTOS: ");
		for(int k=0; k<DEPTOS; k++) {
			cad.append("\t"+NOM_DEPTO[k]+"\t");
		}
		cad.append("\nMESES");
		for(int j=0; j<MESES; j++) {
			cad.append("\n"+NOM_MES[j]+"\t");
			for(int i=0; i<DEPTOS; i++) {
				cad.append("\t"+ventas[j][i]+"\t\t");
			}
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
