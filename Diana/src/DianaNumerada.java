//Autor: Ari Valenzuela (A01635584)
//Nombre de la clase: DianaNumerada.java
//Fecha: 04/04/2018
//Comentarios u observaciones: Se dibuja la Diana numerada.

import java.awt.Color;
import java.awt.Graphics;

public class DianaNumerada extends Diana {
	public DianaNumerada(int xPos, int yPos) {
		super(xPos, yPos);
		
	}
	public void pintaFigura(Graphics g) {
		int inicio = super.ancho/12 + super.ancho/6*5/2;
		super.pintaFigura(g);
		int alejadox = 30;
		int alejadoy = 21;
		for(int i = 10; i>=5; i--) {
			if(i==10) {
				g.setColor(Color.BLACK);
				g.drawString(Integer.toString(i),super.xPos+inicio-5,super.yPos+inicio+5);
				continue;
			} else if (i%2==0) {
				g.setColor(Color.BLACK);
			} else if (i%2!=0) {
				g.setColor(Color.WHITE);
			}
			g.drawString(Integer.toString(i),super.xPos+inicio-7+alejadox,super.yPos+inicio+5);
			g.drawString(Integer.toString(i),super.xPos+inicio+3-alejadox,super.yPos+inicio+5);
			g.drawString(Integer.toString(i),super.xPos+inicio-7,super.yPos+inicio+5+alejadoy);
			g.drawString(Integer.toString(i),super.xPos+inicio-7,super.yPos+inicio+5-alejadoy);
			alejadox+=17;
			alejadoy+=18;
		}
	}
}
