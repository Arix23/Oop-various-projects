import java.util.ArrayList;

public class EjemploWildcards {
	public static double suma(ArrayList<? extends Number> numeros) {
		double suma = 0.0;
		for(int i = 0;i<numeros.size();i++) {
			suma+=numeros.get(i).doubleValue();
		}
		return suma;
	}
	
	public static void main(String[] args) {
		ArrayList<Number> numeros = new ArrayList<Number>();
		numeros.add(2);
		numeros.add(24);
		numeros.add(0.5); 
		numeros.add(0);
		System.out.println(suma(numeros));
	}
}
