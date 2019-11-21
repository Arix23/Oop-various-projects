import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MiPanelDibujo extends JPanel implements MouseMotionListener, MouseListener{
	private Image fondo;
	private int x0,
				y0,
				xF,
				yF;
	
	public MiPanelDibujo() {
		super();
		this.setPreferredSize(new Dimension(1000,800));
		this.fondo = new ImageIcon("fondo.jpg").getImage();
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fondo, 0,0,this.getWidth(),this.getHeight(),this);
		g.setColor(Color.BLUE);
		g.fillOval(100,200, 500, 500);
		g.drawLine(this.x0, this.y0, this.xF, this.yF);
		g.setColor(Color.BLACK);
		g.drawString("HOLA SOY GOKU", 250, 250);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.x0 = e.getX();
		this.y0 = e.getY();
		this.repaint();
		
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
	public void mouseDragged(MouseEvent e) {
		this.xF = e.getX();
		this.yF = e.getY();
		this.repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
