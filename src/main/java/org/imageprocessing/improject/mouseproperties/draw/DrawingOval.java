package org.imageprocessing.improject.mouseproperties.draw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import org.imageprocessing.improject.components.panels.ImagePanel;
import org.imageprocessing.improject.programproperties.ImageManager;

public class DrawingOval implements MouseListeners {
	
	Point pointStart = null;
	Point pointEnd   = null;
	ImagePanel pnl;
	ImageManager imgmngr;
	
	public DrawingOval(ImageManager imgmnger) {
		this.imgmngr = imgmnger;
		this.pnl = imgmnger.getImgpanel();
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
	public void mouseReleased(MouseEvent arg0) {
		if(pointStart != null && pointEnd != null) {
			int distance = (int) pointStart.distance(pointEnd);
			imgmngr
			.dObjectList
			.add(
					new Oval(
							(int)((pointStart.x - imgmngr.xOffset) / imgmngr.zoomFactor), 
							(int)((pointStart.y - imgmngr.yOffset) /imgmngr.zoomFactor),
							(int)distance,
							(int)distance,
							imgmngr.getShapeColor()));
		}
		pointStart = null;
		pointEnd = null;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		pointEnd = e.getPoint();
		
		pnl.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paint(Graphics2D g) {
		if (pointStart != null) {
			g.setColor(Color.RED);
			g.setStroke(new BasicStroke(1));
			int distance = (int) pointStart.distance(pointEnd);
			g.drawOval((int)((pointStart.x - imgmngr.xOffset) / imgmngr.zoomFactor),  (int)((pointStart.y - imgmngr.yOffset) /imgmngr.zoomFactor),(int)distance,(int)distance);	
			
		}
	}

}
