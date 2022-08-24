/* nov 2020
 * definición de una planta para sembrar en un huerto
 */
public class Planta {
	private int codigo;
	private static int generadorCodigo= 100;
	private String nombreComun;
	private String nombreCientifico;
	private int riegoSemanal;
	private String color;
	private boolean amarga;
	
	public Planta() {
		codigo=generadorCodigo;
		generadorCodigo++;
	}
	
	public Planta(int codigo){
		this.codigo=codigo;
	}

	public Planta(String nombreComun, String nombreCientifico, int riegoSemanal, String color, boolean amarga) {
		this();
		this.nombreComun = nombreComun;
		this.nombreCientifico = nombreCientifico;
		this.riegoSemanal = riegoSemanal;
		this.color = color;
		this.amarga = amarga;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNombreComun() {
		return nombreComun;
	}

	public String getNombreCientifico() {
		return nombreCientifico;
	}

	public int getRiegoSemanal() {
		return riegoSemanal;
	}

	public String getColor() {
		return color;
	}

	public boolean isAmarga() {
		return amarga;
	}

	public void setRiegoSemanal(int riegoSemanal) {
		this.riegoSemanal = riegoSemanal;
	}
	
	public int compareTo(Planta otra){
		return this.codigo-otra.codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planta other = (Planta) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	public String toString(){
		StringBuilder cad= new StringBuilder();
		
		cad.append("\nPlanta              con codigo: "+codigo);
		cad.append("\n                  nombre común: "+nombreComun);
		cad.append("\n             nombre cientifico: "+nombreCientifico);
		cad.append("\n num días de riego a la semana: "+riegoSemanal);
		cad.append("\n                         color: "+color);
		cad.append("\n                     es amarga: "+amarga);
		return cad.toString();
	}
}
