package org.imageprocessing.improject.mouseproperties.draw;

import java.awt.Color;
import java.awt.Graphics2D;

public class Oval implements DObject{
	
	private int cX;
	
	private int cY;
	
	private int width;
	
	private int height;
	
	private Color color;

	public Oval(int cX, int cY, int width, int height, Color color) {
		this.cX = cX;
		this.cY = cY;
		this.width = width;
		this.height = height;
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	public int getcX() {
		return cX;
	}
	
	public int getcY() {
		return cY;
	}
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	@Override
	public void print(Graphics2D g2d) {
		g2d.setColor(this.color);
		g2d.drawOval(cX, cY, width, height);
	}
}
