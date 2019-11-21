import java.util.*;

public class Fraccion {
	private int entero;
	private int numerador;
	private int denominador;

	public Fraccion(int entero, int numerador, int denominador) {
		this.entero = entero;
		this.numerador = numerador;
		if(denominador == 1) {
			this.numerador = 0;
			this.entero += numerador;
		}
		this.denominador = denominador;
	}

	public Fraccion(int numerador, int denominador) {
		this(0,numerador,denominador);
	}

	public void setFraccion(int entero, int numerador, int denominador) {
		this.entero = entero;
		if(denominador == 1) {
			this.numerador = 0;
			this.entero += numerador;
		}
		this.denominador = denominador;				
	}

	/*public void simplificacion() {
		
	}*/

	public void propia() {
		if(this.denominador<=this.numerador) {
			this.entero += this.numerador / this.denominador;
			this.numerador = this.numerador % this.denominador;
		}				
	}

	public void impropia() {
		if(entero>0) {
			this.numerador += this.entero*this.denominador;
			this.entero = 0;
		}
	}

	public String toString() {
		if(entero==0 && numerador == 0) {
		return "0";
		} else if(entero==0) {
			return numerador + "/" + denominador;
		} else if(numerador==0) {
			return Integer.toString(entero);
		} else {
			return entero + " " + numerador + "/" + denominador;
		}
	}
	

	public static void main(String[] args) {
		Fraccion fraccion = new Fraccion(3,5,9);
		System.out.println(fraccion);
	}
}