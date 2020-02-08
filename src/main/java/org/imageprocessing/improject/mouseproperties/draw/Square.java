package org.imageprocessing.improject.mouseproperties.draw;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class Square extends Polygon implements DObject{
	
	private Color color;
	
	private int thickness;
	
	public Square(int [] xpoints, int [] ypoints, int npoints, Color color) {
		super(xpoints, ypoints, npoints);
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}

	public int getThickness() {
		return thickness;
	}

	@Override
	public void print(Graphics2D g2d) {
		g2d.setColor(this.getColor());
		g2d.drawPolygon(this);
	
	
	}	
	
}
