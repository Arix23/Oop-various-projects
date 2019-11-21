// Integrantes: Santiago Gabriel Vallejo Garcia (A01631816) & Ari Ramon Valenzuela Navarro (A01635584)

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Numerote {
	private byte[] numerote;
	private boolean signo;
	
	
	public Numerote(){
		
		this.numerote=new byte[1];
		this.numerote[0]=0;
		this.signo=true;
	}
	
	

	public Numerote(String num) throws NumberFormatException {
		try {
			if (num.charAt(0)=='-') {
				this.numerote=new byte[num.length()-1];
				this.signo=false;
				for (int i =0; i<num.length()-1;i++) {
					this.numerote[i]=Byte.parseByte(Character.toString(num.charAt(num.length()-i-1)));
				}
			}else if (num.charAt(0)=='+') {
				this.numerote=new byte[num.length()-1];
				this.signo=true;
				for (int i =0; i<num.length()-1;i++) {
					this.numerote[i]=Byte.parseByte(Character.toString(num.charAt(num.length()-i-1)));
				}
			}else {
				this.numerote=new byte[num.length()];
				this.signo=true;
				for (int i =0; i<num.length();i++) {
					this.numerote[i]=Byte.parseByte(Character.toString(num.charAt(num.length()-i-1)));
				}
			}
		} catch(NumberFormatException ex) {
			throw new NumberFormatException();
		}
	}
	
	public Numerote suma(Numerote num) {
		String suma="", 
			   invertida="";
		byte cOut=0;
		
		if (this.signo && num.signo) {
			if (this.numerote.length==num.numerote.length) {
				for (int i = 0; i < num.numerote.length; i++) {
					suma += (this.numerote[i]+num.numerote[i]+cOut)%10;
					if ((this.numerote[i]+num.numerote[i]+cOut)/10==1) {
						cOut=1;
					}else {
						cOut=0;
					}
				}
				if (cOut==1) {
					suma+=cOut;
				}else {
					//se queda igual.
				}
				
			}else if (this.numerote.length < num.numerote.length) {
				for (int i = 0; i < this.numerote.length; i++) {
					suma += (this.numerote[i]+num.numerote[i]+cOut)%10;
					if ((this.numerote[i]+num.numerote[i]+cOut)/10==1) {
						cOut=1;
					}else {
						cOut=0;
					}
				}
				for (int i = this.numerote.length; i < num.numerote.length; i++) {
					suma+=(num.numerote[i]+cOut)%10;
					if ((num.numerote[i]+cOut)/10==1) {
						cOut=1;
					}else {
						cOut=0;
					}
				}
				if (cOut==1) {
					suma+=cOut;
				}else {
					//se queda igual.
				}
			}else {
				for (int i = 0; i < num.numerote.length; i++) {
					suma += (this.numerote[i]+num.numerote[i]+cOut)%10;
					if ((this.numerote[i]+num.numerote[i]+cOut)/10==1) {
						cOut=1;
					}else {
						cOut=0;
					}
				}
				for (int i = num.numerote.length; i < this.numerote.length; i++) {
					suma+=(this.numerote[i]+cOut)%10;
					if ((this.numerote[i]+cOut)/10==1) {
						cOut=1;
					}else {
						cOut=0;
					}
				}
				if (cOut==1) {
					suma+=cOut;
				}else {
					//se queda igual.
				}
			}
		}else if (this.signo) {
			num.signo=true;
			return this.resta(num);
		}else if (num.signo) {
			this.signo=true;
			return num.resta(this);
		}else {
			this.signo=num.signo=true;
			Numerote res=this.suma(num);
			res.signo=false;
			return res;
		}	
		for (int i =0; i<suma.length();i++) {
			invertida+=suma.charAt(suma.length()-i-1);
		}
		return new Numerote(invertida);
	}
	
	public Numerote resta(Numerote num) {
		String resta="", 
			   invertida="";
		byte cOut=0;
		if (this.signo && num.signo) {
			if (this.numerote.length==num.numerote.length) {
				if (this.numerote[this.numerote.length-1]<num.numerote[num.numerote.length-1]) {
					for (int i = 0; i < num.numerote.length; i++) {
						if (num.numerote[i]<this.numerote[i]) {
							resta+=num.numerote[i]+10-this.numerote[i]-cOut;
							cOut=1;
						}else {
							resta+=num.numerote[i]-this.numerote[i]-cOut;
							cOut=0;
						}
					}
					invertida+="-";
				}else if (this.numerote[this.numerote.length-1]==num.numerote[num.numerote.length-1] && this.numerote[0]<num.numerote[0]) {
					for (int i = 0; i < num.numerote.length; i++) {
						if (num.numerote[i]<this.numerote[i]) {
							resta+=num.numerote[i]+10-this.numerote[i]-cOut;
							cOut=1;
						}else {
							resta+=num.numerote[i]-this.numerote[i]-cOut;
							cOut=0;
						}
					}
					invertida+="-";
				}else {
					for (int i = 0; i < num.numerote.length; i++) {
						if (this.numerote[i]<num.numerote[i]) {
							resta+=this.numerote[i]+10-num.numerote[i]-cOut;
							cOut=1;
						}else {
							resta+=this.numerote[i]-num.numerote[i]-cOut;
							cOut=0;
						}
					}
				}
			}else if (this.numerote.length<num.numerote.length) {
				for (int i = 0; i < this.numerote.length; i++) {
					if (this.numerote[i]>num.numerote[i]) {
						resta+=num.numerote[i]+10-this.numerote[i]-cOut;
						cOut=1;
					}else {
						resta+=num.numerote[i]-this.numerote[i]-cOut;
						cOut=0;
					}
				}
				for (int i = this.numerote.length; i < num.numerote.length; i++) {
					resta+=num.numerote[i]-cOut;
					cOut=0;
				}
				invertida+="-";
			}else {
				for (int i = 0; i < num.numerote.length; i++) {
					if (this.numerote[i]<num.numerote[i]) {
						resta+=this.numerote[i]+10-num.numerote[i]-cOut;
						cOut=1;
					}else {
						resta+=this.numerote[i]-num.numerote[i]-cOut;
						cOut=0;
					}
				}
				for (int i = num.numerote.length; i < this.numerote.length; i++) {
					resta+=this.numerote[i]-cOut;
					cOut=0;
				}
			}
		}else if (this.signo) {
			num.signo=true;
			return num.suma(this);
		}else if (num.signo) {
			this.signo=true;
			Numerote res=num.suma(this);
			res.signo=false;
			return res;
		}else {
			this.signo=true;
			num.signo=true;
			return num.resta(this);
		}
		
		for (int i =0; i<resta.length();i++) {
			invertida+=resta.charAt(resta.length()-i-1);
		}
		return new Numerote(invertida);
	}
	
	public Numerote multiplica(Numerote num) {
		String mult="", 
			   invertida="";
		byte cOut=0;
		Numerote n0=new Numerote(), 
		 		 n1;
		if (this.signo==num.signo==true) {
			for (int i = 0; i < this.numerote.length; i++) {
				for (int j = 0; j < num.numerote.length; j++) {
					mult+=(this.numerote[i]*num.numerote[j]+cOut)%10;
					cOut=Byte.parseByte(Integer.toString((this.numerote[i]*num.numerote[j]+cOut)/10));
				}
				if (cOut!=0) {
					mult+=cOut;
				}else {
					//Hola soy sol y gabo no sabe que hacer.
				}

				for (int l =0; l<mult.length();l++) {
					invertida+=mult.charAt(mult.length()-l-1);
				}
				for (int k = 0; k < i; k++) {
					invertida+=0;
				}
				n1=new Numerote(invertida);
				n0=n0.suma(n1);
				mult="";
				invertida="";
			}
		}else if (this.signo==true || num.signo==true) {
			for (int i = 0; i < this.numerote.length; i++) {
				for (int j = 0; j < num.numerote.length; j++) {
					mult+=(this.numerote[i]*num.numerote[j]+cOut)%10;
					cOut=Byte.parseByte(Integer.toString((this.numerote[i]*num.numerote[j]+cOut)/10));
				}
				if (cOut!=0) {
					mult+=cOut;
				}else {
					//Se queda igual.
				}
				for (int l =0; l<mult.length();l++) {
					invertida+=mult.charAt(mult.length()-l-1);
				}
				for (int k = 0; k < i; k++) {
					invertida+=0;
				}
				n1=new Numerote(invertida);
				n0=n0.suma(n1);
				mult="";
				invertida="";
			}
			return n1=new Numerote("-"+n0);
		}else {
			this.signo=num.signo=true;
			this.multiplica(num);
		}
		return n0;
	}
	
	public String toString() {
		String num ="";
		if (this.signo) {
			for (int i = this.numerote.length-1; i >= 0 ; i--) {
				num+=this.numerote[i];
			}
		}else {
			num+="-";
			for (int i = this.numerote.length-1; i >= 0 ; i--) {
				num+=this.numerote[i];
			}
		}
		return num;
	}
	
	public static void ejecutaArchivo(String entrada, String salida) {
		try {
			String 	linea,
					operacion;
			StringTokenizer st;
			BufferedReader br = new BufferedReader(new FileReader(entrada));
			PrintWriter pw = new PrintWriter(salida);
			Numerote 	a,
						b,
						resultado;
			while((linea = br.readLine()) != null) {
				st = new StringTokenizer(linea, ",");
				a = new Numerote(st.nextToken());
				b = new Numerote(st.nextToken());
				operacion = st.nextToken();
				
				if (operacion.equals("s")) {
					resultado = a.suma(b);
					pw.println(resultado.toString());
				} else if (operacion.equals("r")) {
					resultado = a.resta(b);
					pw.println(resultado.toString());
				} else if (operacion.equals("m")) {
					pw.println(a.multiplica(b).toString());
				} else {
					pw.println("Error en las entradas");
				}
			}
			pw.close();
			br.close();
		} catch (FileNotFoundException ex) {
			System.out.println("No se pudo encontrar el archivo");
		} catch (IOException ex) {
			System.out.println("Error");
		} catch (NumberFormatException ex) {
			System.out.println("Error");
		}
	}

	public static void main(String[] args) {
		Numerote numerote = new Numerote("23");
		Numerote b = new Numerote("2");
		System.out.println(numerote.suma(b));
	}

}
