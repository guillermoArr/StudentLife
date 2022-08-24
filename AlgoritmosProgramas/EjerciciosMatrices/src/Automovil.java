/*Guillermo Arredondo
 * 11 de noviembre 2020
 * Clase Auto para la clase Estacionamiento -> ejercicio 8
 */
public class Automovil implements Comparable<Automovil> {
	private String marca;
	private int anio;
	private String modelo;
	private String placa;
	private String tipo;
	private String[] fechas;
	private String[] servicios;
	private int numServicios;
	private final int MAX_SERVICIOS=15;
	private Persona duenio;
	private int hora;
	
	public Automovil(String placa) {
		this.placa=placa;
	}
	public Automovil(String placa, String marca, String modelo, int anio, String tipo) {
		this.anio=anio;
		this.marca=marca;
		this.modelo=modelo;
		this.tipo=tipo;
		this.placa=placa;
		
		this.servicios=new String[MAX_SERVICIOS];
		this.numServicios=0;
		this.fechas=new String[MAX_SERVICIOS];
	}
	public Automovil(String placa, String marca, String modelo, int anio, String tipo, int hora) {
		this.anio=anio;
		this.marca=marca;
		this.modelo=modelo;
		this.tipo=tipo;
		this.placa=placa;
		this.hora=hora;
		this.duenio=new Persona("vacio");
		
		this.servicios=new String[MAX_SERVICIOS];
		this.numServicios=0;
		this.fechas=new String[MAX_SERVICIOS];
	}
	public String getMarca() {
		return marca;
	}
	public int getAnio() {
		return anio;
	}
	public String getModelo() {
		return modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public String getTipo() {
		return tipo;
	}
	public int getNumServicios() {
		return numServicios;
	}
	
	public Persona getDuenio() {
		return duenio;
	}
	public int getHora() {
		return hora;
	}
	public String getUnServicio(String mes) {
		String res="No hay servicios en ese mes";
		int pos=ManejadorArreglosGenericos.buscaSecDesorden(fechas, numServicios, mes);
		
		if(pos>=0) {
			res=servicios[pos];
		}
		return res;
	}
	public String getFechaServicio(String servicio) {
		String res="Servicio no efectuado";
		int pos=ManejadorArreglosGenericos.buscaSecDesorden(servicios, numServicios, servicio);
		
		if(pos>=0) {
			res=fechas[pos];
		}
		return res;
	}
	public boolean setDuenio(String nombre, String curp, String edoCivil) {
		boolean res=false;
		Persona aux=new Persona("vacio");
		
		if(duenio.equals(aux)) {
			this.duenio=new Persona(nombre, curp, edoCivil);
			res=true;
		}
		return res;
	}
	public boolean altaServicio(String servicio, String mes) {
		boolean res=false;
		
		if(numServicios<MAX_SERVICIOS) {
			servicios[numServicios]=servicio;
			fechas[numServicios]=mes;
			numServicios++;
			res=true;
		}
		return res;
	}
	
	public boolean conServicio(String servicio) {
		boolean res=false;
		int pos;
		
		servicio=servicio.toLowerCase();
		pos=ManejadorArreglosGenericos.buscaSecDesorden(servicios, numServicios, servicio);
		if(pos>=0) {
			res=true;
		}
		return res;
	}
	public String toString() {
		StringBuilder cad=new StringBuilder();
		
		cad.append("\nAuto de placa: "+placa);
		cad.append("\n        marca: "+marca);
		cad.append("\n       modelo: "+modelo);
		cad.append("\n         anio: "+anio);
		cad.append("\n         tipo: "+tipo);
		cad.append("\ningreso a las: "+hora+" horas");
		cad.append("\n  pertenece a: "+duenio);
		cad.append("\ncuenta con los siguientes servicios suministrados: ");
		for(int i=0; i<numServicios; i++) {
			cad.append("\n"+servicios[i]);
			cad.append("\taplicado en "+fechas[i]);
		}
		return cad.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
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
		Automovil other = (Automovil) obj;
		if (placa == null) {
			if (other.placa != null) {
				return false;
			}
		} else if (!placa.equals(other.placa)) {
			return false;
		}
		return true;
	}
	public int compareTo(Automovil otro) {
		return this.placa.compareTo(otro.placa);
	}

}
