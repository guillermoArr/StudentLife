import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;
/*Guillermo Arredondo
 * 23 noviembre 2020
 * Empezando a hacer interfaces graficas simples
 */
public class ConvertidorVista extends JFrame {
	protected JLabel kmsLb, millasLb;
	protected JTextField kmsTxtF, millasTxtF;
	
	public ConvertidorVista(String titulo) {
		super(titulo);
		
		this.kmsLb=new JLabel("Kilometros: ");
		this.millasLb=new JLabel("Millas: ");
		this.kmsTxtF=new JTextField(12); 	// 12 es el numero de caracteres en la vista
		this.millasTxtF=new JTextField(12);
		
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(2, 2));
		Border gap=BorderFactory.createEmptyBorder(2,2,2,2);
		panel.setBorder(gap);
		
		panel.add(kmsLb);
		panel.add(kmsTxtF);
		panel.add(millasLb);
		panel.add(millasTxtF);
		
		this.add(panel);
		this.setVisible(true);
		this.setBounds(100, 200, 200, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	// provisional 
	public static void main(String[] args) {
		ConvertidorVista yo=new ConvertidorVista("PRUEBA:::");

	}

}
