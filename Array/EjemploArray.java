//Autor: Ari Valenzuela(A01635584)
//Nombre de la clase: EjemploArreglos
//

public class EjemploArreglos {
	public int suma(int[] arreglo) {
		int suma = 0;
		for(int i = 0; i<arreglo.length;i++) {
			suma+=arreglo[i];
		}
		return suma;
	}

	public static void main(String[] args) {
		int[] arreglo = {2,3,4,5,6};
		int xd = suma(arreglo);
		System.out.println(xd);
	}

}
