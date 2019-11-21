import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class MyPanelDibujo extends JPanel implements MouseMotionListener, MouseListener {
	
	private int x0,
				y0,
				xF,
				yF;
	
	public MyPanelDibujo() {
		super();
		this.setPreferredSize(new Dimension(650,600));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(xF>x0 && yF>y0) {
			g.drawOval(x0, y0, (xF-x0), (yF-y0));
		} else if(xF>x0 && yF<y0) {
			g.drawOval(x0, yF, (xF-x0), (y0-yF));
		} else if(xF<x0 && yF>y0) {
			g.drawOval(xF, y0, (x0-xF), (yF-y0));
		} else if (xF<x0 && yF<y0) {
			g.drawOval(xF, yF, (x0-xF), (y0-yF));
		}
		

		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		this.x0 = e.getX();
		this.y0 = e.getY();
		System.out.println(x0);
		System.out.println(y0);
		this.repaint();
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
	@Override
	public void mouseClicked(MouseEvent e) {

		
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
