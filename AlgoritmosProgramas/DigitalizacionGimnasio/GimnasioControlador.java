import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*Guillermo Arredondo
 * 30 noviembre 2020
 * Clase Controlador, interfaz final
 */
public class GimnasioControlador extends GimnasioVista{
	
	private Gimnasio g;

	public void leeArchivo() {
		File entrada=new File("gimnasio.txt");
		Gimnasio g;
		String nombre, ubicacion, encargado, curp, estilo, aparato, posicionEjecucion, categoria;
		int antiguedad, horario, logro, anio;
		double peso;
		char dificultad;
		boolean obligatorio;
		
		try(Scanner lec=new Scanner(entrada)){
			nombre=lec.next();
			lec.nextLine();
			ubicacion=lec.nextLine();
			encargado=lec.next();
			g=new Gimnasio(nombre, ubicacion, encargado);
			
			// Para asegurar una buena lectura, y correcto funcionamiento, se dejaron varias impresiones para checar las lecturas
			while(lec.hasNext()) {
				lec.nextLine();
				nombre=lec.nextLine();
				System.out.println(nombre);
				curp=lec.next();
				System.out.println(curp);
				antiguedad=lec.nextInt();
				System.out.println(antiguedad);
				estilo=lec.next();
				System.out.println(estilo);
				horario=lec.nextInt();
				System.out.println(horario);
				peso=lec.nextDouble();
				System.out.println(peso);
				if(g.altaGimnasta(nombre, curp, antiguedad, estilo, horario, peso)) {
					System.out.println("Alta exitosa");
				}
				else {
					System.out.println("Error en alta");
				}
				lec.nextLine();
				nombre=lec.nextLine();
				System.out.println(nombre);
				aparato=lec.next();
				System.out.println(aparato);
				posicionEjecucion=lec.next();
				System.out.println(posicionEjecucion);
				dificultad=lec.next().charAt(0);
				System.out.println(dificultad);
				obligatorio=lec.nextBoolean();
				System.out.println(obligatorio);
				if(g.altaMovimientoGimnasta(curp, nombre, aparato, posicionEjecucion, dificultad, obligatorio)) {
					System.out.println("Alta exitosa");
				}
				else {
					System.out.println("Error en alta");
				}
				lec.nextLine();
				nombre=lec.nextLine();
				aparato=lec.next();
				posicionEjecucion=lec.next();
				dificultad=lec.next().charAt(0);
				obligatorio=lec.nextBoolean();
				if(g.altaMovimientoGimnasta(curp, nombre, aparato, posicionEjecucion, dificultad, obligatorio)) {
					System.out.println("Alta exitosa");
				}
				else {
					System.out.println("Error en alta");
				}
				lec.nextLine();
				nombre=lec.nextLine();
				aparato=lec.next();
				posicionEjecucion=lec.next();
				dificultad=lec.next().charAt(0);
				obligatorio=lec.nextBoolean();
				if(g.altaMovimientoGimnasta(curp, nombre, aparato, posicionEjecucion, dificultad, obligatorio)) {
					System.out.println("Alta exitosa");
				}
				else {
					System.out.println("Error en alta");
				}
				lec.nextLine();
				nombre=lec.nextLine();
				System.out.println(nombre);
				ubicacion=lec.nextLine();
				System.out.println(ubicacion);
				categoria=lec.nextLine();
				System.out.println(categoria);
				anio=lec.nextInt();
				System.out.println(anio);
				logro=lec.nextInt();
				System.out.println(logro);
				if(g.altaCompetenciaGimnasta(curp, nombre, ubicacion, categoria, anio)) {
					System.out.println("Alta exitosa");
				}
				else {
					System.out.println("Error en alta");
				}
				System.out.println(g.setLogroCompetenciaGimnasta(curp, nombre, logro));
				lec.nextLine();
				nombre=lec.nextLine();
				System.out.println(nombre);
				ubicacion=lec.nextLine();
				System.out.println(ubicacion);
				categoria=lec.nextLine();
				System.out.println(categoria);
				anio=lec.nextInt();
				System.out.println(anio);
				logro=lec.nextInt();
				System.out.println(logro);
				if(g.altaCompetenciaGimnasta(curp, nombre, ubicacion, categoria, anio)) {
					System.out.println("Alta exitosa");
				}
				else {
					System.out.println("Error en alta");
				}
				System.out.println(g.setLogroCompetenciaGimnasta(curp, nombre, logro));
				lec.nextLine();
				nombre=lec.nextLine();
				System.out.println(nombre);
				ubicacion=lec.nextLine();
				System.out.println(ubicacion);
				categoria=lec.nextLine();
				System.out.println(categoria);
				anio=lec.nextInt();
				System.out.println(anio);
				logro=lec.nextInt();
				System.out.println(logro);
				if(g.altaCompetenciaGimnasta(curp, nombre, ubicacion, categoria, anio)) {
					System.out.println("Alta exitosa");
				}
				else {
					System.out.println("Error en alta");
				}
				System.out.println(g.setLogroCompetenciaGimnasta(curp, nombre, logro));
				g.actualizaGimnasio();
				this.g=g;
			}			
		}
		catch(FileNotFoundException fnfe) {
			System.err.println("E R R O R "+fnfe);
			System.exit(-1);
		}
	}
	
	public GimnasioControlador(String titulo) {
		super(titulo);
		
		this.g=new Gimnasio();
		
		leerArchivo.addActionListener(new EscuchadorArchivo());
		super.infoComplBt.addActionListener(new EscuchadorImprime());
		tablaDataBt.addActionListener(new EscuchadorImprime());
		super.actualizaGymBt.addActionListener(new EscuchadorBotones1());
		super.nutricionBt.addActionListener(new EscuchadorBotones1());
		super.buscaGimnasBt.addActionListener(new EscuchadorBotones1());
		super.mejoresCompetenciasNivel.addActionListener(new EscuchadorBotones1());
		super.expAparato.addActionListener(new EscuchadorBotones1());
		super.bajaGimnastaBt.addActionListener(new EscuchadorBotones2());
		super.altaGimnastasBt.addActionListener(new EscuchadorBotones2());	//Nuevos Gimnastas
		super.mayDificultad.addActionListener(new EscuchadorBotones2());
		super.cuantosCompetencia.addActionListener(new EscuchadorBotones2());
		super.horario.addActionListener(new EscuchadorBotones2());
		super.antiguedad.addActionListener(new EscuchadorBotones2());
		super.estilo.addActionListener(new EscuchadorBotones2());
		super.logroCompBt.addActionListener(new EscuchadorBotones2());
		super.gimNivel.addActionListener(new EscuchadorBotones3());
		super.cuantosMovimiento.addActionListener(new EscuchadorBotones3());
		super.altaLogrosBt.addActionListener(new EscuchadorBotones3());
		super.bajaCompBt.addActionListener(new EscuchadorBotones3());
		super.edad.addActionListener(new EscuchadorBotones3());
		super.numComp.addActionListener(new EscuchadorBotones3());
		super.buscaLogro.addActionListener(new EscuchadorBotones3()); 
		super.listMovBt.addActionListener(new EscuchadorRadioBotones());
		super.movMasDificil.addActionListener(new EscuchadorRadioBotones());
		
		nutricionTxtF.setText("Ingrese curp del gimnasta");
		estadTxtF.setText("Ingrese Info a buscar");
		logrosTxtF1.setText("Nombre Competencia o Movimiento");
		logrosTxtF2.setText("Lugar o Aparato");
		logrosTxtF3.setText("Categoria o Posición de Ejecucion");
		logrosTxtF4.setText("Año de competencia o dificultad de movimiento");
		logrosTxtF5.setText("Posición resultante en competencia");
		pantallaGimnastas.setText("Ingrese curp del gimnasta");
		
		
	}
	private class EscuchadorArchivo implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			leeArchivo();
			pantallaGral.setText("Archivo Cargado y Listo para usarse \n\n"+g.toString());
		}
		
	}
	private class EscuchadorImprime implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			String comando=e.getActionCommand();
			StringBuilder txt=new StringBuilder();
			
			if(comando.charAt(0)=='T') {
				if(!g.isGimnasioVacio()) {
					for(int j=0; j<g.getMAX_NIVELES(); j++) {
						txt.append("Gimnastas nivel"+(j+1));
						if(g.getNumCompsNivel(j+1)!=0) {
							txt.append(g.getGimnastasNivel(j)+"\n");
						}
						else {
							txt.append("\t 0 Gimnastas \n");
						}
					}
				}
				else {
					txt.append("Gimnasio sin gimnastas");
				}
			}
			else {
				txt.append(g.toString());
			}
			pantallaGral.setText(txt.toString());
		}
	}
	
	private class EscuchadorBotones1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String comando=e.getActionCommand();
			String salida, entrada;
			boolean musculo;
			double aux;
			int aux2;
			
			switch(comando.charAt(0)) {
				case 'N':
					entrada=nutricionTxtF.getText();
					musculo=nutMuscRdBt.isSelected();
					System.out.println(musculo);
					aux=g.getProteinasGimnasta(entrada, musculo);
					salida=Double.toString(aux);
					nutricionTxtF.setText(salida+" gramos al día");
					break;
				case 'B':
					entrada=pantallaGimnastas.getText();
					salida="Resultado de búsqueda en Gimnastas: ";
					salida=salida.concat(g.getUnGimnasta(entrada));
					pantallaGral.setText(salida);
					break;
				case 'A':
					g.actualizaGimnasio();
					pantallaGral.setText("Gimnasio actualizado");
					break;
				case 'M':
					entrada=(String)nivelesCBox1.getSelectedItem();
					salida=g.mejoresCompetenciasGimnastasNivel(entrada);
					pantallaGral.setText("Mejores Competencias en el nivel "+entrada+" "+salida);
					break;
				case 'E':
					entrada=logrosTxtF2.getText();
					aux2=g.cuantasExpertiseAparato(entrada);
					salida="Gimnastas con experiencia en aparato "+entrada;
					salida=salida.concat(":\n"+Integer.toString(aux2));
					pantallaGimnastas.setText(salida);
					break;
			}
			
		}
		
	}
	private class EscuchadorBotones2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String comando=e.getActionCommand();
			String nombre, curp, entrada1, entrada2, aux2;
			String salida="";
			boolean alta;
			int antiguedad, aux, horario;
			double pesoKg;
			
			switch(comando.charAt(0)) {
				case 'N':
					entrada1=(String)estilosCBox1.getSelectedItem();
					aux2=(String)horarioCBox1.getSelectedItem();
					entrada2=aux2.substring(0, 2);
					entrada2=entrada2.concat(aux2.substring(3,5));
					horario=Integer.parseInt(entrada2);
					nombre=inscripcionesTxtF1.getText();
					curp=inscripcionesTxtF2.getText();
					antiguedad=Integer.parseInt(inscripcionesTxtF3.getText());
					pesoKg=Double.parseDouble(inscripcionesTxtF4.getText());
					alta=g.altaGimnasta(nombre, curp, antiguedad, entrada1, horario, pesoKg);
					if(alta) {
						salida="Alta exitosa";
					}
					else {
						salida="E R R O R   E N   A L T A";
					}
					break;
				case 'B':
					curp=pantallaGimnastas.getText();
					salida="Gimnasta dad@ de baja: ";
					salida=salida.concat(g.bajaGimnasta(curp));
					break;
				case 'M':
					salida="Gimnasta mayor dificultad ";
					salida=salida.concat(g.gimnastaMayDificul());
					
					break;
				case 'C':
					entrada1=estadTxtF.getText();
					aux=g.cuantosGimnastasEnCompetencia(entrada1);
					salida="Gimnastas en competencia "+entrada1;
					salida=salida.concat(" "+Integer.toString(aux));
					
					break;
				case 'H':
					aux2=(String)horarioCBox2.getSelectedItem();
					entrada2=aux2.substring(0, 2);
					entrada2=entrada2.concat(aux2.substring(3,5));
					horario=Integer.parseInt(entrada2);
					aux=g.gimnastasHorario(horario);
					salida="Gimnastas en horario "+aux2;
					salida=salida.concat(" son "+Integer.toString(aux));
					break;
				case 'A':
					antiguedad=Integer.parseInt(estadTxtF.getText());
					aux=g.cuantasAntiguedad(antiguedad);
					salida="Gimnastas con antiguedad: "+antiguedad;
					salida=salida.concat(" "+Integer.toString(aux));
					break;
				case 'E':
					entrada1=(String)estilosCBox2.getSelectedItem();
					aux=g.cuantasEstilo(entrada1);
					salida="Gimnastas de estilo "+entrada1;
					salida=salida.concat(" son "+Integer.toString(aux));
					break;
				case 'L':
					entrada1=pantallaGimnastas.getText();
					nombre=logrosTxtF1.getText();
					entrada2=logrosTxtF5.getText();
					aux=Integer.parseInt(entrada2);
					salida=g.setLogroCompetenciaGimnasta(entrada1, nombre, aux);
					break;
			}
			pantallaGral.setText(salida);
			inscripcionesTxtF1.setText("Nombre");
			inscripcionesTxtF2.setText("CURP");
			inscripcionesTxtF3.setText("Años en gimnasio");
			inscripcionesTxtF4.setText("Peso en Kg");
			logrosTxtF5.setText("Posición resultante en competencia");
			pantallaGimnastas.setText("Ingrese curp del gimnasta");
			estadTxtF.setText("Ingrese Info a buscar");
		}
		
	}
	private class EscuchadorBotones3 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String comando=e.getActionCommand();
			String curp, nombre, txt2, txt3;
			String salida="";
			char txt4;
			boolean alta;
			int txt5, aux, edad;
			switch(comando.charAt(0)) {
				case 'M':
					txt2=estadTxtF.getText();
					aux=g.cuantosGimnastasConMovimiento(txt2);
					salida="Gimnastas con movimiento "+txt2;
					salida=salida.concat(" "+Integer.toString(aux));
					break;
				case 'A':
					curp=pantallaGimnastas.getText();
					nombre=logrosTxtF1.getText();
					txt2=logrosTxtF2.getText();
					txt3=logrosTxtF3.getText();
					if(movBt.isSelected()) {
						txt4=logrosTxtF4.getText().charAt(0);
						alta=g.altaMovimientoGimnasta(curp, nombre, txt2, txt3, txt4, obligatorioBt.isSelected());
						obligatorioBt.setSelected(false);;
					}
					else{
						txt5=Integer.parseInt(logrosTxtF4.getText());
						alta=g.altaCompetenciaGimnasta(curp, nombre, txt2, txt3, txt5);
					}
					if(alta) {
						salida="Alta exitosa";
					}
					else {
						salida="E R R O R   E N   A L T A";
					}
					break;
				case 'B':
					nombre=logrosTxtF1.getText();
					curp=pantallaGimnastas.getText();
					if(comando.charAt(1)=='a') { //Baja competencia
						salida=g.bajaCompetenciaGimnasta(curp, nombre);
					}
					else if(movBt.isSelected()) { //Busca
							salida=g.getUnMovimientoGimnasta(curp, nombre);
					}
					else if(compBt.isSelected()) {
						salida=g.getUnaCompetenciaGimnasta(curp, nombre);
					}
					break;
				case 'E':
					txt2=estadTxtF.getText();
					edad=Integer.parseInt(txt2);
					aux=g.gimnastasEdad(edad);
					salida="Número de gimnastas de edad "+edad+" años";
					salida=salida.concat(": "+Integer.toString(aux));
					break;
				case 'C':
					txt2=(String)nivelesCBox2.getSelectedItem();
					aux=g.getNumCompsNivel(txt2);
					salida="Número de competidores en nivel "+txt2;
					salida=salida.concat(": "+Integer.toString(aux));
					break;
				case 'G':
					txt2=(String)nivelesCBox1.getSelectedItem();
					salida="Gimnastas en nivel "+txt2+": ";
					salida=salida.concat(g.getGimnastasNivel(txt2));
					break;
			}
			pantallaGral.setText(salida);
			logrosTxtF1.setText("Nombre Competencia o Movimiento");
			logrosTxtF2.setText("Lugar o Aparato");
			logrosTxtF3.setText("Categoria o Posición de Ejecucion");
			logrosTxtF4.setText("Año de competencia o dificultad de movimiento");
			pantallaGimnastas.setText("Ingrese curp del gimnasta");
			estadTxtF.setText("Ingrese Info a buscar");
			
		}
		
	}
	private class EscuchadorRadioBotones implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String comando=e.getActionCommand();
			String txt, txt2;
			String salida="";
			
			txt=pantallaGimnastas.getText();
			switch(comando.charAt(0)) {
				case 'L': //lista de movimiento
					txt2=logrosTxtF2.getText();
					System.out.println(txt2);
					salida="Lista de movimientos de Gimnasta "+txt+" en aparato "+txt2;
					salida=salida.concat(":\n"+g.getListaMovimientosGimnastaAparato(txt, txt2));
					break;
				case 'M':
					salida="Movimiento mas dificil de Gimnasta "+txt;
					salida=salida.concat("\n"+g.getMovMasDificilGimnasta(txt));
					break;
			}
			pantallaGral.setText(salida);
			pantallaGimnastas.setText("Ingrese curp del gimnasta");
			logrosTxtF2.setText("Lugar o Aparato");
		}
		
	}
	
	public static void main(String[] args) {
		GimnasioControlador yo=new GimnasioControlador("A VER SI AHORA SI....:");

	}

}
