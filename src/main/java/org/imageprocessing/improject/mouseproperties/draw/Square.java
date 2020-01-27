package org.imageprocessing.improject.mouseproperties.draw;

import java.awt.Color;
import java.awt.Polygon;

public class Square extends Polygon{
	
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
}
