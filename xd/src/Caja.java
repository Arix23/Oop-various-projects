
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
	
	public String toString() {
		return ("Caja de " + this.perimetro() + " unidades de perímetro, "+ this.area() + " unidades cuadradas de area, " + this.volumen() + " unidades cubicas de volumen");
	}
	
	public void saluda() {
		System.out.println("HOLA VEGETTA");
	}
	public static void main(String[] args) {
		Caja c = new Caja(10.0,15.3,20.0);
		System.out.println(c);
		System.out.println("el perimetro es " +c.perimetro());
		
		Figura[] figuras = {new Rectangulo(6.0,4.0), new Caja(10.0,15.3,2.5)};
		for (int i =0;i<figuras.length;i++) {
			System.out.println(figuras[i]);
			if(figuras[i] instanceof Caja) {
				((Caja)figuras[i]).saluda();
			}
		}
	}
}
