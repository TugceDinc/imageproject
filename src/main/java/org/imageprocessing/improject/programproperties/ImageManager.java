package org.imageprocessing.improject.programproperties;

import java.awt.Point;
import java.awt.image.BufferedImage;

import org.imageprocessing.improject.components.panels.ImagePanel;

public class ImageManager {

	
	public double zoomFactor = 1;
	public double prevZoomFactor = 1;
	public boolean zoomer;
	public boolean dragger;
	public boolean released;
	public double xOffset = 0;
	public double yOffset = 0;
	public int xDiff;
	public int yDiff;
	public Point startPoint;
	
	private ImagePanel imgpanel;
	
	public ImageManager() {
		imgpanel = new ImagePanel();
		imgpanel.setImageManager(this);
	}

	public void setImgpanel(ImagePanel imgpanel) {
		this.imgpanel = imgpanel;
	}

	public ImagePanel getImgpanel() {
		return imgpanel;
	}

	public void setImage(BufferedImage image) {
		if(imgpanel != null) {
			imgpanel.setImage(image);
			imgpanel.repaint();
		}
	}

	public BufferedImage getImage() {
		if(imgpanel != null) {
			return imgpanel.getImage();
		}
		else {
			return null;
		}
	}

}
