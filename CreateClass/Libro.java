//Autor: Ari Valenzuela (A01635584)
//Nombre de la clase: Libro.java
//Fecha: 25/01/2018
//Comentarios u observaciones: Todo funciono correctamente, y entendi un poco más sobre el comportamiento y los atributos de los objetos practicando con la clase Libro. Tambien empece a usar el this como buena practica.

public class Libro {
	private String title;
	private String autor;
	private String editorial;
	private String ISBN;

	public Libro(){
		title = "Default title";
		autor = "Anonimo";
		editorial = "Editorial";
		ISBN = "123-0000-01-7";
	}
	
	public Libro(String title, String autor, String editorial, String ISBN){
		this.title = title;
		this.autor = autor;
		this.editorial = editorial;
		this.ISBN = ISBN;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public void setAutor(String autor){
		this.autor = autor;
	}

	public void setEditorial(String editorial){
		this.editorial = editorial;
	}

	public void setISBN(String ISBN){
		this.ISBN = ISBN;
	}

	public String getTitle(){
		return this.title;
	}

	public String getAutor(){
		return this.autor;
	}

	public String getEditorial(){
		return this.editorial;
	}

	public String getISBN(){
		return this.ISBN;
	}
	public static void main(String[] args){
		//Uso de constructores para crear dos objetos de la clase Libro
		//Constructor default
		Libro libro = new Libro();

		//Constructor con parametros
		Libro enciclopedia = new Libro("El principito","Antoine de Saint-Exupéry","Gallimard","1234-123-123-00");

		//Comprobación de que funcionaron los constructores
		System.out.println("Titulo: " + libro.title + "\nAutor: " + libro.autor + "\nEditorial: " + libro.editorial + "\nISBN: " + libro.ISBN);
		System.out.println("");
		System.out.println("Titulo: " + enciclopedia.title + "\nAutor: " + enciclopedia.autor + "\nEditorial: " + enciclopedia.editorial + "\nISBN: " + enciclopedia.ISBN);
		System.out.println("");

		//Uso de métodos getters para obtener datos del libro default
		System.out.println("Título default usando getter: " + libro.getTitle());
		System.out.println("Autor default usando getter: " + libro.getAutor());
		System.out.println("Editorial default usando getter: " + libro.getEditorial());
		System.out.println("ISBN default usando getter: " + libro.getISBN());
		System.out.println("");

		//Usar métodos set para cambiar el objeto enciclopedia:
		enciclopedia.setTitle("Encylopedia Britannica");
		enciclopedia.setAutor("N/A");
		enciclopedia.setEditorial("Encyclopaedia Britannica");
		enciclopedia.setISBN("9780852297070");
		
		//Se prueba que funcionaron los métodos setter
		System.out.println("Titulo: " + enciclopedia.title + "\nAutor: " + enciclopedia.autor + "\nEditorial: " + enciclopedia.editorial + "\nISBN: " + enciclopedia.ISBN);
		
	}
}


