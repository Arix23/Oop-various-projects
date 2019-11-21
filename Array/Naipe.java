public class Naipe {
	private int valor;
	private int figura; //espadas = 0, corazones = 1, treboles = 2, diamantes = 3
	private String[] valores = {"As","Dos","Tres","Cuatro","Cinco","Seis","Siete","Ocho","Nueve","Diez","Joto","Reina","Rey"};
	private String[] figuras = {"Espadas","Corazones","Treboles","Diamantes"};

	public Naipe(int valor, int figura) {
		this.valor = valor;
		this.figura = figura;
	}

	public String toString() {
		return this.valores[this.valor] + " De " + this.figuras[this.figura];
	}




	public static void main(String[] args){
	 	Naipe reinaDeCorazones = new Naipe(11,1);
		System.out.println(reinaDeCorazones);
		



	}

}