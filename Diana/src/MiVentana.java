import javax.swing.JFrame;

public class MiVentana extends JFrame{
	
	public MiVentana() {
		super("Tarea Diana");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(new MiPanelDibujo());
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		MiVentana v = new MiVentana();

	}

}
