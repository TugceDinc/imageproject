package org.imageprocessing.improject.mouseproperties.draw;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

public interface MouseListeners extends MouseListener, MouseMotionListener, MouseWheelListener  {
	
	void paint(Graphics2D g);
}
