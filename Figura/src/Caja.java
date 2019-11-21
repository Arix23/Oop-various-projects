
public class Caja extends Rectangulo {
	protected double alto;
	
	public Caja(double largo, double ancho, double alto) {
		super(largo,ancho);
		this.alto = alto;
	}
	
	public Caja() {
		this(3.0,7.0,9.0);
	}
	
	public double perimetro() {
		return 4.0*this.largo+2.0*this.ancho+8.0*this.alto;
		
	}
	
	public double area() {
		return 2.0*(this.ancho*this.alto+this.largo*this.ancho+this.largo*this.alto);
		
	}
	
	public double volumen() {
		return super.area()*this.alto;
	}
	

	public static void main(String[] args) {


	}

}
