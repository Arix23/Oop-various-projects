
public class Rectangulo extends Figura {
	protected double largo;
	protected double ancho;
	
	public Rectangulo(double largo, double ancho) {
		this.largo = largo;
		this.ancho = ancho;
	}
	
	public double area() {
		return this.largo*this.ancho;
	}

	public static void main(String[] args) {
		

	}

}
