//Autor: Ari Valenzuela (A01635584)
//Nombre de la clase: Division.java
//Fecha: 01/03/2019
//Comentarios u observaciones: Solo se dan dos excepciones, la division entre 0 y al intentar convertir letras del String a Int.


import javax.swing.*;

public class Division {
	public static int divisionEntera(int num, int den) {
		return num/den;
	}
	
	public static void main(String[] args) {
		boolean success = false;
		while(!success) {
			try {
				int n = Integer.parseInt(JOptionPane.showInputDialog("Escribe un número"));
				int d = Integer.parseInt(JOptionPane.showInputDialog("Escribe otro número"));
				int res = divisionEntera(n,d);
				JOptionPane.showMessageDialog(null, "El resultado de la división entera de "+n+"/"+d+" es "+res);
				success=true;
			} catch(ArithmeticException e) {
				JOptionPane.showMessageDialog(null, "Error, no se puede dividir entre 0");
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null,  "No se puede convertir ese String a un número");
			}
		}
	}
}
