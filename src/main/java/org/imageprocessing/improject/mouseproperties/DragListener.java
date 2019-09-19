package org.imageprocessing.improject.mouseproperties;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class DragListener extends MouseAdapter {

    private final JPanel frame;
    private Point mouseDownCompCoords = null;
    private Point mouseCurrent;
    public DragListener(JPanel frame) {
        this.frame = frame;
    }

    public void mouseReleased(MouseEvent e) {
        mouseDownCompCoords = null;
    }

    public void mousePressed(MouseEvent e) {
        mouseDownCompCoords = e.getPoint();
    }

    public void mouseMove(MouseEvent e) {
    	
    }
    
    public void mouseDragged(MouseEvent e) {
    	mouseCurrent = e.getLocationOnScreen();
        frame.setLocation(mouseCurrent.x - ((JComponent)frame.getParent()).getLocationOnScreen().x - mouseDownCompCoords.x, mouseCurrent.y - ((JPanel)frame.getParent()).getLocationOnScreen().y - mouseDownCompCoords.y);
    }
}