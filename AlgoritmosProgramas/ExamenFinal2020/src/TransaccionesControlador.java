import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*Guillermo Arredondo Renero
 * 8 de diciembre de 2020
 * Problema 1 Examen Final 2020 Clase Controlador
 */
public class TransaccionesControlador extends TransaccionesVista{

	public TransaccionesControlador(String titulo) {
		super(titulo);
		
		aceptarBt.addActionListener(new EscuchadorBotones());
	}
	private class EscuchadorBotones implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String entrada1, lectura, aux, salida;
			int clave, claveAux, contador; 	
			//por la longitud de los archivos en la vida real seria una buena decision que contador fuera de tipo long
			File entrada=new File("transaccionesBancos.txt");
			/*switch dentro del try 
			entrada1=nombreTxtF.getText();
			
			switch(entrada1.charAt(3)) {
				case 'A': clave=12;
					break;
				case 'a': clave=2;
					break;
				case 't': clave=14;
					break;
				default: clave=0;
					break;
			} */
		
			try(Scanner lec=new Scanner(entrada)){
				contador=0;
				entrada1=nombreTxtF.getText();
				
				switch(entrada1.charAt(3)) {
					case 'A': clave=12;
						break;
					case 'a': clave=2;
						break;
					case 't': clave=14;
						break;
					default: clave=0;
						break;
				}
				while(lec.hasNext()) {
					lectura=lec.next();
					aux=lectura.substring(9, 12);
					claveAux=Integer.parseInt(aux);
					aux=lectura.substring(42, 45);
					//podria convertirse aux a entero 
					if(claveAux==clave && aux.equals("001")) {
						contador++;
					}
				}
				lec.close();
				salida=Integer.toString(contador);
				cantMovTxtF.setText(salida);
			}
			catch(FileNotFoundException fnfe) {
				System.err.println("E R R O R "+fnfe);
				System.exit(-1);
			}
			
			
		}
		
	}
	public static void main(String[] args) {
		TransaccionesControlador yo=new TransaccionesControlador("ESTADÍSTICAS TRANSACCIONES BANCARIAS:..");
		
	}

}
