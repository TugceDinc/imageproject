package org.imageprocessing.improject.mouseproperties.draw;

import java.awt.Color;

public class Line{
	
	private int p1x, p1y, p2x, p2y;
	
	private int thickness = 1;
	 
	private Color color;
	
	public Line(int p1x, int p1y, int p2x, int p2y, Color color) {
		this.p1x = p1x;
		this.p1y = p1y;
		this.p2x = p2x;
		this.p2y = p2y;
		this.color = color;
	}
	
	public int getThickness() {
		return thickness;
	}
	
	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
	
	public int getP1x() {
		return p1x;
	}
	
	public int getP1y() {
		return p1y;
	}
	
	public int getP2x() {
		return p2x;
	}
	
	public int getP2y() {
		return p2y;
	}
	
	public Color getColor() {
		return color;
	}
}