import javax.swing.*;
import java.util.*;


public class introJava {
	public static void main(String[] args){
		int xd = caloriasScanner();
		System.out.println(xd);
	}
	public static void calificacionUsario(){
		String strCalif = JOptionPane.showInputDialog("Escribe tu calificaci�n");
		int calificacion = Integer.parseInt(strCalif);
		if (calificacion < 70) {
			System.out.println("Reprobado");
		} else {
			System.out.println("Aprobado");
		}
	}

	public static void imprimirSerie(int entero){
		for(int i = 0; i<50;i++){
			System.out.println("El n�mero #" + (i+1) + " de la serie es " + (entero*(i+1)));
		}
	}
	
	public static void imprimirNumeros(){
		for(int i = 0; i<100;i++){
			System.out.println("El n�mero es " + (i+1));
		}
	}
	
	public static int caloriasScanner(){
		int caloriasTotales = 0;
		Scanner lector = new Scanner(System.in);
		System.out.println("�Cu�ntas comidas realizaste hoy?");
		int numComidas = lector.nextInt();
		for(int i =0; i<numComidas;i++){
			lector.nextLine();
			System.out.println("�Cu�ntas calorias consumiste en la comida #" + (i+1)+ "?");
			caloriasTotales += lector.nextInt();
		}
		return caloriasTotales;
	}
}

