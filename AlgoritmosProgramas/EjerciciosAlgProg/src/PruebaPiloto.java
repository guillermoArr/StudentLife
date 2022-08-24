
public class PruebaPiloto {

	public static void main(String[] args) {
		Piloto p1, p2;
		
		p1=new Piloto("Rodolfo","hombre", 64.0, 170, 9, true);
		p2=new Piloto("Georgina", "mujer", 60.0, 152, 2, false);
		
		System.out.println("El piloto de clave unica: "+p1.getClveUnica()+" requiere ingerir: "+p1.calculaCarbohidratos()+"gr de carbs");
		
		if(p1.equals(p2)) {
			System.out.println("El piloto 1 y el piloto 2 son el mismo");
		}
		else {
			System.out.println("El piloto 1 y el piloto 2 no son el mismo");
		}
		p1.actualizaPuntos(12);
		System.out.println("El nuevo total de puntos del piloto 1 es de: "+p1.getPuntosComp());

	}

}
