//Autor: Ari Valenzuela(A01635584)
//Nombre de la clase: EjemploArreglos
//Fecha: 08/02/2019
//Comentarios u observaciones: Aprendí a usar los arrays y a utilizar el Array del main

public class EjemploArreglos {
	public int suma(int[] arreglo) {
		int suma = 0;
		for(int i = 0; i<arreglo.length;i++) {
			suma+=arreglo[i];
		}
		return suma;
	}
	
	public int maximo(int[] arreglo) {
		int max = arreglo[0];
		for(int i = 1;i<arreglo.length;i++) {
			if (max < arreglo[i]) {
				max = arreglo[i];
			}
		}
		return max;
	}


	public void imprime(String [] [] palabras) {
		for(int i = 0; i<palabras.length;i++) {
			System.out.println("");
			for(int j = 0; j<palabras[i].length;j++) {
				System.out.print(palabras[i][j]+ " ");
			}
		}
	}

	public int minimo(int[] arreglo) {
		int minimo = arreglo[0];
		for(int i = 1; i<arreglo.length;i++){
			if(arreglo[i] < minimo) {
				minimo = arreglo[i];
			}
		}
		return minimo;
	}

	public double promedio(int[] arreglo) {
		int promedio = 0;
		for(int i = 0; i<arreglo.length;i++) {
			promedio += arreglo[i];
		}
		promedio /= arreglo.length;
		return promedio;
	}

	public static void main(String[] args) {
		EjemploArreglos ea = new EjemploArreglos();
		int[] arreglo = {2,3,4,5,6};
		System.out.println(ea.suma(arreglo));
		System.out.println(ea.maximo(arreglo));
		System.out.println(ea.minimo(arreglo));
		System.out.println(ea.promedio(arreglo));
		
		String[][] nombres = {{"Ari","Ramon","Oscar","Andres"},{"Alex","John","Goku"},args};
		ea.imprime(nombres);
	}

}
