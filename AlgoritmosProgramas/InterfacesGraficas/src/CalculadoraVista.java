import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;
/*Guillermo Arredondo
 * 24 noviembre 2020
 * CalculadoraVista con interaccion provisional
 */
public class CalculadoraVista extends JFrame{
	protected JButton num1, num2, num3, num4, num5, num6, num7, num8, num9, num0, mult, suma, resta, div, igual;
	protected JTextField pantalla;
	
	public CalculadoraVista(String titulo) {
		super(titulo);
		
		this.num1=new JButton("1");
		this.num2=new JButton("2");
		this.num3=new JButton("3");
		this.num4=new JButton("4");
		this.num5=new JButton("5"); 
		this.num6=new JButton("6"); 
		this.num7=new JButton("7"); 
		this.num8=new JButton("8"); 
		this.num9=new JButton("9"); 
		this.num0=new JButton("0");
		this.mult=new JButton("*");
		this.suma=new JButton("+");
		this.resta=new JButton("-");
		this.div=new JButton("/");
		this.igual=new JButton("=");
		this.pantalla=new JTextField();
		
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(4, 4));
		Border gap=BorderFactory.createEmptyBorder(2,2,2,2);
		panel.setBorder(gap);
		
		panel.add(num1);
		panel.add(num2);
		panel.add(num3);
		panel.add(pantalla);
		panel.add(num4);
		panel.add(num5);
		panel.add(num6);
		panel.add(suma);
		panel.add(num7);
		panel.add(num8);
		panel.add(num9);
		panel.add(resta);
		panel.add(mult);
		panel.add(num0);
		panel.add(div);
		panel.add(igual);
		
		this.add(panel);
		this.setVisible(true);
		this.setBounds(0, 0, 500, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// provisional
	public static void main(String[] args) {
		CalculadoraVista yo=new CalculadoraVista("PRUEBA CALCULADORA:::");

	}

}
