

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MiVentana extends JFrame {
	public MiVentana() {
		super("Mi Ventana de Java");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		MiPanelDibujo pd = new MiPanelDibujo();
		MiPanelControles pc = new MiPanelControles(pd);
		this.add(pd);
		this.add(new MiPanelControles(pd),BorderLayout.WEST);
		this.pack();
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		MiVentana v = new MiVentana();

	}

}
