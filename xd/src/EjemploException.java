
public class EjemploException {
	
	public void metodoD() throws Exception{
		PrintWriter pw = new PrintWriter(new FileWriter("Hola.txt"));
		throw new Exception("Ocurrió un error método D");
	}
	
	public void metodoC() throws Exception {
		this.metodoD();
	}
	
	public void metodoB() throws Exception {
		this.metodoC();
	}
	
	public void metodoA() throws Exception{
		this.metodoB();
	}

	public static void main(String[] args) {
		try {
			EjemploException ee = new EjemploException();
			ee.metodoA();	
		}
		catch(Exception ex) {
			System.out.println("No se puede continuar ya kyc");
		}

	}

}
