package org.imageprocessing.improject.mouseproperties;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import org.imageprocessing.improject.components.panels.ImagePanel;
import org.imageprocessing.improject.mouseproperties.draw.MouseListeners;
import org.imageprocessing.improject.programproperties.ImageManager;

public class ZoomAndDragListener implements MouseListeners {

	JPanel pnl;
	private ImageManager imgmngr;
	public ZoomAndDragListener(ImageManager imgmngr) {
		this.imgmngr = imgmngr;
		pnl = imgmngr.getImgpanel();

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		imgmngr.zoomer = true;

		//Zoom in
		if (e.getWheelRotation() < 0) {
			imgmngr.zoomFactor *= 1.1;
			pnl.repaint();
		}
		//Zoom out
		if (e.getWheelRotation() > 0) {
			imgmngr.zoomFactor /= 1.1;
			pnl.repaint();
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Point curPoint = e.getLocationOnScreen();
		imgmngr.xDiff = curPoint.x - imgmngr.startPoint.x;
		imgmngr.yDiff = curPoint.y - imgmngr.startPoint.y;

		imgmngr.dragger = true;
		pnl.repaint();

	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		imgmngr.released = false;
		imgmngr.startPoint = MouseInfo.getPointerInfo().getLocation();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		imgmngr.released = true;
		pnl.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void paint(Graphics2D g2) {
		 
		if (imgmngr.zoomer) {
			AffineTransform at = new AffineTransform();

			double xRel = MouseInfo.getPointerInfo().getLocation().getX() - imgmngr.getImgpanel().getLocationOnScreen().getX();
			double yRel = MouseInfo.getPointerInfo().getLocation().getY() - imgmngr.getImgpanel().getLocationOnScreen().getY();

			double zoomDiv = imgmngr.zoomFactor / imgmngr.prevZoomFactor;

			imgmngr.xOffset = (zoomDiv) * (imgmngr.xOffset) + (1 - zoomDiv) * xRel;
			imgmngr.yOffset = (zoomDiv) * (imgmngr.yOffset) + (1 - zoomDiv) * yRel;

			at.translate(imgmngr.xOffset, imgmngr.yOffset);
			at.scale(imgmngr.zoomFactor, imgmngr.zoomFactor);
			imgmngr.prevZoomFactor = imgmngr.zoomFactor;
			g2.transform(at);
			imgmngr.zoomer = false;
		}

		if (imgmngr.dragger) {
			AffineTransform at = new AffineTransform();
			at.translate(imgmngr.xOffset + imgmngr.xDiff, imgmngr.yOffset + imgmngr.yDiff);
			at.scale(imgmngr.zoomFactor, imgmngr.zoomFactor);
			g2.transform(at);

			if (imgmngr.released) {
				imgmngr.xOffset += imgmngr.xDiff;
				imgmngr.yOffset += imgmngr.yDiff;
				imgmngr.dragger = false;
			}

		}

		g2.drawImage(imgmngr.getImage(), 0,0, imgmngr.getImgpanel());
		
	}
}
