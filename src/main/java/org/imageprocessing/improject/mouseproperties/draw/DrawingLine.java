package org.imageprocessing.improject.mouseproperties.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import org.imageprocessing.improject.components.panels.ImagePanel;




public class DrawingLine implements MouseListeners {
	

	Point pointStart = null;
	Point pointEnd   = null;
	JPanel layer;
	ImagePanel pnl;
	JPanel pnell;

	public DrawingLine(ImagePanel pnl) {
		this.pnl = pnl;
	}



	public void mousePressed(MouseEvent e) {
		pnell = new JPanel();
		pointStart = e.getPoint();
	}


	public void mouseReleased(MouseEvent e) {
		pointStart = null;
	}


	public void paint(Graphics g) {
		if (pointStart != null) {
			g.setColor(Color.RED);
			g.drawLine(pointStart.x, pointStart.y, pointEnd.x, pointEnd.y);
			//BufferedImage image = new BufferedImage(pnl.image, 300, 55);
		}
	}


	public void mouseDragged(MouseEvent e) {
		pointEnd = e.getPoint();
		pnl.repaint();
	}


	public void mouseMoved(MouseEvent e) {
		pointEnd = e.getPoint();
	}


	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}


}
