//Autor: Ari Valenzuela (A01635584)
//Nombre de la clase: Complejo.java
//Fecha: 07/02/2019
//Comentarios u observaciones: Aprendí a manejar mejor los returns de objetos, además de aprender un poco sobre los números complejos.

public class Complejo {
    private double real,
		   imaginario;

    public Complejo() {
        this(0,0);
    }

   public Complejo(double real,double imaginario){
        this.real = real;
	this.imaginario = imaginario;
    }

    public void establecer(double real, double imaginario) {
	this.real = real;
	this.imaginario = imaginario;	
    }

    public void imprimir() {
	if (imaginario >= 0) {
	    System.out.println(Double.toString(real) + " + " + Double.toString(imaginario) + "i");
	} else {
	    System.out.println(Double.toString(real) + " " + Double.toString(imaginario) + "i");
	    }
    }

    public void agregar(double real, double imaginario) {
	this.real += real;
	this.imaginario += imaginario;
    }

    public void agregar(Complejo complejo) {
	this.real += complejo.real;
	this.imaginario += complejo.imaginario;
    }

    public Complejo suma(Complejo complejo) {
	return new Complejo(this.real+complejo.real,this.imaginario+complejo.real);
    }

    public Complejo resta(Complejo complejo) {
	return new Complejo(this.real-complejo.real,this.imaginario-complejo.real);
    }

    public Complejo multiplicacion(Complejo complejo) {
	return new Complejo(this.real*complejo.real,this.imaginario*complejo.imaginario);

    }

    public Complejo multiplicacion(double real) {
	return new Complejo(this.real*real,this.imaginario*real);
	
    }

    public Complejo conjugado() {
	return new Complejo(this.real,-this.imaginario);
    }

    public static void main(String[] args) {
	Complejo complejo = new Complejo();
	complejo.imprimir();
	Complejo newComplejo = new Complejo(2,3);
	newComplejo.imprimir();
	newComplejo.establecer(5,-6);
	newComplejo.agregar(3,3);
	newComplejo.imprimir();
	Complejo xd = newComplejo.conjugado();
	xd.imprimir();
	
    }
}