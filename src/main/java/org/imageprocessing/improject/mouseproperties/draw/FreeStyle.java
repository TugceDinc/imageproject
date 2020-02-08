//package org.imageprocessing.improject.mouseproperties.draw;
//
//import java.awt.Color;
//import java.awt.Graphics2D;
//import java.awt.Point;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseWheelEvent;
//
//import javax.swing.JPanel;
//
//import org.imageprocessing.improject.components.panels.ImagePanel;
//import org.imageprocessing.improject.programproperties.ImageManager;
//
//public class FreeStyle implements MouseListeners {
//
//	Point pointStart = null;
//	Point pointEnd   = null;
//	ImagePanel pnl;
//	ImageManager imgmngr;
//	Square p;
//	
//	public FreeStyle(ImageManager imgmnger) {
//		this.imgmngr = imgmnger;
//		this.pnl = imgmnger.getImgpanel();
//	}
//
//	@Override
//	public void mousePressed(MouseEvent e) {
//		
//		pointStart = e.getPoint();
//		if(!((pointStart.getX()) / imgmngr.zoomFactor > imgmngr.xOffset/ imgmngr.zoomFactor
//				&& (pointStart.getY())/imgmngr.zoomFactor > imgmngr.yOffset/ imgmngr.zoomFactor
//				&& (pointStart.getX())/imgmngr.zoomFactor < ((imgmngr.xOffset + imgmngr.getImage().getWidth()*imgmngr.zoomFactor)/imgmngr.zoomFactor) 
//				&& (pointStart.getY())/imgmngr.zoomFactor < (imgmngr.yOffset + imgmngr.getImage().getHeight()*imgmngr.zoomFactor)/imgmngr.zoomFactor)) {
//			pointStart = null;
//			
//		}
//		
//	}
//	
//	@Override
//	public void mouseReleased(MouseEvent e) {
//		if(pointStart != null && pointEnd != null) {
//			imgmngr.squareList.add(p);
//		}
//		pointStart = null;
//		pointEnd = null;
//	}
//
//	@Override
//	public void paint(Graphics2D g) {
//		if (pointStart != null) {
//			g.setColor(Color.RED);
//						
//			int [] xpoints = {(int)((pointStart.x - imgmngr.xOffset) / imgmngr.zoomFactor), (int)((pointEnd.x - imgmngr.xOffset) / imgmngr.zoomFactor), (int)((pointEnd.x - imgmngr.xOffset) / imgmngr.zoomFactor), (int)((pointStart.x - imgmngr.xOffset) / imgmngr.zoomFactor)};//,(int)((pointStart.x - imgmngr.xOffset) / imgmngr.zoomFactor)};
//			int [] ypoints = {(int)((pointEnd.y - imgmngr.yOffset) / imgmngr.zoomFactor), (int)((pointEnd.y - imgmngr.yOffset) / imgmngr.zoomFactor), (int)((pointStart.y - imgmngr.yOffset) / imgmngr.zoomFactor), (int)((pointStart.y - imgmngr.yOffset) / imgmngr.zoomFactor)};//,(int)((pointEnd.y - imgmngr.xOffset) / imgmngr.zoomFactor)};
// 			p  = new Square(xpoints, ypoints, 4,imgmngr.getShapeColor());
//			g.drawPolygon(p);
//		}
//	}
//	
//	
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseExited(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseDragged(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseMoved(MouseEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void mouseWheelMoved(MouseWheelEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//}
