//Autor: Ari Valenzuela(A01635584)
//Nombre de la clase: MyPanelDibujo.java
//Fecha: 19/03/2019
//Comentarios u observaciones: En esta clase se inicializa el panel dibujo.

import java.awt.Dimension;
import java.awt.Graphics;
import java.math.*;
import javax.swing.JPanel;

public class MyPanelDibujo extends JPanel  {
	private int lados;
	private int puntos;
	private int radioCambio;
	
	
	public MyPanelDibujo() {
		super();
		this.setPreferredSize(new Dimension(800,800));
		this.lados = 8;
		this.puntos = 18;
		this.radioCambio = 16;
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int radio = 300;
		for(int i = 0; i<this.puntos;i++) {
			g.drawLine((int)(400+radio*Math.cos(1.5-(Math.PI*2.0*i/this.lados))), (int)(400+radio*Math.sin(1.5-(Math.PI*2.0*i/this.lados))), (int)(400+(radio-this.radioCambio)*Math.cos(1.5-(Math.PI*2.0*(i+1)/this.lados))), (int)(400+(radio-this.radioCambio)*Math.sin(1.5-(Math.PI*2.0*(i+1)/this.lados))));
			radio-=this.radioCambio;
		}
	}
	
	public void setLados(int lados) {
		this.lados = lados;
		repaint();
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
		repaint();
	}
	
	public void setRadio(int radio) {
		this.radioCambio = radio;
		repaint();
	}
}
