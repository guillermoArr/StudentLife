/*Guillermo Arredondo
 * 5 de octubre de 2020
 * Clase ejercicio 9 pag 46
 */
public class InstitucionNatacion {
	private String nombre;
	private String domicilio;
	private int totalAlbercas;
	private Rectangulo[] tamAlbercas;
	private final int MAX_ALBERCAS=10;
	
	public InstitucionNatacion(){
		tamAlbercas=new Rectangulo[MAX_ALBERCAS];
		totalAlbercas=0;
	}
	public InstitucionNatacion(String nombre, String domicilio) {
		this();
		this.nombre=nombre;
		this.domicilio=domicilio;
	}
	public InstitucionNatacion(String nombre, String domicilio, int numAlbercas) {
		tamAlbercas=new Rectangulo[numAlbercas];
		totalAlbercas=0;
		this.nombre=nombre;
		this.domicilio=domicilio;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public int getTotalAlbercas() {
		return totalAlbercas;
	}
	public String getUnaAlberca(int num) {
		String res;
		
		if(num>=1 && num<=totalAlbercas) {
			res=tamAlbercas[num-1].toString(); //considerando que no haya alberca 0
		}
		else {
			res="Alberca no registrada";
		}
		return res;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public void setUnaAlberca(int num, double ancho, double largo) {
		Rectangulo alberca;
		
		if(num<=totalAlbercas) {
			alberca=new Rectangulo(ancho, largo);
			tamAlbercas[num-1]=alberca;
		}
	}
	public boolean altaAlberca(double ancho, double largo) {
		boolean res=false;
		Rectangulo alberca;
		
		if(totalAlbercas<tamAlbercas.length) {
			alberca=new Rectangulo(ancho, largo);
			this.tamAlbercas[totalAlbercas]=alberca;
			res=true;
			totalAlbercas++;
		}
		return res;
	}
	public double calculaAreaTotAlbercas() {
		double areaTot=0;
		
		for(int i=0; i<tamAlbercas.length; i++) {
			areaTot+=tamAlbercas[i].calculaArea();
		}
		return areaTot;
	}
	public String toString() {
		StringBuilder cad=new StringBuilder();
		
		cad.append("\n             Institucion de Natacion "+nombre);
		cad.append("\n                         ubicada en: "+domicilio);
		cad.append("\n cuenta con un total de "+totalAlbercas+" albercas");
		for(int i=0; i<totalAlbercas; i++) {
			cad.append("\n Alberca "+(i+1)+" de forma: ");
			cad.append(tamAlbercas[i].toString());
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
		InstitucionNatacion other = (InstitucionNatacion) obj;
		if (nombre == null) {
			if (other.nombre != null) {
				return false;
			}
		} else if (!nombre.equals(other.nombre)) {
			return false;
		}
		return true;
	}
	public int compareTo(InstitucionNatacion otro) {
		return this.nombre.compareTo(otro.nombre);
	}
	
}
