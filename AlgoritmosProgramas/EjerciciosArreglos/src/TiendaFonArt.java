
public class TiendaFonArt {
	private String nombre;
	private String direccion;
	private Artesania[] artesanias;
	private int cantArtesanias;
	private final int MAX_ARTESANIAS=150;
	
	public TiendaFonArt(String nombre, String direccion) {
		this.nombre=nombre;
		this.direccion=direccion;
		artesanias=new Artesania[MAX_ARTESANIAS];
		cantArtesanias=0;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public int getCantArtesanias() {
		return cantArtesanias;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public boolean altaArtesania(String tipoMat, String regOrig,int numElaboradores, int diasElab, boolean derechAutor) {
		boolean res=false;
		Artesania art;
		
		if(cantArtesanias<MAX_ARTESANIAS) {
			art=new Artesania(tipoMat, regOrig, numElaboradores, diasElab, derechAutor);
			this.artesanias[cantArtesanias]=art;
			cantArtesanias++;
			res=true;
		}
		
		return res;
	}
	public int artesaniaMasBarata() {
		int indiceMin=0;
		double precMin=artesanias[indiceMin].calculaPrecVenta();
		
		for(int i=1; i<cantArtesanias; i++) {
			if(precMin>artesanias[i].calculaPrecVenta()) {
				precMin=artesanias[i].calculaPrecVenta();
				indiceMin=i;
			}
		}
		return artesanias[indiceMin].getClveUnica();
	}
	public boolean artesaniaConDerechos() {
		boolean res=false;
		int i=0;
		
		while(i<cantArtesanias && !artesanias[i].isDerechAutor()) {
			i++;
		}
		if(i!=cantArtesanias) {
			res=true;
		}
		return res;
	}
	public double promElaboradores() {
		double prom=0;
		double tot=0;
		
		for(int i=0; i<cantArtesanias; i++) {
			tot+=artesanias[i].getNumElaboradores();
		}
		if(cantArtesanias!=0) {
			prom=tot/cantArtesanias;
		}
		return prom;
	}
	public String toString() {
		StringBuilder cad=new StringBuilder();
		
		cad.append("\n TiendaFonArt: "+nombre);
		cad.append("\n  de dreccion: "+direccion);
		cad.append("\n   cuenta con: "+cantArtesanias+" artesanias");
		for(int i=0; i<cantArtesanias; i++) {
			cad.append("\n"+artesanias[i].toString());
		}
		return cad.toString();
	}
}
