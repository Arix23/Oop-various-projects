public class Baraja {
	private Naipe[] cartas;
	
	public Baraja() {
		this.cartas = new Naipe[52];
		int c = 0;
		for(int i = 0;i<4;i++) {
			for(int	y = 0;y<13;y++) {
				this.cartas[c++] = new Naipe(y,i);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Baraja baraja = new Baraja();
		for(int i = 0;i<52;i++) {
			System.out.println(baraja.cartas[i]);
		}
	}

}