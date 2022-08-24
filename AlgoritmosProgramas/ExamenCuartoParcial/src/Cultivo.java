/* Guillermo Arredondo
 * 18 noviembre 2020
 * Clase Cultivo
 */
public class Cultivo {
	private String nombre;
	private int tamaño;
	private Planta[][] huerto;
	private final int MAX_REN=10;
	private final int MAX_COL=10;
	
	// se considera un planta con codigo=0 como un espacio vacio en el huerto
	public Cultivo(String nombre) {
		Planta p=new Planta(0);
		
		this.nombre=nombre;
		this.huerto=new Planta[MAX_REN][MAX_COL];
		for(int j=0; j<MAX_REN; j++) {
			for(int i=0; i<MAX_COL;i++) {
				huerto[j][i]=p;
			}
		}
		this.tamaño=MAX_REN*MAX_COL;
	}
	public Cultivo(String nombre, int renglones, int columnas) {
		Planta p=new Planta(0);
		
		this.nombre=nombre;
		this.huerto=new Planta[renglones][columnas];
		for(int j=0; j<renglones; j++) {
			for(int i=0; i<columnas;i++) {
				huerto[j][i]=p;
			}
		}
		this.tamaño=renglones*columnas;
	}
	
	public boolean siembraPlanta(String nombreComun, String nombreCientifico, int riegoSemanal, String color, boolean amarga, int ren, int col) {
		boolean res=false;
		Planta p=new Planta(0);
		
		if(ren>=0 && col>=0 && ren<huerto.length && col<huerto[0].length && huerto[ren][col].equals(p)) { // considerando que este metodo solo siembre nuevas
			p=new Planta(nombreComun, nombreCientifico, riegoSemanal, color, amarga); 					  // y si fuera sustituir se requeriría otro metodo
			huerto[ren][col]=p;
			res=true;
		}
		return res;	// considero que sea boolean por simplicidad, pero bien podria ser entero con una clave específica acorde al error encontrado
	}
	public boolean sonAmargas(int col) {
		boolean res=true;
		int j=0;
		
		while(j<huerto.length && huerto[j][col].isAmarga()) {
			j++;
		}
		if(j!=huerto.length) {
			res=false;
		}
		return res;
	}
	
	
}
