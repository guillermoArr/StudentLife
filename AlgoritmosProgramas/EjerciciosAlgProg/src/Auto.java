
public class Auto {
	private int clveUnica;
	private static int generadorClveUnica=1231;
	private String marca;
	private int aho;
	private double numKm;
	private String nombreClient;
	private int numLicClient;
	
	
	public Auto(String marca, int aho, double numKm) {
		clveUnica=generadorClveUnica;
		this.marca=marca;
		this.aho=aho;
		this.numKm=numKm;
		generadorClveUnica+=1001;
	}
	
	/*public void setNombreClient(String nombreClient) {
		this.nombreClient=nombreClient;
	}
	public void setNumLicClient(int numLicClient) {
		this.numLicClient=numLicClient;
	}*/
	public int getClveUnica() {
		return clveUnica;
	}
	public String getMarca() {
		return marca;
	}
	public int getAho() {
		return aho;
	}
	public double getNumKm() {
		return numKm;
	}
	public String getNombreClient() {
		return nombreClient;
	}
	public int getNumLicClient() {
		return numLicClient;
	}
	
	public double renta(String nombreClient, int numLicClient, int diasRent) {
		this.nombreClient=nombreClient;
		this.numLicClient=numLicClient;
		double prec;
		
		if(aho<2005 && numKm<20000) {
			prec=220;
		}
		else if(aho<2005 && numKm>20000) {
			prec=200;
		}
		else if(aho>=2005 && numKm<20000) {
			prec=320;
		}
		else {
			prec=300;
		}
		return prec*diasRent;
	}
	public void devolucion(double numKm) {
		this.nombreClient=" ";
		this.numLicClient=0;
		if (numKm>0) {
			this.numKm+=numKm;
		}
		else {
			this.numKm=numKm;
		}
	}
	
	public String toString() {
		StringBuilder cad=new StringBuilder();
		
		cad.append("\nAuto de clave unica: "+clveUnica);
		cad.append("\n           de marca: "+marca);
		cad.append("\n            de anio: "+aho);
		cad.append("\n    con kilometraje: "+numKm);
		cad.append("\n rentado al cliente: "+nombreClient);
		cad.append("\n       con licencia: "+numLicClient);
		return cad.toString();
	}
	
	public int compareTo(Auto otro) {
		int res;
		
		if(this.clveUnica<otro.clveUnica) {
			res=-1;
		}
		else if(this.clveUnica==otro.clveUnica) {
			res=0;
		}
		else {
			res=1;
		}
		return res;
	}
	
	public boolean equals(Auto otro) {
		boolean res;
		
		if(this.clveUnica==otro.clveUnica) {
			res=true;
		} 
		else {
			res=false;
		}
		return res;
	}
	
	
}
