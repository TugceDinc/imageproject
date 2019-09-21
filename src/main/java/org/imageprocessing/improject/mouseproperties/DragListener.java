package org.imageprocessing.improject.mouseproperties;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.imageprocessing.improject.components.panels.ImagePanel;

public class DragListener extends MouseAdapter {

	private final JPanel frame;
	private Point mouseDownCompCoords = null;
	private Point mouseCurrent;
	private Point offset = new Point(0, 0);


	public DragListener(JPanel frame) {
		this.frame = frame;
	}

	public void mouseReleased(MouseEvent e) {
		mouseDownCompCoords = null;
	}

	public void mousePressed(MouseEvent e) {
		mouseDownCompCoords = e.getPoint();
	}

	public void mouseMove(MouseEvent e) {

	}

	public void mouseDragged(MouseEvent e) {
		mouseCurrent = e.getPoint();//getLocationOnScreen();
		//frame.setLocation(mouseCurrent.x - ((JComponent)frame.getParent()).getLocationOnScreen().x - mouseDownCompCoords.x, mouseCurrent.y - ((JPanel)frame.getParent()).getLocationOnScreen().y - mouseDownCompCoords.y);
		int x = offset.x + mouseCurrent.x - mouseDownCompCoords.x;// + offset.x;// - ((ImagePanel)frame).getImage().getWidth();
		int y = offset.y + mouseCurrent.y - mouseDownCompCoords.y;// + offset.y;// - ((ImagePanel)frame).getImage().getHeight();
		//		Point p = e.getPoint();
		//		int x = p.x - mouseDownCompCoords.x;
		//		int y = p.y - mouseDownCompCoords.x;
		offset = new Point(x, y);
		frame.repaint();

	}

	public void print(Graphics g, BufferedImage img) {
		if (img != null) {
			Graphics2D g2d = (Graphics2D) g.create();
			if (offset == null) {
				offset = new Point(0, 0);
			}
			g2d.drawImage(img, offset.x, offset.y, frame);
			g2d.dispose();
		}
	}


}