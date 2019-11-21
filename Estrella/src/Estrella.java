import javax.swing.JFrame;

public class Estrella extends JFrame {
	public Estrella() {
		super("Estrella de Java");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		MyPanelDibujo pd = new MyPanelDibujo();
		this.add(pd);
		this.pack();
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		Estrella estrella = new Estrella();

	}

}
