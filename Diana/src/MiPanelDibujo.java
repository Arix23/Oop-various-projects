import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MiPanelDibujo extends JPanel {
	private DianaNumerada diana;
	
	public MiPanelDibujo() {
		super();
		this.setPreferredSize(new Dimension(800,600));
		diana = new DianaNumerada(100,100);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.diana.pintaFigura(g);
	}
}
