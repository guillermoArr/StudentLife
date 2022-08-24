/*Guillermo Arredondo
 * 18 sepriembre 2020
 * Examen Segundo Parcial tipo C3 Pregunta 3
 */
public class PruebaLaboratorio {

	public static void main(String[] args) {
		Laboratorio lab1,lab2;
		int numPruebas;
		
		lab1=new Laboratorio("Chopo", "BAJA", false, 100);
		lab2=new Laboratorio("Imagenus", "CDMX", true, 200);
		numPruebas=lab1.calculaPruebasCovid(1);
		System.out.println("El numero de prubeas que se pueden realizar es de: "+numPruebas); //no explicaste que significaba el -3
		if (numPruebas==-3) {
			System.out.println("Este laboratorio no esta destinado a pruebas de covid");
		}
		else if(numPruebas==350) {
			System.out.println("Su laboratorio se encuentra en Baja California, por favor considere laboratorios vecinos");
		}
		lab2.contrataNumTec(25);
		lab2.estatusNoCovid();
		
		System.out.println(lab1.toString());
		System.out.println(lab2.toString());

	}

}
