//Autor: Ari Valenzuela(A01635584)
//Nombre de la clase: Octagono.java
//Fecha: 19/03/2019
//Comentarios u observaciones: En esta clase es la que se ejecuta el paneldibujo y se crea el Octagono

import java.awt.BorderLayout;

import javax.swing.JFrame;


public class Octagono extends JFrame {
	
	public Octagono() {
		super("Espiral de octagono");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		MyPanelDibujo pd = new MyPanelDibujo();
		this.add(pd);
		MyPanelControles pc = new MyPanelControles(pd);
		this.add(pc,BorderLayout.WEST);
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		Octagono oct = new Octagono();

	}

}
