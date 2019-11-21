import java.io.*;
import java.util.StringTokenizer;
public class EjemploLector2 {
	public static void main(String[] args) {
		try {
			StringTokenizer st;
			String			linea,
							nombre,
							paterno;
			int				horas;
			double			pago;
			PrintWriter 	pw = new PrintWriter(new FileWriter("archivoxd.csv"));
			BufferedReader	br = new BufferedReader(new FileReader("horasTrabajadas.txt"));
			br.readLine();
			pw.println("Nombre completo,pago");
			while((linea = br.readLine()) != null) {
				st = new StringTokenizer(linea);
				nombre = st.nextToken();
				paterno = st.nextToken();
				horas = Integer.parseInt(st.nextToken());
				pago = Double.parseDouble(st.nextToken());
				pw.println(nombre + " " + paterno + "," + (pago*horas));
				
			}
			pw.close();
			br.close();
			System.out.println("FIN");
		}
		catch(FileNotFoundException e) {
			System.out.println("No se pudo encontrar el archivo");
		}
		catch(IOException e) {
			System.out.println("Error de input/output");
		}
	}

}
