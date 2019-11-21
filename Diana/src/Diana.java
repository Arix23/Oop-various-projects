//Autor: Ari Valenzuela (A01635584)
//Nombre de la clase: Diana.java
//Fecha: 04/04/2018
//Comentarios u observaciones: Se dibuja la Diana normal

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Diana {
	
	protected int 		xPos,
				  		yPos,
				  		ancho;
	protected Color 	colorCentro;
	
	
	
	public Diana(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.ancho = 200;
		this.colorCentro = Color.RED;
	}
	
	public void setColorCentro(Color color) {
		this.colorCentro = color;
	}
	
	public Color getColorCentro() {
		return this.colorCentro;
	}
	
	public void setPosicionInicial(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public void pintaFigura(Graphics g) {
		int radio = this.ancho/6;
		for(int i = 5; i>=0; i--) {
			int xd = radio*(5-i)/2;
			if(i==0) {
				g.setColor(this.colorCentro);
				g.fillOval(xPos+xd, yPos+xd, radio, radio);
			} else if (i%2==0) {
				g.setColor(Color.WHITE);
				g.fillOval(xPos+xd, yPos+xd, radio*(i+1), radio*(i+1));
			} else if (i%2==1) {
				g.setColor(Color.BLACK);
				g.fillOval(xPos+xd, yPos+xd, radio*(i+1), radio*(i+1));
			}
		}
		
	}

}
