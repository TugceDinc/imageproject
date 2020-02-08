package org.imageprocessing.improject.components.panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.imageprocessing.improject.mouseproperties.ZoomAndDragListener;
import org.imageprocessing.improject.mouseproperties.draw.DObject;
import org.imageprocessing.improject.mouseproperties.draw.DrawingLine;
import org.imageprocessing.improject.mouseproperties.draw.Line;
import org.imageprocessing.improject.mouseproperties.draw.MouseListeners;
import org.imageprocessing.improject.mouseproperties.draw.Square;
import org.imageprocessing.improject.programproperties.ImageManager;

public class ImagePanel extends JPanel {

	
	ImageManager imgmngr;
	
	public void setImageManager(ImageManager imgmngr) {
		this.imgmngr = imgmngr;
	}
	
	public ImageManager getImageManager() {
		return imgmngr;
	}
	
	protected BufferedImage image;
	
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		if(!imgmngr.dragger && !imgmngr.zoomer) {
			AffineTransform at = new AffineTransform();
			at.translate(imgmngr.xOffset, imgmngr.yOffset);
			at.scale(imgmngr.zoomFactor, imgmngr.zoomFactor);
			g2.transform(at);
			g2.drawImage(image, 0,0, this);
		}
		
		for(MouseMotionListener listerns : this.getMouseMotionListeners()) {
			if(listerns instanceof MouseListeners) {
				((MouseListeners)listerns).paint(g2);
				break;
			}
		}	
		
		for(DObject dObject : imgmngr.dObjectList) {
			dObject.print(g2);
		}

	}

	public BufferedImage getImage() {
		return image;
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public void addMouseListeners(MouseListeners listener) {
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
		this.addMouseWheelListener(listener);
	}
	
	public void removeMouseListeners(MouseListeners listener) {
		this.removeMouseMotionListener(listener);
		this.removeMouseWheelListener(listener);
		this.removeMouseWheelListener(listener);
	}


	public ImagePanel() {
		//this.setBorder(BorderFactory.createLineBorder(new Color(83, 41, 42), 5));
		
		try {
			image = ImageIO.read(new File("C:\\Users\\Tugce\\Downloads\\helloooooooo.png"));
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		this.setBackground(new Color(50,50,50));
//		g.drawImage(image, this.getWidth() / 2 - image.getWidth() / 2,
//				this.getHeight() / 2 - image.getHeight() / 2, this); 
		
		
//		Graphics2D g2 = (Graphics2D) g;
//		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//
//		g2.setColor(getBackground());
//		g2.fillRoundRect(this.getX(), this.getY(), getWidth(), getHeight(), 20, 20);
//		//this.setForeground(ProgramColor.getColor().clrBackground);
//		g2.setColor(getForeground());
//		g2.drawRoundRect(this.getX(), this.getY(), getWidth(), getHeight(), 20, 20);
		
	}
}
