package org.imageprocessing.improject.mouseproperties.draw;

import java.awt.Color;
import java.awt.Polygon;

public class Square extends Polygon{
	public Color c;
	public Square(int [] xpoints, int [] ypoints, int npoints, Color c) {
		super(xpoints, ypoints, npoints);
		this.c = c;
	}
}
