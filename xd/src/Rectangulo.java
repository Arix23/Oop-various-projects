
public class Rectangulo implements Figura {
	protected double largo;
	protected double ancho;
	
	public Rectangulo(double largo, double ancho) {
		this.largo = largo;
		this.ancho = ancho;
	}
	
	public double perimetro() {
		return 2*(this.largo+this.ancho);
	}
	
	public double area() {
		return this.largo*this.ancho;
	}
	
	public double volumen() {
		return 0.0;
	}

	public static void main(String[] args) {
		

	}

}
