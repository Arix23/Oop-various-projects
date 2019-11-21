import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyPanelControles extends JPanel implements ActionListener, ChangeListener, MouseListener {
	private MyPanelDibujo pd;
	private JSlider slider,
					slider2;
	private JTextField tflineas;
	private JButton btnlineas;
	private JLabel label1,
					label2;
	
	
	public MyPanelControles(MyPanelDibujo pd) {
		super();
		this.pd = pd;
		this.setPreferredSize(new Dimension(150,600));
		this.tflineas = new JTextField(10);
		this.btnlineas = new JButton("Cambiar # de líneas");
		this.add(tflineas);
		this.add(btnlineas);
		this.btnlineas.addActionListener(this);

    	this.label1 = new JLabel("Set Lados");
    	this.add(label1);
		this.slider = new JSlider(JSlider.VERTICAL, 3, 23, 8);
    	this.slider.setMinorTickSpacing(1);
    	this.slider.setMajorTickSpacing(5);
    	this.slider.setPaintTicks(true);
    	this.slider.setPaintLabels(true);
    	this.slider.addChangeListener(this);
    	this.add(this.slider);
    	
    	this.label2 = new JLabel("Set disminución del radio");
    	this.add(label2);
    	this.slider2 = new JSlider(JSlider.VERTICAL,5,30,16);
    	this.slider2.setMinorTickSpacing(1);
    	this.slider2.setMajorTickSpacing(5);
    	this.slider2.setPaintLabels(true);
    	this.slider2.setPaintTicks(true);
    	this.slider2.addChangeListener(this);
    	this.add(this.slider2);
    	

		
		
		
		
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


	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource()==slider) {
			this.pd.setLados(this.slider.getValue());
		}
		else if (e.getSource()==slider2) {
			this.pd.setRadio(this.slider2.getValue());
		}
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnlineas) {
			this.pd.setPuntos(Integer.parseInt(this.tflineas.getText()));
			repaint();
		}
	}
}
