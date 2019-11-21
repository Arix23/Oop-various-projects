/*
 * PROYECTO FINAL DE POO
 * 
 * DONKEY KONG
 * 
 * CREADORES:
 * Alan Ezequiel Savoy A01351362
 * Ari  Valenzuela A01635584
 * 
 * MAYO 6 2019
 * 
 * */



import javax.swing.JFrame;

public class DonkeyKongFrame extends JFrame {
	public DonkeyKongFrame() {
		super("Donkey Kong el juego");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(new DonkeyKongJuego());
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		DonkeyKongFrame dk = new DonkeyKongFrame();
	}

}
