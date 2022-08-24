import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;

/*Guillermo Arredondo Renero
 * 8 de diciembre de 2020
 * Problema 1 del Examen Final Clase Vista
 */
public class TransaccionesVista extends JFrame{
	private JLabel nombreLb, cantMovLb;
	protected JTextField nombreTxtF, cantMovTxtF;
	protected JButton aceptarBt;
	
	public TransaccionesVista(String titulo) {
		super(titulo);
		
		nombreLb=new JLabel("Nombre del Banco: ");
		cantMovLb=new JLabel("Cantidad movimientos MISMO DÍA");
		nombreTxtF=new JTextField();
		cantMovTxtF=new JTextField();
		aceptarBt=new JButton("ACEPTAR");
		
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(3, 2));
		Border gap=BorderFactory.createEmptyBorder(2,2,2,2);
		panel.setBorder(gap);
		
		panel.add(nombreLb);
		panel.add(nombreTxtF);
		panel.add(cantMovLb);
		panel.add(cantMovTxtF);
		panel.add(aceptarBt);
		
		this.add(panel);
		this.setVisible(true);
		this.setBounds(500, 500, 750, 375);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		TransaccionesVista yo=new TransaccionesVista("ESTOOOY VIVOOOO::....");

	}

}
