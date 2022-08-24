import java.util.ArrayList;

/*Guillermo Arredondo
 * 2 de noviembre 2020
 * Tarea EXTRA OBLIGATORIA 4 de noviembre
 */ 
public class AnalizaCadena {
	
	public static String modificaCadena(String cadena, ArrayList<String> lista) {
		int i=0;
		String pal;
		
		while(i<lista.size()) {
			pal=lista.get(i);
			cadena=cadena.replaceFirst(pal, "");
			i++;
		}
		return cadena;
	}
	public static String modificaCadena2(String cadena, ArrayList<String> lista) {
		int indIn, i, indFin;
		
		i=0;
		while(i<lista.size()) {
			indIn=cadena.indexOf(lista.get(i));
			indFin=indIn+lista.get(i).length();
			if(indIn>=0) {
				cadena=cadena.substring(0, indIn)+cadena.substring(indFin);
			}
			i++;
		}
		
		return cadena;
	}

	public static void main(String[] args) {
		String cadena="valor es lo que se necesita para levantarse y hablar, pero también es lo que se requiere para sentarse y escuchar";
		ArrayList<String> lista=new ArrayList<String>();
		
		lista.add("hablar");
		lista.add("sentarse");
		lista.add("valor");
		lista.add("flores");
		System.out.println(cadena);
		System.out.println(lista.toString());
		System.out.println(modificaCadena2(cadena, lista));

	}

}
