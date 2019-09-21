package org.imageprocessing.improject.components.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.imageprocessing.improject.mouseproperties.DragListener;
import org.imageprocessing.improject.mouseproperties.Zoom;
import org.imageprocessing.improject.mouseproperties.ZoomAndDragListener;
import org.imageprocessing.improject.mouseproperties.draw.DrawingLine;
import org.imageprocessing.improject.mouseproperties.draw.MouseListeners;
import org.imageprocessing.improject.programproperties.ImageManager;
import org.imageprocessing.improject.programproperties.ProgramColor;
import org.imageprocessing.improject.programproperties.ProgramColorFactory;

public class ImagePanel extends JPanel {

	
	
	MouseListeners listener;
	protected BufferedImage image;
	ZoomAndDragListener zdlis;
	@Override
	public void paint(Graphics g) {
		//Graphics2D g2 = (Graphics2D) g;
		super.paint(g);
		zdlis.paint(g);
		g.drawImage(image, this.getWidth() / 2 - image.getWidth() / 2,
				this.getHeight() / 2 - image.getHeight() / 2, this);
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
	}

	public ImagePanel() {
		//this.setBorder(BorderFactory.createLineBorder(new Color(83, 41, 42), 5));
		listener = new DrawingLine(this);
		zdlis = new ZoomAndDragListener(this);
		this.addMouseWheelListener(zdlis);
		this.addMouseListener(zdlis);
		this.addMouseMotionListener(zdlis);

		
		
		try {
			image = ImageIO.read(new File("C:\\Users\\Tugce\\Desktop\\image2.jpg"));
			//this.setBounds(0, 0, image.getWidth(), image.getHeight());
			
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

		g.drawImage(image, this.getWidth() / 2 - image.getWidth() / 2,
				this.getHeight() / 2 - image.getHeight() / 2, this); 
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setColor(getBackground());
		g2.fillRoundRect(this.getX(), this.getY(), getWidth(), getHeight(), 20, 20);
		//this.setForeground(ProgramColor.getColor().clrBackground);
		g2.setColor(getForeground());
		g2.drawRoundRect(this.getX(), this.getY(), getWidth(), getHeight(), 20, 20);

	}
}
