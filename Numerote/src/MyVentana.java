import javax.swing.JFrame;

public class MyVentana extends JFrame {
	public MyVentana() {
		super("Proyecto final");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(new MyPanelDibujo());
		this.pack();
		
		this.setVisible(true);
	}
	public static void main(String[] args) {
		MyVentana Ventana = new MyVentana();

	}

}
