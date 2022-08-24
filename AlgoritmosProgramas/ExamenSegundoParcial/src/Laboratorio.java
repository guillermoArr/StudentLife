/*Guillermo Arredondo
 * 18 de septiembre 2020
 * Examen Segundo Parcial tipo C3 Pregunta 2
 */
public class Laboratorio {
	private String nombre;
	private String edoServ;
	private int idUnico;
	private static int generadorIdUnico=3000;
	private boolean acredCovid;
	private int numTecnic;
	
	public Laboratorio(String nombre, String edoServ, boolean acredCovid, int numTecnic) {
		this.nombre=nombre;
		this.edoServ=edoServ;
		this.acredCovid=acredCovid;
		this.numTecnic=numTecnic;
		
		idUnico=generadorIdUnico;
		generadorIdUnico+=7;
	}
	public String getNombre() {
		return nombre;
	}
	//todos los get sin problema alguno
	
		
	public int calculaPruebasCovid(int mes) {
		int pruebas=-3;
		
		if(this.edoServ.equals("BAJA")) {
			pruebas=350;
		}
		else {
			if(this.acredCovid) {
				switch(mes) {
					case 3: 
					case 4: 
					case 5: pruebas=this.numTecnic*30;
						break;
					case 6: 
					case 7: pruebas=this.numTecnic*20;
						break;
					case 8: pruebas=this.numTecnic*10;
						break;
					case 9: 
					case 10: pruebas=this.numTecnic*5;
						break;	
				}
			}
		}
		return pruebas;
	}
	public void contrataNumTec(int newTecnic) {
		this.numTecnic+=newTecnic;
	}
	public void estatusNoCovid() {
		this.acredCovid=false;
	}
	public String toString() {
		StringBuilder cad=new StringBuilder();
		
		cad.append("\nLaboratorio de ID Unico: "+idUnico);
		cad.append("\n              de nombre: "+nombre);
		cad.append("\n        con servicio en: "+edoServ);
		cad.append("\n         pruebas COVID?: "+acredCovid);
		cad.append("\n     numero de tecnicos: "+numTecnic);
		return cad.toString();
	}
	public int compareTo(Laboratorio otro) {
		int res;
		
		if(this.idUnico==otro.idUnico) {
			res=0;
		}
		else if(this.idUnico<otro.idUnico){
			res=-1;
		}
		else {
			res=1;
		}
		return res;
	}
	public boolean equals(Laboratorio otro) {
		boolean res=false;
		
		if(this.idUnico==otro.idUnico) {
			res=true;
		}
		return res;
	}
}
