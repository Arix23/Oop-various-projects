import java.io.*;
import java.util.StringTokenizer;
public class EjemploLector {

	public static void main(String[] args) {
		try {
			String linea;
			StringTokenizer st;
			String nombre,
					paterno;
			int hrs;
			double tabulador;
			BufferedReader br = new BufferedReader(new FileReader("horasTrabajadas.txt"));
			PrintWriter pw = new PrintWriter(new FileWriter("nomina.csv"));
			br.readLine();
			pw.println("Nombre completo, pago");
			while((linea = br.readLine()) != null) {
				st = new StringTokenizer(linea);
				nombre = st.nextToken();
				paterno = st.nextToken();
				hrs = Integer.parseInt(st.nextToken());
				tabulador = Double.parseDouble(st.nextToken());
				
				pw.println(nombre + " " + paterno + "," + (hrs*tabulador));
			}
			pw.close();
			br.close();
			System.out.println("FIN");
		} catch(FileNotFoundException ex) {
			System.out.println("No se localizó el archivo " + ex);
		}catch(IOException ex) {
			System.out.println("Ocurrió un error de I/O "+ ex);
		}
		

	}

}
