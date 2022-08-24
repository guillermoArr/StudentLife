import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*Guillermo Arredondo
 * 24 noviembre 2020
 * Controlador de clase CalculadoraVista con interaccion real
 */
public class CalculadoraControlador extends CalculadoraVista{
	private long primNum;
	private long segNum;
	private char operador;
	
	public CalculadoraControlador(String titulo) {
		super(titulo);
		this.operador=' ';
		num1.addActionListener(new EscuchadorNum());
		num2.addActionListener(new EscuchadorNum());	
		num3.addActionListener(new EscuchadorNum());
		num4.addActionListener(new EscuchadorNum());
		num5.addActionListener(new EscuchadorNum());
		num6.addActionListener(new EscuchadorNum());
		num7.addActionListener(new EscuchadorNum());
		num8.addActionListener(new EscuchadorNum());
		num9.addActionListener(new EscuchadorNum());
		num0.addActionListener(new EscuchadorNum());
		
		suma.addActionListener(new EscuchadorOperador());
		resta.addActionListener(new EscuchadorOperador());
		mult.addActionListener(new EscuchadorOperador());
		div.addActionListener(new EscuchadorOperador());
		
		igual.addActionListener(new EscuchadorIgual());
	}
	private class EscuchadorNum implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String cifra, primNumStr, segNumStr;
			
			if(operador==' ') {
				cifra=primNum+e.getActionCommand();
				primNum=Long.parseLong(cifra);
				primNumStr=Long.toString(primNum);
				pantalla.setText(primNumStr);
				
			}
			else {
				cifra=segNum+e.getActionCommand();
				segNum=Long.parseLong(cifra);
				segNumStr=Long.toString(segNum);
				pantalla.setText(segNumStr);
			}
		}
		
	}
	private class EscuchadorOperador implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			if(primNum==0) {
				primNum=Long.parseLong(pantalla.getText());	
			}
			// en caso de querer hacer operaciones sucesivas a partir del resultado
			// importante considerar que es necesario dar click en el igual
			operador=e.getActionCommand().charAt(0);
			System.out.print(operador);
			
		}
		
	}
	private class EscuchadorIgual implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			long resultado=0;
			String resultadoStr;
			
			switch(operador) {
				case '+': resultado=primNum+segNum;
					break;
				case '-': resultado=primNum-segNum;
					break;
				case '*': resultado=primNum*segNum;
					break;
				case '/': resultado=primNum/segNum;
					break;
				default: resultado=primNum;
			}
			resultadoStr=Long.toString(resultado);
			pantalla.setText(resultadoStr);
			primNum=0;
			segNum=0;
			operador=' ';
		}
		
	}
	
	public static void main(String[] args) {
		CalculadoraControlador yo=new CalculadoraControlador("CALCULADORA:::");

	}

}
