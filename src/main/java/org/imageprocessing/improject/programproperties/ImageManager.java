package org.imageprocessing.improject.programproperties;

import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.imageprocessing.improject.components.panels.ImagePanel;
import org.imageprocessing.improject.mouseproperties.draw.Line;
import org.imageprocessing.improject.mouseproperties.draw.Square;

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
	private Color shapeColor = Color.WHITE;
	
	public List<Line> lineList;
	public List<Square> squareList;
	public ImageManager() {
		imgpanel = new ImagePanel();
		imgpanel.setImageManager(this);
		lineList = new ArrayList<Line>();
		squareList = new ArrayList<Square>();
	}

	public Color getShapeColor() {
		return shapeColor;
	}
	
	public void setShapeColor(Color shapeColor) {
		this.shapeColor = shapeColor;
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
