import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.io.*;

public class MiPanelControles extends JPanel implements MouseListener, MouseMotionListener, ActionListener,ChangeListener{
	private MiPanelDibujo pd;
	protected JRadioButton linea;
	private JButton guardar,
					abrir,
					aplicar;
	private JSlider slider;
	private JLabel label,
					labeltxt;
	private JTextField tf;
	
	public MiPanelControles(MiPanelDibujo pd) {
		this.pd = pd;
		this.setPreferredSize(new Dimension(160,1000));
		this.linea = new JRadioButton("Linea",true);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(linea);
		
		this.add(linea);
		
		this.labeltxt = new JLabel("Textooooooooooooooo");
		this.add(labeltxt);
		this.tf = new JTextField(15);
		this.add(tf);
		
		this.aplicar = new JButton("Aplicar cambios");
		this.aplicar.addActionListener(this);
		this.add(aplicar);
		
		this.label = new JLabel("Set de las Coordenadas");
		this.add(label);
		this.slider = new JSlider(JSlider.VERTICAL,0,100,50);
			this.slider.setMajorTickSpacing(10);
			this.slider.setMinorTickSpacing(2);
			this.slider.setPaintLabels(true);
			this.slider.setPaintTicks(true);
			this.slider.addChangeListener(this);
			this.add(slider);
		
		this.guardar = new JButton("Guardar Archivo");
		this.guardar.addActionListener(this);
		this.abrir = new JButton("Abrir Archivo");
		this.abrir.addActionListener(this);
		this.add(guardar);
		this.add(abrir);
		
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==guardar) {
			JFileChooser jc = new JFileChooser();
			int respArchivo = jc.showSaveDialog(this.pd);
			if(respArchivo == JFileChooser.APPROVE_OPTION) {
				File archivo = jc.getSelectedFile();
				try {
					PrintWriter pw = new PrintWriter(new FileWriter(archivo.getAbsolutePath()));
					pw.println("HOLA SOY GOKU");
					pw.close();
				}
				catch(IOException ex) {
					System.out.println("ERROR");
				}
			}

		} else if (e.getSource()==abrir) {
			JFileChooser jc = new JFileChooser();
			int respArchivo = jc.showOpenDialog(this.pd);
			if(respArchivo == JFileChooser.APPROVE_OPTION) {
				File archivo = jc.getSelectedFile();
				try {
					BufferedReader br = new BufferedReader(new FileReader(archivo.getAbsolutePath()));
					br.close();
					
				}
				catch(FileNotFoundException ex) {
					System.out.println("ERROR AL ENCONTRAR EL ARCHIVO");
				}
				catch(IOException ex) {
					System.out.println("ERRORZAZO");
				}
			}
			
		}
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
