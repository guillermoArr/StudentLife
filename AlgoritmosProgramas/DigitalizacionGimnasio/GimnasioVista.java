import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;


/*Guillermo Arredondo
 * 30 nov 2020
 * Clase Vista de interfaz Gimnasio
 */
public class GimnasioVista extends JFrame{

	protected JTextArea pantallaGral;
	protected JButton leerArchivo, tablaDataBt, nutricionBt, altaLogrosBt, altaGimnastasBt, actualizaGymBt, infoComplBt;
	protected JButton buscaGimnasBt, bajaCompBt, bajaGimnastaBt, mayDificultad, expAparato, mejoresCompetenciasNivel, gimNivel;
	protected JButton cuantosMovimiento, cuantosCompetencia, horario, edad, estilo, antiguedad, logroCompBt, numComp, buscaLogro;
	protected JLabel inicioLb, estadCuantos;
	protected JTextField nutricionTxtF, estadTxtF, inscripcionesTxtF1,inscripcionesTxtF2,inscripcionesTxtF3, inscripcionesTxtF4, logrosTxtF1, pantallaGimnastas;
	protected JTextField logrosTxtF2, logrosTxtF3, logrosTxtF4, logrosTxtF5;
	protected JRadioButton nutMuscRdBt, obligatorioBt, movBt, compBt, listMovBt, movMasDificil;
	protected JComboBox<String> estilosCBox1, estilosCBox2, nivelesCBox1, nivelesCBox2, horarioCBox1, horarioCBox2;
	protected JScrollPane textoGrande;
	
	public GimnasioVista(String titulo) {
		super(titulo);
		String[] listaEstilos={"Rítmica", "Olimpica", "Tricking", "Parkour", "Recreativa", "Adultos"};
		String[] listaNiveles={"EXCEL 1", "EXCEL 2","EXCEL 3","EXCEL 4","EXCEL 5","EXCEL 6","EXCEL 7","EXCEL 8","EXCEL 9","EXCEL 10","FIG"};
		String[] listaHorarios= {"08:00", "10:00", "12:00", "14:00", "14:30", "15:00", "16:00", "16:30", "19:00", "19:30", "20:30"};
		
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(5,6));
		Border gap=BorderFactory.createEmptyBorder(5, 5, 5, 5);
		panel.setBorder(gap);
		
		JPanel nutricionPn=new JPanel();
		nutricionPn.setLayout(new GridLayout(2,2));
		Border gap2=BorderFactory.createTitledBorder(gap, "NUTRICION");
		Border gap3=BorderFactory.createBevelBorder(WIDTH, Color.BLUE, Color.BLUE);
		Border gap4=BorderFactory.createCompoundBorder(gap3, gap2);
		nutricionPn.setBorder(gap4);
		
		JPanel inscripcionesPn=new JPanel();
		inscripcionesPn.setLayout(new GridLayout(2,7));
		gap2=BorderFactory.createTitledBorder(gap, "INSCRIPCIONES");
		gap3=BorderFactory.createBevelBorder(WIDTH, Color.CYAN, Color.CYAN);
		gap4=BorderFactory.createCompoundBorder(gap3, gap2);
		inscripcionesPn.setBorder(gap4);
		
		JPanel gimnastasPn=new JPanel();
		gimnastasPn.setLayout(new GridLayout(2,1));
		gap2=BorderFactory.createTitledBorder(gap, "GIMNASTAS");
		gap3=BorderFactory.createBevelBorder(WIDTH, Color.GREEN, Color.GREEN);
		gap4=BorderFactory.createCompoundBorder(gap3, gap2);
		gimnastasPn.setBorder(gap4);
		
		JPanel logrosPn=new JPanel();
		logrosPn.setLayout(new GridLayout(4,5));
		gap2=BorderFactory.createTitledBorder(gap, "LOGROS- COMPETENTCIAS Y MOVIMIENTOS");
		gap3=BorderFactory.createBevelBorder(WIDTH, Color.MAGENTA, Color.MAGENTA);
		gap4=BorderFactory.createCompoundBorder(gap3, gap2);
		logrosPn.setBorder(gap4);
		
		JPanel estadPn=new JPanel();
		estadPn.setLayout(new GridLayout(4,5));
		gap2=BorderFactory.createTitledBorder(gap, "ESTADISTICAS GYM");
		gap3=BorderFactory.createBevelBorder(WIDTH, Color.WHITE, Color.WHITE);
		gap4=BorderFactory.createCompoundBorder(gap3, gap2);
		estadPn.setBorder(gap4);
		
		JPanel tablasDatos=new JPanel();
		tablasDatos.setLayout(new GridLayout(1,2));
		gap2=BorderFactory.createTitledBorder(gap, "Impresión de Datos");
		gap3=BorderFactory.createBevelBorder(WIDTH, Color.WHITE, Color.WHITE);
		gap4=BorderFactory.createCompoundBorder(gap3, gap2);
		tablasDatos.setBorder(gap4);
		
		this.inicioLb=new JLabel("Bienvenido a Gym");
		
		this.leerArchivo=new JButton("Archivo");
		this.nutricionTxtF=new JTextField(25);
		this.nutricionBt=new JButton("Nutricion");
		this.nutMuscRdBt=new JRadioButton("Desea más músculo");
		this.estilosCBox1=new JComboBox<String>(listaEstilos);
		this.estilosCBox2=new JComboBox<String>(listaEstilos);
		this.altaGimnastasBt=new JButton("Nuevos Gimnastas");
		this.gimNivel=new JButton("Gimnastas en nivel");
		this.inscripcionesTxtF1=new JTextField("Nombre",30);
		this.inscripcionesTxtF2=new JTextField("CURP",30);
		this.inscripcionesTxtF3=new JTextField("Años en gimnasio",30);
		this.inscripcionesTxtF4=new JTextField("Peso en Kg",30);
		this.buscaGimnasBt=new JButton("Busca");
		this.bajaGimnastaBt=new JButton("BAJA GIMNASTA");
		this.pantallaGimnastas=new JTextField(70);
		this.nivelesCBox1=new JComboBox<String>(listaNiveles);
		this.nivelesCBox2=new JComboBox<String>(listaNiveles);
		this.mayDificultad=new JButton("Mayor Dif.");
		this.expAparato=new JButton("Exp. Aparato");
		this.mejoresCompetenciasNivel=new JButton("Mejores Competencias en Nivel");
		this.horarioCBox1=new JComboBox<String>(listaHorarios);
		this.horarioCBox2=new JComboBox<String>(listaHorarios);
		this.logrosTxtF1=new JTextField(30);
		this.logrosTxtF2=new JTextField(30);
		this.logrosTxtF3=new JTextField(30);
		this.logrosTxtF4=new JTextField(30);
		this.logrosTxtF5=new JTextField(30);
		this.obligatorioBt=new JRadioButton("Obligatorio");
		this.movBt=new JRadioButton("Es Movimiento");
		this.compBt=new JRadioButton("Es Competencia");
		this.buscaLogro=new JButton("Busca");
		this.infoComplBt=new JButton("INFO GYM");
		this.tablaDataBt=new JButton("Tabla de datos");
		this.actualizaGymBt=new JButton("ActualizaGym");
		this.altaLogrosBt=new JButton("Altas");
		this.bajaCompBt=new JButton("Baja competencia");
		this.listMovBt=new JRadioButton("Lista de Movimientos de Gimnasta");
		this.logroCompBt=new JButton("Logro en Competencia");
		this.movMasDificil=new JRadioButton("Movimiento más dificil de Gimnasta");
		this.estadTxtF=new JTextField(40);
		this.estadCuantos=new JLabel("Cuantos:");
		this.cuantosMovimiento=new JButton("Movimiento");
		this.cuantosCompetencia=new JButton("Competencia");
		this.horario=new JButton("Horario");
		this.edad=new JButton("Edad");
		this.estilo= new JButton("Estilo");
		this.numComp=new JButton("Competidores en Nivel");
		this.antiguedad=new JButton("Años en gym");
		
		this.pantallaGral=new JTextArea("Información sobre GYM",30, 50);
		this.textoGrande=new JScrollPane(pantallaGral);
		
		panel.add(inicioLb);
		panel.add(leerArchivo,1);
		
		// primer panel: destinado a calcular nutricion del gimnasta solicitado
		nutricionPn.add(nutricionTxtF);
		nutricionPn.add(nutricionBt);
		nutricionPn.add(nutMuscRdBt);
		panel.add(nutricionPn, 2);
		
		/* segundo panel: destinado a altas gimnastas unicamente, para facilitar interaccion hay un
		 * text field por cada parametro necesario y Combo Box para otros de eleccion 
		 */
		inscripcionesPn.add(inscripcionesTxtF1);
		inscripcionesPn.add(inscripcionesTxtF2);
		inscripcionesPn.add(inscripcionesTxtF3);
		inscripcionesPn.add(inscripcionesTxtF4);
		inscripcionesPn.add(altaGimnastasBt);
		inscripcionesPn.add(estilosCBox1);
		inscripcionesPn.add(horarioCBox1);
		panel.add(inscripcionesPn, 3);
		
		/* tercer panel: destinado a explotar la informacion de la matriz de gimnastas, aporta algunas
		 * estadisticas y permite un campo a traves del cual es necesario siempre colocar el CURP del
		 * gimnasta con el que se desea trabajar
		 */
		gimnastasPn.add(pantallaGimnastas);
		gimnastasPn.add(buscaGimnasBt);
		gimnastasPn.add(bajaGimnastaBt);
		gimnastasPn.add(mejoresCompetenciasNivel);
		gimnastasPn.add(mayDificultad);
		gimnastasPn.add(expAparato);
		gimnastasPn.add(nivelesCBox1);
		gimnastasPn.add(gimNivel);
		panel.add(gimnastasPn, 4);
		
		/*se establece un grupo de botones para evitar doble eleccion de movimientos y competencias 
		 * sumamente importante para las altas y busquedas
		 */
		ButtonGroup group = new ButtonGroup();
	    group.add(movBt);
	    group.add(compBt);

	    /*cuarto panel: logros, en este se explota el uso de los arreglos instanciados en cada gimnasta
	     * por un lado tenemos los movimientos y por el otro las competencias, importante distinguir
	     */
		logrosPn.add(logrosTxtF1);
		logrosPn.add(logrosTxtF2);
		logrosPn.add(logrosTxtF3);
		logrosPn.add(logrosTxtF4);
		logrosPn.add(movBt);
		logrosPn.add(compBt);
		logrosPn.add(buscaLogro);
		logrosPn.add(altaLogrosBt);
		logrosPn.add(obligatorioBt);
		logrosPn.add(listMovBt);
		logrosPn.add(logroCompBt);
		logrosPn.add(bajaCompBt);
		logrosPn.add(movMasDificil);
		logrosPn.add(logrosTxtF5);
		panel.add(logrosPn,5);
		
		/*un boton grande que actualiza el gimnasio, un metodo muy importante y complejo para poder
		 * colocar a cada gimnasta en su nivel correspondiente
		 */
		panel.add(actualizaGymBt, 6);
		/*boton grande para poder desplegar dos diferentes toString, el primero despliega un metodo de estilo
		 * imprimeMatriz en el cual se presentan por niveles los nombres de todos los gimnastas en 
		 * el gimnasio, el segundo es el toString de todo el gimnasio en general
		 */
		tablasDatos.add(tablaDataBt);
		tablasDatos.add(infoComplBt);
		panel.add(tablasDatos,7);
		/*
		 * quinto panel: estadisticas: este panel sirve para obtener todas las estadisticas
		 * que puedan ser requeridad por el Gimnasio acerca del tipo de competidores que hay
		 * inscritos
		 */
		estadTxtF.setBounds(0, 0, 10, 60);
		estadPn.add(estadTxtF);
		estadPn.add(estadCuantos);
		estadPn.add(horario);
		estadPn.add(cuantosMovimiento);
		estadPn.add(cuantosCompetencia);
		estadPn.add(horarioCBox2);
		estadPn.add(estilo);
		estadPn.add(edad);
		estadPn.add(numComp);
		estadPn.add(estilosCBox2);
		estadPn.add(antiguedad);
		estadPn.add(nivelesCBox2);
		panel.add(estadPn,8);
		
		/*por ultimo la pantalla en la cual se despliega la informacion grande de varios metodos
		 * cuenta con ScrollPane para poder visualizar mas facilmente
		 */
		panel.add(textoGrande, 9);
		
		this.add(panel);
		this.setVisible(true);
		this.setBounds(50, 0, 1800, 900);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		GimnasioVista yo=new GimnasioVista("PRUEBA:...");

	}

}
