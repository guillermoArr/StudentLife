import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AlergiaControlador extends AlergiaVista{
	
	public AlergiaControlador(String titulo) {
		super(titulo);
		
		super.buscarBt.addActionListener(new EscuchadorBotones());
	}
	
	public class EscuchadorBotones implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			String entrada1, entrada2, entrada3;
			double aux;
			StringBuilder cad;
			int clave;
			double prec;
			String descripcion;
			File entrada;
			
			entrada1=alergiaTxtF.getText();
			entrada2=precioTxtF.getText();
			entrada3=archivoTxtF.getText();
			
			entrada=new File(entrada3);
			
			try(Scanner lec=new Scanner (entrada)){
				aux=Double.parseDouble(entrada2);
				cad=new StringBuilder();
				cad.append("Lista de alimentos que no llevan "+entrada1);
				while(lec.hasNext()) {
					clave=lec.nextInt();
					prec=lec.nextDouble();
					descripcion=lec.nextLine();
					if(prec<aux && descripcion.contains(entrada1)) {
						cad.append("\n"+clave);
						cad.append("- ");
						cad.append(descripcion);
					}
				}
				listaTxtA.setText(cad.toString());
			}
			catch(FileNotFoundException fnfe) {
				listaTxtA.setText("Por favor ingrese información correcta");
				System.err.println("E R R O R "+fnfe);
				System.exit(-1);
			}
		}
		
	}
	public static void main(String[] args) {
		AlergiaControlador yo=new AlergiaControlador("Espero que funcione:....");

	}

}
