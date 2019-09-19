package org.imageprocessing.improject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.imageprocessing.improject.mouseproperties.DragListener;
import org.imageprocessing.improject.mouseproperties.Zoom;
import org.imageprocessing.improject.mouseproperties.draw.DrawingLine;
import org.imageprocessing.improject.mouseproperties.draw.MouseListeners;

public class ImagePanel extends JPanel {

	/**
	 * Create the panel.
	 */

	MouseListeners listener;
	public BufferedImage image;
	Zoom zoom;


	@Override
	public void paint(Graphics g) {
		super.paint(g);
		listener.paint(g);
		//		g.drawImage(image, this.getWidth() / 2 - image.getWidth() / 2,
		//				this.getHeight() / 2 - image.getHeight() / 2, this); 
		Graphics2D g2 = (Graphics2D) g;

		zoom.paint(g2);
	}

	public void addMouseListeners(MouseListeners listener) {
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
	}

	public ImagePanel() {
		listener = new DrawingLine(this);
		DragListener listen = new DragListener(this);
		zoom = new Zoom(this);
		this.addMouseWheelListener(zoom);

		this.addMouseListener(listen);
		this.addMouseMotionListener(listen);

		//this.addMouseListeners(listener);
		try {
			image = ImageIO.read(new File("C:\\Users\\Tugce\\Desktop\\image2.jpg"));
			this.setBounds(0, 0, image.getWidth(), image.getHeight());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	static int l = 0;

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		if(l < 3) {
			g.drawImage(image, this.getWidth() / 2 - image.getWidth() / 2,
					this.getHeight() / 2 - image.getHeight() / 2, this); 
			l++;
		}
	}
}
