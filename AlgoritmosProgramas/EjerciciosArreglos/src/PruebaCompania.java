import java.util.Scanner;
/*Guillermo Arredondo
 * de octubre 2020
 * Prueba de Compania ej. 5 pag 44 
 */
public class PruebaCompania {

	public static void main(String[] args) {
		Compania cpn;
		Scanner lec=new Scanner(System.in);
		double venta;
		int n;
		
		cpn=new Compania("Empaques S.A. de C.V.", "Av. Constitucion 34", "Queretaro", "Sr. Perez");
		System.out.println("Dime numero de meses con ventas");
		n=lec.nextInt();
		for(int i=1; i<=n; i++) {
			System.out.println("Dame la venta del mes de "+cpn.getUnMes(i));
			venta=lec.nextDouble();
			if(cpn.altaInfoVenta(venta)) {
				System.out.println("Registro exitoso");
			}
			else {
				System.out.println("error en el registro");
			}
		}	
		System.out.println(cpn.toString());
		System.out.println("Mes con mayor venta: "+cpn.mesMayor());
		System.out.println("Mes con menor venta: "+cpn.mesMenor());
		System.out.println("Promedio de ventas: "+cpn.promAnual());
		System.out.println("Num meses arriba del promedio: "+cpn.mesesArribaProm());
		System.out.println("Meses mayores al promedio: "+cpn.cualesMesesMayProm());

	}

}
