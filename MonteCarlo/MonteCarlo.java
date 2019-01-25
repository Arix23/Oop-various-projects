//Autor: Ari Valenzuela (A01635584)
//Nombre de la clase: MonteCarlo.java
//Fecha: 23/01/2018
//Comentarios u observaciones: Obtuve los resultados esperados con un numero elevado de intentos.



import java.util.*;

public class MonteCarlo{
	public static void main(String[] args){
		double PI = aproximarPI(20000000);
		System.out.println(PI);
	}
	
	public static double aproximarPI(int numeroDardos){
		double aciertos = 0;
		double r,
		x,
		y,
		PI;

		for(int i = 0; i<numeroDardos; i++){
			r = Math.random();
			x = -1 + 2*r;
			r = Math.random();
			y = -1 + 2*r;
			if(x*x + y*y <= 1){
				aciertos ++;
			}
		}

		PI = 4 * aciertos/numeroDardos;
		return PI;
	}
}