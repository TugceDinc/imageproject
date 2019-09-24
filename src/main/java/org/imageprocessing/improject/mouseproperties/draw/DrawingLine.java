package org.imageprocessing.improject.mouseproperties.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import org.imageprocessing.improject.components.panels.ImagePanel;
import org.imageprocessing.improject.programproperties.ImageManager;




public class DrawingLine implements MouseListeners {
	

	Point pointStart = null;
	Point pointEnd   = null;
	JPanel layer;
	ImagePanel pnl;
	ImageManager imgmngr;
	
	public DrawingLine(ImageManager imgmnger) {
		this.imgmngr = imgmnger;
		this.pnl = imgmnger.getImgpanel();
	}


	@Override
	public void mousePressed(MouseEvent e) {
		
		pointStart = e.getPoint();
		if(!((pointStart.getX()) / imgmngr.zoomFactor > imgmngr.xOffset/ imgmngr.zoomFactor
				&& (pointStart.getY())/imgmngr.zoomFactor > imgmngr.yOffset/ imgmngr.zoomFactor
				&& (pointStart.getX())/imgmngr.zoomFactor < ((imgmngr.xOffset + imgmngr.getImage().getWidth()*imgmngr.zoomFactor)/imgmngr.zoomFactor) 
				&& (pointStart.getY())/imgmngr.zoomFactor < (imgmngr.yOffset + imgmngr.getImage().getHeight()*imgmngr.zoomFactor)/imgmngr.zoomFactor)) {
			pointStart = null;
			
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(pointStart != null && pointEnd != null) {
			imgmngr.lineList.add(new Line((int)((pointStart.x - imgmngr.xOffset) / imgmngr.zoomFactor), (int)((pointStart.y - imgmngr.yOffset) /imgmngr.zoomFactor), (int)((pointEnd.x - imgmngr.xOffset) / imgmngr.zoomFactor), (int)((pointEnd.y - imgmngr.yOffset) / imgmngr.zoomFactor), imgmngr.getShapeColor()));
		}
		pointStart = null;
		pointEnd = null;
	}

	@Override
	public void paint(Graphics2D g) {
		if (pointStart != null) {
			g.setColor(Color.RED);
			g.drawLine((int)((pointStart.x - imgmngr.xOffset) / imgmngr.zoomFactor), (int)((pointStart.y - imgmngr.yOffset) /imgmngr.zoomFactor), (int)((pointEnd.x - imgmngr.xOffset) / imgmngr.zoomFactor), (int)((pointEnd.y - imgmngr.yOffset) / imgmngr.zoomFactor));
			
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		pointEnd = e.getPoint();
		
		pnl.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//pointEnd = e.getPoint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		
	}


}
