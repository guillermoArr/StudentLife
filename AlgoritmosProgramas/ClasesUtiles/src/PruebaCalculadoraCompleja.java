import java.util.Scanner;

/*Guillermo Arredondo
 * 24 septiembre 2020
 * Prueba de clase Calculadora Compleja
 */
public class PruebaCalculadoraCompleja {

	public static void main(String[] args) {
		double ptR, ptI;
		String str;
		char operador;
		Complejo num1, num2, res;
		StringBuilder cad=new StringBuilder();
		Scanner lec;
		
		lec=new Scanner(System.in);
		System.out.println("Bienvenid@ a su Calculadora Cientifica/Compleja");
		cad.append("\nPor favor ingrese el caracter correspondiente para alguna de las siguientes operaciones:");
		cad.append("\n  +  (suma)");
		cad.append("\n  -  (resta)");
		cad.append("\n  *  (multiplicacion)");
		cad.append("\n  /  (division)");
		cad.append("\n 's'  para salir");
		System.out.println(cad.toString());
		str=lec.next();
		operador=str.charAt(0);
		while(operador!='s') {
			
			System.out.println("Por favor ingrese los dos terminos del primer numero");
			ptR=lec.nextDouble();
			ptI=lec.nextDouble();
			num1=new Complejo(ptR, ptI);
			System.out.println("Por favor ingrese los dos terminos del segundo numero");
			ptR=lec.nextDouble();
			ptI=lec.nextDouble();
			num2=new Complejo(ptR, ptI);
			
			res=null;
			switch(operador) {
			case '+': res=CalculadoraCompleja.sumaComplejo(num1, num2);
				break;
			case '-': res=CalculadoraCompleja.restaComplejo(num1, num2);
				break;
			case '*': res=CalculadoraCompleja.multiplicacionComplejo(num1, num2);
				break;
			case '/': res=CalculadoraCompleja.divisionComplejo(num1, num2);
				break;
			default: System.out.println("Selecciona operacion valida");
				break;
			}
			if(res!=null) {
				System.out.println(num1.toString());
				System.out.println(num2.toString());
				System.out.println(res.toString());
			}
			else {
				System.out.println("Resultado no valido");
			}
			
			System.out.println(cad.toString());
			str=lec.next();
			operador=str.charAt(0);
		}
		System.out.println("Hasta luego");
	}

}
