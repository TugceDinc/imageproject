package org.imageprocessing.improject.mouseproperties;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.AffineTransform;

import org.imageprocessing.improject.components.panels.ImagePanel;


public class Zoom extends MouseAdapter{

	ImagePanel imgpanel;

	public Zoom(ImagePanel pnl) {
		imgpanel = pnl;
	}


	private double zoomFactor = 1;
	private double prevZoomFactor = 1;
	private boolean zoomer;
	private double xOffset = 0;
    private double yOffset = 0;

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		zoomer = true;
		//Zoom in
		if (e.getWheelRotation() < 0) {
			zoomFactor *= 1.1;
			imgpanel.repaint();
		}
		//Zoom out
		if (e.getWheelRotation() > 0) {
			zoomFactor /= 1.1;
			imgpanel.repaint();
		}
		
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		if (zoomer) {
            AffineTransform at = new AffineTransform();

            double xRel = MouseInfo.getPointerInfo().getLocation().getX() -imgpanel.getLocationOnScreen().getX();
            double yRel = MouseInfo.getPointerInfo().getLocation().getY() - imgpanel.getLocationOnScreen().getY();

            double zoomDiv = zoomFactor / prevZoomFactor;

            xOffset = (zoomDiv) * (xOffset) + (1 - zoomDiv) * xRel;
            yOffset = (zoomDiv) * (yOffset) + (1 - zoomDiv) * yRel;

            at.translate(xOffset, yOffset);
            at.scale(zoomFactor, zoomFactor);
            prevZoomFactor = zoomFactor;
            g2d.transform(at);
            zoomer = false;
            g2d.drawImage(imgpanel.getImage(), 0, 0, imgpanel);
        }

	}
}
