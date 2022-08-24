import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/*Guillermo Arredondo Renero
 * 28 Octubre 2020 Main de clase fiesta con arreglos en persona y en fiesta
 */
public class MainFiesta {

	public static void main(String[] args) {
		Fiesta f;
		int n;
		File entrada=new File("invitados.txt");
		String dat1, dat2, dat3;
		
		try(Scanner lec=new Scanner(entrada)){
			/*dat1=lec.next();
			dat2=lec.next();*/
			f=new Fiesta("ITAM", "1 DE ENERO 2021");
			while(lec.hasNext()) {
				dat1=lec.next();
				dat2=lec.next();
				dat3=lec.next();
				if(f.altaInvitado(dat1, dat2, dat3)) {
					System.out.println("Alta exitosa");
				}
				else {
					System.out.println("E R R O R en el alta");
				}
			}
			lec.close();
			System.out.println(f.toString());
		}
		catch(FileNotFoundException fnfe){
			System.err.println("E R R O R "+fnfe);
			System.exit(-1);
		}

	}

}
