import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MyPanelDibujo extends JPanel implements ActionListener {
	private Numerote numerote;
	
	private JButton calcular,
					archivo;
	
	private JTextField 	tb1,
						tb2,
						tbsalida,
						tbArchivoEntrada,
						tbArchivoSalida;
	
	private JRadioButton 	suma,
							resta,
							multiplicacion;
	
	private JLabel 	titulo,
					resultado,
					tituloArchivo,
					labelEntrada,
					labelSalida;
	
	public MyPanelDibujo() {
		super();
		this.setPreferredSize(new Dimension(450,340));
		
		this.numerote = new Numerote();
		
		this.titulo = new JLabel("Calculadora de Numerotes");
		this.titulo.setFont(new Font("Arial", 1, 32));
		this.add(titulo);
		
		this.suma = new JRadioButton("Sumar",true);
		this.add(this.suma);
		this.resta = new JRadioButton("Restar");
		this.add(this.resta);
		this.multiplicacion = new JRadioButton("Multiplicación");
		this.add(this.multiplicacion);
		ButtonGroup bg = new ButtonGroup();
		bg.add(suma);
		bg.add(resta);
		bg.add(multiplicacion);
		
		this.calcular = new JButton("Calcular");
		this.calcular.addActionListener(this);
		this.add(this.calcular);
		
		this.tb1 = new JTextField(20);
		this.add(tb1);
		
		this.tb2 = new JTextField(20);
		this.add(tb2);
		
		this.resultado = new JLabel("Resultado:");
		this.add(this.resultado);
		
		this.tbsalida = new JTextField(40);
		this.tbsalida.setEditable(false);
		this.add(tbsalida);
		
		this.tituloArchivo = new JLabel("Realiza operaciones predeterminadas mediante un archivo");
		this.tituloArchivo.setFont(new Font("Arial", 1, 14));
		this.add(this.tituloArchivo);
		
		this.labelEntrada = new JLabel("Nombre del archivo a ejecutar");
		this.add(this.labelEntrada);
		
		this.tbArchivoEntrada = new JTextField(20);
		this.add(this.tbArchivoEntrada);
		
		this.labelSalida = new JLabel("Nombre del archivo a generar");
		this.add(this.labelSalida);
		
		this.tbArchivoSalida = new JTextField(20);
		this.add(this.tbArchivoSalida);
		
		this.archivo = new JButton("Ejecutar Archivo");
		this.archivo.addActionListener(this);
		this.add(this.archivo);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Numerote numerote2 = new Numerote();
		if (e.getSource()==this.calcular) {
			Numerote resultado = new Numerote();
			try {
				if (this.tb1.getText().length()==0) {
					this.numerote = new Numerote();
				} else {
					this.numerote = new Numerote(this.tb1.getText());
				}
				if (this.tb2.getText().length()==0) {
					numerote2 = new Numerote();
				} else {
					numerote2 = new Numerote(this.tb2.getText());
				}
				if(this.suma.isSelected()) {
					resultado = this.numerote.suma(numerote2);
				} else if(this.resta.isSelected()) {
					resultado = this.numerote.resta(numerote2);
				} else if(this.multiplicacion.isSelected()) {
					resultado = this.numerote.multiplica(numerote2);
				}
				this.tbsalida.setText(resultado.toString());
			} catch (NumberFormatException ex) {   
				this.tbsalida.setText("Por favor ingrese solo números");
			}
			resultado = null;
			this.tb1.setText(null);
			this.tb2.setText(null);
		} else if (e.getSource()==this.archivo) {
			Numerote.ejecutaArchivo(this.tbArchivoEntrada.getText(), this.tbArchivoSalida.getText());
		}	
	}
}
