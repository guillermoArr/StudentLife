import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;

public class AlergiaVista extends JFrame{
	
	protected JLabel alergiaLb, precioLb, archivoLb;
	protected JTextField alergiaTxtF, precioTxtF, archivoTxtF;
	protected JButton buscarBt;
	protected JTextArea listaTxtA;
	protected JScrollPane listaTxtA2;
	
	public AlergiaVista(String titulo) {
		super(titulo);
		
		this.alergiaLb=new JLabel("Alergia a: ");
		this.precioLb=new JLabel("Precio límite: $");
		this.archivoLb=new JLabel("Nombre del archivo: ");
		this.alergiaTxtF=new JTextField();
		this.precioTxtF=new JTextField();
		this.archivoTxtF=new JTextField();
		this.buscarBt=new JButton("BUSCAR");
		this.listaTxtA=new JTextArea();
		this.listaTxtA2=new JScrollPane(listaTxtA);
		
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(4, 2));
		Border gap=BorderFactory.createEmptyBorder(2,2,2,2);
		panel.setBorder(gap);
		
		panel.add(alergiaLb);
		panel.add(alergiaTxtF);
		panel.add(precioLb);
		panel.add(precioTxtF);
		panel.add(archivoLb);
		panel.add(archivoTxtF);
		panel.add(buscarBt);
		panel.add(listaTxtA2);
		
		this.add(panel);
		this.setVisible(true);
		this.setBounds(300, 200, 500, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		AlergiaVista yo=new AlergiaVista("PRUEBA:..... ");

	}

}
