package org.imageprocessing.improject.mouseproperties.draw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import org.imageprocessing.improject.components.panels.ImagePanel;
import org.imageprocessing.improject.programproperties.ImageManager;

public class DrawingCenteredCircle implements MouseListeners {
	
	Point pointStart = null;
	Point pointEnd   = null;
	ImagePanel pnl;
	ImageManager imgmngr;

	public DrawingCenteredCircle(ImageManager imgmnger) {
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
			int spx = (int)((pointStart.x - imgmngr.xOffset) / imgmngr.zoomFactor);
			int spy = (int)((pointStart.y - imgmngr.yOffset) /imgmngr.zoomFactor);
			int epx = (int)((pointEnd.x - imgmngr.xOffset) / imgmngr.zoomFactor);
			int epy = (int)((pointEnd.y - imgmngr.yOffset) /imgmngr.zoomFactor);
			
			
			int distance = (int)Math.sqrt(Math.pow((spx - epx), 2) + Math.pow((spy - epy), 2));
			imgmngr
			.dObjectList
			.add(
					new Oval(
							(int)((pointStart.x - imgmngr.xOffset) / imgmngr.zoomFactor) - (int)distance, 
							(int)((pointStart.y - imgmngr.yOffset) /imgmngr.zoomFactor) - (int)distance,
							(int)distance * 2,
							(int)distance * 2,
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
			int spx = (int)((pointStart.x - imgmngr.xOffset) / imgmngr.zoomFactor);
			int spy = (int)((pointStart.y - imgmngr.yOffset) /imgmngr.zoomFactor);
			int epx = (int)((pointEnd.x - imgmngr.xOffset) / imgmngr.zoomFactor);
			int epy = (int)((pointEnd.y - imgmngr.yOffset) /imgmngr.zoomFactor);
			
			
			int distance = (int)Math.sqrt(Math.pow((spx - epx), 2) + Math.pow((spy - epy), 2));
			g.drawOval((int)((pointStart.x - imgmngr.xOffset) / imgmngr.zoomFactor) - (int)distance, (int)((pointStart.y - imgmngr.yOffset) /imgmngr.zoomFactor) - (int)distance, (int)distance * 2, (int)distance * 2);	

		}
	}

}
