package org.imageprocessing.improject.mouseproperties.draw;

import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public interface MouseListeners extends MouseListener, MouseMotionListener  {
	
	void paint(Graphics g);
}
